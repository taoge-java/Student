package com.student.dao.inter;

import com.student.utils.ResultCode;

public interface ResultDao {
	
	public boolean isSuccess();
	
	public void setResultCode();
	
	public ResultCode getResultCode();
	
	public void setModel();
	
	public void getModel();
	
}
