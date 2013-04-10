package com.jasonclawson.tachyon.trigger.evaluators;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.trigger.domain.CronTrigger;

public class CronTriggerEvaluator implements TriggerEvaluator<CronTrigger> {

    @Override
    public LocalDateTime getNextFireTime(CronTrigger trigger, LocalDateTime afterInstant) {
        // TODO Auto-generated method stub
        return null;
    }

}
