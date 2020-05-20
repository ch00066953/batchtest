package cn.archer.spring.bacthrocketmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
 
/**
 * Description: 从rabbitmq中读取消息
 */
public class RabbitReader<T> implements ItemReader {
 
	// amqpTemplate 实例
	private RabbitTemplate amqpTemplate;
 
	// 消息队列名称
	private String mqName;
 
	private final Object lock = new Object();
 
	public RabbitReader(RabbitTemplate amqpTemplate, String mqName){
		this.amqpTemplate = amqpTemplate;
		this.mqName = mqName;
	}
 
	@Override
	public T read() {
		T receive;
                //加同步锁，以防万一
		synchronized (lock) {
			amqpTemplate.setMessageConverter(jsonMessageConverter());
			receive = (T) amqpTemplate.receiveAndConvert(mqName);
		}
		return receive;
	}
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
 
}