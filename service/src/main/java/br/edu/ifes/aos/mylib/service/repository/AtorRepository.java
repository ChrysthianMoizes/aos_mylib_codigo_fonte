package br.edu.ifes.aos.mylib.service.repository;

import br.edu.ifes.aos.mylib.service.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {

}
