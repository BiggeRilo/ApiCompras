package atom.juice.apicompras.services;

import atom.juice.apicompras.mocks.MockCliente;
import atom.juice.apicompras.models.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ClienteServiceTest {

    static MockCliente inputObject;

    @BeforeAll
    static void init() {
        inputObject = new MockCliente();
    }

    @Test
    void disable() {
        Cliente entity = inputObject.mockEntity();
        Assertions.assertFalse(entity.isStatusDb());
        entity.setAtivo(Boolean.TRUE);
        Assertions.assertTrue(entity.isStatusDb());
    }
}