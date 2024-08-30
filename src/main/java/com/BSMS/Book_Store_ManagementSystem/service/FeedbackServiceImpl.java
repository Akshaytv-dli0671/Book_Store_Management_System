package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.CustomInvalidException;
import com.BSMS.Book_Store_ManagementSystem.model.Feedback;
import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.repository.FeedbackRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.ProductRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Feedback addFeedback(long id,Feedback feedback) {
        User user = userRepository.findById(feedback.getUser().getUser_id()).orElseThrow(()-> new CustomInvalidException("User not found with the given id"));
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new CustomInvalidException("Product not found"));


        Feedback feedback1 = new Feedback(feedback.getRating(), feedback.getText(),feedback.getCreatedAt(), user,product);

        return feedbackRepository.save(feedback1);

    }

    public List<Feedback> findAllFeedback()
    {
        return feedbackRepository.findAll();
    }

}
