package com.infosys.internal.cde.validators;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserForm{
	
	private Long userId;

	@NotEmpty
	@Size(min=1,max=100)
	private String userName;
	@NotEmpty
	@Size(min=1,max=100)
	@Email
	private String userEmail;
	@NotEmpty
	@Size(min=6,max=20)	
	private String password;
	private String confirmPassword;
	private String userGender;
	
	@Size(min=10,max=20)
	private String phoneNo;
	private String address;
	
	public void setUserId(Long userId){
		   this.userId=userId;
	 }	
	public Long getUserId(){
		 return userId;
	 }
	
	public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
	}
	public String getUserEmail() {
	        return userEmail;
	}
	
	public void setUserName(String userName) {
        this.userName = userName;
	}
	public String getUserName() {
	        return userName;
	}
	
	public void setPassword(String password){
		   this.password=password;
	 }
	public String getPassword(){
		  return password;
	}
	
	public void setConfirmPassword(String confirmPassword){
		   this.confirmPassword=confirmPassword;
	 }
	public String getConfirmPassword(){
		  return confirmPassword;
	}
	
	public void setUserGender(String userGender){
		   this.userGender=userGender;
	 }
	public String getUserGender(){
		  return userGender;
	}
	
	public void setPhoneNo(String phoneNo){
		   this.phoneNo=phoneNo;
	 }
	public String getPhoneNo(){
		  return phoneNo;
	}
	
	public void setAddress(String address){
		   this.address=address;
	 }
	public String getAddress(){
		  return address;
	}
	
}
