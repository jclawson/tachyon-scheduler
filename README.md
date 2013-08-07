Tachyon Enterprise Job Scheduler (in project planning phase...)
=======

Enterprise Job Scheduler

TODO
------
* add support for H2 store and JDBC store

Architecture Questions
----------------------------
* Should we use/require Hazelcast?  Or should we try and reduce dependencies and opt for simple webservices to communicate / database.  Perhaps use hazelcast at first because it offers us some really easy to use features but abstract it so that we could eliminate this dependency later.

Changes in comparison with Quartz
----------------------------
* support cancelling jobs on any node (using tag, job name, running instance id)
* job intermediate status tracking (% done, custom status message)
* support job tags instead of job group
* better trigger support (occurrence / rrule based trigger)
* better node failure misfire detection even when clock drift is present or GC time prevents checkin (use db clock time)
* more easily defined and understood misfire protocols
* job concurrency configuration (ie: jobs with __ tag(s) can only run 2 at a time) to prevent particularly expensive jobs from running concurrently.
* easy job partitioning.  ie: you want to run an expensive job every 4 hours.  Instead, run it every hour doing 1/4 of the work
* sensible exceptions
* annotation driven job triggers
* statistics / more visibility into what the scheduler is doing
* pluggable db connection pool (c3po, dbcp, ?that other one?, default to???)
* dynamically increase / decrease threads based on customizable hueristics (JVM low on memory / high CPU contention... reduce thread count)
* pluggable storage services.  Mongo?  Redis?  ... provide JDBC, H2, in memory out of the box
* named scheduler topologies for supporting multiple scheudlers in the same app

Quartz features we will make easier / better
----------------------------
* (quartz where) controlling where jobs run in the cluster.  Do this by tag / dynamically updating cluster aware statistics.
* job management ui (separate project)
* 

Future Features
------------------
* support running as a standalone server (separate project?) that accepts uploading of jobs as OSGI bundles / jars / groovy scripts.
* job chaining / simple workflow support.  Run job A and job B, when they are both finished, run job C.  Jobs spawning from other jobs like this (optionally?) inheret the parent's tags.