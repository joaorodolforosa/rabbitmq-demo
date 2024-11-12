package br.uam.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.uam.rabbitmq.producer.RabbitMQProducer;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private RabbitMQProducer producer;
	
	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	
	// http://localhost:8080/api/publish?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam String message) {
		producer.sendMessage(message);
		return ResponseEntity.ok("Mensagem enviada para o RabbitMQ...");
	}

}
