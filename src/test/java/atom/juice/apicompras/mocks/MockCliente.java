package atom.juice.apicompras.mocks;

import atom.juice.apicompras.data.dto.ClienteDTO;
import atom.juice.apicompras.data.dto.EnderecoDTO;
import atom.juice.apicompras.models.Cliente;
import atom.juice.apicompras.models.Endereco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockCliente {

    public Cliente mockEntity() {
        return mockEntity(0L);

    }

    public ClienteDTO mockDto() {
        return mockDTO(0L);
    }

    public List<Cliente> mockEntityList() {
        List<Cliente> persons = new ArrayList<Cliente>();
        for (long i = 0L; i < 14L; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<ClienteDTO> mockDTOList() {
        List<ClienteDTO> persons = new ArrayList<ClienteDTO>();
        for (long i = 0L; i < 14L; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }


    private Cliente mockEntity(long i) {
        Cliente cli = new Cliente();
        cli.setId(i);
        cli.setNome("Test");
        cli.setSobreNome("Test");
        cli.setCpf("000.000.000-00");
        cli.setRg("000.000.000-00");
        cli.setCnpj("000.000.000/00");
        Endereco adress = mockAdress(i);
        cli.setEnderecos(new ArrayList<>(List.of(adress)));
        cli.setDataNascimento(new Date("01/01/2002"));
        return cli;
    }

    public Endereco mockAdress(long i) {
        Endereco adress = new Endereco(i);
        adress.setCep("00000000");
        adress.setComplemento("Teste");
        adress.setCidade("Teste");
        adress.setEstado("Teste");
        adress.setLogradouro("Teste");
        adress.setNumero("123");
        return adress;
    }

    private ClienteDTO mockDTO(long i) {
        ClienteDTO cli = new ClienteDTO();
        cli.setId(i);
        cli.setNome("Test");
        cli.setSobreNome("Test");
        cli.setCpf("000.000.000-00");
        cli.setRg("000.000.000-00");
        cli.setCnpj("000.000.000/00");
        cli.setDataNascimento(new Date("01/01/2002"));
        EnderecoDTO adressDTO = mockDTOAdress(i);
        cli.setEnderecos(new ArrayList<>(List.of(adressDTO)));
        return cli;
    }

    public EnderecoDTO mockDTOAdress(long i) {
        EnderecoDTO adressDTO = new EnderecoDTO(i);
        adressDTO.setCep("00000000");
        adressDTO.setComplemento("Teste");
        adressDTO.setCidade("Teste");
        adressDTO.setEstado("Teste");
        adressDTO.setLogradouro("Teste");
        adressDTO.setNumero("123");

        return adressDTO;
    }


}
