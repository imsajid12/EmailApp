import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String email;
	private int defaultPasswordLength = 10;
	private String companySuffix = "konnect.com";
	
	//Constructor to recieve the firstname & last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMPLOYEE NAME: " + this.firstName + " " + this.lastName);
		
		//Call a method asking for department - return the department
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		//Call a method that returns a password
		this.password = generateRandomPassword(defaultPasswordLength);
		System.out.println("System generated password for you: " + this.password);
		
		//Combine employee attribute to generate email
		email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is: " + email);
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODE: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
		Scanner sc = new Scanner(System.in);
		int departChoice = sc.nextInt();
		
		if(departChoice == 1) { return "sales"; }
		else if(departChoice == 2) { return "development"; }
		else if(departChoice == 3) { return "accounting"; }
		else if(departChoice == 1) { return "none"; }
		else { return "none"; }
	}
	
	//Generate a random password
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@$!";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int random = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getNewPassword() {
		return password;
	}
	
	public String showInfo() {
		return  "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
				
	}
}
