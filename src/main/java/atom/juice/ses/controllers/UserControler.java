package atom.juice.ses.controllers;

import atom.juice.ses.data.dto.v1.UserDTO;
import atom.juice.ses.services.UserService;
import atom.juice.ses.util.CustomMediaType;
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
@RequestMapping("/User/v1")
@Tag(name = "User", description = "Endpoint para gestão de Users")
public class UserControler {

    UserService service;

    @Autowired
    public UserControler(UserService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/{id}", produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    @Operation(summary = "Busca um User", description = "Busca um User recebendo o seu Id como parâmetro", tags = "User",
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200", content = {
                            @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                            @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                            @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public UserDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Busca todos os Users", description = "Busca todos os Users cadastrados", tags = "User", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @GetMapping(produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Cria um User", description = "Cria um User passando os valores de cadastro", tags = "User", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @PostMapping(consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML}, produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public UserDTO create(@RequestBody UserDTO User) {

        return service.create(User);
    }

    @Operation(summary = "Atualiza um User", description = "Atualiza um User passando os valores de cadastro atualizados", tags = "User", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(mediaType = CustomMediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_YML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))),
                    @Content(mediaType = CustomMediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
    })
    @PutMapping(consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
            CustomMediaType.APPLICATION_YML}, produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML, CustomMediaType.APPLICATION_YML})
    public UserDTO update(@RequestBody UserDTO User) {

        return service.update(User);
    }

    @Operation(summary = "Desativa um User", description = "Desativa um User passando os seu id", tags = "User", responses = {
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

    @Operation(summary = "Deleta um User", description = "Deleta um User passando os seu id", tags = "User", responses = {
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
