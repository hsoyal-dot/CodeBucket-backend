package com.hsdot.codebucket_backend.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final Client client;
    public String askGemini(String link, String prompt){
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", link+prompt, null);

        return response.text();
    }
}
