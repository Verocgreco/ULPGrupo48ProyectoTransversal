/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.Conexion;
import accesoADatos.MateriaData;
import entidades.Materia;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author arielvallejos
 */
public class Menu extends javax.swing.JFrame {
    private Connection conn=null;
//private static List<Materia> ListaMateria=new ArrayList<>();
//MateriaData matData=new MateriaData(); 
    /**
     * Creates new form Menu
     */
    public Menu() {
        this.conn=Conexion.getConexion();
        initComponents();
        this.setLocationRelativeTo(null);
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/logo.png"));
        Image imagen = icono.getImage();
        Escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graph){
                graph.drawImage(imagen,0,0, getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        Alumno = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Materia = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Administracion = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setPreferredSize(new java.awt.Dimension(700, 600));

        Alumno.setText("Alumno");

        jMenuItem1.setText("Formulario De Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Alumno.add(jMenuItem1);

        jMenuBar1.add(Alumno);

        Materia.setText("Materia");

        jMenuItem2.setText("Formulario De Materia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Materia.add(jMenuItem2);

        jMenuBar1.add(Materia);

        Administracion.setText("Administracion");

        jMenuItem3.setText("Manejo De Inscripciones");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Administracion.add(jMenuItem3);

        jMenuItem4.setText("Manipulacion De Notas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Administracion.add(jMenuItem4);

        jMenuBar1.add(Administracion);

        Consulta.setText("Consulta");

        jMenuItem5.setText("Alumnos Por Materia");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Consulta.add(jMenuItem5);

        jMenuBar1.add(Consulta);

        Salir.setText("Salir");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                // PARA QUE JINTERNALFRAME SEA VISIBLE 
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioAlumno FA = new FormularioAlumno();
        FA.setVisible(true);
        Escritorio.add(FA);
        Escritorio.moveToFront(FA);
                // PARA QUE SE CENTREN EN EL MEDIO DEL DESKTOP PANE 
        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = FA.getSize();
        FA.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        FA.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
                // PARA QUE JINTERNALFRAME SEA VISIBLE 
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioMateria FM = new FormularioMateria();
        FM.setVisible(true);
        Escritorio.add(FM);
        Escritorio.moveToFront(FM);
                // PARA QUE SE CENTREN EN EL MEDIO DEL DESKTOP PANE 
        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = FM.getSize();
        FM.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        FM.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
                // PARA QUE JINTERNALFRAME SEA VISIBLE 
        Escritorio.removeAll();
        Escritorio.repaint();
        ManejoInscripciones MI = new ManejoInscripciones();
        MI.setVisible(true);
        Escritorio.add(MI);
        Escritorio.moveToFront(MI);
                // PARA QUE SE CENTREN EN EL MEDIO DEL DESKTOP PANE 
        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = MI.getSize();
        MI.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        MI.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
                // PARA QUE JINTERNALFRAME SEA VISIBLE 
        Escritorio.removeAll();
        Escritorio.repaint();
        ManejoNotas MN = new ManejoNotas();
        MN.setVisible(true);
        Escritorio.add(MN);
        Escritorio.moveToFront(MN);
                // PARA QUE SE CENTREN EN EL MEDIO DEL DESKTOP PANE 
        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = MN.getSize();
        MN.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        MN.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
                 // PARA QUE JINTERNALFRAME SEA VISIBLE 
        Escritorio.removeAll();
        Escritorio.repaint();
        AlumnosMateria AM = new AlumnosMateria();
        AM.setVisible(true);
        Escritorio.add(AM);
        Escritorio.moveToFront(AM);
                // PARA QUE SE CENTREN EN EL MEDIO DEL DESKTOP PANE 
        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = AM.getSize();
        AM.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        AM.show();
                  
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Administracion;
    private javax.swing.JMenu Alumno;
    private javax.swing.JMenu Consulta;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu Materia;
    private javax.swing.JMenu Salir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables


     
        
        
        
    





}
