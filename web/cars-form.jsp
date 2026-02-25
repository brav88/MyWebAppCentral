<%-- 
    Document   : cars-form
    Created on : 10 feb 2026, 8:17:53 p. m.
    Author     : Personal
--%>

<%@page import="java.util.List"%>
<%@page import="model.pck.myapp.Catalog"%>
<%@page import="model.pck.myapp.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
        <title>JSP Page</title>
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
                            <a class="nav-link active" href="CarsServlet">Inicio</a>
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
        <div class="container text-center mb-5 mt-custom">
            <div class="row">
                <div class="col">                   
                    <%
                        Car car = (Car) request.getAttribute("Car");
                        List<Catalog> carTypeList = (List<Catalog>) request.getAttribute("CarTypeList");
                        List<Catalog> fuelTypeList = (List<Catalog>) request.getAttribute("FuelTypeList");
                        List<Catalog> transmissionList = (List<Catalog>) request.getAttribute("TransmissionList");
                    %>
                    <h1><%= (car == null) ? "Create new car" : "Modify car"%></h1>    

                    <div class="card" style="width: 18rem;">                      
                        <div class="card-body">
                            <form method="POST" action="CarsServlet">
                                <input type="hidden" name="txtCarId" value='<%= (car == null) ? "" : car.getId()%>'/><br>                       
                                <div class="form-floating mb-3">
                                    <input class="form-control" type="text" name="txtBrand"  id="txtBrand" value='<%= (car == null) ? "" : car.getBrand()%>' placeholder="name">
                                    <label for="txtBrand">Brand</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" type="text" name="txtModel"  id="txtModel" value='<%= (car == null) ? "" : car.getModel()%>' placeholder="model">
                                    <label for="txtModel">Model</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <select class="form-select" name="selCarType" aria-label="Default select example">
                                        <% for (Catalog cat : carTypeList) {%>  
                                        <option value="<%=cat.getId()%>"                                                
                                                <%= (car == null) ? "" : (cat.getId() == car.getCarType()) ? "selected" : ""%>                                                
                                                ><%=cat.getDescription()%></option>                                       
                                        <% }%>  
                                    </select>                                   
                                </div>

                                <div class="form-floating mb-3">
                                    <select class="form-select" name="selFuelType" aria-label="Default select example">
                                        <% for (Catalog cat : fuelTypeList) {%>  
                                        <option value="<%=cat.getId()%>" 
                                                <%= (car == null) ? "" : (cat.getId() == car.getFuelType()) ? "selected" : ""%>
                                                ><%=cat.getDescription()%></option>                                       
                                        <% }%>  
                                    </select>
                                </div>

                                <div class="form-floating mb-3">
                                    <select class="form-select" name="selTransmission" aria-label="Default select example">
                                        <% for (Catalog cat : transmissionList) {%>  
                                        <option value="<%=cat.getId()%>"
                                                <%= (car == null) ? "" : (cat.getId() == car.getTranmission()) ? "selected" : ""%>
                                                ><%=cat.getDescription()%></option>                                       
                                        <% }%>  
                                    </select>
                                </div>

                                <div class="form-floating mb-3">
                                    <input class="form-control"  type="number" name="txtCC" id="txtCC" value='<%= (car == null) ? "" : car.getCC()%>' placeholder="1000">
                                    <label for="txtCC">CC</label>
                                </div>
                                <button class="btn btn-primary" type="submit"><%= (car == null) ? "Save" : "Modify"%></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
    </div>
</div>
</body>
</html>
