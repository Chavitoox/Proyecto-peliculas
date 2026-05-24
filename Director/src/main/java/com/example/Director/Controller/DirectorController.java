package com.example.Director.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Director.Model.Director;
import com.example.Director.Repository.DirectorRepository;

@RestController
@RequestMapping("/director")
public class DirectorController {
    
    @Autowired
    private DirectorRepository repo;

    @GetMapping("/director")
    public String crear(@RequestBody Director d){

        if(d.getNombre() == null || d.getNombre().trim().isEmpty()){
            return "El nombre del Director es Obligatorio";
        }

        if(repo.existByNombre(d.getNombre())){
            return "El Nombre NO se puede Repetir";
        }

        if(d.getNacionalidad() == null || d.getNacionalidad().trim().isEmpty()){
            return "La Nacionalidad es Obligatoria";
        }

        repo.save(d);
        return "Director Creado Exitosamente";
    }



    @PutMapping("/director/{id}")
    public String crear(@RequestBody Director d, @PathVariable  String id ){

        Director existente = repo.findById(id).orElse(null);

        if(existente == null){
            return "Director No encontrado";
        }

        if(d.getNombre() == null || d.getNombre().trim().isEmpty()){
            return "El nombre del Director es Obligatorio";
        }

        if(repo.existByNombre(d.getNombre())){
            return "El Nombre NO se puede Repetir";
        }

        if(d.getNacionalidad() == null || d.getNacionalidad().trim().isEmpty()){
            return "La Nacionalidad es Obligatoria";
        }


        existente.setId(d.getId());
        existente.setNombre(d.getNombre());
        existente.setNacionalidad(d.getNacionalidad());

        repo.save(existente);
        return "Director Actualizado Exitosamente";
    }


    @GetMapping("/director/{id}")
    public Director buscarId(@PathVariable String id){
        return repo.findById(id).orElse(null);

    }

    @GetMapping("/director/{nombre}")
    public List<Director> buscarNombre(@PathVariable String nombre){
        return repo.findByNombre(nombre);
    }


    @GetMapping("/director")
    public List<Director> listar(){
        return repo.findAll();
    }



    @DeleteMapping("/director/{id}")
    public String eliminar(@PathVariable  String id){
        if(!repo.existsById(id)){
            return "El director no fue encontrado";
        }

        repo.deleteById(id);
        return "Director Eliminado Correctamente";
    }


}
