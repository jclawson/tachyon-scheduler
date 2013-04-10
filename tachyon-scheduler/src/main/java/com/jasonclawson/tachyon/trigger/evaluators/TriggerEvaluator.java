package com.jasonclawson.tachyon.trigger.evaluators;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.trigger.domain.Trigger;

/**
 * Should we decompose triggers into domain / services?
 * The TriggerService (and a class for each type of trigger)
 * 
 * would handle trigger evaluation, calendar evaluation, ... general business logic 
 * concerns.
 * 
 * The trigger classes would be focused on deserializing their trigger data into 
 * logical fields for easy evaluation by the trigger service and easy construction 
 * for developers who are creating the trigger.
 * 
 * serialization should be done with a json object.... gson?  jackson?
 * 
 * @author jclawson
 *
 */
public interface TriggerEvaluator<T extends Trigger> {
    public abstract LocalDateTime getNextFireTime(T trigger, LocalDateTime afterInstant);
}
