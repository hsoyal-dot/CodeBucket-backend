package com.hsdot.codebucket_backend.controller;

import com.hsdot.codebucket_backend.model.ProblemRequest;
import com.hsdot.codebucket_backend.model.ProblemResponse;
import com.hsdot.codebucket_backend.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GeminiController {

    String prompt = " Analyze this LeetCode problem and fill in the values for title, time complexity, space complexity, explanation, and approach.";
    private final GeminiService gs;

    @GetMapping("/ask")
    public String askGeminiAPI(@RequestBody ProblemRequest req){
        return gs.askGemini(req.getLink(), this.prompt);
    }
}
