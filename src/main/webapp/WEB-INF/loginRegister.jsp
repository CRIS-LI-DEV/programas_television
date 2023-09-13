<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="estilo.css">
<body>

<div class="container">
<div class="row">
<div class="col-md-1"> </div>
<div class="col-md-5">

<div class="panel panel-primary" id="b">
   
    <div class="panel-heading" id="a"> <h3>Login!</h3></div>
    <div class="panel-body">
   <h1><c:out value="${error}"></c:out></h1> 

<form action="/login" method="post" >
<label >Email : </label>
<input type="text" name="email" class="form-control"><br>
<label >Password : </label>

<input type="password" name="password" class="form-control"><br>
 <p><input type="submit" value="Login!" class="form-control" ></p>
</form>
 
    </div>
    </div>
   

</div>
<div class="col-md-5">
<div class="panel panel-primary" id="b">
   
    <div class="panel-heading" id="a">     <h3>Register!</h3></div>
    <div class="panel-body">
   
 




    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/reg" modelAttribute="user">
       
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" class="form-control" />
        </p>
       
         
        
            <p>
            <form:label path="email">Email:</form:label>
            <form:input path="email" class="form-control" />
        </p>
        
        
        
        
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password" class="form-control" />
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation" class="form-control" />
        </p>
        <input type="submit" value="Register!" class="form-control"/>
    </form:form>
    
    
    </div>
    </div>
    </div>
    
    <div class="col-md-2"> </div>
</div>
</div>

</body>
</html>