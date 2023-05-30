package atom.juice.apicompras.controllers;

import atom.juice.apicompras.data.dto.v1.ClienteDTO;
import atom.juice.apicompras.services.ClienteService;
import atom.juice.apicompras.util.CustomMediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente/v1")
@Tag(name = "Cliente", description = "Endpoint para gestão de Clientes")
public class ClienteController {

    ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/{id}", produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    @Operation(summary = "Busca um Cliente", description = "Busca um cliente recebendo o seu Id como parâmetro", tags = "Cliente",
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200", content = {
                            @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                            @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                            @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ClienteDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Busca todos os clientes", description = "Busca todos os clientes cadastrados", tags = "Cliente", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @GetMapping(produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public List<ClienteDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Cria um cliente", description = "Cria um cliente passando os valores de cadastro", tags = "Cliente", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))
            }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @PostMapping(consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML}, produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {

        return service.create(cliente);
    }

    @Operation(summary = "Atualiza um cliente", description = "Atualiza um cliente passando os valores de cadastro atualizados", tags = "Cliente", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))
            }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @PutMapping(consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML}, produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {

        return service.update(cliente);
    }

    @Operation(summary = "Desativa um cliente", description = "Desativa um cliente passando os seu id", tags = "Cliente", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @DeleteMapping(value = "/{id}", produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public ResponseEntity<String> disable(@PathVariable(value = "id") Long id) {

        service.disable(id);

        return ResponseEntity.noContent().build();

    }

    @Operation(summary = "Deleta um cliente", description = "Deleta um cliente passando os seu id", tags = "Cliente", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, CustomMediaType.APPLICATION_YML})
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
