package com.BSMS.Book_Store_ManagementSystem.repository;

import com.BSMS.Book_Store_ManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.user_name = :username")
    User findByUsername(@Param("username") String username);

}
