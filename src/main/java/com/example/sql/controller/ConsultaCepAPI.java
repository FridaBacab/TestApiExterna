
package com.example.sql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.sql.models.CepResultDTO;

@RestController
@RequestMapping("/API/consulta-cep")
public class ConsultaCepAPI {

	@GetMapping("{cep}")
	public CepResultDTO consultaCep (@PathVariable("cep") String cep, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CepResultDTO> resp =

		restTemplate
		.getForEntity(
	
		String.format("https://viacep.com.br/ws/%s/json", cep),
		CepResultDTO.class);
		model.addAttribute("respCesp", resp);
		
		return resp.getBody();
	}
	
}
