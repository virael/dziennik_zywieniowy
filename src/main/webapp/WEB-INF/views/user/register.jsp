<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja nowego użytkownika</title>
</head>

<body> 

    <f:form method="post" modelAttribute="user">
		<p>Imię: <f:input path="firstName" /> </p>
		<p>Nazwisko: <f:input path="lastName" /> </p>
		<p>Email: <f:input type="email" path="email" /> </p>
		<p>Hasło: <f:input type="password" path="password" /> </p>
	   
		<p><input type="submit" value="Dodaj użytkownika"/></p>
	</f:form>

</body>
</html>