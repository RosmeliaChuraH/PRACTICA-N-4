<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1><c:if test="${usuario.id == 0}">Nuevo</c:if>
                <c:if test="${usuario.id == 0}">Editar</c:if>
                    usuario
                </h1>
                <form action="InicioU" method="post">
                    <input type="hidden" name="id" value="${usuario.id}"/>

                <div class="form-group">
                    <label>Usuario</label>
                    <input type="text" name="usuario" value="${usuario.usuario}" class="form-control" />
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" value="${usuario.password}" 
                           class="form-control" />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Enviar"/>
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>
