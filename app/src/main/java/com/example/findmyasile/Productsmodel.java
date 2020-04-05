package com.example.findmyasile;

public class Productsmodel {
    private String Pasile;
    private String Pname;

    public String getPasile() {
        return Pasile;
    }

    public Productsmodel() {
    }

    public Productsmodel(String Pasile, String Pname) {
        this.Pasile = Pasile;
        this.Pname = Pname;
    }


    public void setPasile(String pasile) {
        Pasile = pasile;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }
}
