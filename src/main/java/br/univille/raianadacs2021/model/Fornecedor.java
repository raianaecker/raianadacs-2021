package br.univille.raianadacs2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String API_PATH;
    private String API_AUTH_PATH;
    private String user;
    private String password;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAPI_PATH() {
        return API_PATH;
    }
    public void setAPI_PATH(String aPI_PATH) {
        API_PATH = aPI_PATH;
    }
    public String getAPI_AUTH_PATH() {
        return API_AUTH_PATH;
    }
    public void setAPI_AUTH_PATH(String aPI_AUTH_PATH) {
        API_AUTH_PATH = aPI_AUTH_PATH;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    
}