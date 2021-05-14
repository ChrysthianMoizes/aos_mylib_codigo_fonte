package br.edu.ifes.aos.mylib.client.service.feign;

import br.edu.ifes.aos.mylib.client.service.dto.AtorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "mylibservice", url = "${application.feign.url}")
public interface MylibService {

    @GetMapping("/api/atores")
    List<AtorDTO> listar();

    @PostMapping("/api/atores")
    AtorDTO salvar(@RequestBody AtorDTO atorDTO);

    @PutMapping("/api/atores")
    AtorDTO editar(@RequestBody AtorDTO atorDTO);

    @DeleteMapping("/api/atores/{id}")
    void excluir(@PathVariable Long id);
}
