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

    String prompt = " Analyze the following LeetCode problem and return only the following fields: Title, Time Complexity (Big-O), Space Complexity (Big-O), Approach (short summary of the method or algorithm used), Explanation (step-by-step beginner-friendly explanation), and Problem Tags (a list of related concepts like “array”, “two-pointer”, etc.). Respond in a clean, labeled format with no extra commentary or conversation.";
    private final GeminiService gService;
    @PostMapping("/ask")
    public String askGeminiAPI(@RequestBody ProblemRequest req) {
        return gService.askGemini(req.getLink(), this.prompt);
    }
}
