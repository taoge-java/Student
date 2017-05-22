package com.student.config;

import com.jfinal.aop.Duang;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.route.AutoBindRoutes;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.student.interceptor.PermissionInterceptor;
import com.student.interceptor.ViewContextInterceptor;
import com.student.job.base.JobManger;
import com.student.model.BaseModel;
import com.student.spring.SpringBeanManger;


@SuppressWarnings("unused")
public class SysConfig extends JFinalConfig{

	private Logger LOG=Logger.getLogger(SysConfig.class);
	
	public final static String BASE_VIEW="/WEB-INF/views";
	
	public static String redisHost; // redis主机
	
	public static String redisPassword; // redis密码
	
	public static String resourceUpload;//文件上传路径
	
	public static String resourceDown;
	@Override
	public void configConstant(Constants constants) {
		 constants.setDevMode(true);
		 constants.setViewType(ViewType.VELOCITY);
		 PropKit.use("config.properties");
		 redisPassword = PropKit.get("db.redis.password").trim();
		 redisHost = PropKit.get("db.redis.host").trim();
		 resourceUpload=PropKit.get("resource.upload.path").trim();
		 resourceDown=PropKit.get("resource.upload.path").trim();
		 constants.setUploadedFileSaveDirectory(resourceUpload);
	}
	/**
	 * 添加路由
	 */
	@Override
	public void configRoute(Routes routes) {
		routes.add(new AutoBindRoutes());
	}
	/**
	 * 配置c3p0数据库连接池
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void configPlugin(Plugins plugin) {
		DruidPlugin druid = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
	    plugin.add(druid);
	    AutoTableBindPlugin atbp = new AutoTableBindPlugin(druid);
	    atbp.addExcludeClasses(BaseModel.class);
	    atbp.setShowSql(true);
	    plugin.add(atbp);
	    //配置缓存插件
	    plugin.add(new EhCachePlugin());
	    //配置redis插件
	    RedisPlugin redis=new RedisPlugin("student", redisHost,6379,redisPassword);
	    redis.getJedisPoolConfig().setMaxTotal(200);
	    redis.getJedisPoolConfig().setMaxIdle(200);
	    plugin.add(redis);
	}

	@Override
	public void configInterceptor(Interceptors interceptors) {
		interceptors.add(new PermissionInterceptor());
		interceptors.add(new ViewContextInterceptor());
	}

	@Override
	public void configHandler(Handlers handlers) {
	   handlers.add(new ContextPathHandler("BASE_PATH"));
	}
	
	@Override
	public void afterJFinalStart() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				JobManger job=Duang.duang(JobManger.class);
				job.start();
			}
		}).start();
		LOG.info("数据初始化完毕");
	}
}
