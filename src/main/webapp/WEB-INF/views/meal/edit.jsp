<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytowanie posiłku</title>
</head>
<body>
  <f:form method="post" modelAttribute="meal">
    <div>
      Nazwa: <f:input path="name"/>
    </div>
    <div>
      Węglowodany: <f:input path="carbs"/>
    </div>
    <div>
      Białko: <f:input path="protein"/>
    </div>
    <div>
      Tłuszcze: <f:input path="fat"/>
    </div>
    <div>
      Kalorie: <f:input path="kcal"/>
    </div>
    <div>
      Data: <f:input type="datetime-local" path="date"/>
    </div>
    
    <div>
      <input type="submit" value="Dodaj posiłek"/>
    </div>
  </f:form>
</body>
</html>