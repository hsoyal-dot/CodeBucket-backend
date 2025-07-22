package com.hsdot.codebucket_backend.controller;

import com.hsdot.codebucket_backend.model.ProblemRequest;
import com.hsdot.codebucket_backend.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GeminiController {

    String prompt = " Analyze this LeetCode problem and fill in the values for title, time complexity, space complexity, explanation, and approach.";
    private final GeminiService gService;
    @PostMapping("/ask")
    public String askGeminiAPI(@RequestBody ProblemRequest req) {
        return gService.askGemini(req.getLink(), this.prompt);
    }
}
