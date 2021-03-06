package index;

/**
 * @author delamora
 */
public class index extends javax.swing.JFrame {

    /**
     * Creates new form index
     */
    public index() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonKinanapp = new javax.swing.JButton();
        botonMedidas = new javax.swing.JButton();
        botonSomatotipo = new javax.swing.JButton();
        botonProporcionalidad = new javax.swing.JButton();
        botonComposicion = new javax.swing.JButton();
        botonFormEcu = new javax.swing.JButton();
        botonDescargas = new javax.swing.JButton();
        botonLaboratorio = new javax.swing.JButton();
        botonExamen = new javax.swing.JButton();
        botonBibliCreditos = new javax.swing.JButton();
        botonGlosario = new javax.swing.JButton();
        botonAntecedentes = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonKinanapp.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        botonKinanapp.setText("Kinantropometría y sus aplicaciones");
        botonKinanapp.setMargin(new java.awt.Insets(2, 0, 2, 0));
        botonKinanapp.setMaximumSize(new java.awt.Dimension(250, 33));
        botonKinanapp.setMinimumSize(new java.awt.Dimension(250, 33));
        botonKinanapp.setPreferredSize(new java.awt.Dimension(250, 33));
        botonKinanapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonKinanappActionPerformed(evt);
            }
        });
        getContentPane().add(botonKinanapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, 33));

        botonMedidas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonMedidas.setText("Medidas antropométricas");
        botonMedidas.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonMedidas.setMaximumSize(new java.awt.Dimension(250, 33));
        botonMedidas.setMinimumSize(new java.awt.Dimension(250, 33));
        botonMedidas.setPreferredSize(new java.awt.Dimension(250, 33));
        botonMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMedidasActionPerformed(evt);
            }
        });
        getContentPane().add(botonMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 270, -1));

        botonSomatotipo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonSomatotipo.setText("Somatotipo");
        botonSomatotipo.setMaximumSize(new java.awt.Dimension(250, 33));
        botonSomatotipo.setMinimumSize(new java.awt.Dimension(250, 33));
        botonSomatotipo.setPreferredSize(new java.awt.Dimension(250, 33));
        botonSomatotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSomatotipoActionPerformed(evt);
            }
        });
        getContentPane().add(botonSomatotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 270, -1));

        botonProporcionalidad.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonProporcionalidad.setText("Proporcionalidad humana");
        botonProporcionalidad.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonProporcionalidad.setMaximumSize(new java.awt.Dimension(250, 33));
        botonProporcionalidad.setMinimumSize(new java.awt.Dimension(250, 33));
        botonProporcionalidad.setPreferredSize(new java.awt.Dimension(250, 33));
        botonProporcionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProporcionalidadActionPerformed(evt);
            }
        });
        getContentPane().add(botonProporcionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 270, -1));

        botonComposicion.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonComposicion.setText("Composición corporal");
        botonComposicion.setMaximumSize(new java.awt.Dimension(250, 33));
        botonComposicion.setMinimumSize(new java.awt.Dimension(250, 33));
        botonComposicion.setPreferredSize(new java.awt.Dimension(250, 33));
        botonComposicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComposicionActionPerformed(evt);
            }
        });
        getContentPane().add(botonComposicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 270, -1));

        botonFormEcu.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonFormEcu.setText("Fórmulas y Ecuaciones");
        botonFormEcu.setMaximumSize(new java.awt.Dimension(250, 33));
        botonFormEcu.setMinimumSize(new java.awt.Dimension(250, 33));
        botonFormEcu.setPreferredSize(new java.awt.Dimension(250, 33));
        botonFormEcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFormEcuActionPerformed(evt);
            }
        });
        getContentPane().add(botonFormEcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 270, -1));

        botonDescargas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonDescargas.setText("Descargas");
        botonDescargas.setMaximumSize(new java.awt.Dimension(250, 33));
        botonDescargas.setMinimumSize(new java.awt.Dimension(250, 33));
        botonDescargas.setPreferredSize(new java.awt.Dimension(250, 33));
        botonDescargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescargasActionPerformed(evt);
            }
        });
        getContentPane().add(botonDescargas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 270, -1));

        botonLaboratorio.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonLaboratorio.setText("Laboratorio");
        botonLaboratorio.setMaximumSize(new java.awt.Dimension(250, 33));
        botonLaboratorio.setMinimumSize(new java.awt.Dimension(250, 33));
        botonLaboratorio.setPreferredSize(new java.awt.Dimension(250, 33));
        botonLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLaboratorioActionPerformed(evt);
            }
        });
        getContentPane().add(botonLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 270, -1));

        botonExamen.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonExamen.setText("Evaluación");
        botonExamen.setMaximumSize(new java.awt.Dimension(250, 33));
        botonExamen.setMinimumSize(new java.awt.Dimension(250, 33));
        botonExamen.setPreferredSize(new java.awt.Dimension(250, 33));
        botonExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExamenActionPerformed(evt);
            }
        });
        getContentPane().add(botonExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 270, -1));

        botonBibliCreditos.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonBibliCreditos.setText("Bibliografía y créditos");
        botonBibliCreditos.setMaximumSize(new java.awt.Dimension(250, 33));
        botonBibliCreditos.setMinimumSize(new java.awt.Dimension(250, 33));
        botonBibliCreditos.setPreferredSize(new java.awt.Dimension(250, 33));
        botonBibliCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBibliCreditosActionPerformed(evt);
            }
        });
        getContentPane().add(botonBibliCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 270, -1));

        botonGlosario.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonGlosario.setText("Glosario");
        botonGlosario.setMaximumSize(new java.awt.Dimension(250, 33));
        botonGlosario.setMinimumSize(new java.awt.Dimension(250, 33));
        botonGlosario.setPreferredSize(new java.awt.Dimension(250, 33));
        botonGlosario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGlosarioActionPerformed(evt);
            }
        });
        getContentPane().add(botonGlosario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 270, -1));

        botonAntecedentes.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        botonAntecedentes.setText("Antecedentes históricos");
        botonAntecedentes.setMaximumSize(new java.awt.Dimension(250, 33));
        botonAntecedentes.setMinimumSize(new java.awt.Dimension(250, 33));
        botonAntecedentes.setPreferredSize(new java.awt.Dimension(250, 33));
        botonAntecedentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAntecedentesActionPerformed(evt);
            }
        });
        getContentPane().add(botonAntecedentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 270, -1));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bienvenida.jpg"))); // NOI18N
        imagen.setFocusable(false);
        imagen.setMaximumSize(new java.awt.Dimension(1200, 600));
        imagen.setMinimumSize(new java.awt.Dimension(1200, 600));
        imagen.setName("FondoPantalla"); // NOI18N
        imagen.setPreferredSize(new java.awt.Dimension(1200, 600));
        imagen.setRequestFocusEnabled(false);
        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAntecedentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAntecedentesActionPerformed
        Antecedentes ventana = new Antecedentes();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonAntecedentesActionPerformed

    private void botonGlosarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGlosarioActionPerformed
        Glosario ventana = new Glosario();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonGlosarioActionPerformed

    private void botonKinanappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonKinanappActionPerformed
        Kinantropometria ventana = new Kinantropometria();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonKinanappActionPerformed

    private void botonMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMedidasActionPerformed
        Medidas ventana = new Medidas();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonMedidasActionPerformed

    private void botonSomatotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSomatotipoActionPerformed
        Somatotipo ventana = new Somatotipo();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonSomatotipoActionPerformed

    private void botonProporcionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProporcionalidadActionPerformed
        Proporcionalidad ventana = new Proporcionalidad();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonProporcionalidadActionPerformed

    private void botonComposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComposicionActionPerformed
        Composicion ventana = new Composicion();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonComposicionActionPerformed

    private void botonFormEcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFormEcuActionPerformed
        Formulas ventana = new Formulas();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonFormEcuActionPerformed

    private void botonDescargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescargasActionPerformed
        Descargas ventana = new Descargas();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonDescargasActionPerformed

    private void botonLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLaboratorioActionPerformed
        Laboratorio ventana = new Laboratorio();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonLaboratorioActionPerformed

    private void botonExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExamenActionPerformed
        Evaluacion ventana = new Evaluacion();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonExamenActionPerformed

    private void botonBibliCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBibliCreditosActionPerformed
        Bibliografia ventana = new Bibliografia();
        ventana.setVisible(true);
    }//GEN-LAST:event_botonBibliCreditosActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAntecedentes;
    private javax.swing.JButton botonBibliCreditos;
    private javax.swing.JButton botonComposicion;
    private javax.swing.JButton botonDescargas;
    private javax.swing.JButton botonExamen;
    private javax.swing.JButton botonFormEcu;
    private javax.swing.JButton botonGlosario;
    private javax.swing.JButton botonKinanapp;
    private javax.swing.JButton botonLaboratorio;
    private javax.swing.JButton botonMedidas;
    private javax.swing.JButton botonProporcionalidad;
    private javax.swing.JButton botonSomatotipo;
    private javax.swing.JLabel imagen;
    // End of variables declaration//GEN-END:variables
}
