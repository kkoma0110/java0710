package com.wt.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wt.dao.IUserDAO;
import com.wt.po.User;
import com.wt.util.jdbcUtils;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner();
			Connection conn = jdbcUtils.getConn();
			String sql="insert into USER values(null,?,?,?)";
			qr.execute(conn, sql, u.getUname(),u.getBirthday(),u.getMoney());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Integer uid) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner();
			Connection conn = jdbcUtils.getConn();
			String sql="delete from USER where uid=?";
			qr.execute(conn, sql, uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner();
			Connection conn = jdbcUtils.getConn();
			String sql="update USER set uname=?,birthday=?,money=? where uid=?";
			qr.execute(conn, sql, u.getUname(),u.getBirthday(),u.getMoney(),u.getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findAll() {
		try {
			QueryRunner qr = new QueryRunner();
			Connection conn = jdbcUtils.getConn();
			String sql="select * from USER";
			List<User> list = qr.query(conn , sql, new BeanListHandler<User>(User.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findOne(Integer uid) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner();
			Connection conn = jdbcUtils.getConn();
			String sql="select * from USER where uid=?";
			User user = qr.query(conn , sql, new BeanHandler<User>(User.class),uid);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
