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
td{
 text-align: center;
}
#opt1{
	background-color: rgba(255,0,0, 0.8);
}
#opt2{
	background-color: rgba(0, 95,0, 0.4);
	-webkit-backdrop-filter: blur(5px);
    backdrop-filter: blur(5px);
	color:white;
	width: 100%;
	table-layout: fixed;
}
#opt3{
	background-color: rgba(255,255,0, 0.8);
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div align="center">
<form action="GTdados" method="post">
<table id="tab1">
<tr>
<td><p>Status dos Grupos</p></td>
</tr>
<tr>
<td><input type="submit" name="btsg" id="btsg" value="LISTAR GRUPOS"></td>
</tr>
</table>
</form>
</div>
<br>

<c:if test="${ not empty ListaGRP }">
<c:forEach items="${ListaGRP}" var="a">
<div align="center">
<table border="1" id ="opt2">
<thead>
<tr>
<td>Grupo</td>
<td>NomeTime</td>
<td>NumeroJogos</td>
<td>Vitorias</td>
<td>Empates</td>
<td>Derrotas</td>
<td>GolsMarcados</td>
<td>GolsSofridos</td>
<td>SaldoGols</td>
<td>Pontos</td>
</tr>
</thead>
<tbody>
<c:forEach items="${ListaT}" var="at">
<c:if test="${at.grp eq a.grp }">
<c:if test="${at.timeStatus eq 'R'}">
<tr id="opt1">
</c:if>
<c:if test="${at.timeStatus eq 'C'}">
<tr id="opt3">
</c:if>
<c:if test="${at.timeStatus eq '-'}">
<tr>
</c:if>
<td><c:out value="${at.grp}"></c:out></td>
<td><c:out value="${at.nomeTime}"></c:out></td>
<td><c:out value="${at.numJogosDisputados}"></c:out></td>
<td><c:out value="${at.vitorias}"></c:out></td>
<td><c:out value="${at.empates}"></c:out></td>
<td><c:out value="${at.derrotas}"></c:out></td>
<td><c:out value="${at.golsMarcados}"></c:out></td>
<td><c:out value="${at.golsSofridos}"></c:out></td>
<td><c:out value="${at.saldoGols}"></c:out></td>
<td><c:out value="${at.pontos}"></c:out></td>
</tr>

</c:if>
</c:forEach>
</tbody>
</table>
</div>
<br>
</c:forEach>
</c:if>


</body>
</html>