package com.valtech.training.dept;

public class EDepartment implements EdeptDao {
	private String DepName;
	private String Manager;
	private String Location;
	
	public EDepartment(){}
	public EDepartment(String DepName,String Manager,String Location){
		this.DepName=DepName;
		this.Manager=Manager;
		this.Location=Location;
		
	}

//	public void Department(String DepName,String Manager,String Location){
//		this.DepName=DepName;
//		this.Manager=Manager;
//		this.Location=Location;
//		
//	}
	
	@Override
	public String toString() {
		return "EDepartment [DepName=" + DepName +", Manager="
				+ Manager + ", Location=" + Location+ "]";
	}
	
	public String getDepName() {
		return DepName;
		
	}

	public void setDepName(String DepName) {
		this.DepName=DepName;
	}
	public String getManager() {
			return Manager;
			
		}

	public void setManager(String Manager) {
			this.Manager=Manager;
	}

	public String getLocation() {
				return Location;
				
			}

	public void setLocation(String Location) {
				this.Location=Location;
	}

}
