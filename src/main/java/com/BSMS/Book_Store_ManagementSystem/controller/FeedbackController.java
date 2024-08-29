package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Feedback;
import com.BSMS.Book_Store_ManagementSystem.service.FeedbackService;
import com.BSMS.Book_Store_ManagementSystem.service.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
public class FeedbackController {

    @Autowired
    FeedbackServiceImpl feedbackImplementation;

    @PostMapping("/add/feedback")
    public Feedback addProductFeedback(@RequestParam long id , @RequestBody Feedback feedback)
    {
        feedback.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        return feedbackImplementation.addFeedback(id,feedback);
    }
    @GetMapping("/get/feedback")
    public List<Feedback> getAllFeedback()
    {
        return feedbackImplementation.findAllFeedback();
    }


}

