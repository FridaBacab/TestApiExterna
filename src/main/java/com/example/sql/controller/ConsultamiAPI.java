package com.example.sql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.sql.models.ApiClient;



@Controller
@RequestMapping("/apiRopa")
public class ConsultamiAPI {

	
	@GetMapping("{cl}")
	public String startMethod (@PathVariable("cl") String cl, Model model) {
		String titulo = "Pagina API con Spring Boot";
		model.addAttribute("name", cl);
		model.addAttribute("titulo", titulo);
		ApiClient startClienteDTO = starClientResultDTO (cl);
		model.addAttribute("startClienteDTO", startClienteDTO);
		return "viewmain";
	}
	
	public ApiClient starClientResultDTO (String numID) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ApiClient> resp =
				restTemplate
				.getForEntity(
						String.format("https://jsonplaceholder.typicode.com/todos/%s", numID),
						ApiClient.class);
		return resp.getBody();
	}
	

}
