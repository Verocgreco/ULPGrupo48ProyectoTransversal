/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Inscripcion;
import entidades.Alumno;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author arielvallejos
 */
public class InscripcionData {
    private Connection conn=null;
    private AlumnoData aluData =new AlumnoData();
    private MateriaData matData =new MateriaData();
    
    public InscripcionData(){
    conn=Conexion.getConexion();}
    
    public void guardarInscripcion(Inscripcion Insc){
        
   String sqlGI="INSERT INTO inscripcion(nota , idAlumno , idMateria) VALUES(0,?,?) ";
        try {
            PreparedStatement psGI= conn.prepareStatement(sqlGI , Statement.RETURN_GENERATED_KEYS);
//            psGI.setDouble(1,Insc.getNota());
            psGI.setInt(1,Insc.getAlumno().getIdAlumno());
            psGI.setInt(2,Insc.getMateria().getIdMateria());
            
            psGI.executeUpdate();
            ResultSet rsGI = psGI.getGeneratedKeys();
                    if(rsGI.next()){
            
            Insc.setIdInscripcion(rsGI.getInt(1));
            JOptionPane.showMessageDialog(null, "Agregado con Exito");
        }
        psGI.close();
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a Inscripcion");
        }
        
    }
    
    public void ActualizarNota(double nota ,int idAlumno , int idMateria  ){
    
    
    String sqlAN ="UPDATE inscripcion SET nota=? WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement psAN=conn.prepareStatement(sqlAN);
            
            psAN.setDouble(1, nota);
            psAN.setInt(2, idAlumno);
            psAN.setInt(3, idMateria);
            
            int fila = psAN.executeUpdate();

            if(fila >0){
            
            JOptionPane.showMessageDialog(null,"ACTUALIZADO CON EXITO" + fila);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    public  void BorrarInscMateriaAlumno(int idAlumno , int idMateria){
    
    String sqlBIMA ="DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria =?";
    
   
        try {
            PreparedStatement psBIMA=conn.prepareStatement(sqlBIMA);
            
            psBIMA.setInt(1, idAlumno);
            psBIMA.setInt(2, idMateria);
            int fila =psBIMA.executeUpdate();
            
            if(fila >0){
            JOptionPane.showMessageDialog(null, "Ejecutado con Exito BIMA");
            
            }
            psBIMA.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public List<Inscripcion> ObtenerInscripciones(){
        List<Inscripcion> Inscripciones =new ArrayList(); 
        String sqlOI = "SELECT * FROM inscripcion";
        try {
            PreparedStatement psOI = conn.prepareStatement(sqlOI);
            ResultSet rsOI = psOI.executeQuery();
            while(rsOI.next()){
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setIdInscripcion(rsOI.getInt(1));
            inscripcion.setNota(rsOI.getDouble("nota"));
            Alumno alu = aluData.BuscarAlumnoPorId(rsOI.getInt("idAlumno"));
            Materia mat = matData.BuscarMateria(rsOI.getInt("idMateria"));
            inscripcion.setAlumno(alu);
            inscripcion.setMateria(mat);
            Inscripciones.add(inscripcion);
            
            
            }
            
            psOI.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error al Conectar OI.- "+ex.getMessage());
        }
        
               
        
        
        
        return Inscripciones;
}
        
        public List<Inscripcion> ObtenerInscripcionesPorAlumno(int idAlumno){
        List<Inscripcion> Inscripciones =new ArrayList<>(); 
        String sqlOI = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        try {
            PreparedStatement psOIA = conn.prepareStatement(sqlOI);
            psOIA.setInt(1, idAlumno);
            ResultSet rsOIA = psOIA.executeQuery();
            while(rsOIA.next()){
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setIdInscripcion(rsOIA.getInt(1));
            inscripcion.setNota(rsOIA.getDouble("nota"));
            Alumno alu = aluData.BuscarAlumnoPorId(rsOIA.getInt("idAlumno"));
            Materia mat = matData.BuscarMateria(rsOIA.getInt("idMateria"));
            inscripcion.setAlumno(alu);
            inscripcion.setMateria(mat);
            Inscripciones.add(inscripcion);
            
            
            }
            
            psOIA.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error al Conectar OI.- "+ex.getMessage());
        }
        
               
        
        
        
        return Inscripciones;
}
       
        public List<Materia> ObtenerMateriasCursadas(int idAlumno){
    
    List<Materia> materias = new ArrayList<>();
        
    String sqlOMC="SELECT inscripcion.idMateria , nombre , anio FROM inscripcion ,materia "
            + "WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?";
            
        try {
            PreparedStatement psOMC = conn.prepareStatement(sqlOMC);
            
            psOMC.setInt(1,idAlumno);
            
            ResultSet rsOMC=psOMC.executeQuery();
            
                while(rsOMC.next()){
                  Materia materia = new Materia();
                    materia.setIdMateria(rsOMC.getInt("idMateria"));
                    materia.setNombre(rsOMC.getString("nombre"));
                    materia.setAnioMateria(rsOMC.getInt("anio"));
                    
                    materias.add(materia);
            }
            
            psOMC.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Obtener las Materias Cur "+ex.getMessage());
        }
        return materias;
    
    }
        
        public List<Materia> ObtenerMateriasNoCursadas(int idAlumno){
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sqlOMNC ="SELECT *  FROM materia WHERE estado = 1 AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
                try {
            PreparedStatement psOMNC = conn.prepareStatement(sqlOMNC);
            
            psOMNC.setInt(1, idAlumno);
            
            ResultSet rsOMC=psOMNC.executeQuery();
            
                while(rsOMC.next()){
                   Materia materia = new Materia();
                    materia.setIdMateria(rsOMC.getInt("idMateria"));
                    materia.setNombre(rsOMC.getString("nombre"));
                    materia.setAnioMateria(rsOMC.getInt("anio"));
                    materia.setEstado(rsOMC.getBoolean("estado"));
                    materias.add(materia);
            }
            
            psOMNC.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Obtener las Materias Cur "+ex.getMessage());
        }
        return materias;
        
            }
        
        public List<Alumno> ObtenerAlumnosPorMateria(int idMateria){
        
            ArrayList<Alumno> alumnos =new ArrayList<>();
        
        String sqlOAM="SELECT alumno.idAlumno , dni, apellido,nombre,fechaNacimiento ,estado "
         + "FROM inscripcion JOIN alumno ON(inscripcion.idAlumno=alumno.idAlumno) WHERE idMateria = ? AND estado=1";
        
        try {
            PreparedStatement psOAM = conn.prepareStatement(sqlOAM);
            psOAM.setInt(1 , idMateria);
            ResultSet rsOAM = psOAM.executeQuery();
            
            while(rsOAM.next()){
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(rsOAM.getInt("idAlumno"));
            alumno.setDni(rsOAM.getInt("dni"));
            alumno.setApellido(rsOAM.getString("apellido"));
            alumno.setNombre(rsOAM.getString("nombre"));
            alumno.setFechaNacimiento(rsOAM.getDate("fechaNacimiento").toLocalDate());
            alumno.setEstado(true);
            alumnos.add(alumno);
            }
            
            psOAM.close();
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al Acceder a OAM");
        }
        
        return alumnos;
        
        }
}
