package com.exigent.leopard.core;

import java.util.List;

import org.jongo.marshall.jackson.oid.MongoId;

public class Project implements Comparable<Project> {
	@MongoId
	private int ProjectID;
	private String ProjectName;
	private String ProjectCode;
	private String ProjectDescription;
	private String ProjectOwner;
	private String ProjectContact;
	private String ProjectContactEmail;
	private String ProjectContactPhone;
	private List<ServiceVersion> ProjectServiceVersions;
	
	public Project(){
		
	}
	
	public Project(int i, String code, String name) {
		this.ProjectID = i;
		this.ProjectCode = code;
		this.ProjectName = name;
	}
	public void setProjectOwnership(String owner, String contact, String email, String phone){
	setProjectContact(contact);
	setProjectContactEmail(email);
	setProjectOwner(owner);
	setProjectContactPhone(phone);
	}
	
	
	@Override
	public String toString() {
		return "Project [ProjectName=" + ProjectName + ", ProjectCode=" + ProjectCode + ", ProjectDescription="
				+ ProjectDescription + ", ProjectOwner=" + ProjectOwner + ", ProjectContact=" + ProjectContact
				+ ", ProjectContactEmail=" + ProjectContactEmail + ", ProjectContactPhone=" + ProjectContactPhone
				+ ", ProjectServiceVersions=" + ProjectServiceVersions.toString() + ", ProjectID=" + ProjectID
				+ "]";
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectCode() {
		return ProjectCode;
	}
	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
	}
	public String getProjectDescription() {
		return ProjectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}
	public String getProjectOwner() {
		return ProjectOwner;
	}
	public void setProjectOwner(String projectOwner) {
		ProjectOwner = projectOwner;
	}
	public String getProjectContact() {
		return ProjectContact;
	}
	public void setProjectContact(String projectContact) {
		ProjectContact = projectContact;
	}
	public String getProjectContactEmail() {
		return ProjectContactEmail;
	}
	public void setProjectContactEmail(String projectContactEmail) {
		ProjectContactEmail = projectContactEmail;
	}
	public String getProjectContactPhone() {
		return ProjectContactPhone;
	}
	public void setProjectContactPhone(String projectContactPhone) {
		ProjectContactPhone = projectContactPhone;
	}
	public List<ServiceVersion> getProjectServiceVersions() {
		return ProjectServiceVersions;
	}

	public void setProjectServiceVersions(List<ServiceVersion> projectServiceVersions) {		
		ProjectServiceVersions = projectServiceVersions;
	}
	public void addProjectServices(ServiceVersion projectServiceVersion) {	
		ProjectServiceVersions.add(projectServiceVersion);
	}
	public int getProjectID() {
		return ProjectID;
	}
	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	@Override
	public int compareTo(Project o) {
		int compareid = o.getProjectID();

		//ascending order
		return this.ProjectID - compareid;		
	}
	

}
