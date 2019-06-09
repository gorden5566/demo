package com.gorden5566.framework.rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author gorden5566
 * @date 2019/06/07
 */
public class RabbitConsumer {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = {
            new Address(IP_ADDRESS, PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root");

        Connection connection = factory.newConnection(addresses);
        final Channel channel = connection.createChannel();

        // 设置客户端最多接收未被 ack 的消息的个数
        channel.basicQos(64);

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("receive message: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);

        TimeUnit.SECONDS.sleep(60);
        channel.close();
        connection.close();
    }
}
