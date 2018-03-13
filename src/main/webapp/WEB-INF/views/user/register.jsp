<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja nowego użytkownika</title>
</head>

<body>
  <f:form action="add" method="post" modelAttribute="user">
    <div>
      Imię: <f:input path="firstName"/>
    </div>
    <div>
      Nazwisko: <f:input path="lastName"/>
    </div>
    <div>
      Email: <f:input type="email" path="email"/>
    </div>
    <div>
      Hasło: <f:input type="password" path="password"/>
    </div>
    <div>
      Powtórz hasło: <f:input type="password" path="password"/>
    </div>
    
    <div>
      <input type="submit" value="Dodaj użytkownika"/>
    </div>
  </f:form>
</body>
</html>