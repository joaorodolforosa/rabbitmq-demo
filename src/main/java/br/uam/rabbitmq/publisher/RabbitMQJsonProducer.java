package br.uam.rabbitmq.publisher;

import br.uam.rabbitmq.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao Rodolfo
 */

@Service
public class RabbitMQJsonProducer {
    
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendJsonMessage(Usuario usuario) {
        LOGGER.info(String.format("Mensagem JSON enviada -> %s", usuario.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, usuario);
    }
    
}
