<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1><c:if test="${post.id == 0}">Nuevo</c:if>
                <c:if test="${post.id == 0}">Editar</c:if>
                post
            </h1>
            <form action="Inicio" method="post">
                <input type="hidden" name="id" value="${post.id}"/>
                <div class="form-group">
                    <label>Fecha</label>
                    <input type="date" name="fecha" value="${post.fecha}" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Titulo</label>
                    <input type="text" name="titulo" value="${post.titulo}" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Contenido</label>
                    <textarea name="contenido" rows="4" cols="20" class="form-control">${post.contenido}</textarea>
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
