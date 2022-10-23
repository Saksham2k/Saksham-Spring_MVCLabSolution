<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp" %>		
</head>
<body>

	<div class="container mt-3">
	
		<div class = "row">
		
			<div class = "col-md-12">
			
				<h1 class = "text-center mb-3">Welcome to Student Management Application</h1>
				<table class = "table">
				
					<thead class = "thead-dark">
					<tr>
					
						<th scope = "col">Id</th>
						<th scope = "col">Student Name</th>
						<th scope = "col">Department</th>
						<th scope = "col">Country</th>
						<th scope = "col">Action</th>
					
					</tr>
					</thead>
					<tbody>
					
						<c:forEach items = "${students}" var = "s">
						
							<tr>
							
								<th scope = "row">${s.id}</th>
								<td>${s.name }</td>
								<td>${s.department }</td>
								<td>${s.country }</td>
								<td>
								
									<a href = "Delete/${s.id }"><i class = "fas fa-trash text-danger"></i></a>
									<a href = "Update/${s.id }"><i class = "fas fa-pen-nib text-primary"></i></a>
								
								</td>
							
							</tr>
						
						</c:forEach>
					
					</tbody>
				</table>
				
				<div class = "container text-center">
				
					<a href = "Add" class = "btn btn-outline-success">Add Student</a>
				
				</div>
			
			</div>
		
		</div>
	
	</div>

</body>
</html>