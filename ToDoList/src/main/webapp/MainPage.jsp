<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="sample.Todo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Home Page</title>
</head>
<body>
<h3>To-do List</h3>
	<table border="1" with="600">
		<tr>
			<td>Title</td>
			<td>Description</td>
			<td><a href="NewToDoList.jsp">New To-Do-List</a> </td>	
		</tr>
		<tbody>
			<%
			List<Todo> toDoListData = (List<Todo>)request.getAttribute("toDoList");				
				for(Todo todo : toDoListData){
						out.print("<tr><td>"+todo.getTitle()+"</td><td>"+todo.getDescription()+"</td><td><a href=\"UpdateToDoServlet?id="+todo.getId()+"\">Edit</a></td><td><a href=\"DeleteToDoServlet?id="+todo.getId()+"\">Delete</a></td></tr>");
				}
			%>			 
		</tbody>		
	</table>
</body>
</html>