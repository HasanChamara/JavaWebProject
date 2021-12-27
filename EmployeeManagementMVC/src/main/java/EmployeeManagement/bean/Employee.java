package EmployeeManagement.bean;

public class Employee {
	protected int id;
	protected String nic;
	protected String name;
	protected String address;
	protected String gender;
	protected String dob;
	protected String section;
	protected String designation;
	protected String epfnumber;
	protected String incrementdate;
	protected String basicsalary;
	
	
	public Employee() {
	}


	public Employee(String nic, String name, String address, String gender, String dob, String section,
			String designation, String epfnumber, String incrementdate, String basicsalary) {
		super();
		this.nic = nic;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.section = section;
		this.designation = designation;
		this.epfnumber = epfnumber;
		this.incrementdate = incrementdate;
		this.basicsalary = basicsalary;
	}


	public Employee(int id, String nic, String name, String address, String gender, String dob, String section,
			String designation, String epfnumber, String incrementdate, String basicsalary) {
		super();
		this.id = id;
		this.nic = nic;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.section = section;
		this.designation = designation;
		this.epfnumber = epfnumber;
		this.incrementdate = incrementdate;
		this.basicsalary = basicsalary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getEpfnumber() {
		return epfnumber;
	}


	public void setEpfnumber(String epfnumber) {
		this.epfnumber = epfnumber;
	}


	public String getIncrementdate() {
		return incrementdate;
	}


	public void setIncrementdate(String incrementdate) {
		this.incrementdate = incrementdate;
	}


	public String getBasicsalary() {
		return basicsalary;
	}


	public void setBasicsalary(String basicsalary) {
		this.basicsalary = basicsalary;
	}
	
	
	
	

}
