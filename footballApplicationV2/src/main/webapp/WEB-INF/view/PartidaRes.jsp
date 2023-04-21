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
input{
	width: 100%;
	font-size:30px;
	border: 2px solid white;
	color:white;
	background-color: rgba(0, 95,0, 0.4);
	transition: background-color 2s;
}
input:hover{
	background-color: rgba(255, 255,255, 0.4);
}
select{
	width: 100%;
	font-size:30px;
	border: 2px solid white;
	color:white;
	padding: 0px;
	background-color: rgba(0, 95,0, 0.4);
}
td{
 text-align: center;
}
#exb{
	width: 50%;
	font-size: 15px;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div align="center">
<form action="PartidaRes" method="post">
<table id="tab1">
<tr>
<td colspan="2">
<p>Partidada Times</p>
</td>
</tr>
<tr>
<td>
<select id="st1" name="st1" onchange="this.form.submit()" required>
<option value=""></option>
<c:if test="${not empty TimesN }">
<c:forEach items="${TimesN}" var="t">
<c:if test="${not empty SeleT}">
<c:if test="${SeleT eq t }">
<option value="${t}" selected = selected><c:out value="${t}"></c:out></option>
</c:if>
<c:if test="${SeleT ne t }">
<option value="${t}"><c:out value="${t}"></c:out></option>
</c:if>
</c:if>
<c:if test="${empty SeleT}">
<option value="${t}"><c:out value="${t}"></c:out></option>
</c:if>
</c:forEach>
</c:if>
</select>
</td>
<td><input type="date" id="btdt" name="btdt" onchange="this.form.submit()" required
value="${cdata}"></td>
</tr>
</table>
<br>

<c:if test="${not empty psm }">
<table id="tab1">
<thead>
<tr id="exb">
<th>Time: <c:out value="${psm.t1nome}"></c:out></th>
<th>Time: <c:out value="${psm.t2nome}"></c:out> </th>
</tr>
</thead>
<tbody>
<tr id="exb">
<td>psm.grp Gols <input type="number" id="t1nb" name="t1nb" step="1" min="0" value="${psm.t1gols }"></td>
<td>psm.grp Gols <input type="number" id="t2nb" name="t2nb" step="1" min="0" value="${psm.t2gols }"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" id="upd" name="upd" value="Atualizar"></td>
</tr>
</tbody>
</table>
</c:if>
</form>
</div>
</body>
</html>