package atom.juice.apicompras.mocker;

import atom.juice.apicompras.models.Cliente;

import java.util.Date;

public class ClienteMocker {

    public static Cliente mock() {
        Cliente cli = new Cliente(1L, "Test", "Test", "000.000.000-00", "000.000.000.00", "000.000.000/00", new Date());
        return cli;
    }

}
