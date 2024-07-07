package com.app.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Account {
    
    public String id;
    public Boolean role;
    public String username;
    public String password;
    public String namaLengkap;
    public int c1Score;

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

    public int getC1Score() {
        return c1Score;
    }

    public void setC1Score(int c1Score) {
        this.c1Score = c1Score;
    }

    public void setAccount(String id, Boolean role, String username, String password, String namaLengkap, int c1Score) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.c1Score = c1Score;
    }

    public void saveAccount() {
        String filePath = "src/main/resources/JSON/DataUser.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JsonArray accounts = JsonParser.parseString(content).getAsJsonArray();
            JsonObject accountJson = gson.toJsonTree(this).getAsJsonObject();

            boolean found = false;
            for (int i = 0; i < accounts.size(); i++) {
                JsonObject existingAccount = accounts.get(i).getAsJsonObject();
                if (existingAccount.get("id").getAsString().equals(this.id)) {
                    accounts.set(i, accountJson);
                    found = true;
                    break;
                }
            }

            if (!found) {
                accounts.add(accountJson);
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(accounts, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeAccount() {
        this.id = null;
        this.role = null;
        this.username = null;
        this.password = null;
        this.namaLengkap = null;
        this.c1Score = 0;
    }
}
