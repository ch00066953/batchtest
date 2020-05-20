package cn.archer.spring.bacthrocketmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class RabbitMQConfig {


//    public final static String queueName = "my-queue";
//    @Autowired
//    private ConnectionFactory rabbitConnectionFactory;
//    @Bean
//    public Queue myQueue() {
//        return new Queue(queueName, true);
//    }
//    // this is necessary for operations with Spring AMQP
//    @Bean
//    public RabbitTemplate getMyQueueTemplate() {
//        RabbitTemplate template = new RabbitTemplate(this.rabbitConnectionFactory);
//        template.setDefaultReceiveQueue(queueName);
//        return template;
//    }
}