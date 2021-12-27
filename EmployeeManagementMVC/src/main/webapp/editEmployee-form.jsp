<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style type="text/css">
.header{
   background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
  
  }
  .well{
      background-color: #C0C0C0;
      padding:24px;
      border-radius:16px
  }
   
   
</style>
<title>SLTB Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>

	<header>
		
			<div class="header">
    				<h1>SLTB Management</h1>
			</div>

	</header>
	
	<br>
	<div class="container">
    <h1 align ="center" class="well">Update Employee Details</h1>
	<div class="col-lg-12 well">
	<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="btn btn-secondary" class="nav-link">View All Employees</a></li>
			</ul>
	<br>
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post">
				</c:if>

				<caption>
					<h2>
						
					<c:if test="${employee == null}">
            			
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>NIC</label> <input type="text"placeholder="Type NIC no here"
						value="<c:out value='${employee.nic}' />" class="form-control"
						name="nic" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"placeholder="Type name here"
						value="<c:out value='${employee.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Address</label> <input type="text" placeholder="Type address here" 
						value="<c:out value='${employee.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Gender</label>
                             <select placeholder="Select the gender" class="form-control" name ="gender" value="<c:out value='${employee.gender}' />">
                                        <option>Male</option>
                                        <option>female</option>
							</select>
				
				</fieldset>
				
				<fieldset class="form-group">
					<label>Date of birth</label> <input type="date"
						value="<c:out value='${employee.dob}' />" class="form-control"
						name="dob">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Section</label>
					<select placeholder="Select the Section" name= "section" class="form-control" 
						value="<c:out value='${employee.section}'/>" >
                                                      
                                                            <option >Racing</option>
                                                            <option >Engineering</option>
                                                            <option >Security</option>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Section</label>
					<select placeholder="Select the designation" name= "designation" class="form-control" 
						value="<c:out value='${employee.designation}'/>" >
                                                      
                                                            <option >Operational</option>
                                                            <option >Staff</option>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>EPF Number</label> <input type="number"oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength = "4"
						placeholder="Type EPF NUmber here"value="<c:out value='${employee.epfnumber}' />" class="form-control"
						name="epfnumber">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Increment Date</label> <input type="date"
						value="<c:out value='${employee.incrementdate}' />" class="form-control"
						name="incrementdate">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Basic salary</label>
					<input type="number" placeholder="Basic salary Here.." name= "basicsalary" class="form-control" value="<c:out value='${employee.basicsalary}'/>" >	 
					
				</fieldset>
				
				
				<button type="submit" class="btn btn-info"value="update" onclick="return confirm('Successfully updated employee details!')">UPDATE</button>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
