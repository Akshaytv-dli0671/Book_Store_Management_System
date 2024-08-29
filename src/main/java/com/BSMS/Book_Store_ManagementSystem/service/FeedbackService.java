package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback addFeedback(long productId , Feedback feedback);
}

