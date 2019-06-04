package com.microblog.model;

import com.google.gson.Gson;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// tells spring that Ips.java is an entry,
@Entity
public class Ips {
    // tells Spring that “id” is a primary key
    @Id
    //  tells Spring that the field is auto-generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ip;

    public Ips() {  }

    public Ips(String ip){
        this.setIp(ip);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getIp() {
        return ip;
    }

    private void setIp(String ip) {
        this.ip = ip;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(new Ips());
    }
}