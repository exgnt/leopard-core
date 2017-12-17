package com.exigent.leopard.core;

import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Outage {
	
	int outageid;
	Date fromTime;
	Date toTime;
	Duration outageDuration;
	Project RelatedProject;
	
	public Outage(Date fromTime, Date toTime, Project relatedProject) {
		super();
		this.fromTime = fromTime;
		this.toTime = toTime;
		
		this.outageDuration = Duration.between(null, null);
		RelatedProject = relatedProject;
		
		
	}
}
