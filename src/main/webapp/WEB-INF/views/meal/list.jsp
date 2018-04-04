<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dziennik żywieniowy - lista wszytskich posiłków</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style>
	body{
		background-color: #F5F5F5;
	}
</style>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-offset-0 col-l-5">
        <p>
		   <a href="/user/logout">
	        <button type="button" class=" btn pull-right btn btn-default btn-sm">
	         <span class="glyphicon glyphicon-log-out"></span> Wyloguj
	        </button>
	        </a>
	      </p>
		  <h2>Witaj ${user.firstName }, oto Twoja lista posiłków</h2>
		  
		  <table class="table table-striped">
		    <tr>
		        <th>Id</th>
		        <th>Nazwa</th>
		        <th>Węglowodany</th>
		        <th>Białko</th>
		        <th>Tłuszcz</th>
		        <th>Kalorie</th>
		        <th>Data i godzina</th>
		        <th>Edytuj</th>
		        <th>Usuń</th>
		    </tr>
		    <c:forEach items="${meals}" var="meal">
		        <tr>
		            <td>${meal.id}</td>
		            <td>${meal.name}</td>
		            <td>${meal.carbs}</td>
		            <td>${meal.protein}</td>
		            <td>${meal.fat}</td>
		            <td>${meal.kcal}</td>
		            <td><fmt:formatDate pattern="dd/MM/yyyy, hh:mm" value="${meal.date}" /></td>
		            <!--<td>${meal.date}</td>-->
		            <td><a href="<c:url value='edit?id=${meal.id}'/>">Edytuj posiłek</a></td>
		            <td><a href="<c:url value='remove?id=${meal.id}'/>">Usuń posiłek</a></td>
		            
		        </tr>
		    </c:forEach>
		  </table>
		  <a href="<c:url value='add?id=${user.id}'/>">Dodaj nowy posiłek</a>
     </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>