package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Admin;
import com.BSMS.Book_Store_ManagementSystem.repository.AdminRepository;
import com.BSMS.Book_Store_ManagementSystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtil jwtUtil;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found");
        }
        return new org.springframework.security.core.userdetails.User(admin.getAdminUsername(), admin.getAdminPassword(), new ArrayList<>());
    }

    public String generateToken(String username) {
        return jwtUtil.generateToken(username);
    }
}

