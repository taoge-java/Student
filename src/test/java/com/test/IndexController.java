package com.test;

import com.jfinal.core.Controller;
/**
 *layer分页插件 省略号分页测试
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月23日 下午8:59:33
 */
public class IndexController extends Controller{

	public void index(){
//		Page<User> page=User.dao.paginate(1, 5, "select * ", "from user");
//		setAttr("page",page);
//		render("/index.jsp");
	}
	
	public void ajaxPage(){
//		int number=getParaToInt("pageNumber",1);
//		Page<User> page=User.dao.paginate(number, 5, "select * ", "from user");
//		setAttr("page",page);
//		render("/list.jsp");
	}
}
