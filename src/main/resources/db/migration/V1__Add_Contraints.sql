ALTER TABLE comprasdb.categoria_produto ADD CONSTRAINT categoria_categoria_produto_fk
    FOREIGN KEY (categoria_id)
        REFERENCES comprasdb.categoria (categoria_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.usuario_perfil ADD CONSTRAINT tipo_perfil_usuario_tipo_fk
    FOREIGN KEY (perfil_id)
        REFERENCES comprasdb.perfil (perfil_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.usuario_perfil ADD CONSTRAINT usuarios_usuario_tipo_fk
    FOREIGN KEY (usuario_id)
        REFERENCES comprasdb.usuarios (usuario_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.endereco_cliente ADD CONSTRAINT paises_endereco_cliente_fk
    FOREIGN KEY (pais_id)
        REFERENCES comprasdb.paises (pais_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.compras ADD CONSTRAINT status_compra_compras_fk
    FOREIGN KEY (status_compra_id)
        REFERENCES comprasdb.status_compra (status_compra_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.endereco_cliente ADD CONSTRAINT tipo_endereco_endereco_cliente_fk
    FOREIGN KEY (tipo_endereco_id)
        REFERENCES comprasdb.tipo_endereco (tipo_endereco_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.clientes ADD CONSTRAINT tipo_cliente_clientes_fk
    FOREIGN KEY (tipo_cliente_id)
        REFERENCES comprasdb.tipo_cliente (tipo_cliente_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.itemCompra ADD CONSTRAINT produtos_itemcompra_fk
    FOREIGN KEY (produto_id)
        REFERENCES comprasdb.produtos (produto_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.categoria_produto ADD CONSTRAINT produtos_categoria_produto_fk
    FOREIGN KEY (produto_id)
        REFERENCES comprasdb.produtos (produto_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.endereco_cliente ADD CONSTRAINT clientes_endereco_fk
    FOREIGN KEY (cliente_id)
        REFERENCES comprasdb.clientes (cliente_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.compras ADD CONSTRAINT clientes_compras_fk
    FOREIGN KEY (cliente_id)
        REFERENCES comprasdb.clientes (cliente_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.itemCompra ADD CONSTRAINT compras_itemcompra_fk
    FOREIGN KEY (compra_id)
        REFERENCES comprasdb.compras (compra_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;