<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sample.Todo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update To-do List</title>
</head>
<body>
<h3>Update To-do List</h3>
	<form action="UpdateToDoServlet" method="POST" >
<% Todo todo = (Todo)request.getAttribute("EditTodoObject");%>	
			Title :	
			<input type="text" name="title" value="<%=todo.getTitle()%>"/><br>		
		
			Description :
			<input type="text" name="description" value="<%=todo.getDescription()%>"/>
			
			<input type="hidden" name="id" value="<%=todo.getId()%>"/>
			
			<input type="submit" value="submit">			
		
		</form>				
			
</body>
</html>