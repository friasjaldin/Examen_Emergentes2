<%-- 
    Document   : index
    Created on : 13-04-2021, 07:08:26 PM
    Author     : CristhianFriasJaldin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Vacunados"%>
<%@page import="com.emergentes.modelo.GestorVacunas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("agenda")==null){
    GestorVacunas objeto1=new GestorVacunas();
    session.setAttribute("agenda", objeto1);
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen Emergentes</title>
    </head>
    <body>
        <table border="0" style="margin: 0 auto;" bgcolor="FF6406" >
        <td rowspan="20"> </tr>
        <tr><td><b>PRIMER PARCIAL EMERGENTES 2  </b></td>  
        <tr><td><b>Nombre:  </b></td> <td>Cristhian Jaime Frias Jaldin</td> 
        <tr><td><b>Ci:  </b></td> <td >10072610 lp</td>
         <tr><td><b>email:  </b></td> <td>friasyoyo@gmail.com </td> 
        <tr><td><b>celular|whatsapp:  </b></td> <td>60122932 </td>
       </table>

        <h1 style="color:red">REGISTRO DE VACUNAS</h1>
        <a href="Principal?op=nuevo">Nuevo Registro</a>
        <table border="1" style="margin: 0 auto;" cellpadding="1" cellspacing="0"  width="100%" height="80" bgcolor="yellow">
            
            <tr style="color:black">
                <th bgcolor="FF4040">Id</th>
                <th bgcolor="FF4040">Nombre</th>
                <th bgcolor="FF4040">Peso</th>
                <th bgcolor="FF4040">Talla</th>
                <th bgcolor="FF4040">Vacuna</th>
                <th bgcolor="FF4040">Editar</th>
                <th bgcolor="FF4040">Eliminar</th>
            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
                <tr style="color:black">
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.peso}</td>
                    <td>${item.talla}</td>
                    <td>${item.vacuna}</td>
                    <td><a href="Principal?op=modificar&id=${item.id}">Editar</a></td>
                    <td><a href="Principal?op=eliminar&id=${item.id}">Eliminar</a></td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>

