package com.student.service.system;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.student.constant.CommonConstant;
import com.student.controller.system.AdminController;
import com.student.model.system.SystemOper;
import com.student.model.system.SystemRole;
import com.student.utils.Result;
import com.student.utils.ResultCode;
/**
 * 角色管理services
 * @author zjt
 *
 */
public class RoleServices {
	
	private Logger log=Logger.getLogger(AdminController.class);
	
	/**
	 * 根据角色获取操作权限列表
	 * @param roleId 角色id
	 * @return
	 */
	public Set<String> findRoleById(int roleId){
		SystemRole systemRole=SystemRole.dao.findById(roleId);
		List<SystemOper> oper=null;
		if(systemRole.getBoolean("super_flag")){
			oper=SystemOper.dao.find("select * from system_oper");
		}else{
			//查询角色所以操作权限
			oper=SystemOper.dao.find("select * from system_oper where id in(select oper_id from system_role_oper_ref where role_id="+roleId+")");
		}
		Set<String> operCode=new LinkedHashSet<String>();
		for(SystemOper code:oper){
			operCode.add(code.getStr("oper_code"));
		}
		return operCode;
	}
	
	
	
	/**
	 * 角色列表
	 * @return
	 */
	public Page<SystemRole> getRole(int pageNumber,String login_name){
		StringBuilder context=new StringBuilder("from system_role where 1=1");
		List<Object> param=new  ArrayList<Object>();
		if(StringUtils.isNotEmpty(login_name)){
			context.append(" and role_name=?");
			param.add(login_name);
		}
		String order=" order by id desc";
		context.append(order);
		return SystemRole.dao.paginate(pageNumber,CommonConstant.pageSize, "select *",context.toString(),param.toArray());
	}
	
    /**
     * 创建角色
     * @param name
     * @param flag
     * @param remark
     * @return
     */
	public Result save(String name, String flag, String remark) {
		Result result=new Result();
		ResultCode resultCode =new ResultCode(ResultCode.SUCCESS, "角色创建成功!");
        try{
        	SystemRole role1=SystemRole.dao.findFirst("select  *from system_role where role_name=?",name);
        	if(role1!=null){
        		resultCode =new ResultCode(ResultCode.FAIL, "该角色已经存在!");
	        	result.setResultCode(resultCode);
	        	return result;
        	}else{
        		SystemRole role=new SystemRole();
        		role.set("role_name", name);
        		role.set("flag", flag);
        		role.set("remark", remark);
        		role.save();
        	}
        }catch(Exception e){
            resultCode =new ResultCode(ResultCode.FAIL, "创建数据异常!");
        	log.error("创建数据异常!");
        }
		result.setResultCode(resultCode);
		return result;
	}
	/**
	 * 更新角色
	 * @param name
	 * @param flag
	 * @param remark
	 * @return
	 */
	public Result update(String name, String flag, String remark,int id){
		Result result=new Result();
		ResultCode resultCode=new ResultCode(ResultCode.SUCCESS,"角色修改成功");
		SystemRole role=SystemRole.dao.findById(id);
		try{
			if(role!=null){
				role.set("role_name", name);
				role.set("flag", flag);
        		role.set("remark", remark);
        		role.update();
			}
		}catch(Exception e){
			resultCode=new ResultCode(ResultCode.FAIL,"更新数据异常");
			log.error("更新数据异常");
		}
		result.setResultCode(resultCode);
		return result;
	}
	/**
	 * 修改角色
	 * @param id
	 * @return
	 */
	public SystemRole alert(int id){
		return SystemRole.dao.findById(id);
	}
	/**
	 * 批量删除角色
	 * @param ids
	 * @return
	 */
	public Result delAll(String ids[]){
		Result result=new Result();
		ResultCode resultCode=new ResultCode(ResultCode.SUCCESS, "删除数据成功");
		try{
			for(String id:ids){
				SystemRole.dao.deleteById(id);
			}
		}catch(Exception e){
			log.error("删除数据异常....");
			resultCode=new ResultCode(ResultCode.FAIL, "删除数据异常");
		}
		result.setResultCode(resultCode);
		return result;
	}
}
