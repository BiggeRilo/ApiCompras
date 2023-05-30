package atom.juice.apicompras.controllers;

import atom.juice.apicompras.data.dto.v1.EnderecoDTO;
import atom.juice.apicompras.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco/v1")
public class EnderecoController {


    EnderecoService service;

    @Autowired
    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

}
