<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dziennik żywieniowy - lista wszytskich posiłków</title>
</head>
<body>
  <h2>Witaj, ${diary_user.id }, oto Twoja lista posiłków</h2>
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
    <c:forEach items="${meals}" var="meal">
        <tr>
            <td>${meal.id}</td>
            <td>${meal.name}</td>
            <td>${meal.carbs}</td>
            <td>${meal.protein}</td>
            <td>${meal.fat}</td>
            <td>${meal.kcal}</td>
            <td>${meal.date}</td>
            <td><a href="<c:url value='edit?id=${meal.id}'/>">Edytuj posiłek</a></td>
            <td><a href="<c:url value='remove?id=${meal.id}'/>">Usuń posiłek</a></td>
            
        </tr>
    </c:forEach>
  </table>
  <a href="<c:url value='add'/>">Dodaj nowy posiłek</a>
</body>
</html>