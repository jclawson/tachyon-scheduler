package com.jasonclawson.tachyon.store;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import org.joda.time.LocalDateTime;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Sets;
import com.jasonclawson.tachyon.model.Job;
import com.jasonclawson.tachyon.model.Trigger;

public class InMemoryStore extends AbstractStore {

	private HashMap<String, Trigger> nameToTrigger = new HashMap<>();
	private HashMap<UUID, Trigger> uuidToTrigger = new HashMap<>();
	private HashMultimap<String, Trigger> tagToTriggers = HashMultimap.create();
	
	private HashMap<String, Job> nameToJob = new HashMap<>();
	private HashMap<UUID, Job> uuidToJob = new HashMap<>();
	private HashMultimap<String, Job> tagToJobs = HashMultimap.create();
	
	
	@Override
	public Trigger getTrigger(UUID id) {
		return uuidToTrigger.get(id);
	}

	@Override
	public Trigger getTrigger(String name) {
		return nameToTrigger.get(name);
	}

	/**
	 * Return the triggers that have all the provided tags
	 */
	@Override
	public Collection<Trigger> getTriggers(String... tags) {
		if(tags.length == 0)
			return Collections.emptySet();
		
		HashSet<Trigger> triggers = new HashSet<>();
		Iterator<String> it = Arrays.asList(tags).iterator();
		String tag = it.next();
		triggers.addAll(tagToTriggers.get(tag));
		
		while(it.hasNext()) {
			tag = it.next();
			triggers.removeAll(Sets.difference(triggers, tagToTriggers.get(tag)));
		}
		
		return triggers;
	}

	@Override
	public Job getJob(UUID id) {
		return uuidToJob.get(id);
	}

	@Override
	public Job getJob(String name) {
		return nameToJob.get(name);
	}

	@Override
	public Collection<Job> getJobs(String... tags) {
		if(tags.length == 0)
			return Collections.emptySet();
		
		HashSet<Job> jobs = new HashSet<>();
		Iterator<String> it = Arrays.asList(tags).iterator();
		String tag = it.next();
		jobs.addAll(tagToJobs.get(tag));
		
		while(it.hasNext()) {
			tag = it.next();
			jobs.removeAll(Sets.difference(jobs, tagToJobs.get(tag)));
		}
		
		return jobs;
	}

	@Override
	public Collection<Trigger> acquireTriggersForExecution(LocalDateTime date, String nodeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markTriggerExecuted(Trigger trigger, LocalDateTime date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void addJob(Job job) {
		nameToJob.put(job.getName(), job);
		uuidToJob.put(job.getId(), job);
		for(String tag : job.getTags()) {
			tagToJobs.put(tag, job);
		}
	}

	@Override
	public synchronized void addTrigger(Trigger trigger) {
		nameToTrigger.put(trigger.getName(), trigger);
		uuidToTrigger.put(trigger.getId(), trigger);
		for(String tag : trigger.getTags()) {
			tagToTriggers.put(tag, trigger);
		}
	}

}
