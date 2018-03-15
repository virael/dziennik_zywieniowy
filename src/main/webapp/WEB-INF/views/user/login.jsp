<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logowanie</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style>
	body{
		background-color: #F5F5F5;
	}
	
	.container{
		margin-top: 100px;
	}
</style>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-offset-4 col-md-3">
        <h4>Witaj ponownie</h4>
            <div class="form-login">
            
			<f:form method="post" modelAttribute="loginData">
				<p><f:input path="email" class="form-control input-sm chat-input" placeholder="Email" required="true" /></p>
				<p><f:password path="password" class="form-control input-sm chat-input" placeholder="Hasło" required="true" /></p>
				<div class="wrapper">
				<p><input type="submit" class="btn btn-primary btn-md" value="Zaloguj"/></p>
				</div>
			</f:form>
			<P>Nie masz konta? <a href="http://localhost:8080/dziennik_zywieniowy/user/register">Rejestracja</a></P>
			</div>
	      </div>
    </div>
</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>