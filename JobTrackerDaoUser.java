package com.sonata.jobtracker.dao;
import java.sql.SQLException;
import com.sonata.jobtracker.model.User;
public interface JobTrackerDaoUser {
		public boolean addUser(User user) throws SQLException;
}