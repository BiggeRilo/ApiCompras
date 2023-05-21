package atom.juice.apicompras.services;

import atom.juice.apicompras.mocker.ClienteMocker;
import atom.juice.apicompras.models.Cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ClienteServiceTest {

    final Cliente mockClient = ClienteMocker.mock();

    @Test
    void disable() {
        assertFalse(mockClient.isStatusDb());

        mockClient.setStatusDb(Boolean.TRUE);

        assertTrue(mockClient.isStatusDb());

    }
}