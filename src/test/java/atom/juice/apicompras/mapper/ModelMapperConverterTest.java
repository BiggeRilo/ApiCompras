package atom.juice.apicompras.mapper;

import atom.juice.apicompras.data.dto.v1.ClienteDTO;
import atom.juice.apicompras.mocks.MockCliente;
import atom.juice.apicompras.models.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelMapperConverterTest {

    static ModelMapper mapper;
    static MockCliente inputObject;

    @BeforeAll
    static void init() {
        mapper = new ModelMapper();
        inputObject = new MockCliente();
    }

    @Test
    public void ParseEntityToDTOTest() {
        ClienteDTO dto = mapper.map(inputObject.mockEntity(), ClienteDTO.class);
        Assertions.assertEquals(Long.valueOf(0), dto.getId());
        Assertions.assertEquals("Test", dto.getNome());
        Assertions.assertEquals("Test", dto.getSobreNome());
        Assertions.assertEquals("000.000.000-00", dto.getCpf());
        Assertions.assertEquals("000.000.000/00", dto.getCnpj());
        Assertions.assertEquals("000.000.000-00", dto.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), dto.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockDTOAdress(0L))), dto.getEnderecos());
    }

    @Test
    public void ParseDTOToEntityTest() {
        Cliente entity = mapper.map(inputObject.mockDto(), Cliente.class);
        Assertions.assertEquals(Long.valueOf(0), entity.getId());
        Assertions.assertEquals("Test", entity.getNome());
        Assertions.assertEquals("Test", entity.getSobreNome());
        Assertions.assertEquals("000.000.000-00", entity.getCpf());
        Assertions.assertEquals("000.000.000/00", entity.getCnpj());
        Assertions.assertEquals("000.000.000-00", entity.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), entity.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockAdress(0L))), entity.getEnderecos());
    }

    @Test
    public void ParseEntityListToDtoListTest() {
        List<ClienteDTO> dtosList = ObjectMapperUtils.mapAll(inputObject.mockEntityList(), ClienteDTO.class);

        ClienteDTO dto = dtosList.get(0);
        Assertions.assertEquals(Long.valueOf(0), dto.getId());
        Assertions.assertEquals("Test", dto.getNome());
        Assertions.assertEquals("Test", dto.getSobreNome());
        Assertions.assertEquals("000.000.000-00", dto.getCpf());
        Assertions.assertEquals("000.000.000/00", dto.getCnpj());
        Assertions.assertEquals("000.000.000-00", dto.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), dto.getDataNascimento());

        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockDTOAdress(0L))), dto.getEnderecos());

        ClienteDTO dto7 = dtosList.get(7);
        Assertions.assertEquals(Long.valueOf(7), dto7.getId());
        Assertions.assertEquals("Test", dto7.getNome());
        Assertions.assertEquals("Test", dto7.getSobreNome());
        Assertions.assertEquals("000.000.000-00", dto7.getCpf());
        Assertions.assertEquals("000.000.000/00", dto7.getCnpj());
        Assertions.assertEquals("000.000.000-00", dto7.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), dto7.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockDTOAdress(7L))), dto7.getEnderecos());

        ClienteDTO dto14 = dtosList.get(12);
        Assertions.assertEquals(Long.valueOf(12), dto14.getId());
        Assertions.assertEquals("Test", dto14.getNome());
        Assertions.assertEquals("Test", dto14.getSobreNome());
        Assertions.assertEquals("000.000.000-00", dto14.getCpf());
        Assertions.assertEquals("000.000.000/00", dto14.getCnpj());
        Assertions.assertEquals("000.000.000-00", dto14.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), dto14.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockDTOAdress(12L))), dto14.getEnderecos());
    }

    @Test
    public void ParseDTOListToEntityListTest() {
        List<Cliente> dtosList = ObjectMapperUtils.mapAll(inputObject.mockDTOList(), Cliente.class);

        Cliente entity = dtosList.get(0);
        Assertions.assertEquals(Long.valueOf(0), entity.getId());
        Assertions.assertEquals("Test", entity.getNome());
        Assertions.assertEquals("Test", entity.getSobreNome());
        Assertions.assertEquals("000.000.000-00", entity.getCpf());
        Assertions.assertEquals("000.000.000/00", entity.getCnpj());
        Assertions.assertEquals("000.000.000-00", entity.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), entity.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockAdress(0L))), entity.getEnderecos());

        Cliente entity7 = dtosList.get(7);
        Assertions.assertEquals(Long.valueOf(7), entity7.getId());
        Assertions.assertEquals("Test", entity7.getNome());
        Assertions.assertEquals("Test", entity7.getSobreNome());
        Assertions.assertEquals("000.000.000-00", entity7.getCpf());
        Assertions.assertEquals("000.000.000/00", entity7.getCnpj());
        Assertions.assertEquals("000.000.000-00", entity7.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), entity7.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockAdress(7L))), entity7.getEnderecos());

        Cliente entity12 = dtosList.get(12);
        Assertions.assertEquals(Long.valueOf(12), entity12.getId());
        Assertions.assertEquals("Test", entity12.getNome());
        Assertions.assertEquals("Test", entity12.getSobreNome());
        Assertions.assertEquals("000.000.000-00", entity12.getCpf());
        Assertions.assertEquals("000.000.000/00", entity12.getCnpj());
        Assertions.assertEquals("000.000.000-00", entity12.getRg());
        Assertions.assertEquals(new Date("01/01/2002"), entity12.getDataNascimento());
        Assertions.assertEquals(new ArrayList<>(List.of(inputObject.mockAdress(12L))), entity12.getEnderecos());


    }

}
