
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionBD implements UsuarioDAO{

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
        ("INSERT into usuarios (usuario,password) values (?,?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
        ("UPDATE usuarios set usuario = ?, password = ? where id = ?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usua = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usua.setId(rs.getInt("id"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usua;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usua = new Usuario();
                usua.setId(rs.getInt("id"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setPassword(rs.getString("password"));
                lista.add(usua);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }   
    
}
