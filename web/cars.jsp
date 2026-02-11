<%-- 
    Document   : cars
    Created on : 10 feb 2026, 6:25:14 p. m.
    Author     : Personal
--%>

<%@page import="java.util.List"%>
<%@page import="model.pck.myapp.Car"%>
<%@page import="database.pck.myapp.Database"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <a href="cars-form.jsp">Create new car</a>
        
        <%
            List<Car> list = (List<Car>)request.getAttribute("carList");
        %>

        <table>
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Cubic Capacity</th>
            </tr>
            <% for (Car car : list) { %>                                
            <tr>
                <td><%=car.getBrand()%></td>
                <td><%=car.getModel()%></td>
                <td><%=car.getCC()%></td>
            </tr>
            <% }%>
        </table>
        <a href='index.html'>Regresar</a>
    </body>
</html>
