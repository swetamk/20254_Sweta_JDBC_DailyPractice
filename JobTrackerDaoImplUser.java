package com.sonata.jobtracker.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import com.sonata.jobtracker.dao.MyConnection;
import com.sonata.jobtracker.model.User;
public class JobTrackerDaoImplUser implements com.sonata.jobtracker.dao.JobTrackerDaoUser{

	@Override
	public boolean addUser(User user) throws SQLException {
		boolean added = false;
		Connection conn = new MyConnectionImpl().connectToMySQL();
		String sql = "INSERT INTO User (userId,userName,email,firstname,lastname,contactno,role,isactive,dob,createdon) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, user.getUserId());
		pst.setString(2,user.getUserName());
		pst.setString(3,user.getEmail());
		pst.setString(4,user.getFirstName());
		pst.setString(5,user.getLastName());
		pst.setLong(6,user.getContactNumber());
		pst.setString(7,user.getRole());
		pst.setBoolean(8,user.getIsAlive());
		pst.setDate(9,(java.sql.Date) user.getDob());
		pst.setDate(10,(java.sql.Date)user.getCreatedOn());
		
		int r = pst.executeUpdate(); // insert, delete, update
		pst.close();
		conn.close();
		if (r > 0)
		added = true;
		return added;
	}

}