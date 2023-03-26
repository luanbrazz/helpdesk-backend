package com.luan.helpdesk.resources;

import com.luan.helpdesk.domain.Tecnico;
import com.luan.helpdesk.domain.dtos.TecnicoDTO;
import com.luan.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    //O tipo ResponseEntity representa toda a resposta HTTP, incluindo o status da resposta, os cabeçalhos e o corpo da
    // resposta. Isso é útil em aplicativos da Web, onde você deseja fornecer uma resposta HTTP bem definida ao cliente,
    // com informações adicionais, como o status da resposta e os cabeçalhos.
    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> list = service.findAll();
        List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
