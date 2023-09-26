
package accesoADatos;

import entidades.Materia;
import java.sql.Connection;
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
public class MateriaData {
    private Connection conn=null;
    
    
    
    public MateriaData(){
    conn=Conexion.getConexion();
    }
    
    
    public void guardarMateria(Materia materia){
        String sqlGM="INSERT INTO materia(nombre,anio,estado) VALUES(?,?,?)";
            try {

                PreparedStatement psGM=conn.prepareStatement(sqlGM,Statement.RETURN_GENERATED_KEYS);
                
                psGM.setString(1,materia.getNombre());
                psGM.setInt(2,materia.getAnioMateria());
                psGM.setBoolean(3,materia.isEstado());
                psGM.executeUpdate();
                
                ResultSet rsGM=psGM.getGeneratedKeys();
                if(rsGM.next()){
                        materia.setIdMateria(rsGM.getInt(1));
                        JOptionPane.showMessageDialog(null, "Materia agregada con éxito");
                }
                
            } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error: La materia ya existe");
        }
    
    }
    
    public Materia BuscarMateria(int id){
    
        
        Materia materia=null;
    
    String sqlBM="SELECT nombre,anio,estado  FROM materia   WHERE idMateria =  ? AND estado BETWEEN 0 AND 1";
    PreparedStatement psBM=null;
    
    
        try {
            psBM=conn.prepareStatement(sqlBM);
            psBM.setInt(1, id);
            ResultSet rsBM = psBM.executeQuery();
            
            if(rsBM.next()){
             materia=new Materia();    
             materia.setIdMateria(id);
             materia.setNombre(rsBM.getString("nombre"));
             materia.setAnioMateria(rsBM.getInt("anio"));
             materia.setEstado(rsBM.getBoolean("estado"));   
            psBM.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar BM");
        }
    
        return materia;
        }
    
    public void ModificarMateria(Materia materia){
    
        String sqlMM="UPDATE  materia SET nombre =? , anio=? , estado=? WHERE idMateria=? ";
        PreparedStatement psMM=null;
        
        try {
            psMM=conn.prepareStatement(sqlMM);
            psMM.setString(1,materia.getNombre());
            psMM.setInt(2, materia.getAnioMateria());
            psMM.setBoolean(3, materia.isEstado());
            psMM.setInt(4, materia.getIdMateria());
            
            int exitoMM=psMM.executeUpdate();
            
            if(exitoMM == 1){
                JOptionPane.showMessageDialog(null, "Cambio Exitoso");
                
            }else{
                    JOptionPane.showMessageDialog(null, "Error Al Modificar M");
            }
            
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null ,"Error: La materia ya existe");  
        }
    }
   
    public void EliminarMateria(int id){
    

        try {
            String sqlEM="UPDATE materia SET estado=0 WHERE idMateria=?";
            PreparedStatement psEM= conn.prepareStatement(sqlEM);
            
            psEM.setInt(1, id);
            int fila=psEM.executeUpdate();
            
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Materia eliminada");
                
            }else{
            JOptionPane.showMessageDialog(null, "Error al ELiminar EM");}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al Conectar"+ex.getMessage());
        }
    
    }
    
    public List<Materia> ListarMateria(){
        
        List<Materia> materias =new ArrayList<>();
        
        
        try {
            String sqlLM="SELECT * FROM materia WHERE estado =1";
            PreparedStatement psLM =conn.prepareStatement(sqlLM);
            ResultSet rsLM=psLM.executeQuery();
            
            while(rsLM.next()){
            Materia materia = new Materia();
            materia.setIdMateria(rsLM.getInt(1));
            materia.setNombre(rsLM.getString("nombre"));
            materia.setAnioMateria(rsLM.getInt("anio"));
            materia.setEstado(rsLM.getBoolean("estado"));
            materias.add(materia);
            
            }
            
            psLM.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    
    
    }
}
