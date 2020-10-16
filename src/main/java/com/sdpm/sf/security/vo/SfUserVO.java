package com.sdpm.sf.security.vo;

/**
 * @author shirukai
 */
public class SfUserVO {
    private Long id;
    private String description;
    private String username;
    private String password;
    private String role;

    private String url;

    public Long getId() {
        return id;
    }

    public SfUserVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SfUserVO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SfUserVO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SfUserVO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SfUserVO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRole() {
        return role;
    }

    public SfUserVO setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "SfUserVO{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
