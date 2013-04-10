package com.jasonclawson.tachyon.job.domain;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

@Data
public class Job {
    private UUID id;
    
    /**
     * This key must be unique amongst all jobs
     */
    private String name;
    
    /**
     * By default this will represent the class name of the job we will run
     */
    private String jobReference;
    
    /**
     * JobDefinition can be tagged with tags in order to find them
     */
    private Set<Tag> tags;
} 
