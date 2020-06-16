package com.example.savelifehome;

public class Model_ContactsForTracing {
    private String cname, cphone, caddress;

    public Model_ContactsForTracing() {
    }

    public Model_ContactsForTracing(String cname, String cphone, String caddress) {
        this.cname = cname;
        this.cphone = cphone;
        this.caddress = caddress;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }
}
