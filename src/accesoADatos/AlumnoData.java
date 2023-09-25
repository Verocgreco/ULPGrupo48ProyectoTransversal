/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AlumnoData {
    private Connection conn=null;
    
public AlumnoData(){
        
        conn=Conexion.getConexion();
    }

public void GuardarAlumno(Alumno alumno){
    
    String sqlGA = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement psGA=conn.prepareStatement(sqlGA, Statement.RETURN_GENERATED_KEYS);
                psGA.setInt(1,alumno.getDni());
                psGA.setString(2,alumno.getApellido());
                psGA.setString(3,alumno.getNombre());
                psGA.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                psGA.setBoolean(5,alumno.isEstado());
        
        psGA.executeUpdate();
        ResultSet rs=psGA.getGeneratedKeys();
        
        if(rs.next()){
            
            alumno.setIdAlumno(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Agregado con Exito");
        }
        psGA.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a alumnos"+ex.getMessage());
        }
        
        
        }

public Alumno BuscarAlumno(int dni){

    Alumno alumno= null;
    
    String sqlBA="SELECT idAlumno, dni ,apellido , nombre, fechaNacimiento , estado FROM alumno WHERE dni=? AND  estado BETWEEN 0 AND 1";
    PreparedStatement psBA=null;
    
    
        try {
            psBA=conn.prepareStatement(sqlBA);
            
            psBA.setInt(1,dni);
                    ResultSet rs = psBA.executeQuery();
                if (rs.next()) {
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt(1));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
   } 
                psBA.close();
                
                
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder alos BA x Dni"+ex.getMessage());
        }
        return alumno;
    }


public Alumno BuscarAlumnoPorId(int id){

    Alumno alumno= null;
    
    String sqlBAI="SELECT dni ,apellido , nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado BETWEEN 0 AND 1";
    PreparedStatement psBAI=null;
    
    
        try {
            psBAI=conn.prepareStatement(sqlBAI);
            
            psBAI.setInt(1 ,id);
                    ResultSet rs = psBAI.executeQuery();
                if (rs.next()) {
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
   
}
                psBAI.close();
                
                
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder alos datos"+ex.getMessage());
        }
        return alumno;
    }


public List<Alumno> listarAlumnos(){
    
            List<Alumno> alumnos = new ArrayList<>();
   
            try {

            
            String sqlLA="SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement psLA=conn.prepareStatement(sqlLA);
            ResultSet rsLA = psLA.executeQuery();
            
            while(rsLA.next()){
            
                Alumno alumno = new Alumno();
            
                    alumno.setIdAlumno(rsLA.getInt("idAlumno"));
                    alumno.setDni(rsLA.getInt("dni"));
                    alumno.setApellido(rsLA.getString("apellido"));
                    alumno.setNombre(rsLA.getNString("nombre"));
                    alumno.setFechaNacimiento(rsLA.getDate("fechaNacimiento").toLocalDate());
                    alumno.setEstado(rsLA.getBoolean("estado"));
                    alumnos.add(alumno);
            
            }
            
            psLA.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error Al CONECTAR"+ ex.getMessage());
        }
    return alumnos;
}

public void modificarAlumnos(Alumno alumno){

String sqlMA="UPDATE alumno SET dni=? , apellido=? , nombre=? , fechaNacimiento =? ,estado =? WHERE idAlumno =?";
PreparedStatement psMA = null;

        try {
            psMA=conn.prepareStatement(sqlMA);
            psMA.setInt(1, alumno.getDni());
            psMA.setString(2,alumno.getApellido());
            psMA.setString(3, alumno.getNombre());
            psMA.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            psMA.setBoolean(5, alumno.isEstado());
            psMA.setInt(6,alumno.getIdAlumno());
            
            int exito =psMA.executeUpdate();
            
            
            if(exito==1){
                    
            JOptionPane.showMessageDialog(null, "Cambio Exitoso");
            }else{
                    
                JOptionPane.showMessageDialog(null,"Erorr al Modificar Alumno");
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error Al Connectar  "+ex.getMessage());
        }





}

public void eliminarAlumno(int id){
    String sqlEA="UPDATE alumno SET estado =0 WHERE idAlumno = ? ";
                         
        try {

            PreparedStatement psEA=conn.prepareStatement(sqlEA);
            psEA.setInt(1 , id);
            
            int fila = psEA.executeUpdate();
            if(fila==1){
            
                JOptionPane.showMessageDialog(null, "Eliminado con EXITO");
            }
            else{
                JOptionPane.showMessageDialog(null,"Alumno Inexistente");
                }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Conectar EA"+ex.getMessage());
        }
    
    
    }




}
