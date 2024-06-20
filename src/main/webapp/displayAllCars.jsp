<%@page import="cms.Car"%>
<%@page import="java.util.List"%>
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
	List<Car> cars = (List) request.getAttribute("carList");
	%>

	<table border="">

		<tr>

			<th>CarId</th>
			<th>CarModel</th>
			<th>CarBrand</th>
			<th>CarPrice</th>
			<th>UPDATE</th>
			<th>DELETE</th>

		</tr>
		<%
		if(cars!=null && !cars.isEmpty()){
		for (Car car : cars) {
		%>
		<tr>
			<td><%=car.getCarId()%></td>
			<td><%=car.getCarModel()%></td>
			<td><%=car.getCarBrand()%></td>
			<td><%=car.getCarPrice()%></td>
			<td><a href="updateCar?carId=<%=car.getCarId()%>">UPDATE</a></td>
			<td><a href="deleteCar?carId=<%=car.getCarId()%>">DELETE</td>

		</tr>
		<%
		}}
		%>
	</table>

</body>
</html>