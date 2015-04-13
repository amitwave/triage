package com.wave.command;


import java.util.List;

public class UserCommand {
    private String name;
    private String email;
    private String password;
    private String displayName;
    private List<RoleCommand> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<RoleCommand> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleCommand> roles) {
        this.roles = roles;
    }
}
