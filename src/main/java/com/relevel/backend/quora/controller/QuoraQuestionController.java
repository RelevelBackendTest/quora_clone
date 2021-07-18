package com.relevel.backend.quora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoraQuestionController {

	@GetMapping("/ping")
	public String ping() {
		return "Ping is Successful";
	}
}
