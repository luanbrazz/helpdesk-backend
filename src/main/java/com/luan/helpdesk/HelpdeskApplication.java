package com.luan.helpdesk;

import com.luan.helpdesk.domain.Chamado;
import com.luan.helpdesk.domain.Cliente;
import com.luan.helpdesk.domain.Tecnico;
import com.luan.helpdesk.enums.Perfil;
import com.luan.helpdesk.enums.Prioridade;
import com.luan.helpdesk.enums.Status;
import com.luan.helpdesk.repositories.ChamadoRepository;
import com.luan.helpdesk.repositories.ClienteRepository;
import com.luan.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

    @Autowired
    private TecnicoRepository tecnicoRepository; //No código apresentado, a anotação "@Autowired" é usada para injetar
    // uma instância da classe "TecnicoRepository" em um componente Spring. A classe "TecnicoRepository" é uma classe
    // que fornece métodos para acessar um banco de dados relacionado a técnicos.

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Tecnico tec1 = new Tecnico(null, "Luan Braz", "83305179007", "luan@email.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Luiz da Silva", "54474398092", "luiz@email.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Pimeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
