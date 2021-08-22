package com.sonata.jobtracker.dao;

import java.sql.SQLException;
import java.util.List;

import com.sonata.jobtracker.model.Task;
public interface JobTrackerDao {
	public boolean addTask(Task task) throws SQLException;
	public List<Task> getAllTasks() throws SQLException;
	public List<Task> getAllTasksByStatus(String status) throws SQLException;
	public  List<Task> getAllTasksByOwner(int ownerId) throws SQLException;
	public int updateTaskPriority(int taskid, String priority) throws SQLException;
	public int updateTaskStatus(int taskid, String status) throws SQLException;
	public int assignTaskUser(int taskid,int ownerid) throws SQLException;
	public int updateTaskBookmark(int taskid, int Bookmark) throws SQLException;
	public int updateTaskNotes(int taskid, String Notes) throws SQLException;
}