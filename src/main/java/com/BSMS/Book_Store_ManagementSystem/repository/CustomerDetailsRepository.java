package com.BSMS.Book_Store_ManagementSystem.repository;

import com.BSMS.Book_Store_ManagementSystem.model.Customer_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<Customer_Details,Long> {
    @Query("select c from Customer_Details c where c.user.user_id=:userId")
    Customer_Details findbyUserID(@Param("userId")Long userId);
}
