/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
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
            
        String sql = "INSERT INTO tasks (idProject"
                + "name,"
                + "description,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnetcionFactory.getConnection;
            statement = connection.PreparedStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        }catch(Exception e){
            throw new RuntimeException("Erro ao salvar tarefa " 
                                        + e.getMessage(),e);
        }finally{
            ConnetcionFactory.closeConnection(connection);
        }
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
