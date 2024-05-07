package com.feedbackService.service;

import com.feedbackService.dto.FeedbackRequest;
import com.feedbackService.dto.FeedbackResponse;
import com.feedbackService.model.Feedback;
import com.feedbackService.repository.FeedbackReposiotry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackReposiotry feedbackReposiotry;
    private static final Logger logger = Logger.getLogger(FeedbackService.class.getName());

    public void addFeedback(FeedbackRequest feedbackRequest){
      Feedback feedback = mapFeedbackRequestToFeedback(feedbackRequest);
      feedbackReposiotry.save(feedback);
        logger.info("Feedback added successfully");
    }

    public Feedback getFeedbackById(int feedbackId) {
        return feedbackReposiotry.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("feedback not found"));
    }

    //Admin use this method
    public Feedback updateFeedback(int feedbackId, FeedbackRequest feedbackRequest) {
        Feedback existingFeedback = getFeedbackById(feedbackId);
        existingFeedback.setMessage(feedbackRequest.getMessage());
        existingFeedback.setCreationDate(feedbackRequest.getCreationDate());
        return feedbackReposiotry.save(existingFeedback);
    }

    //Admin use this method
    public void deleteFeedback(int feedbackId) {
        Feedback existingReview = getFeedbackById(feedbackId);
        feedbackReposiotry.delete(existingReview);
        logger.info("Feedback deleted successfully");
    }

    //FeedbackRequest ==> Feedback
    private Feedback mapFeedbackRequestToFeedback(FeedbackRequest feedbackRequest){
        Feedback feedback = new Feedback();
        feedback.setCreationDate(new Date());
        feedback.setMessage(feedbackRequest.getMessage());
        feedback.setUserId(feedbackRequest.getUserId());
        return feedback;
    }

    @Transactional
    public List<FeedbackResponse> getAllfeedbacks() {
        List<Feedback> products = feedbackReposiotry.findAll();
        return products.stream().map(this:: mapToFeedbackResponse).collect(Collectors.toList());
    }

    private FeedbackResponse mapToFeedbackResponse(Feedback feedback){
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setId(feedback.getId());
        feedbackResponse.setCreationDate(feedback.getCreationDate());
        feedbackResponse.setMessage(feedback.getMessage());
        feedbackResponse.setUserId((feedback.getUserId()));
        return feedbackResponse;
    }
}