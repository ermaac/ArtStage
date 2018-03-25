package by.bsuir.spp.painters.dto;

import by.bsuir.spp.painters.model.Profile;

public class UserDto {
    private int id;
    private String login;
    private String password;
    private String role;
    private Profile profile;

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
