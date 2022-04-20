package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.AuthenticationRequest;
import com.vegetables.website.security.JwtUtil;
import com.vegetables.website.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DetailsService detailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ApplicationUserDAO applicationUserDAO;

    public AuthenticationController(BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserDAO applicationUserDAO) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.applicationUserDAO = applicationUserDAO;
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody String data) {
        System.out.println(data);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        applicationUserDAO.save(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = detailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        ResponseCookie springCookie = ResponseCookie.from("jwt-token", jwt)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(3600)
                .domain("localhost")
                .build();

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .build();
    }
}
