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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            .mt-custom {
                margin-top: 50px !important;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold" href="#">
                    <span class="text-danger">AUTO</span>ELITE
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto align-items-center">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Inventario</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Categorías
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Suvs</a></li>
                                <li><a class="dropdown-item" href="#">Sedanes</a></li>
                                <li><a class="dropdown-item" href="#">Pickups / 4x4</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Eléctricos</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#">Financiamiento</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contacto</a>
                        </li>

                        <li class="nav-item ms-lg-3">
                            <a class="btn btn-outline-danger btn-sm" href="cars-form.jsp">Vende tu Auto</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <%
            List<Car> list = (List<Car>) request.getAttribute("carList");
        %>

        <div class="container text-center mb-5 mt-custom">
            <div class="row">
                <% for (Car car : list) {%>    
                <div class="col">                   
                    <div class="card" style="width: 18rem;">
                        <img src="https://www.shutterstock.com/image-vector/flat-car-picture-placeholder-symbol-600nw-2366856295.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"><%=car.getBrand()%> <%=car.getCC()%>cc</h5>
                            <p class="card-text"><%=car.getModel()%></p>
                            <a href="CarsServlet?action=Edit&carId=<%=car.getId()%>" class="btn btn-primary">Edit</a>
                            <a href="CarsServlet?action=Delete&carId=<%=car.getId()%>" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </div>   
                <% }%>  
            </div>
        </div>
    </body>
</html>
