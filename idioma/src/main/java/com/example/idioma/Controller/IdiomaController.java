package com.example.idioma.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.idioma.model.Idioma;
import com.example.idioma.repository.IdiomaRepository;

@RestController
@RequestMapping("/Idioma")
public class IdiomaController {
@Autowired
private IdiomaRepository repo;

@GetMapping
public ResponseEntity <List<Idioma>>listar(){
    List <Idioma> lista = repo.findAll();
    return ResponseEntity.ok(lista);
} 
@PostMapping
public ResponseEntity<?> crear(@RequestBody Idioma i){
    List<Idioma>ExistenteLeng = repo.findByLenguaje(i.getLenguaje());
    List<Idioma>ExistenteVer = repo.findByVersion(i.getVersion());
    if (i.getLenguaje() == null || i.getLenguaje().isEmpty() ){
        return ResponseEntity.badRequest().body("El lenguaje no puede estar vacio");
    }
    if (i.getVersion() == null || i.getVersion().isEmpty()){
        return ResponseEntity.badRequest().body("La version no puede estar vacia");
    }
    if (!ExistenteLeng.isEmpty() && !ExistenteVer.isEmpty()){
        return ResponseEntity.badRequest().body("ya Existe esa version del idioma");
    }
    Idioma guardada = repo.save(i);
    return ResponseEntity.status(201).body(guardada);
}

}
