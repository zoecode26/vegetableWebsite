package com.vegetables.website.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private DetailsService detailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        boolean returnOk = request.getServletPath().startsWith("/boxes")
                || request.getServletPath().startsWith("/boxed-vegetables")
                || request.getServletPath().startsWith("/vegetables");

        String jwt = null;
        String authToken = request.getHeader("Authorization");
        if (authToken != null) {
            String[] splitToken = authToken.split(" ");
            if (splitToken.length > 1) {
                jwt = authToken.split(" ")[1];
            }
        }

        try {
            jwtUtil.extractAllClaims(jwt);
        } catch (Exception e) {
            Cookie jwtCookie = new Cookie("jwt-token", null);
            jwtCookie.setMaxAge(0);
            Cookie emailCookie = new Cookie("email", null);
            emailCookie.setMaxAge(0);
            response.addCookie(jwtCookie);
            response.addCookie(emailCookie);
        }

        String email = null;
        if (jwt != null) {
            email = jwtUtil.extractUsername(jwt);
        }

        if (email == null && !returnOk) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.detailsService.loadUserByUsername(email);
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                returnOk = true;
            }
        }

        if (returnOk) {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        chain.doFilter(request, response);
    }
}