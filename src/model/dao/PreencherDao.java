
package model.dao;

import conection.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;


public class PreencherDao {
    
    //cadastrar usuário
    public void create(Cliente cliente){
    
        Connection con = Conect.getConnection();
        PreparedStatement set = null;
        
        try {
            set = con.prepareStatement("INSERT INTO cliente (nome, cpf, endereco, celular, email) values(?,?,?,?,?)");
            set.setString(1, cliente.getNome());
            set.setString(2, cliente.getCpf());
            set.setString(3, cliente.getEndereco());
            set.setString(4, cliente.getCelular());
            set.setString(5, cliente.getEmail());
            
            
            set.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso!!!");
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null,"Erro ao cadstrar!"+ex);
        }finally{
                
            Conect.closeConnection(con, set);
        }
    }
    
    // visualizar dados do usuário para excluir
    
    public List<Cliente> read(String cpf){
        
      Connection con = Conect.getConnection();
        PreparedStatement set = null;
        
        ResultSet selec = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        String recpf = cpf;
      
        try {
            
            set = con.prepareStatement("SELECT * FROM cliente WHERE cpf = '"+recpf+"';");
            selec = set.executeQuery();
            
            while (selec.next()) {                
                Cliente c = new Cliente();
                c.setIdCliente(selec.getInt("id"));
                c.setNome(selec.getString("nome"));
                c.setCpf(selec.getString("cpf"));
                c.setEndereco(selec.getString("endereco"));
                c.setCelular(selec.getString("celular"));
                c.setEmail(selec.getString("email"));
                
                clientes.add(c);
            }
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro no banco de dados!!!"+ex);
        
        }finally{
            Conect.closeConnection(con, set, selec);
        }
    
    
        return clientes;
    
    }
  
    
    
    //ver dados do usuário tela atualizar
    public Cliente UpdateVer(String cpf){
        
      Connection con = Conect.getConnection();
        PreparedStatement set = null;
        
        ResultSet selec = null;
        
//        List<Cliente> clientes = new ArrayList<>();
        
        String recpf = cpf;
        
        Cliente clienteUp = new Cliente();
      
        try {
            
            set = con.prepareStatement("SELECT * FROM cliente WHERE cpf = '"+recpf+"';");
            selec = set.executeQuery();
            
            while (selec.next()) {                
                Cliente c = new Cliente();
                c.setIdCliente(selec.getInt("id"));
                c.setNome(selec.getString("nome"));
                c.setCpf(selec.getString("cpf"));
                c.setEndereco(selec.getString("endereco"));
                c.setCelular(selec.getString("celular"));
                c.setEmail(selec.getString("email"));
                
                clienteUp = c;
            }
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro na consulta"+ex);
        }finally{
            Conect.closeConnection(con, set, selec);
        }
    
    
        return clienteUp;
    
    }
    
    
    //update
    
  public int Update(int id ,String nome,String cpf,String end, String cel, String email){
        
      Connection con = Conect.getConnection();
        PreparedStatement set = null;
        
//        ResultSet selec = null;
        
//        List<Cliente> clientes = new ArrayList<>();
        int idC = id;
        String recpf = cpf;
        String nom = nome;
        String ende = end;
        String tel = cel;
        String emails = email;
        
        
        int numP = 0;
      
      
        try {
           
            
            set = con.prepareStatement("UPDATE cliente SET nome = '"+nom+"', cpf = '"+recpf+"',"
            + " endereco = '"+ende+"', celular = '"+tel+"', email = '"+emails+"' "
                    + "WHERE id = '"+idC+"';");
            
            set.executeUpdate();
            numP = 1;
            
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro na atualização dos dados !"+ex);
        }finally{
            Conect.closeConnection(con, set);
        }
    
    
        return numP;
    
    }
  
  //excluir dados
     public int DeletarUser(int Id){
        
      Connection con = Conect.getConnection();
        PreparedStatement set = null;
        
//        ResultSet selec = null;
        
//        List<Cliente> clientes = new ArrayList<>();
        int idC = Id;
       
      
        try {
            
            
            
            
            set = con.prepareStatement("DELETE FROM cliente WHERE id = '"+idC+"'; ");
            
            set.executeUpdate();
            idC = 0;
            JOptionPane.showMessageDialog(null,"Dados excluídos com sucesso !");
            
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro na exclusão dos dados !"+ex);
        }finally{
            Conect.closeConnection(con, set);
        }
    
    
        return idC;
    
    }
    
    
}
