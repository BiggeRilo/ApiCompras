package atom.juice.apicompras.controllers;

import atom.juice.apicompras.data.dto.ClienteDTO;
import atom.juice.apicompras.services.ClienteService;
import atom.juice.apicompras.util.CustomMediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces ={CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ClienteDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces ={CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public List<ClienteDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = { CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML  },produces ={CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {

        return service.create(cliente);
    }

    @PutMapping(consumes = { CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML  },produces ={CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {

        return service.update(cliente);
    }

    @DeleteMapping(value = "/{id}", produces ={CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ResponseEntity<String> disable(@PathVariable(value = "id") Long id) {

        service.disable(id);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete/{id}", produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, CustomMediaType.APPLICATION_YML})
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
