CREATE SEQUENCE comprasdb.produtos_produto_id_seq;

CREATE TABLE comprasdb.Produtos (
                                    produto_id BIGINT NOT NULL DEFAULT nextval('comprasdb.produtos_produto_id_seq'),
                                    descricao VARCHAR NOT NULL,
                                    valor_unitario NUMERIC(10,2) NOT NULL,
                                    data_ultima_modificacao DATE NOT NULL,
                                    data_criacao DATE NOT NULL,
                                    status_db BOOLEAN DEFAULT FALSE,
                                    CONSTRAINT produto_id PRIMARY KEY (produto_id)
);


ALTER SEQUENCE comprasdb.produtos_produto_id_seq OWNED BY comprasdb.Produtos.produto_id;

CREATE SEQUENCE comprasdb.clientes_cliente_id_seq;

CREATE TABLE comprasdb.Clientes (
                                    cliente_id BIGINT NOT NULL DEFAULT nextval('comprasdb.clientes_cliente_id_seq'),
                                    nome VARCHAR NOT NULL,
                                    sobrenome VARCHAR NOT NULL,
                                    data_nascimento DATE NOT NULL,
                                    rg VARCHAR,
                                    cnpj VARCHAR,
                                    cpf VARCHAR,
                                    data_criacao DATE NOT NULL,
                                    data_ultima_modificacao DATE NOT NULL,
                                    status_db BOOLEAN DEFAULT FALSE,
                                    CONSTRAINT cliente_id PRIMARY KEY (cliente_id)
);


ALTER SEQUENCE comprasdb.clientes_cliente_id_seq OWNED BY comprasdb.Clientes.cliente_id;

CREATE SEQUENCE comprasdb.compras_compra_id_seq;

CREATE TABLE comprasdb.Compras (
                                   compra_id BIGINT NOT NULL DEFAULT nextval('comprasdb.compras_compra_id_seq'),
                                   valor_total NUMERIC(10,2) NOT NULL,
                                   data_abertura DATE NOT NULL,
                                   data_fechamento DATE,
                                   data_ultima_modificacao DATE NOT NULL,
                                   status_db BOOLEAN DEFAULT FALSE,
                                   data_criacao DATE NOT NULL,
                                   cliente_id BIGINT NOT NULL,
                                   CONSTRAINT compra_id PRIMARY KEY (compra_id)
);


ALTER SEQUENCE comprasdb.compras_compra_id_seq OWNED BY comprasdb.Compras.compra_id;

CREATE SEQUENCE comprasdb.itemcompra_item_compra_id_seq;

CREATE TABLE comprasdb.ItemCompra (
                                      item_compra_id BIGINT NOT NULL DEFAULT nextval('comprasdb.itemcompra_item_compra_id_seq'),
                                      produto_id BIGINT NOT NULL,
                                      compra_id BIGINT NOT NULL,
                                      valorTotal NUMERIC(10,2) NOT NULL,
                                      valorProdutoUnitarioCriacao NUMERIC(10,2) NOT NULL,
                                      quantidadeProduto INTEGER NOT NULL,
                                      data_ultima_modificacao DATE NOT NULL,
                                      data_criacao DATE NOT NULL,
                                      status_db BOOLEAN DEFAULT FALSE,
                                      CONSTRAINT item_compra_id PRIMARY KEY (item_compra_id)
);


ALTER SEQUENCE comprasdb.itemcompra_item_compra_id_seq OWNED BY comprasdb.ItemCompra.item_compra_id;

CREATE SEQUENCE comprasdb.endereco_cliente_endereco_id_seq;

CREATE TABLE comprasdb.Endereco_cliente (
                                            endereco_id BIGINT NOT NULL DEFAULT nextval('comprasdb.endereco_cliente_endereco_id_seq'),
                                            cidade VARCHAR NOT NULL,
                                            cliente_id BIGINT NOT NULL,
                                            cep VARCHAR NOT NULL,
                                            logradouro VARCHAR ,
                                            complemento VARCHAR ,
                                            estado VARCHAR NOT NULL,
                                            numero VARCHAR NOT NULL,
                                            data_criacao DATE NOT NULL,
                                            data_ultima_modificacao DATE NOT NULL,
                                            status_db BOOLEAN DEFAULT FALSE,
                                            CONSTRAINT endereco_id PRIMARY KEY (endereco_id)
);


ALTER SEQUENCE comprasdb.endereco_cliente_endereco_id_seq OWNED BY comprasdb.Endereco_cliente.endereco_id;

ALTER TABLE comprasdb.ItemCompra ADD CONSTRAINT produtos_itemcompra_fk
    FOREIGN KEY (produto_id)
        REFERENCES comprasdb.Produtos (produto_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.Endereco_cliente ADD CONSTRAINT clientes_endereco_fk
    FOREIGN KEY (cliente_id)
        REFERENCES comprasdb.Clientes (cliente_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.Compras ADD CONSTRAINT clientes_compras_fk
    FOREIGN KEY (cliente_id)
        REFERENCES comprasdb.Clientes (cliente_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE comprasdb.ItemCompra ADD CONSTRAINT compras_itemcompra_fk
    FOREIGN KEY (compra_id)
        REFERENCES comprasdb.Compras (compra_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;