<%-- 
    Document   : login
    Created on : 10 mar 2026, 7:12:00 p. m.
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>       
    </head>
    <body>      
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold" href="#">
                    <span class="text-danger">AUTO</span>ELITE
                </a>
            </div>
        </div>
    </nav>
    <div class="d-flex justify-content-center align-items-center">
        <div class="card" style="width: 18rem;margin-top:30px">    
            <div class="card-header">
                Login
            </div>
            <div class="card-body">
                <form method="POST" action="LoginServlet">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" name="txtEmail" placeholder="name@example.com">
                        <label for="floatingInput">Email address</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" name="txtPwd" placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <hr>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>