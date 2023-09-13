<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="estilo.css">
</head>
<body>



<div class="container">
<div class="row">


<div class="panel panel-primary" id="b">
   
    <div class="panel-heading" id="a">

<h1>Welcome <c:out value="${user.getName() }"></c:out>
</h1>
</div>
    <div class="panel-body">
<h2>TV SHOWS</h2>
<table  class="table">
<thead>

<tr> 

<th> Show </th> 

<th> Network </th> 

<th> AvgRating </th> 

 
 
</tr>

</thead>


<tbody>

<c:forEach items="${shows}" var="s">
<tr>
<td>
<a href="/shows/${s.getId() }">${s.getName()}<br>
</a>
</td>

<td>
${s.getNetwork().getName()}
<br>
</td>




 
<td>

${s.getAvg_rating()}

   
</td>

</tr>
</c:forEach>


</tbody>
</table>
<div>
<a href="/shows/new"> Add Show</a>
</div>



</div>
</div>
</div>
</div> 


</body>
</html>