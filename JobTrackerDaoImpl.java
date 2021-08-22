package com.sonata.jobtracker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonata.jobtracker.dao.MyConnection;
import com.sonata.jobtracker.model.Task;

public class JobTrackerDaoImpl implements com.sonata.jobtracker.dao.JobTrackerDao {
	@Override
	public boolean addTask(Task task) throws SQLException 
	{
		boolean added = false;
		Connection conn = new MyConnectionImpl().connectToMySQL();
		String sql = "INSERT INTO Task (taskId,ownerid,name,description,status) VALUES(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, task.getTaskId());
		pst.setInt(2, task.getOwnerId());
		pst.setString(3, task.getName());
		pst.setString(4,task.getDescription());
		pst.setString(5, task.getStatus());
		int r = pst.executeUpdate(); // insert, delete, update
		pst.close();
		conn.close();
		if (r > 0)
		added = true;
		return added;
	}

	@Override
	public List<Task> getAllTasks() throws SQLException {
		// TODO Auto-generated method stub
		List<Task>tasklist=new ArrayList<Task>();
		Connection conn= new MyConnectionImpl().connectToMySQL();
		String sql = "SELECT * from Task";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Task task=new Task(0, 0, null, null, null, null, null, null, null, null, null);
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("OwnerId"));
			task.setName(rs.getString("name"));
			task.setStatus(rs.getString("status"));
			tasklist.add(task);
			
		}
		rs.close();
		pst.close();
		conn.close();
		return tasklist;
	}

	@Override
	public List<Task> getAllTasksByStatus(String status) throws SQLException 
	{
		// TODO Auto-generated method stub
		List<Task>tasklist=new ArrayList<Task>();
		Connection conn= new MyConnectionImpl().connectToMySQL();
		String sql ="SELECT * from Task WHERE status LIKE " +"'"+ status + "'";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Task task=new Task(0, 0, null, null, null, null, null, null, null, null, null);
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("OwnerId"));
			task.setName(rs.getString("name"));
			task.setStatus(rs.getString("status"));
			tasklist.add(task);
			
		}
		rs.close();
		pst.close();
		conn.close();
		return tasklist;
	}
	public List<Task> getAllTasksByOwner(int ownerId) throws SQLException {
		List<Task> tasklist = new ArrayList<Task>();
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql ="SELECT * from Task WHERE ownerId = " +ownerId;
		PreparedStatement qst =  conn.prepareStatement(sql);
		ResultSet rs = qst.executeQuery();
		
		while(rs.next()) {
			Task task=new Task(0, 0, null, null, null, null, null, null, null, null, null);
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("OwnerId"));
			task.setName(rs.getString("name"));
			task.setStatus(rs.getString("status"));
			tasklist.add(task);
		}
		rs.close();
		qst.close();
		conn.close();
		return tasklist;
	}

	public int updateTaskPriority(int taskid, String priority) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET priority = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, priority);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}
	public int assignTaskUser(int taskid, int ownerid) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET ownerId = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setInt(1, ownerid);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return ownerid;
	}

	@Override
	public int updateTaskStatus(int taskid, String status) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET status = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, status);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}

	@Override
	public int updateTaskBookmark(int taskid, int Bookmark) throws SQLException {
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET Isbookmarked = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setInt(1, Bookmark);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}

	@Override
	public int updateTaskNotes(int taskid, String Notes) throws SQLException {
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET notes = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, Notes);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}

}