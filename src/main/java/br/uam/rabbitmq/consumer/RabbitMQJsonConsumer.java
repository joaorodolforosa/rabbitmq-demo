package br.uam.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.uam.rabbitmq.entities.Usuario;

@Service
public class RabbitMQJsonConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

	@RabbitListener(queues = { "${rabbitmq.queue.json.name}" })
	public void consumeJsonMessage(Usuario usuario) {

		LOGGER.info(String.format("Recebida a mensagem JSON -> %s", usuario.toString()	));

	}

}
