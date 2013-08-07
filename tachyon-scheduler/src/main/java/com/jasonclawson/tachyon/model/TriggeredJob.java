package com.jasonclawson.tachyon.model;

import lombok.Data;

@Data
public class TriggeredJob {//this is reallt a dto
    private TriggeredJobStatus status;//mve to trigger
    private Trigger trigger;
    private Job job;
}
