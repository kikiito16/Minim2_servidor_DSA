package edu.upc.dsa.models.api;

public class CompleteCredentials {
    private String username;
    private String password;
    private String fullName;
    private String email;

    public CompleteCredentials(String username, String password, String fullName, String email)
    {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public CompleteCredentials(){}

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String dateBirth) {
        this.fullName = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
