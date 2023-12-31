package vistas;

import accesoADatos.*;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FormularioAlumno extends javax.swing.JInternalFrame {

    private Connection conn = null;
    AlumnoData aluData = new AlumnoData();
    int idAlum;

    public FormularioAlumno() {
        this.conn = Conexion.getConexion();

        initComponents();

        block();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruupo1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jtNombre = new javax.swing.JTextField();
        jrbTrue = new javax.swing.JRadioButton();
        jrbFalse = new javax.swing.JRadioButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jdcFNacimiento = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Form Alumnos");

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 13)); // NOI18N
        jLabel1.setText("ALUMNOS");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jLabel2.setText("Documento :");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jLabel3.setText("Apellido : ");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jLabel4.setText("Nombre : ");

        jLabel5.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jLabel5.setText("Estado : ");

        jLabel6.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jLabel6.setText("F.Nacimiento : ");

        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDniKeyReleased(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        gruupo1.add(jrbTrue);
        jrbTrue.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jrbTrue.setText("True");

        gruupo1.add(jrbFalse);
        jrbFalse.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jrbFalse.setText("False");

        jbNuevo.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbAgregar.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jdcFNacimiento.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 122, Short.MAX_VALUE)
                .addComponent(jbNuevo)
                .addGap(18, 18, 18)
                .addComponent(jbAgregar)
                .addGap(18, 18, 18)
                .addComponent(jbGuardar)
                .addGap(29, 29, 29)
                .addComponent(jbEliminar)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbFalse))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbTrue)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(jtApellido)
                                        .addComponent(jtNombre)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBuscar)
                    .addComponent(jdcFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbTrue)
                    .addComponent(jrbFalse))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNuevo)
                            .addComponent(jbAgregar)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (!jtDni.getText().isEmpty()) {
            try {
                Alumno AluEnc = aluData.BuscarAlumno(Integer.parseInt(jtDni.getText()));
                idAlum = AluEnc.getIdAlumno();
                jtApellido.setText(AluEnc.getApellido());
                jtNombre.setText(AluEnc.getNombre());
                if (AluEnc.isEstado() == true) {
                    jrbTrue.setSelected(true);
                } else if (AluEnc.isEstado() == false) {
                    jrbFalse.setSelected(true);
                }//IF-ELSE
                jdcFNacimiento.setDate(Date.valueOf(AluEnc.getFechaNacimiento()));
                bBlock();
                this.jtDni.requestFocus();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "No se encontró el alumno");
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(this, "DNI incorrecto");
            }//TRY-CATCH
        } else {
            JOptionPane.showMessageDialog(this, "Complete campo DNI");
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if ((!jtDni.getText().isEmpty()) && (!jtApellido.getText().isEmpty()) && (!jtNombre.getText().isEmpty())
                && (jdcFNacimiento.getDate() != null) && (jrbTrue.isSelected() == true
                || jrbFalse.isSelected() == true)) {
            try {
                int dni = Integer.parseInt(jtDni.getText());
                LocalDate fechaNacimiento = jdcFNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (dni > 0) {
                    // VALIDAR QUE LA FECHA SEA ANTERIOR A LA ACTUAL.
                    LocalDate fechaActual = LocalDate.now();
                    if (fechaNacimiento.isBefore(fechaActual)) {
                        Alumno alumno = aluData.BuscarAlumnoPorId(idAlum);
                        alumno.setDni(Integer.parseInt(jtDni.getText()));
                        alumno.setApellido(jtApellido.getText());
                        alumno.setNombre(jtNombre.getText());
                        alumno.setFechaNacimiento(jdcFNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        if (jrbTrue.isSelected()) {
                            alumno.setEstado(true);

                        } else if (jrbFalse.isSelected()) {
                            alumno.setEstado(false);
                        }//IF-ELSE 

                        aluData.modificarAlumnos(alumno);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un DNI válido");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Error no encotrado");
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(this, "DNI incorrecto");
            }//TRY-CATCH
        } else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:

        for (Alumno alu : aluData.listarAlumnos()) {
            if (alu.getDni() == Integer.parseInt(jtDni.getText())) {
                aluData.eliminarAlumno(alu.getIdAlumno());
            }//IF

        }//FOR EACH
        actualizarEliminado();

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        if ((!jtDni.getText().isEmpty()) && (!jtApellido.getText().isEmpty()) && (!jtNombre.getText().isEmpty())
                && (jdcFNacimiento.getDate() != null) && (jrbTrue.isSelected() == true
                || jrbFalse.isSelected() == true)) {
            try {
                int dni = Integer.parseInt(jtDni.getText());
                LocalDate fechaNacimiento = jdcFNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (dni > 0) {
                    LocalDate fechaActual = LocalDate.now();
                    if (fechaNacimiento.isBefore(fechaActual)) {
                        Alumno alumno = new Alumno();
                        alumno.setDni(Integer.parseInt(jtDni.getText()));
                        alumno.setApellido(jtApellido.getText());
                        alumno.setNombre(jtNombre.getText());
                        alumno.setFechaNacimiento(jdcFNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        if (jrbTrue.isSelected()) {
                            alumno.setEstado(true);
                        } else if (jrbFalse.isSelected()) {
                            alumno.setEstado(false);
                        }//IF-ELSE                
                        aluData.GuardarAlumno(alumno);
                        LimpiarCampos();
                        block();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un DNI válido");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Complete todos los Campos");
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(this, "DNI incorrecto");
            }//TRY-CATCH
        } else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
        block();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyReleased
        // TODO add your handling code here:
        if (!jtDni.getText().isEmpty()) {
            disblock();
            jbNuevo.setEnabled(true);
        } else if (jtDni.getText().isEmpty()) {
            block();
            LimpiarCampos();

//            jtApellido.setEnabled(true);
        }
    }//GEN-LAST:event_jtDniKeyReleased

    private void jtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyReleased
        // TODO add your handling code here:
        if (!jtApellido.getText().isEmpty() && !jtDni.getText().isEmpty()) {
            jbBuscar.setEnabled(false);
        } else if (jtApellido.getText().isEmpty() && !jtDni.getText().isEmpty()) {
            jbBuscar.setEnabled(true);
            jtApellido.setEnabled(false);
            block();
        } else if (jtApellido.getText().isEmpty() && jtDni.getText().isEmpty()) {
            block();

        }

    }//GEN-LAST:event_jtApellidoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gruupo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private com.toedter.calendar.JDateChooser jdcFNacimiento;
    private javax.swing.JRadioButton jrbFalse;
    private javax.swing.JRadioButton jrbTrue;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        jtDni.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        gruupo1.clearSelection();
        jdcFNacimiento.setDate(null);

    }

    public void block() {
        jtApellido.setEnabled(false);
        jtNombre.setEnabled(false);
        jrbTrue.setEnabled(false);
        jrbFalse.setEnabled(false);
        jdcFNacimiento.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbAgregar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbNuevo.setEnabled(false);
    }

    public void disblock() {
        jtApellido.setEnabled(true);
        jtNombre.setEnabled(true);
        jrbTrue.setEnabled(true);
        jrbFalse.setEnabled(false);
        jdcFNacimiento.setEnabled(true);
        jbAgregar.setEnabled(true);

    }

    public void bBlock() {
        jbGuardar.setEnabled(true);
        jbEliminar.setEnabled(true);
        jbNuevo.setEnabled(true);
        jbAgregar.setEnabled(false);
    }

    public void actualizarEliminado() {
        Alumno AluEnc = aluData.BuscarAlumno(Integer.parseInt(jtDni.getText()));
        idAlum = AluEnc.getIdAlumno();
        jtApellido.setText(AluEnc.getApellido());
        jtNombre.setText(AluEnc.getNombre());
        if (AluEnc.isEstado() == true) {
            jrbTrue.setSelected(true);
        } else if (AluEnc.isEstado() == false) {
            jrbFalse.setSelected(true);
        }//IF-ELSE
        jdcFNacimiento.setDate(Date.valueOf(AluEnc.getFechaNacimiento()));
    }
}
