
package ModeloDAO;

import Interfaces.CRUD;
import Modelo.Persona;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();

    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from persona";
        //Brayan
        //String sql="select Id, DNI, Nombres from persona WHERE Nombres=\"Daniel Bosos\"";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("Id"));
                per.setDni(rs.getString("DNI"));
                per.setNom(rs.getString("Nombres"));
                list.add(per);
            }
        }catch(Exception e){          
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from persona where Id="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("Id"));
                p.setDni(rs.getString("DNI"));
                p.setNom(rs.getString("Nombres"));
               
            }
        }catch(Exception e){          
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into persona(DNI, Nombres) values('"+per.getDni()+"','"+per.getNom()+"')";
        try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
       String sql="update persona set DNI='"+per.getDni()+"',Nombres='"+per.getNom()+"'where Id="+per.getId();
     try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
     }catch(Exception e){       
     }
     return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from persona where Id="+id;
        try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){        
        }
        return false;
    }

    @Override
    public List buscar(String texto) {
       List<Persona> lista=new ArrayList<>();
       String sql;
        sql="select * from persona where Id like '%"+texto+"%' or DNI like '%"+texto+"%' or Nombres like '%"+texto+"%'";      
       try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               Persona pe=new Persona();
               pe.setId(rs.getInt("Id"));
               pe.setDni(rs.getString("DNI"));
               pe.setNom(rs.getString("Nombres"));
               lista.add(pe);             
           }         
       }catch(SQLException e){              
       }
       return lista;
    }    
}
