package com.example.sql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.sql.models.StarWarResultDTO;

@RestController
@RequestMapping("/API/consulta-starwar")
public class ConsultaStarWarAPI {

	
	@GetMapping("{sw}")
	public StarWarResultDTO starWarResultDTO (@PathVariable("sw") String sw) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StarWarResultDTO> resp =
			restTemplate
				.getForEntity(
						String.format("https://swapi.dev/api/people/%s", sw),
						StarWarResultDTO.class);
		return resp.getBody();
	}
}
