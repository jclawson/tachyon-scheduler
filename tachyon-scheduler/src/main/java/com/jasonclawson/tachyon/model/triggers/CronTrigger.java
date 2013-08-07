package com.jasonclawson.tachyon.model.triggers;

import lombok.Getter;
import lombok.Setter;

import com.jasonclawson.tachyon.model.Trigger;

@Getter
@Setter
public class CronTrigger extends Trigger {
	private String cronExpression;
	
}
