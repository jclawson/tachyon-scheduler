Trigger and Job
----------
I removed UUID id from Trigger and Job. There is really no point. The name of each is required to be unique so that should be the primary key.


Trigger
----------
A trigger can never fire the same job more than once at the same time. This is so that you can lookup a Trigger to get the status of a job. A trigger has a status. Note: different triggers can run the same job at the same time... unless that job is set to prevent concurrent runs (Stateful in Quartz)


TrigeredJob
----------
I would like to track instances of a fired job called TriggeredJob. Each one of these instances should be given a unique UUID... a runId... A run ID can be used to lookup statuses/info in the past.