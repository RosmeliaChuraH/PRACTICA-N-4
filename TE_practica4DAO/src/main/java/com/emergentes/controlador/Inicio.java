
package com.emergentes.controlador;

import com.emergentes.dao.PostDAO;
import com.emergentes.dao.PostDAOimpl;
import com.emergentes.modelo.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            PostDAO dao = new PostDAOimpl();
            int id;
            Post pos = new Post();
            String action =(request.getParameter("action") != null)? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("post", pos);
                    request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pos = dao.getById(id);
                    System.out.println(pos);
                    request.setAttribute("post", pos);
                    request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/Inicio");
                    break;
                case "view":
                    List<Post> lista = dao.getAll();
                    request.setAttribute("posts", lista);
                    request.getRequestDispatcher("post.jsp").forward(request, response);
                default:
                    break;
            }    
        } catch (Exception ex) {
            System.out.println("Error "+ ex.getMessage());
        }
        //////////////////////////////////////77
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Post pos = new Post();
        pos.setId(id);
        pos.setFecha(fecha);
        pos.setTitulo(titulo);
        pos.setContenido(contenido);
        
        if(id == 0){
            try {
                PostDAO dao = new PostDAOimpl();
                dao.insert(pos);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try {
                PostDAO dao = new PostDAOimpl();
                dao.update(pos);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }
        //////////////////////////////////////////
        
    }
}
