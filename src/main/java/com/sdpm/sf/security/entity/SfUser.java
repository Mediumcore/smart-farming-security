package com.sdpm.sf.security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author shirukai
 */
@Entity
public class SfUser {
    @Id
    private long id;
    private String description;
    private String username;

    private String password;
    private String basePassword;
    private String role;

    private String url;

    public long getId() {
        return id;
    }

    public SfUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUrl() {
        return url;
    }

    public SfUser setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SfUser setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBasePassword() {
        return basePassword;
    }

    public SfUser setBasePassword(String basePassword) {
        this.basePassword = basePassword;
        return this;
    }
}
