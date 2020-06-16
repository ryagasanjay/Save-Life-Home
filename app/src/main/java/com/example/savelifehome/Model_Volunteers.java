package com.example.savelifehome;

public class Model_Volunteers {
    private String vname;
    private String vphone;

    public Model_Volunteers(String vname, String vphone) {
        this.vname = vname;
        this.vphone = vphone;
    }

    public Model_Volunteers() {

    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }
}
