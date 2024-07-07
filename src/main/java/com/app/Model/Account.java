package com.app.Model;

public class Account {
    private String id;
    private Boolean role;
    private String username;
    private String password;
    private String namaLengkap;

    public Account() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
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

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public void setAccount(String id, Boolean role, String username, String password, String namaLengkap) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
    }

    public void removeAccount() {
        this.id = null;
        this.role = null;
        this.username = null;
        this.password = null;
        this.namaLengkap = null;
    }
}
