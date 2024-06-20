<%@page import="cms.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
Car car= (Car)request.getAttribute("dcar");
%>

<form action="deleteCar" method="post">

<input type="number" name="carId" value="<%=car.getCarId() %>" readonly="readonly">
<input type="text" name="carModel" value="<%=car.getCarModel() %>"  readonly="readonly">
<input type="text" name="carBrand" value="<%=car.getCarBrand() %>" readonly="readonly">
<input type="number" name="carPrice" value="<%=car.getCarPrice() %>" readonly="readonly">
<input type="submit" value="Delete">



</form>
</body>
</html>