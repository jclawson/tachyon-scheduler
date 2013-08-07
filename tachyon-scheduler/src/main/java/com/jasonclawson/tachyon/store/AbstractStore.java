package com.jasonclawson.tachyon.store;

import java.util.Collection;
import java.util.UUID;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.model.Job;
import com.jasonclawson.tachyon.model.Trigger;

public abstract class AbstractStore {
    public abstract Trigger getTrigger(UUID id);
    public abstract Trigger getTrigger(String name);
    public abstract Collection<Trigger> getTriggers(String ... tags);
    
    public abstract Job getJob(UUID id);
    public abstract Job getJob(String name);
    public abstract Collection<Job> getJobs(String ... tags);
    
    public abstract void addJob(Job job);
    public abstract void addTrigger(Trigger trigger);
    
    public abstract Collection<Trigger> acquireTriggersForExecution(LocalDateTime date, String nodeName);
    public abstract void markTriggerExecuted(Trigger trigger, LocalDateTime date);
    
}
