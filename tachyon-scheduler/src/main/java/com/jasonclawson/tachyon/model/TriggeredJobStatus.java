package com.jasonclawson.tachyon.model;


public enum TriggeredJobStatus {
    /**
     * the trigger has never fired
     */
    NEVER_FIRED,
    
    /**
     * The trigger is supposed to run, but is waiting on the thread pool to 
     * become available to accept it
     */
    WAITING,
    
    /**
     * The trigger waited for the thread pool to become available but no thread
     * was available in the timeout allocated
     */
    BLOCKED,
    
    /**
     * The triggered job is currently running
     */
    RUNNING,
    
    /**
     * The triggered job has completed its run from the last firing of the trigger
     */
    COMPLETE,
    
    /**
     * The triggered job threw an exception on the last firing of the trigger
     */
    ERRORED,
    
    /**
     * This trigger, or tag applied to the trigger is paused
     */
    PAUSED
}
