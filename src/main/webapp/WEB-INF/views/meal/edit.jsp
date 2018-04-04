<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytowanie posiłku</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style>
	body{
		background-color: #F5F5F5;
	}
	
	.container{
		margin-top: 50px;
	}
	.wrapper{
		margin-top: 5px;
	}
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-3">
        <a href="/meal/list">
	     <button type="button" class="btn btn-default navbar-btn pull-right">
	        <span class="glyphicon glyphicon-chevron-left"></span>
     	 </button>
     	 </a>
        <h4>Edytuj posiłek:</h4>
            <div class="form-login">
			  <f:form method="post" modelAttribute="meal">
			    <div>
			      Nazwa: <f:input path="name" class="form-control input-sm chat-input" required="true" />
			    </div>
			    <div>
			      Węglowodany: <f:input path="carbs" class="form-control input-sm chat-input" />
			    </div>
			    <div>
			      Białko: <f:input path="protein" class="form-control input-sm chat-input" />
			    </div>
			    <div>
			      Tłuszcze: <f:input path="fat" class="form-control input-sm chat-input" />
			    </div>
			    <div>
			      Kalorie: <f:input path="kcal" class="form-control input-sm chat-input" />
			    </div>
			    <div>
			      Data: <f:input type="datetime-local" path="date" class="form-control input-sm chat-input" />
			    </div>
			    <div class="wrapper">
						<input type="submit" class="btn btn-primary btn-md" value="Zmień posiłek"/>
					</div>
			  </f:form>
  			</div>
	      </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>