<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SLTB Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"crossorigin="anonymous">
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
	
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

		<div class="container">
			<h2 class="text-center">EMPLOYEE REPORT</h2><br><br>
		
			<div class="container text-left">
			
			<a href="employee-form.jsp" class="btn btn-secondary">ADD
					New Employee</a>

					<br><br>
				<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Employee ID" title="Type in a name">	

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
						
						
					</tr>
				</thead>
				<tbody>
				
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
						
						</tr>
					</c:forEach>
				
				</tbody> 

			</table>
			
			<script type="text/javascript">
        function Export() {
            html2canvas(document.getElementById('myTable'), {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Employee Report.pdf");
                }
            });
        }
    </script>
			
			
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

		<input type="button" id="btnExport" class="btn btn-success" value="Download Report" onclick="Export()" />

		</div>
	</div>
	
	
	
	<!-- FOOTER -->
        <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p>SLTB Management © 2021 . &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>
</body>

</html>

