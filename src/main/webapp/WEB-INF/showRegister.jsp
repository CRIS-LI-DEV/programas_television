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
  <link rel="stylesheet" href="/estilo.css">
<body>

<div class="container">
<div class="row">

<div class="col-md-4">


</div>
<div class="col-md-4">
<div class="panel panel-primary" id="b">
   
    <div class="panel-heading" id="a">     <h1>Create a new show!</h1></div>
    <div class="panel-body">
   

<c:out value="${mensajeShow}"></c:out>
    
 <form action="/shows" method="post">
  <table class="table">
  <tbody>
  <tr> <td>  <label>Title : </label>  </td>   <td>  <input name="name_show" type="text" class="form-control" minLength="2"> <br> </td> </tr>
  
  <tr> <td> <label>Network : </label>  </td>   <td> <input name="name_network" type="text" class="form-control" minLength="2">  </td> </tr>
 
 <tr>  <td> <input type="submit" value="Create!!! " class="form-control btn btn-danger"> </td> <td> </td> </tr>
  </tbody>
  
  </table>



 
 
 </form>
    
   
    </div>
    </div>
    </div>
    
    <div class="col-md-2"> </div>
</div>
</div>

</body>
</html>