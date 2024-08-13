package com.korgun.springcourse.SecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty(message = "Username should be not empty")
    @Column(name = "username")
    String username;

    @Min(value = 1900, message = "Year of birth min = 1900")
    @Column(name = "year_of_birth")
    int yearOfBirth;

    @NotEmpty(message = "Password should be not empty")
    @Column(name = "password")
    String password;

    @Column(name = "role")
    String role;

    public Person() {}

    public Person(String username, int yearOfBirth, String password) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Username should be not empty") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "Username should be not empty") String username) {
        this.username = username;
    }

    @Min(value = 1900, message = "Year of birth min = 1900")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(@Min(value = 1900, message = "Year of birth min = 1900") int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public @NotEmpty(message = "Password should be not empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password should be not empty") String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
