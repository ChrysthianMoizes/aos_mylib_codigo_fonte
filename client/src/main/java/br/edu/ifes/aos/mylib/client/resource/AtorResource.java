package br.edu.ifes.aos.mylib.client.resource;

import br.edu.ifes.aos.mylib.client.service.AtorService;
import br.edu.ifes.aos.mylib.client.service.dto.AtorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class AtorResource {

    private final AtorService atorService;

    @GetMapping
    public ResponseEntity<List<AtorDTO>> listar() {
        List<AtorDTO> atores = atorService.listar();
        return new ResponseEntity<>(atores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AtorDTO> salvar(@RequestBody AtorDTO atorDTO) {
        AtorDTO ator = atorService.salvar(atorDTO);
        return new ResponseEntity<>(ator, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AtorDTO> alterar(@RequestBody AtorDTO atorDTO) {
        AtorDTO ator = atorService.salvar(atorDTO);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        atorService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
