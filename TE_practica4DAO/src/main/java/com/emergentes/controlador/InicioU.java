
package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicioU", urlPatterns = {"/InicioU"})
public class InicioU extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            UsuarioDAO dao = new UsuarioDAOimpl();
            int id;
            Usuario usua= new Usuario();
            String action =(request.getParameter("action") != null)? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("usuario", usua);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usua = dao.getById(id);
                    System.out.println(usua);
                    request.setAttribute("usuario", usua);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/InicioU");
                    break;
                case "view":
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                default:
                    break;
            }    
        } catch (Exception ex) {
            System.out.println("Error "+ ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Usuario usua = new Usuario();
        usua.setId(id);
        usua.setUsuario(usuario);
        usua.setPassword(password);
        
        if(id == 0){
            try {
                UsuarioDAO dao = new UsuarioDAOimpl();
                dao.insert(usua);
                response.sendRedirect(request.getContextPath()+"/InicioU");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try {
                UsuarioDAO dao = new UsuarioDAOimpl();
                dao.update(usua);
                response.sendRedirect(request.getContextPath()+"/InicioU");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }
    }


}
