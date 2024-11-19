package br.uam.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uam.rabbitmq.entities.Usuario;
import br.uam.rabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/json")
public class MessageJsonController {
	
	private RabbitMQJsonProducer jsonProducer;
	
	public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody Usuario usuario) {
		jsonProducer.sendJsonMessage(usuario);
		return ResponseEntity.ok("Mensagem JSON enviada para o RabbitMQ");
	}

}
