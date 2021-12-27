package EmployeeManagement.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import EmployeeManagement.bean.Employee;
import EmployeeManagement.dao.EmployeeDAO;



@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	
	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/report":
				showreport(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	//list stock method
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//report generation
		private void showreport(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Employee> listEmployee = employeeDAO.selectAllEmployees();
			request.setAttribute("listEmployee", listEmployee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.forward(request, response);
		}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}

	//Edit employee
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDAO.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee-form.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	//insert employee method
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");		
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String section = request.getParameter("section");
		String designation = request.getParameter("designation");
		String epfnumber = request.getParameter("epfnumber");
		String incrementdate = request.getParameter("incrementdate");
		String basicsalary = request.getParameter("basicsalary");
		
		Employee newEmployee = new Employee(nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary);
		employeeDAO.insertEmployee(newEmployee);
		response.sendRedirect("list");
	}

	//update employee method
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");		
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String section = request.getParameter("section");
		String designation = request.getParameter("designation");
		String epfnumber = request.getParameter("epfnumber");
		String incrementdate = request.getParameter("incrementdate");
		String basicsalary = request.getParameter("basicsalary");

		Employee employee = new Employee(id, nic, name, address, gender, dob, section, designation, epfnumber, incrementdate, basicsalary);
		employeeDAO.updateEmployee(employee);
		response.sendRedirect("list");
	}

	//delete employee method
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.deleteEmployee(id);
		response.sendRedirect("list");

	}
	

}
