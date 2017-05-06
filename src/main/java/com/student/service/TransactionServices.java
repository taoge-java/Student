package com.student.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.jfinal.plugin.activerecord.Config;
import com.jfinal.plugin.activerecord.DbKit;

public class TransactionServices {
	
	private Config config=null;
	private Connection conn=null;
	Boolean autoCommit=null;
	
	/**
	 * 开启事物
	 */
	@SuppressWarnings("unused")
	private void startTransaction(){
		config=DbKit.getConfig();
		conn=config.getThreadLocalConnection();
		try{
			if(conn!=null){
				if(conn.getTransactionIsolation()<config.getTransactionLevel()){
					conn.setTransactionIsolation(config.getTransactionLevel());
					return;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn=config.getConnection();
			autoCommit=conn.getAutoCommit();
			conn.setTransactionIsolation(config.getTransactionLevel());
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 提交事物
	 */
	public void commit(){
		if(conn!=null){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 事物回滚
	 */
	public void rollback(){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭事物
	 */
	public void close(){
		if(conn!=null){
			if(autoCommit!=null){
				try {
					conn.setAutoCommit(autoCommit);
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
