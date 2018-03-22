<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Potwierdzenie usunięcia posiłku</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style>
	body{
		background-color: #F5F5F5;
	}
	
	.container{
		margin-top: 50px;
	}
</style>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-offset-0 col-l-5">
			<h2>Czy potwierdzasz usunięcie następującego posiłku?</h2>
			<table class="table table-striped">
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
				<input type="submit" class="btn btn-primary btn-md" value="Potwierdź" />
			</f:form>
			<f:form action="list" method="get">
				<input type="submit" class="btn btn-primary btn-md" value="Anuluj" />
			</f:form>
		</div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>