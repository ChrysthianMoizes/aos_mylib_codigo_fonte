package br.edu.ifes.aos.mylib.client.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AtorDTO implements Serializable {

    private Long id;

    private String nome;

    private String cpf;

}
