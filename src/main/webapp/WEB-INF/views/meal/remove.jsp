<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Potwierdzenie usunięcia posiłku</title>
</head>
<body>
	<h2>Czy potwierdzasz usunięcie następującego posiłku?</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Węglowodany</th>
			<th>Białko</th>
			<th>Tłuszcz</th>
			<th>Kalorie</th>
			<th>Data</th>
		</tr>
		<tr>
			<td>${meal.id}</td>
			<td>${meal.name}</td>
			<td>${meal.carbs}</td>
			<td>${meal.protein}</td>
			<td>${meal.fat}</td>
			<td>${meal.kcal}</td>
			<td>${meal.date}</td>
		</tr>
	</table>
	<f:form action="remove" method="post" modelAttribute="meal">
		<f:hidden path="id" />
		<input type="submit" value="Potwierdź" />
	</f:form>
	<f:form action="list" method="get">
		<input type="submit" value="Anuluj" />
	</f:form>
</body>
</html>