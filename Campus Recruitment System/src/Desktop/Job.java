package Desktop;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Job extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;

    public Job() {
        initComponents();
        Showdata();
    }
    public Connection getConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://122.168.195.107:1433/libDemo;user=Lib;password=admin_st");
            return conn;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<View_Jobs> getViewJobList(){
        ArrayList<View_Jobs> viewJobList = new ArrayList<View_Jobs>();
        Connection connection = getConnection();
        String query = "SELECT * FROM libDemo.dbo.CAM_JOBS;";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            View_Jobs viewjobs;
            while(rs.next()){
                viewjobs = new View_Jobs(rs.getString("COMPANY_NAME"), rs.getString("JOB_TITLE"), rs.getString("JOB_DESCRIPTION"),
                        rs.getString("JOB_REQUIREMENT"), rs.getString("KEY_RESPONSIBILITIES"), rs.getString("SALARY_RANGE"), rs.getInt("CRITERIA"));
                viewJobList.add(viewjobs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewJobList;
    }
    
    public void Showdata(){
        ArrayList<View_Jobs> list = getViewJobList();
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        Object[] row = new Object[7];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getCompanyName();
            row[1] = list.get(i).getJobTitle();
            row[2] = list.get(i).getJobDescription();
            row[3] = list.get(i).getJobRequirement();
            row[4] = list.get(i).getKeyResponsibilities();
            row[5] = list.get(i).getSalaryRange();
            row[6] = list.get(i).getCriteria();
            
            model.addRow(row);
        }
    }
    public void executeSQLQuery(String query, String message){
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query) == 1 ){
                DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
                model.setRowCount(0);
                Showdata();
                JOptionPane.showMessageDialog(null, "Data"+message+"Sucessfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Data not "+message);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@DESKTOP-79B6HIH:1521:XEPU").createEntityManager();
        jobsQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT j FROM Jobs j");
        jobsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jobsQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Desktop/Job.png"))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COMPANY NAME", "JOB TITLE", "JOB DESCRIPTION", "JOB REQUIREMENT", "KEY RESPONSIBILITIES", "SALARY RANGE", "CRITERIA"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Delete Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String sql = "DELETE FROM libDemo.dbo.CAM_JOBS WHERE COMPANY_NAME = 'company';";
        executeSQLQuery(sql, "Deleted");

    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Job().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.util.List<Desktop.Jobs> jobsList;
    private javax.persistence.Query jobsQuery;
    // End of variables declaration//GEN-END:variables
}
