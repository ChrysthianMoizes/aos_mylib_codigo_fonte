package br.edu.ifes.aos.mylib.service.service;

import br.edu.ifes.aos.mylib.service.domain.Ator;
import br.edu.ifes.aos.mylib.service.repository.AtorRepository;
import br.edu.ifes.aos.mylib.service.service.dto.AtorDTO;
import br.edu.ifes.aos.mylib.service.service.exception.RegraNegocioException;
import br.edu.ifes.aos.mylib.service.service.mapper.AtorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AtorService {

    private final AtorRepository atorRepository;

    private final AtorMapper atorMapper;

    public List<AtorDTO> listar() {
        List<Ator> atores = atorRepository.findAll();
        return atorMapper.toDto(atores);
    }

    private Ator getAtor(Long id) {
        return atorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Ator não encontrado"));
    }

    public AtorDTO salvar(AtorDTO atorDTO) {
        Ator ator = atorMapper.toEntity(atorDTO);
        atorRepository.save(ator);
        return atorMapper.toDto(ator);
    }

    public void excluir(Long id) {
        Ator ator = getAtor(id);
        atorRepository.delete(ator);
    }

}
