package com.example.pract.controllers;

import com.example.pract.models.User;
import com.example.pract.services.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public User create(@RequestParam String name, @RequestParam int age) {
        return userService.save(new User(name, age));
    }
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }
    @GetMapping("/{id}/update")
    public User update(@PathVariable int id, @RequestParam String name, @RequestParam int age){
        return userService.update(id, name, age);
    }
    @GetMapping("/{id}/delete")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
    }


}
