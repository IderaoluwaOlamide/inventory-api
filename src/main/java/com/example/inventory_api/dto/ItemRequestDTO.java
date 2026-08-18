package com.example.inventory_api.dto;

public class ItemRequestDTO {
    private String name;
    private int quantity;
    private double price;
    private Long categoryId;

    public ItemRequestDTO(String name, int quantity, double price, Long categoryId){
        this.name = name;
        this.quantity =quantity;
        this.price = price;
        this.categoryId = categoryId;
    }
    public ItemRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
