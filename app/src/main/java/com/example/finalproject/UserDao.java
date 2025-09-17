package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface UserDao {

        @Insert
        void insertUser(User user);

        @Update
        void updateUser(User user);

        @Query("SELECT * FROM users WHERE userId = :userId")
        User getUserById(int userId);

        @Query("SELECT * FROM users WHERE email = :email")
        User getUserByEmail(String email);

        @Query("SELECT * FROM users")
        List<User> getAllUsers();
    }

