package com.hsdot.codebucket_backend.controller;

import com.hsdot.codebucket_backend.model.ProblemRequest;
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

//    String prompt = " ,Analyze this given link and STRICTLY provide me in json format like: title: problemName, timeComeplexity: x, spaceComplexity: y, explanation: aboutQuestionIn8Lines, approach: toSolveThis (not too long)";
    String prompt = " ,Search on google and STRICTLY provide me in json format like: title: problemName, timeComeplexity: x, spaceComplexity: y, explanation: aboutQuestionIn8Lines, approach: toSolveThis (not too long)";
    private final GeminiService gs;
    @GetMapping("/ask")
    public String askGeminiAPI(@RequestBody ProblemRequest req){
        return gs.askGemini(req.getLink(), this.prompt);
    }
}
