package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.AuthenticationRequest;
import com.vegetables.website.security.JwtUtil;
import com.vegetables.website.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserDAO.save(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = detailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        System.out.println("JWT: " + jwt);
        Cookie jwtCookie = new Cookie("jwt-token", jwt);
        Cookie emailCookie = new Cookie("email", authenticationRequest.getEmail());
        response.addCookie(jwtCookie);
        response.addCookie(emailCookie);
        return ResponseEntity.ok().body(jwt);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authstatus")
    public ResponseEntity createAuthenticationToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("jwt-token")) {
                long expiration = jwtUtil.extractExpiration(cookie.getValue()).toInstant().toEpochMilli();
                if (expiration > System.currentTimeMillis()) {
                    return ResponseEntity.ok().build();
                }
            }
        }

        return ResponseEntity.badRequest().build();

    }
}
