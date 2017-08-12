package com.demo.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.demo.Vo.User;

public class UserDao extends JdbcDaoSupport{
	
	public void add(User user){
		String sql="insert into userinfo (username, password ) values(?,?)";
		this.getJdbcTemplate().update(sql,user.getUsername(),user.getPassword());
	}
	public void update(User user){
		String sql = "update userinfo set username=?,password=? where id =?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		this.getJdbcTemplate().update(sql, args);
	}
	public void delete(int id){
		String sql="delete from userinfo where id=?";
		this.getJdbcTemplate().update(sql,id);
	}

	/**
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return this.getJdbcTemplate().query("select * from userinfo", ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}

	public User getById(int id) {
		return this.getJdbcTemplate().queryForObject("select * from userinfo where id = ?", ParameterizedBeanPropertyRowMapper.newInstance(User.class), id);
	}

}
