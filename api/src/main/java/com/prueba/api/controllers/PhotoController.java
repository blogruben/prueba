package com.prueba.api.controllers;

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
import com.prueba.api.models.UsuarioModel;
import com.prueba.api.services.UsuarioService;



//Clase de tipo controlador recibe la peticion web que llama al servicio
@RestController
@RequestMapping("/photo")
public class PhotoController {
   @Autowired
   PhotoService usuarioService;

   @GetMapping()
   public ArrayList<UsuarioModel> obtenerUsuarios(){
    return this.usuarioService.obtenerUsuarios();
   }
    
   @PostMapping()
   public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
    return this.usuarioService.guardarUsuario(usuario);
   }

   //Ejemlo http://localhost:8080/usuario/1
   @GetMapping(path ="/{id}")
   public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
    return this.usuarioService.obtenerUsuarioPorId(id);
   }

   //Ejemlo http://localhost:8080/usuario/query?prioridad=5
   @GetMapping("/query")
   public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    return this.usuarioService.obtenerUsuarioPorPrioridad(prioridad);
   }


@DeleteMapping(path ="/{id}")
public String eliminarPorId(@PathVariable("id") Long id){
    boolean ok = this.usuarioService.eliminarUsuario(id);
    if(ok){
      return "Se elimino el usuario por id "+id;
    }else{
      return "No se pudo eliminar el usuario con id "+id;
    }

  }

}
