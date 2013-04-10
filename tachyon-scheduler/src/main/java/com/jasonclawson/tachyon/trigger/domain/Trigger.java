package com.jasonclawson.tachyon.trigger.domain;

import java.util.Set;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import org.joda.time.DateTime;

import com.jasonclawson.tachyon.job.domain.Tag;

@Data
public abstract class Trigger {
    private UUID id;
    
    /**
     * This value must be unique amongst all triggers
     */
    private String name;
    
    /**
     * Trigger can be tagged with tags in order to find them
     */
    private Set<Tag> tags;
    
    @Setter(AccessLevel.NONE)
    private DateTime nextFireTime;
    
}
