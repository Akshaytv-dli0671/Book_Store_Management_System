package com.BSMS.Book_Store_ManagementSystem.model;

import lombok.Data;


public enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    @Override
    public String toString() {
        // Customize the string representation if needed
        return "en";
    }
}


