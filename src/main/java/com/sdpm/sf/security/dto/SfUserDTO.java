package com.sdpm.sf.security.dto;



/**
 * @author shirukai
 */
public class SfUserDTO{
    private Long id;

    private String description;
    private String username;

    private String password;

    private String role;

    private String url;

    private String token;

    public Long getId() {
        return id;
    }

    public SfUserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SfUserDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SfUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SfUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public SfUserDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SfUserDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getToken() {
        return token;
    }

    public SfUserDTO setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        return "SfUserDTO{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
