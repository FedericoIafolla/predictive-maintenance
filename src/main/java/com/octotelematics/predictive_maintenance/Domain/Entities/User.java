package com.octotelematics.predictive_maintenance.Domain.Entities;

public class User {
    private UserKey key;
    private String name;
    private String surname;
    private String mail;

    private User(UserKey key, String name, String surname, String mail) {
        this.key = key;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public static User create(UserKey key, String name, String surname, String mail) {
        return new User(key, name, surname, mail);
    }

    public UserKey getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }
}
