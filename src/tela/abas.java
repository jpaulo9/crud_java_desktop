/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.dao.PreencherDao;

/**
 *
 * @author Jpaulo
 */
public class abas extends javax.swing.JFrame {

    /**
     * Creates new form abas
     */
    public abas() {
        initComponents();
        
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            tabela.setRowSorter(new TableRowSorter(modelo));
            
           
            
    }
  
    
    public void TabelaDados(){
    
        
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
            modelo.setNumRows(0);
            PreencherDao cliente = new PreencherDao();
            String cpf = textCselec.getText();
            for(Cliente c: cliente.read(cpf)){
                
                
                modelo.addRow(new Object[]{
                
                    c.getIdCliente(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEndereco(),
                    c.getCelular(),
                    c.getEmail()
                
                
                });
            
            }
    }
    
    
    public void VisualizarDados(){
    
        
        String Cp = textCpfup.getText().toString();
         Cliente dateCli = new Cliente();
        if(!Cp.trim().equals("")){
            
        
         PreencherDao dadoUp = new PreencherDao();
            
          dateCli = dadoUp.UpdateVer(Cp);
           
           if(dateCli.getIdCliente() != 0){
           
           textVerNome.setText(dateCli.getNome());
           
           textVerCelular.setText(dateCli.getCelular());
           textVerEnd.setText(dateCli.getEndereco());
           textVerEmail.setText(dateCli.getEmail());
           
           }else{
           
               JOptionPane.showMessageDialog(null," Cliente não encontrado !!!");

           
           }
        }else{
           
            JOptionPane.showMessageDialog(null,"Digite um CPF para realizar a pesquisa!!!");

        
        
        }
        
     
        
    
    }
    
    public void Updados(){
    
       
        
        PreencherDao dadoUp = new PreencherDao();
        
        String cpfN = textCpfup.getText();
                
        Cliente novo = dadoUp.UpdateVer(cpfN);
        
        int id = novo.getIdCliente();
        String nome = textVerNome.getText();
        String cpf = novo.getCpf();
        String ender = textVerEnd.getText();
        String celu = textVerCelular.getText();
        String email = textVerEmail.getText();
        
        int c = dadoUp.Update(id,nome, cpf, ender, celu, email);
        
        if(c == 1){
            
       
           JOptionPane.showMessageDialog(null,"Dados do Cliente Atualizados "
                   + "com sucesso!");

        }
                
    
    }
    
    public void Excluir (){
    
        String id = textId.getText();
        
        int IdCli = Integer.parseInt(id);
        
        PreencherDao DelCliente = new PreencherDao();
        
        IdCli = DelCliente.DeletarUser(IdCli);
        
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        textNome = new javax.swing.JTextField();
        TextCpf = new javax.swing.JTextField();
        textEndereco = new javax.swing.JTextField();
        textCel = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        textVerNome = new javax.swing.JTextField();
        textVerEnd = new javax.swing.JTextField();
        textVerCelular = new javax.swing.JTextField();
        textVerEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textCpfup = new javax.swing.JTextField();
        btnSelec = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textCselec = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnInsert.setText("INSERIR");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        textCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCelActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Endereço");

        jLabel4.setText("Celular");

        jLabel5.setText("Email");

        jButton1.setText("LIMPAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        btnUp.setText("ATUALIZAR");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        textVerCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVerCelularActionPerformed(evt);
            }
        });

        textVerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVerEmailActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome");

        jLabel10.setText("Endereço");

        jLabel11.setText("Celular");

        jLabel12.setText("Email");

        jLabel13.setText("CPF");

        btnSelec.setText("Search");
        btnSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecActionPerformed(evt);
            }
        });

        jButton2.setText("LIMPAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textVerNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textVerCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textVerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(textCpfup, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textCpfup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textVerNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textVerEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textVerCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textVerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Atualizar", jPanel8);

        textCselec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCselecActionPerformed(evt);
            }
        });

        jLabel6.setText("CPF");

        btnSel.setText("Search");
        btnSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Endereco", "Celular", "Email"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel7.setText("ID do Cliente");

        textId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdActionPerformed(evt);
            }
        });

        btnDel.setText("Excluir");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(textCselec, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCselec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnSel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Excluir", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdActionPerformed

    private void textCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCelActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
      
        Cliente cliente = new Cliente();
        PreencherDao novoCli = new PreencherDao();
        
        cliente.setNome(textNome.getText());
        cliente.setCpf(TextCpf.getText());
        cliente.setEndereco(textEndereco.getText());
        cliente.setCelular(textCel.getText());
        cliente.setEmail(textEmail.getText());
        
        novoCli.create(cliente);
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
            Updados();


    }//GEN-LAST:event_btnUpActionPerformed

    private void textVerCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVerCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVerCelularActionPerformed

    private void textVerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVerEmailActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void textCselecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCselecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCselecActionPerformed

    private void btnSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelActionPerformed
      TabelaDados();
      textCselec.setText("");
    }//GEN-LAST:event_btnSelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        textNome.setText("");
        textCel.setText("");
        textEmail.setText("");       
        textEndereco.setText("");
        TextCpf.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
            
        Excluir();

    }//GEN-LAST:event_btnDelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            textVerCelular.setText("");
          
            textVerEmail.setText("");
            textVerEnd.setText("");
            textVerNome.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecActionPerformed
        VisualizarDados();
    }//GEN-LAST:event_btnSelecActionPerformed

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
            java.util.logging.Logger.getLogger(abas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextCpf;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSel;
    private javax.swing.JButton btnSelec;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textCel;
    private javax.swing.JTextField textCpfup;
    private javax.swing.JTextField textCselec;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textEndereco;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textVerCelular;
    private javax.swing.JTextField textVerEmail;
    private javax.swing.JTextField textVerEnd;
    private javax.swing.JTextField textVerNome;
    // End of variables declaration//GEN-END:variables
}
