package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


    @Entity(tableName = "users")
    public class User {

        @PrimaryKey(autoGenerate = true)
        public int userId;

        @ColumnInfo(name = "full_name")
        public String fullName;

        @ColumnInfo(name = "email")
        public String email;

        @ColumnInfo(name = "password")
        public String password;

        @ColumnInfo(name = "role")
        public String role;

        // constructor
        public User(String fullName, String email, String password, String role) {
            this.fullName = fullName;
            this.email = email;
            this.password = password;
            this.role = role;
        }


        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

