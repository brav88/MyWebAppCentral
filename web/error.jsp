<%-- 
    Document   : error
    Created on : 24 feb 2026, 8:45:15 p. m.
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Auth Error</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex align-items-center justify-content-center vh-100">

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-lg border-0">
                        <div class="card-body text-center p-5">

                            <div class="mb-4">
                                <h1 class="display-4 text-danger">401</h1>
                                <h4 class="text-danger">Authentication error</h4>
                            </div>

                            <div class="alert alert-danger" role="alert">
                                Invalid user or password.  
                                Please, check you credentials and try again later.
                            </div>

                            <a href="login.jsp" class="btn btn-primary mt-3">
                                Back to Login
                            </a>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
