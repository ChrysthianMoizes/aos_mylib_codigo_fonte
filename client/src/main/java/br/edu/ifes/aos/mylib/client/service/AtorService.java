package br.edu.ifes.aos.mylib.client.service;

import br.edu.ifes.aos.mylib.client.service.dto.AtorDTO;
import br.edu.ifes.aos.mylib.client.service.feign.MylibService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtorService {

    private final MylibService mylibService;

    public List<AtorDTO> listar() {
        return mylibService.listar();
    }

    public AtorDTO salvar(AtorDTO atorDTO) {
        return mylibService.salvar(atorDTO);
    }

    public void excluir(Long id) {
        mylibService.excluir(id);
    }

}
