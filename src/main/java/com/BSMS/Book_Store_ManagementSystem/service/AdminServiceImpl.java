package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Admin;
import com.BSMS.Book_Store_ManagementSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void registerAdmin(Admin admin) {
        admin.setAdminPassword(admin.getAdminPassword());
        admin.setCreated_at(new Timestamp(System.currentTimeMillis()));
        adminRepository.save(admin);
    }

    @Override
    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminRepository.findByAdminUsername(username);
        return admin != null && admin.getAdminPassword().equals(password);
    }
}
