<%@page import="java.util.List"%>
<%@page import="demo.Employee"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	<h3>Employee Details</h3>
	<table border="1" with="600">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Age</td>
		</tr>
		<tbody>
			<%
				List<Employee> empData = (List<Employee>)request.getAttribute("empData");
				for(Employee e : empData){
					out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td></tr>");
				}
			%>
		</tbody>
	</table>
	
	
	<table border="1" with="600" class="table">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Age</td>
		</tr>
		<tbody>
			<c:forEach items="${empData}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>