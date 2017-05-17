package com.test.redis;


import redis.clients.jedis.Jedis;

public class RedisClient {

	@SuppressWarnings("resource")
	public void getRedisMessage(){
		 Jedis jr = new Jedis("localhost",6379,100000000);//redis服务地址和端口号
         jr.auth("123456");
         RedisListener sp = new RedisListener();
         jr.subscribe(sp,"java");//订阅频道
	}
}
