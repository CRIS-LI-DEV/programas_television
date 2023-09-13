<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
   
    <div class="panel-heading" id="a">     <h1>Edit your show!</h1>
  <h2>  <c:out value="${show.getName()}"></c:out></h2>   
    </div>
    <div class="panel-body">
   

<c:out value="${mensajeShow}"></c:out>
 
 <form action="/shows/edit" method="post">
 <input type="hidden" value="<c:out value="${show.getId()}"></c:out>" name="show_id">
 
  <table class="table">
  <tbody>
  <tr> <td>  <label>Title : </label>  </td>   <td>  <input name="name_show" type="text" class="form-control" minLength="2"> <br> </td> </tr>
  
  <tr> <td> <label>Network : </label>  </td>   <td> <input name="name_network" type="text" class="form-control" minLength="2">   </td> </tr>
 
 <tr>  <td> <input type="submit" value="Edit!!! " class="form-control btn btn-danger"> </td> <td> </td> </tr>
  </tbody>
  
  </table>



 
 
 </form>
    
       <a href="/shows/<c:out value="${show.getId()}"></c:out>/delete">Delete shows </a>
   
    </div>
    </div>
    </div>
    
    <div class="col-md-2"> </div>
</div>
</div>

</body>
</html>