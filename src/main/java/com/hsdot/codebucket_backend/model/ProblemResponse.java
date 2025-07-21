package com.hsdot.codebucket_backend.model;

import lombok.Data;

@Data
public class ProblemResponse {
    private String title;
    private String titleComplexity;
    private String spaceComplexity;
    private String explanation;
    private String approach;
}
