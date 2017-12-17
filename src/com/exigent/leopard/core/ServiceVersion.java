package com.exigent.leopard.core;

import java.util.List;

import org.jongo.marshall.jackson.oid.MongoId;

@SuppressWarnings("unused")
public class ServiceVersion {
	
	@MongoId
	private int versionNumber;
	private String VersionReadable;
	private List<Service> services;
	
	public ServiceVersion(int i, String version) {
		this.versionNumber = i;
		this.VersionReadable = version;
	}

	public ServiceVersion() {
		super();
	}

	public List<Service> getServices() {
		return services;
	}
	
	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void addService(Service serv) {
		this.services.add(serv);	
	}
}
