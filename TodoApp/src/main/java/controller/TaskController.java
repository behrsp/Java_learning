/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnetcionFactory;

/**
 *
 * @author robson
 */
public class TaskController {
    
    public void save(Task task){
    
    }
    
    public void update(Task task){
    
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ? "; 
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnetcionFactory.getConnection();
            statement = conn.PreparedStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }catch (SQLException e){
            throw new SQLException("Erro ao Deletar tarefa.", e);
        }finally{
            ConnetcionFactory.closeConnection(conn);
        }
        
        
    }
    
    public List<Task> getAll(int idProject){
        return null;
    }
}
