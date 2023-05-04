package com.example.sql.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.sql.models.UsuarioModel;
import com.example.sql.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping(path = "/queryPrioridad")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@GetMapping(path = "/queryNombre")
	public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
		return this.usuarioService.obtenerPorNombre(nombre);
	}
	
	@GetMapping(path = "/queryEmail")
	public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("mail") String mail){
		return this.usuarioService.obtenerPorEmail(mail);
	}
	
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se eliminó el usuario con id " + id;
		}else {
			return "No se pudo eliminar el usuario con id " + id;
		}
	}

}
