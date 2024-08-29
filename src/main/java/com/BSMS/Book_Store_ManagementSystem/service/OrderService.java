package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Order;

public interface OrderService {
    Order placeOrder(Long userId);
}
