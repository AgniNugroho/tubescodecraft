package com.app.Model;

public class DataAkun {
    private String id;
    private String username;
    private String namaLengkap;

    public DataAkun(String id, String username, String namaLengkap) {
        this.id = id;
        this.username = username;
        this.namaLengkap = namaLengkap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
}
