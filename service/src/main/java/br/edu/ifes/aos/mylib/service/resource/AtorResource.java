package br.edu.ifes.aos.mylib.service.resource;

import br.edu.ifes.aos.mylib.service.service.AtorService;
import br.edu.ifes.aos.mylib.service.service.dto.AtorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/atores")
@RequiredArgsConstructor
@Tag(name = "AtorResource", description = "Resource responsável pelo gerenciamento de Atores")
public class AtorResource {

    private final AtorService atorService;

    @GetMapping
    @Operation(description = "Listagem de atores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem completa")
    })
    public ResponseEntity<List<AtorDTO>> listar() {
        List<AtorDTO> atores = atorService.listar();
        return new ResponseEntity<>(atores, HttpStatus.OK);
    }

    @PostMapping
    @Operation(description = "Criação de ator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ator Criado"),
            @ApiResponse(responseCode = "400", description = "Ator duplicado")
    })
    public ResponseEntity<AtorDTO> salvar(@RequestBody AtorDTO atorDTO) {
        AtorDTO ator = atorService.salvar(atorDTO);
        return new ResponseEntity<>(ator, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(description = "Edição de ator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ator atualizado"),
            @ApiResponse(responseCode = "400", description = "Ator duplicado")
    })
    public ResponseEntity<AtorDTO> alterar(@RequestBody AtorDTO atorDTO) {
        AtorDTO ator = atorService.salvar(atorDTO);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Exclusão de ator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ator excluido"),
            @ApiResponse(responseCode = "400", description = "Ator não encontrado")
    })
    public ResponseEntity<Void> excluir(@Parameter(description = "id do ator a ser excluído")  @PathVariable("id") Long id) {
        atorService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
