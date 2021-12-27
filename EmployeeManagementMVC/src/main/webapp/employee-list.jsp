<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<style type="text/css">
body {
    background-image:url(emp.jpg);
}
.myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

.header{
   background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
</style>
</head>
<body>

	<header>
		
			<div class="header">
    				<h1>SLTB Management</h1>
			</div>

		
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h2 class="text-center">EMPLOYEE DETAILS</h2>
		
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-secondary">ADD
					New Employee</a>
					
				<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for NIC" title="Type in a name">	

			</div>
			<br>
			<table class="table table-bordered table table-hover"id="myTable">
				<thead class="thead-dark">
					<tr>
						<th>Emp ID</th>
						<th>NIC</th>
						<th>Employee Name</th>
						<th>Address</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Section</th>
						<th>Designation</th>
						<th>EPF Number</th>
						<th>Increment Date</th>
						<th>Basic Salary</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.nic}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.address}" /></td>
							<td><c:out value="${employee.gender}" /></td>
							<td><c:out value="${employee.dob}" /></td>
							<td><c:out value="${employee.section}" /></td>
							<td><c:out value="${employee.designation}" /></td>
							<td><c:out value="${employee.epfnumber}" /></td>
							<td><c:out value="${employee.incrementdate}" /></td>
							<td><c:out value="${employee.basicsalary}" /></td>
						
							<td>
							<div class="btn-group">
                                        <label class="p-0 mr-1 my-0">
                                            <a href="edit?id=<c:out value='${employee.id}' />"><button type="submit" class="btn btn-primary">Edit</button></a>
                                        </label>
                                        <label class="p-0 my-0">
                                            <a href="delete?id=<c:out value='${employee.id}' />"><button type="submit" class="btn btn-danger"value="delete" onclick="return confirm('Are you sure you want to delete?')">Delete</button>
                                        </label>   
                                    </div>	
							</td>
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
			
			<script>
			function myFunction() {
				  // Declare variables
				  var input, filter, table, tr, td, i, txtValue;
				  input = document.getElementById("myInput");
				  filter = input.value.toUpperCase();
				  table = document.getElementById("myTable");
				  tr = table.getElementsByTagName("tr");

				  // Loop through all table rows, and hide those who don't match the search query
				  for (i = 0; i < tr.length; i++) {
				    td = tr[i].getElementsByTagName("td")[0];
				    if (td) {
				      txtValue = td.textContent || td.innerText;
				      if (txtValue.toUpperCase().indexOf(filter) > -1) {
				        tr[i].style.display = "";
				      } else {
				        tr[i].style.display = "none";
				      }
				    }
				  }
				}
</script>

<a href="<%=request.getContextPath()%>/report" > <button type="button" class="btn btn-success">Employee Report</button></a>

		</div>
	</div>
	
	<!-- FOOTER -->
        <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p>&copy; 2021 &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>
</body>
</html>
