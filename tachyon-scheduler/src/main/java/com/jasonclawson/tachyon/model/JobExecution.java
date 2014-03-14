package com.jasonclawson.tachyon.model;

import lombok.Data;

import org.joda.time.DateTime;

@Data
public class JobExecution {//this is reallt a dto
    private TriggeredJobStatus status;//mve to trigger
    private Trigger trigger;
    private Job job;
    private DateTime dateStarted;
    private DateTime dateFinished;
}
