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
<title>Food diary - meal list</title>
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
	         <span class="glyphicon glyphicon-log-out"></span> Logout
	        </button>
	        </a>
	      </p>
		  <h2>Welcome ${user.firstName }, here's your meal list</h2>
		  
		  <table class="table table-striped">
		    <tr>
		        <!--<th>Id</th>-->
		        <th>Name</th>
		        <th>Carbohydrates</th>
		        <th>Protein</th>
		        <th>Fat</th>
		        <th>Calories</th>
		        <th>Date and time</th>
		        <th>Edit</th>
		        <th>Delete</th>
		    </tr>
		    <c:forEach items="${meals}" var="meal">
		        <tr>
		           <!-- <td>${meal.id}</td>-->
		            <td>${meal.name}</td>
		            <td>${meal.carbs}</td>
		            <td>${meal.protein}</td>
		            <td>${meal.fat}</td>
		            <td>${meal.kcal}</td>
		            <td><fmt:formatDate pattern="dd/MM/yyyy, hh:mm" value="${meal.date}" /></td>
		            <!--<td>${meal.date}</td>-->
		            <td><a href="<c:url value='edit?id=${meal.id}'/>">Edit meal</a></td>
		            <td><a href="<c:url value='remove?id=${meal.id}'/>">Remove meal</a></td>
		            
		        </tr>
		    </c:forEach>
		  </table>
		  <a href="<c:url value='add?id=${user.id}'/>">Add new meal</a>
     </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>