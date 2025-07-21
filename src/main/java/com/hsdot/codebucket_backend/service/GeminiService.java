package com.hsdot.codebucket_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.hsdot.codebucket_backend.model.ProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final Client client;
    public String askGemini(String link, String prompt){
        ImmutableMap<String, Object> schema = ImmutableMap.of(
                "type", "object",
                "properties", ImmutableMap.of(
                        "title", ImmutableMap.of("type", "string"),
                        "timeComplexity", ImmutableMap.of("type", "string"),
                        "spaceComplexity", ImmutableMap.of("type", "string"),
                        "explanation", ImmutableMap.of("type", "string"),
                        "approach", ImmutableMap.of("type", "string")
                ),
                "required", ImmutableList.of("title", "timeComplexity", "spaceComplexity", "explanation",  "approach")
        );

        GenerateContentConfig config =
                GenerateContentConfig.builder()
                        .responseMimeType("application/json")
                        .candidateCount(1)
                        .responseJsonSchema(schema)
                        .build();
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", link+prompt, config);

        try{
            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(response.text(), ProblemResponse.class);
            return response.text();
        }catch (Exception e){
            throw new RuntimeException("Failed to fetch the response");
        }
    }
}
