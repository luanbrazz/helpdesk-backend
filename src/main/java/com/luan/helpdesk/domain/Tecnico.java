package com.luan.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luan.helpdesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends  Pessoa {
    private static final long serialVersionUID =1L;

    //Em Java, a anotação "@JsonIgnore" é usada para indicar que um determinado atributo ou método de uma classe não
    // deve ser incluído na serialização ou desserialização de objetos em JSON.
    @JsonIgnore
    @OneToMany(mappedBy ="tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
