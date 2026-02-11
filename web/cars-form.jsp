<%-- 
    Document   : cars-form
    Created on : 10 feb 2026, 8:17:53 p. m.
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create new car</h1>
        <form method="POST" action="CarsServlet">
            Brand: <input type="text" name="txtBrand" /><br>
            Model <input type="text" name="txtModel" /><br>
            CC: <input type="number" name="txtCC" /><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
