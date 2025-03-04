package org.example.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.dto.AuthRequest;
import org.example.dto.AuthResponse;
import org.example.dto.user.UserDTO;
import org.example.service.CustomUserDetailsService;
import org.example.service.UserService;
import org.example.util.JWTUtil;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class AuthAndRegController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Authentication authReq = new UsernamePasswordAuthenticationToken(
            authRequest.getEmail(), authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authReq);

        RedirectView redirectView = new RedirectView();

        if (authentication.isAuthenticated()) {
            String token = jwtUtil.generateToken(authRequest.getEmail());
            response.addHeader("Authorization", "Bearer " + token);

            response.addCookie(new Cookie("token", token));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.ok("redirect:/login");
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("autRequest", new AuthRequest());
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

}
