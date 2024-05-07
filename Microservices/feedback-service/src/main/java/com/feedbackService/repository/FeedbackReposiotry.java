package com.feedbackService.repository;

import com.feedbackService.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackReposiotry extends JpaRepository<Feedback,Integer> {
}
