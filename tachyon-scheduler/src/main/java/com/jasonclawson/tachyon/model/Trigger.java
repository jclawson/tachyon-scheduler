package com.jasonclawson.tachyon.model;

import java.util.Set;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import org.joda.time.LocalDateTime;


@Data
public abstract class Trigger {
    /**
     * This value must be unique amongst all triggers
     */
    private String name;
    
    /**
     * Trigger can be tagged with tags in order to find them
     */
    private Set<String> tags;
    
    /**
     * The number of times this trigger has been attempted to be fired
     */
    private int attemptedFiredCount;
    
    @Setter(AccessLevel.NONE)
    private LocalDateTime nextFireTime;
    
    @Setter(AccessLevel.NONE)
    private LocalDateTime dateCreated;
    
    @Setter(AccessLevel.NONE)
    private UUID jobId;
}
