/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

/**
 *
 * @author delamora
 */
public class MedidasVideosProforma extends javax.swing.JFrame {

    /**
     * Creates new form Glosario
     */
    public MedidasVideosProforma() {
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

        btnEctomorfia = new javax.swing.JButton();
        btnEndomorfia = new javax.swing.JButton();
        btnMesomorfia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEctomorfia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEctomorfia.setText("Ectomorfia");
        btnEctomorfia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEctomorfiaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEctomorfia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        btnEndomorfia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEndomorfia.setText("Endomorfia");
        btnEndomorfia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndomorfiaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEndomorfia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        btnMesomorfia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnMesomorfia.setText("Mesomorfia");
        btnMesomorfia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesomorfiaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesomorfia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Videos Proforma");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo4 4x4.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 402, 144));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEctomorfiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEctomorfiaActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\videos\\Ectomorfia.wmv");
        } catch (Exception e){}
    }//GEN-LAST:event_btnEctomorfiaActionPerformed

    private void btnEndomorfiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndomorfiaActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\videos\\Endomorfia.wmv");
        } catch (Exception e){}
    }//GEN-LAST:event_btnEndomorfiaActionPerformed

    private void btnMesomorfiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesomorfiaActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\videos\\mesomorfia.wmv");
        } catch (Exception e){}
    }//GEN-LAST:event_btnMesomorfiaActionPerformed

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
            java.util.logging.Logger.getLogger(MedidasVideosProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedidasVideosProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedidasVideosProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedidasVideosProforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedidasVideosProforma().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEctomorfia;
    private javax.swing.JButton btnEndomorfia;
    private javax.swing.JButton btnMesomorfia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}