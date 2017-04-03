package com.student.dao.inter;

import com.student.utils.Result;
/**
 * 数据库增删该查接口
 * @author Administrator
 *
 */
public interface DataManger {
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	public Result alert(int id);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public Result delById(int id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public Result delAll(String[] ids);

}
