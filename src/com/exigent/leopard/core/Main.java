package com.exigent.leopard.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exigent.leopard.core.Service.ServiceStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	//Simple runnable class to test the implementation
	public static void main(String[] args) {
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().create();
		
		Endpoint enp = new Endpoint("mq://cmainframe.net:9090/GQX");
		System.out.println(enp.getEndPointDomain());
		Service serv = new Service(101);
		serv.setServiceEndpoint(enp);
		serv.setServiceTransport(enp.getEndPointTransport());
		serv.setServiceAdded(new Date());
		//serv.setServiceID(100);
		serv.setServiceName("MQ-sert");
		serv.setServiceStatus(ServiceStatus.DEPRECATED);
		serv.setServiceDescription("Deployed by Bamboo");
		serv.setServiceDeployEnvironments(new String[]{"DEV","TEST"});
		
		ServiceVersion version = new ServiceVersion(1,"Version: 0.0.1 SNAPSHOT");
		List<Service> services = new ArrayList<Service>();
		services.add(serv);
		version.setServices(services);
		
		Project project = new Project(104,"CMQ", "Mainframe MQ connection" );
		project.setProjectDescription("an mq project");
		project.setProjectOwnership("Danish mq team", "D Trump", "d.trump@effen.com", "097235890");
		List<ServiceVersion> serviceVersions = new ArrayList<ServiceVersion>();
		serviceVersions.add(version);
		project.setProjectServiceVersions(serviceVersions);
		
		String fromJson = gson.toJson(project);
		System.out.println(fromJson);

		MongoWrapper mongo = new MongoWrapper();
		//mongo.testSave("");
		mongo.save(project);
		//System.out.println("SAVED");
		//mongo.save(project);
		//Project stx = mongo.getProjectByID(103);
		//
		Project pp = mongo.getProjectByCode("CMQ");
		System.out.println("ready:"+pp.toString());
		ArrayList<Project> projects = new ArrayList<Project>();
		projects = mongo.getAllProjects();
		for (Project project2 : projects) {
			System.out.println(project2.getProjectServiceVersions().get(0).getServices().get(0).getServiceEndpoint().toString());
		}
		mongo.logItem("Test Executed!");

	}

}
