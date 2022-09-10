/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.tasks;
import util.ConnectionFactory;

/**
 *
 * @author user
 */
public class taskController {
    
    public void save(tasks task){
    
        String sql = " INSERT INTO tasks (idProject"
                +"name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setInt(1, task.getIdProject());
           statement.setString(2, task.getName());
           statement.setString(3, task.getDescription());
           statement.setBoolean(4, task.getCompleted());
           statement.setString(5, task.getNotes());
           statement.setDate(6, new Date(task.getDeadline().getTime()));
           statement.setDate(7, new Date( task.getCreatedAt().getTime()));
           statement.setDate(8, new Date(task.getUpdateAt().getTime()));
           statement.execute();    
        }catch(SQLException e) {
           throw new RuntimeException(" Erro ao  salvar a tarefa" + ex.getMessage(), ex);
           
                    
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
            
            
        }
    }
    
    public void update(tasks task){
    
    
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = " DELET FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
               
        }catch (SQLException e){
            throw new SQLException(" Erro ao  deletar a tarefa");
            
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        
        }
        
    }
    
    public List<tasks> getAll(int idProject){
        return null;
    }
}
