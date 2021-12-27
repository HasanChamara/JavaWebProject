package EmployeeManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EmployeeManagement.bean.Employee;
import EmployeeManagement.bean.Employee;


public class EmployeeDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/sltb?useSSL=false"; //127.0.0.1
	private String jdbcUsername = "root";
	private String jdbcPassword = "Hasan.2000";

	private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees" + "  (nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_EMPLOYEE_BY_ID = "select id, nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary from employees where id =?";
	private static final String SELECT_ALL_EMPLOYEES = "select * from employees";
	private static final String DELETE_EMPLOYEES_SQL = "delete from employees where id = ?;";
	private static final String UPDATE_EMPLOYEES_SQL = "update employees set nic = ?, name = ?, address =?, gender =?,dob=?, section=?, designation=?, epfnumber=?, incrementdate=?, basicsalary=? where id = ?;";

	
	public EmployeeDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//create or insert a employee to the table

	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEES_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				Connection connection = getConnection(); 	//call the getConnection Method 
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) { 	//Pass INSERT_EMPLOYEES_SQL Quarry 
			preparedStatement.setString(1, employee.getNic());
			preparedStatement.setString(2, employee.getName()); 	//Prepared Statement object
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getGender());
			preparedStatement.setString(5, employee.getDob());
			preparedStatement.setString(6, employee.getSection());
			preparedStatement.setString(7, employee.getDesignation());
			preparedStatement.setString(8, employee.getEpfnumber());
			preparedStatement.setString(9, employee.getIncrementdate());
			preparedStatement.setString(10, employee.getBasicsalary());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	//list employee by Individual ID
	
	public Employee selectEmployee(int id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(); //Return ResultSet

			// Step 4: Process the ResultSet object.
			while (rs.next()) {								//Iterate while 
				String nic = rs.getString("nic");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String gender =rs.getString("gender");
				String dob = rs.getString("dob");
				String section = rs.getString("section");
				String designation = rs.getString("designation");
				String epfnumber = rs.getString("epfnumber");
				String incrementdate = rs.getString("incrementdate");
				String basicsalary = rs.getString("basicsalary");
				employee = new Employee(id, nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary);		// Pass values to employee Object
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;			// Return employee Object
	}

	//list All employees
	
	public List<Employee> selectAllEmployees() {

		// using try-with-resources to avoid closing resources
		List<Employee> employees = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(); 

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nic = rs.getString("nic");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String gender =rs.getString("gender");
				String dob = rs.getString("dob");
				String section = rs.getString("section");
				String designation = rs.getString("designation");
				String epfnumber = rs.getString("epfnumber");
				String incrementdate = rs.getString("incrementdate");
				String basicsalary = rs.getString("basicsalary");
				employees.add(new Employee(id, nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}

	//delete employee
	
	public boolean deleteEmployee(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update employee
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);) {
			
			statement.setString(1, employee.getNic());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getGender());
			statement.setString(5, employee.getDob());
			statement.setString(6, employee.getSection());
			statement.setString(7, employee.getDesignation());
			statement.setString(8, employee.getEpfnumber());
			statement.setString(9, employee.getIncrementdate());
			statement.setString(10, employee.getBasicsalary());
			statement.setInt(11, employee.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
