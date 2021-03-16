package com.example.pract.services;

import com.example.pract.models.User;

import java.util.List;

public interface IUser {
    User save(User user);
    List<User> getAll();
    User update(int id, String name, int age);
    User getById(int id);
    void deleteById(int id);
}
