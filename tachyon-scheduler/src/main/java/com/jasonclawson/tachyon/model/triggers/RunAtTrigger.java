package com.jasonclawson.tachyon.model.triggers;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.LocalDateTime;

import com.jasonclawson.tachyon.model.Trigger;

@Getter
@Setter
public class RunAtTrigger extends Trigger {
	private LocalDateTime runAt;
}
