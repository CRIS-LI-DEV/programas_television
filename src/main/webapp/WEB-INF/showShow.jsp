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

<link rel="stylesheet" href="../estilo.css">


</head>
<body>

<div class="container">
<div class="row">

<div class="col-md-2"></div>
<div class="col-md-8">
<div class="panel panel-primary" id="b">
   
    <div class="panel-heading" id="a">
 <h1><c:out value="${show.getName()}"></c:out></h1>
</div>
    <div class="panel-body">
<h2>
  Network : <c:out value="${show.getNetwork().getName()}"></c:out><br>
  </h2>
 <h1>USer who rated ths show</h1>

<table border="1" class="table">
<thead>

<tr> 


<th> User</th> 


<th> Rating </th> 



 
 
</tr>

</thead>


<tbody>

<c:forEach items="${show.getRatings()}" var="r">
<tr>
<td>

${r.getUser().getName()} <br>
</td>

<td>

${r.getRating_pts()} <br>
</td>


</tr>
</c:forEach>


</tbody>
</table>



    </div>
    </div>
    <h2>
    Leave a rating
    </h2>

  
   <c:set var="co" value="${0}" />
   
   <c:forEach items="${show.getRatings()}" var="r" >
   
   
    <c:choose>
         
         <c:when test = "${r.getUser().getId() == id_user}">
            <c:set var="co" value="${1}" />
         </c:when>
         
         </c:choose>
   
   
   </c:forEach>
 
 
   <c:choose>
    <c:when test = "${co == 0}">
<form action="/shows/rat" method="post">
<input type="number" name="rat" min="1" max="5">

<input type="hidden" name="id_show" value="<c:out value="${show.getId()}"></c:out>">
<input type="submit" value="Rated!!" class="btn btn-danger">
</form>
       </c:when>
</c:choose>
<br>
      <a href="/shows/<c:out value="${showID}"></c:out>/edi">Edit shows </a></div> 
    
    
    
 
    <div class="col-md-2"> </div>
</div>
</div>



</body>
</html>