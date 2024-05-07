package com.feedbackService.controller;

import com.feedbackService.dto.FeedbackRequest;
import com.feedbackService.dto.FeedbackResponse;
import com.feedbackService.model.Feedback;
import com.feedbackService.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    private static final Logger logger = Logger.getLogger(FeedbackController.class.getName());

    @PostMapping("/addFeedback")
    public void addFeedback(@RequestBody FeedbackRequest feedbackRequest){
        feedbackService.addFeedback(feedbackRequest);
    }
    @GetMapping ("/all")
    public List<FeedbackResponse> getAllFeedbacks(){
        logger.info("Getting all feedbacks");
        return feedbackService.getAllfeedbacks();
    }
    //admin will use this method
    @GetMapping("/getFeedbackById/{id}")
    public Feedback getFeedbackById(@PathVariable int id) {
        return feedbackService.getFeedbackById(id);
    }

    //admin will use this method
    @PutMapping("/updateFeedback/{id}")
    public Feedback updateFeedback(@PathVariable int id, @RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.updateFeedback(id, feedbackRequest);
    }
    //admin will use this method
    @DeleteMapping("/deleteFeedback/{id}")
    public void deleteFeedback(@PathVariable int id) {
        feedbackService.deleteFeedback(id);
    }
}
