package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.AuthenticationRequest;
import com.vegetables.website.model.UserIdRequest;
import com.vegetables.website.security.JwtUtil;
import com.vegetables.website.security.DetailsService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        Cookie jwtCookie = new Cookie("jwt-token", jwt);
        Cookie emailCookie = new Cookie("email", authenticationRequest.getEmail());
        response.addCookie(jwtCookie);
        response.addCookie(emailCookie);
        return ResponseEntity.ok().body(jwt);
    }

    @PostMapping("/userid")
    public ResponseEntity<?> getUserIdFromEmail(@RequestBody UserIdRequest userIdRequest, HttpServletResponse response) throws Exception {
        ApplicationUser user = applicationUserDAO.findByEmail(userIdRequest.getEmail());
        return ResponseEntity.ok(user.getId());
    }
}
