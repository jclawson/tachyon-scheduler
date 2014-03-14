package com.jasonclawson.tachyon.model;

import java.util.Set;

import lombok.Data;

@Data
public class Job {
    /**
     * This key must be unique amongst all jobs...
     * .... no I don't want this to be unique unless we configure a job to be unique
     * 
     */
    private String name;
    
    /**
     * By default this will represent the class name of the job we will run
     */
    private String jobReference;
    
    /**
     * JobDefinition can be tagged with tags in order to find them
     */
    private Set<String> tags;
} 
