/**
 * 
 */
package edu.sc.csce740.model;

import edu.sc.csce740.GRADS;
import edu.sc.csce740.exception.InvalidUserException;

/**
 * Class defining a user object for the GRADS system. 
 * @author Maximus Brandel
 * @author Ibrahim Elsayed
 * @author Christian Merchant
 * @version 1.00 2015-11-21
 *
 */
public class User {
	/**
	 * Instance variable containing the id of the user 
	 */
	private String id;
	/**
	 * Instance variable containing the first name of the user
	 */
	private String firstName;
	/**
	 * Instance variable containing the last name of the user
	 */
	private String lastName;
	/**
	 * Instance variable containing the role of the user STUDENT or GRADUATE_PROGRAM_COORDINATOR
	 */
	private String role;
	/**
	 * Instance variable containing the academic department associated with the user
	 */
	private String department;
	/**
	 * Instance variable containing the temporary edit flag that is 
	 * set if a student edits a field that they only have temporary access to
	 */
	private boolean tempEditFlag = false; 
	
	/**
	 * Method to get the string userId of the user
	 * @return the userId as a string
	 */
	public String getUserID() throws InvalidUserException{
		return id;
	}
	
	/**
	 * Method to get the first name of the user
	 * @return firstName the first name of the user
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Method to get the last name of the user as a String
	 * @return lastName the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method to get the role of the user
	 * @return role the role of the user either STUDENT or GRADUATE_PROGRAM-COORDINATOR
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Method to get the academic department of the user
	 * @return department the Department of the user as a string
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Method to set the userId associated with the user
	 * @param userID the userId of the user
	 * @throws InvalidUserException 
	 */
	public void setUserID(String userID) throws InvalidUserException {
		String role = GRADS.getRole();
		if (role.equals("STUDENT") || role.equals("GRADUATE_PROGRAM_COORDINATOR"))
		{
			throw new InvalidUserException("Access Denied: Invalid Permissions");
		}
		this.id = userID;
	}

	/**
	 * Method to set the first name associated with the user
	 * @param firstName the firstName of the user
	 */
	public void setFirstName(String firstName) {
		tempEditCheck(GRADS.getRole());
		this.firstName = firstName;
	}

	/**
	 * Method to set the last name associated with the user
	 * @param lastName the last name of the user
	 */
	public void setLastName(String lastName) {
		tempEditCheck(GRADS.getRole());
		this.lastName = lastName;
	}
	
	/**
	 * Method to set the academic role associated with the user
	 * @param role the role of the user, either STUDENT or GRADUATE_PROGRAM_COORDINATOR
	 * @throws InvalidUserException 
	 */
	public void setRole(String role) throws InvalidUserException {
		validationCheck(GRADS.getRole());
		this.role = role;
	}

	/**
	 * Method to set the department associated with the user
	 * @param department the 
	 * @throws InvalidUserException if a student tries to access this field
	 */
	public void setDepartment(String department) throws InvalidUserException {
		validationCheck(GRADS.getRole());
		this.department = department;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return id + " " + firstName + " "  + lastName + " " + role + " " + department;
		
	}
	/**
	 * Method to get the tempEditFlag in class User. This method returns 
	 * this flag status true if a student edits an instance variable over which they have only temporary 
	 * record edit permissions
	 * @return the flag status
	 */
	public boolean getTempEditStatus()
	{
		return tempEditFlag; 
	}
	/**
	 * Method to set the tempEditFlag in class User. The flag is set to true if a student 
	 * edits an instance variable over which they have only temporary 
	 * record edit permissions
	 * @param flag the flag value to set, true if a temporary edit has been performed, false otherwise
	 */
	private void setUserTempEdit(boolean flag)
	{
		tempEditFlag = flag; 
	}
	
	/**
	 * Method to check if a student is accessing a method that they cannot edit
	 * @param role the role of the user currently using the system
	 * @throws InvalidUserException exception thrown if user cannot access this method call
	 */
	private void validationCheck(String role) throws InvalidUserException
	{
		if (role.equals("STUDENT"))
		{
			throw new InvalidUserException("Access Denied: Access Permissions invalid");
		}
	}
	
	/**
	 * Method to set the temp edit flag if a student is editing a field over which they have
	 * only temporary permissions
	 * @param role the role of the user currently using the system
	 */
	private void tempEditCheck(String role)
	{
		if (role.equals("STUDENT"))
		{
			setUserTempEdit(true);
		}
	}

}
