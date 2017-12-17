package com.exigent.leopard.core;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.*;
@SuppressWarnings("unused")
public class MongoWrapper {
	MongoCollection projects;
	Jongo jongo;
	private MongoCollection mongoLogger;
	private static AtomicInteger current = new AtomicInteger(0);
	private static int limit = 100;	

	
	
	@SuppressWarnings("deprecation")
	public MongoWrapper() {
		current.getAndIncrement();
		if (current.get() < limit){
		DB db = new Mongo().getDB("leopard");
		//DB db = new MongoClient().getDB("leopard");
		jongo = new Jongo(db);
		projects = jongo.getCollection("projects");
		mongoLogger = jongo.getCollection("log");	
		System.out.println("Instanciating wrapper");
		}
		
	}
	public void testSave(String someBs) {
		//projects.save(proj);
		try{
			
			WriteResult result = projects.insert("{ProjectID: 1091, ProjectName: 'GetRetryToVote'}");
		}catch(Exception e ){
			System.out.println("Error");
			e.getLocalizedMessage();
		}
	}
	public void save(Project proj) {
		WriteResult result = projects.insert(proj);
		try{
			projects.insert(proj);
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	public ArrayList<Project> getAllProjects(){
		//returns ALL Projects
		ArrayList<Project> ProjectHolder = new ArrayList<Project>();
		MongoCursor<Project> coll = projects.find().as(Project.class);
		while (coll.hasNext()) {
			ProjectHolder.add(coll.next());
		}
		logItem("Searched for all Projects");
		return ProjectHolder;
	}
	public Project getProjectByID(int i){
		projects = jongo.getCollection("projects");
		Project one = projects.findOne("{_id: "+i+"}").as(Project.class);
		return one;
	}
	public Project getProjectByCode(String code){
		projects = jongo.getCollection("projects");
		Project one = projects.findOne("{ProjectCode: '"+code+"'}").as(Project.class);
		return one;
	}
	public void logItem(String item){
		LogItem logitem = new LogItem(item);
		WriteResult logres = mongoLogger.insert(logitem);
	}

}
