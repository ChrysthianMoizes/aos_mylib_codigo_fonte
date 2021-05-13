package br.edu.ifes.aos.mylib.service.service.mapper;

import br.edu.ifes.aos.mylib.service.domain.Ator;
import br.edu.ifes.aos.mylib.service.service.dto.AtorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AtorMapper extends EntityMapper<AtorDTO, Ator> {
}
