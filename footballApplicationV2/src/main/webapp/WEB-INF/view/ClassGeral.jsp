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
select{
	height: 100%;
	font-size:30px;
	width: 100%;
	border: 2px solid white;
	color:white;
	background-color: rgba(0, 95,0, 0.4);
	transition: background-color 2s;
}
select :hover{
	background-color: rgba(255, 255,255, 0.4);
}
td{
 text-align: center;
}
#opt1{
	background-color: rgba(255,0,0, 0.6);
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
	background-color: rgba(0,0,255, 0.4);
}
#opt4{
	background-color: rgba(0,0,0, 0.8);
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div align="center">
<form action="ClassGeral" method="post">
<table id="tab1">
<tr>
<td colspan="2">
<p>Classificacao Geral dos Times</p>
</td>
</tr>
<tr>
<td>
<select name="sl" id="sl" required>
<c:forEach items="${lg}" var="g">
<c:if test="${not empty GBusc}">
<c:if test="${g.grp eq cgp}">
<option value="${g.grp}" selected="selected"><c:out value="${g.grp}"></c:out></option>
</c:if>
<c:if test="${g.grp ne cgp}">
<option value="${g.grp}"><c:out value="${g.grp}"></c:out></option>
</c:if>
</c:if>
<c:if test="${empty GBusc}">
<option value="${g.grp}"><c:out value="${g.grp}"></c:out></option>
</c:if>
</c:forEach>
</select>
</td>
<td><input type="submit" name="btb" id="btb" value="buscar"></td>
</tr>
</table>
</form>
</div>
<br>
<div align="center">
<c:if test="${not empty GBusc}">
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
<c:forEach items="${GBusc}" var="a">
<c:if test="${a.otime lt 3}">
<tr id="opt3">
</c:if>
<c:if test="${a.otime gt 2}">
<c:if test="${a.timeStatus eq 'R'}">
<tr id="opt1">
</c:if>
<c:if test="${a.timeStatus eq '-'}">
<tr>
</c:if>
</c:if>
<td><c:out value="${a.grp}"></c:out></td>
<td><c:out value="${a.nomeTime}"></c:out></td>
<td><c:out value="${a.numJogosDisputados}"></c:out></td>
<td><c:out value="${a.vitorias}"></c:out></td>
<td><c:out value="${a.empates}"></c:out></td>
<td><c:out value="${a.derrotas}"></c:out></td>
<td><c:out value="${a.golsMarcados}"></c:out></td>
<td><c:out value="${a.golsSofridos}"></c:out></td>
<td><c:out value="${a.saldoGols}"></c:out></td>
<td><c:out value="${a.pontos}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>
<br>

<div align="center">
<c:if test="${not empty FL}">
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
<c:forEach items="${FL}" var="a">
<c:if test="${a.grp eq cgp}">
<tr id="opt4">
</c:if>
<c:if test="${a.grp ne cgp}">
<c:if test="${a.otime lt 3}">
<tr id="opt3">
</c:if>
<c:if test="${a.otime gt 2}">
<c:if test="${a.timeStatus eq 'R'}">
<tr id="opt1">
</c:if>
<c:if test="${a.timeStatus eq '-'}">
<tr>
</c:if>
</c:if>
</c:if>
<td><c:out value="${a.grp}"></c:out></td>
<td><c:out value="${a.nomeTime}"></c:out></td>
<td><c:out value="${a.numJogosDisputados}"></c:out></td>
<td><c:out value="${a.vitorias}"></c:out></td>
<td><c:out value="${a.empates}"></c:out></td>
<td><c:out value="${a.derrotas}"></c:out></td>
<td><c:out value="${a.golsMarcados}"></c:out></td>
<td><c:out value="${a.golsSofridos}"></c:out></td>
<td><c:out value="${a.saldoGols}"></c:out></td>
<td><c:out value="${a.pontos}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>







</body>
</html>