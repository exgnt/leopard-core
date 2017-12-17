package com.exigent.leopard.core;

import java.net.URI;
import java.net.URISyntaxException;

public class Endpoint {
	
	//private String EndPointAdrdess;
	private Transport EndPointTransport;
	private URI EndpointAddress; 
	private String Scheme;
	private String EndPointDomain;

	public Endpoint() {
		super();
	}
	
	public Endpoint(String edp) {
		if (edp.startsWith("http")) {
			setEndPointTransport(Transport.HTTP);
		}
		try {
			setEndpointAddress(new URI(edp));
			setScheme(this.EndpointAddress.getScheme());
			setEndPointDomain(this.EndpointAddress.getHost());
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
	public URI getEndpointAddress() {
		return EndpointAddress;
	}

	public void setEndpointAddress(URI endpointAddress) {
		EndpointAddress = endpointAddress;
	}

	public Transport getEndPointTransport() {
		return EndPointTransport;
	}

	public void setEndPointTransport(Transport endPointTransport) {
		EndPointTransport = endPointTransport;
	}
	/**
	 * @return the scheme
	 */
	public String getScheme() {
		return Scheme;
	}

	/**
	 * @param scheme the scheme to set
	 */
	public void setScheme(String scheme) {
		Scheme = scheme;
	}

	/**
	 * @return the endPointDomain
	 */
	public String getEndPointDomain() {
		return EndPointDomain;
	}

	/**
	 * @param endPointDomain the endPointDomain to set
	 */
	public void setEndPointDomain(String endPointDomain) {
		EndPointDomain = endPointDomain;
	}

	@Override
	public String toString() {
		return "Endpoint [EndPointAdrdess=" + EndpointAddress + "]";
	}

}
