<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/genre/add" var="genreAdd"/>
	<sf:form action="${genreAdd}" modelAttribute="newGenre" method="POST">
		<table>
			<tr>
				<td>name:</td>
				<td>
					<sf:input path="name" />
					<sf:errors path="name" />
				</td>
			</tr>
			<tr>
				<td/>
				<td><input type="submit" name="saveNewGenre" value="Save" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>