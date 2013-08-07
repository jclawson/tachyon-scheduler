package com.jasonclawson.tachyon.scheduler.trigger.evaluators;

import java.text.ParseException;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.model.triggers.CronTrigger;

public class CronTriggerEvaluator implements TriggerEvaluator<CronTrigger> {

    @Override
    public LocalDateTime getNextFireTime(CronTrigger trigger, LocalDateTime afterInstant) throws EvaluationException {
        try {
			CronExpression expression = new CronExpression(trigger.getCronExpression());
			return new LocalDateTime(expression.getNextValidTimeAfter(afterInstant.toDate()));			
		} catch (ParseException e) {
			throw new EvaluationException(trigger.getCronExpression()+" is an invalid cron expression", e);
		}
    }

}
