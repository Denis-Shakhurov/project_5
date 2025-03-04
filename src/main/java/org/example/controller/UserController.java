package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.user.UserCreateDTO;
import org.example.dto.user.UserDTO;
import org.example.dto.user.UserUpdateDTO;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/users")
    @ResponseStatus(HttpStatus.OK)
    public String getUsers(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           Model model) {
        List<UserDTO> users = userService.findAll(page, size);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String showUser(@PathVariable("id") Long id, Model model) {
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user", userDTO);
        return "user";
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@Valid @RequestBody UserCreateDTO dto, Model model) {
        UserDTO userDTO = userService.create(dto);

        model.addAttribute("user", userDTO);
        return "redirect:/users";
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateUser(@PathVariable("id") Long id,
                             @RequestBody UserUpdateDTO dto,
                             Model model) {
        UserDTO userDTO = userService.update(dto, id);
        model.addAttribute("user", userDTO);
        return "redirect:/users/" + userDTO.getId();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
