package com.exigent.leopard.core;

import java.util.Date;

import org.jongo.marshall.jackson.oid.MongoId;

public class Service {
	@MongoId
	private int serviceID;
	private String ServiceName;
	private ServiceTypes EnumServiceType;
	private String ServiceDescription;
	private ServiceStatus serviceStatus;
	private String[] serviceDeployEnvironments;
	private Date serviceAdded;
	private Transport serviceTransport;
	//external address
	private Endpoint serviceEndpoint;
	//service address
	private Endpoint serviceAddress;
	
	public Service() {
		super();
		
	}

	public Service(int i) {
		serviceID = i;
		this.ServiceName = "";
	}
	
	public enum ServiceStatus {
        DEVELOPMENT, ACTIVE, DEPRECATED, OFFLINE
        }


	public String getServiceName() {
		return ServiceName;
	}


	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}


	/**
	 * @return the serviceAddress
	 */
	public Endpoint getServiceAddress() {
		return serviceAddress;
	}

	/**
	 * @param serviceAddress the serviceAddress to set
	 */
	public void setServiceAddress(Endpoint serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public ServiceTypes getEnumServiceType() {
		return EnumServiceType;
	}


	public void setEnumServiceType(ServiceTypes enumServiceType) {
		EnumServiceType = enumServiceType;
	}


	public String getServiceDescription() {
		return ServiceDescription;
	}


	public void setServiceDescription(String serviceDescription) {
		ServiceDescription = serviceDescription;
	}

	

	public String[] getServiceDeployEnvironments() {
		return serviceDeployEnvironments;
	}


	public void setServiceDeployEnvironments(String[] serviceDeployEnvironments) {
		this.serviceDeployEnvironments = serviceDeployEnvironments;
	}


	public Date getServiceAdded() {
		return serviceAdded;
	}


	public void setServiceAdded(Date serviceAdded) {
		this.serviceAdded = serviceAdded;
	}


	public Transport getServiceTransport() {
		return serviceTransport;
	}


	public void setServiceTransport(Transport serviceTransport) {
		this.serviceTransport = serviceTransport;
	}


	public Endpoint getServiceEndpoint() {
		return serviceEndpoint;
	}


	public void setServiceEndpoint(Endpoint serviceEndpoint) {
		this.serviceEndpoint = serviceEndpoint;
	}


	public int getServiceID() {
		return serviceID;
	}


	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}


	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}


	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}
