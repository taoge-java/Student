package com.test.redis;

import redis.clients.jedis.Jedis;

public class RedisServer {

	@SuppressWarnings("resource")
	public void sendMessage(){
		Jedis redis=new Jedis("localhost",6379,10000000);
		redis.auth("123456");
		redis.publish("java", "hello word");//发送消息
		System.out.println("消息发送成功");
	}
}
