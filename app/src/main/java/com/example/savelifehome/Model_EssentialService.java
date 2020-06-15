package com.example.savelifehome;

public class Model_EssentialService {
    private String name, phone, instructions, category;

    public Model_EssentialService() {
    }

    public Model_EssentialService(String name, String phone, String instructions, String category) {
        this.name = name;
        this.phone = phone;
        this.instructions = instructions;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

