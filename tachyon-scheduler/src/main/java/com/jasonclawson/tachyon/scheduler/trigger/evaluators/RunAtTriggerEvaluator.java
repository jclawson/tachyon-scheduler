package com.jasonclawson.tachyon.scheduler.trigger.evaluators;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.model.triggers.RunAtTrigger;

public class RunAtTriggerEvaluator implements TriggerEvaluator<RunAtTrigger> {

    @Override
    public LocalDateTime getNextFireTime(RunAtTrigger trigger, LocalDateTime afterInstant) {
        LocalDateTime time = trigger.getRunAt();
        if(time.isBefore(afterInstant)) {
        	return time;
        }
        
        return null;
    }

}
