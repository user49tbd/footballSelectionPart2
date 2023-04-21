<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#tab1{
	font-size:40px;
	color:white;
	text-align:center;
	width: 50%;
}
input[type=submit]{
	height: 100%;
	font-size:30px;
	width: 100%;
	border: 2px solid white;
	color:white;
	background-color: rgba(0, 95,0, 0.4);
	transition: background-color 2s;
}
input[type=submit]:hover{
	background-color: rgba(255, 255,255, 0.4);
}
#maintxt{
	background-color: rgba(0, 95,0, 0.4);
    -webkit-backdrop-filter: blur(5px);
    backdrop-filter: blur(5px);
	color:white;
	width: 50%;
	table-layout: fixed;
}
td{
 text-align: center;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div align="center">
<form action="finais" method="post">
<table id="tab1">
<tr>
<td><p>Finais</p></td>
</tr>
<tr>
<td><input type="submit" name="btf" id="btf" value="LISTAR PARTIDAS"></td>
</tr>
</table>
</form>
</div>
<br>

<div align="center">
<c:if test="${not empty ListaF}">
<table border="1" id="maintxt">
<thead>
<tr>
<td>Time-1</td>
<td>---</td>
<td>Time-2</td>
</tr>
</thead>
<tbody>
<c:forEach items="${ListaF}" var="a">
<tr>
<td><c:out value="${a.timeA}"></c:out></td>
<td>X</td>
<td><c:out value="${a.timeB}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>

</body>
</html>