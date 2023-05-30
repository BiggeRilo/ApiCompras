CREATE SEQUENCE comprasdb.usuario_id_seq;

CREATE TABLE comprasdb.usuarios (
                                    usuario_id BIGINT NOT NULL DEFAULT nextval('comprasdb.usuario_id_seq'),
                                    nome VARCHAR NOT NULL,
                                    sobrenome VARCHAR NOT NULL,
                                    email VARCHAR NOT NULL,
                                    telefone VARCHAR,
                                    celular VARCHAR,
                                    data_nascimento DATE NOT NULL,
                                    ativo BOOLEAN DEFAULT FALSE,
                                    data_criacao DATE NOT NULL,
                                    data_ultima_modificacao DATE NOT NULL,
                                    usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                    usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                    CONSTRAINT usuario_id PRIMARY KEY (usuario_id)
);


ALTER SEQUENCE comprasdb.usuario_id_seq OWNED BY comprasdb.usuarios.usuario_id;


CREATE SEQUENCE comprasdb.categoria_id_seq;

CREATE TABLE comprasdb.categoria (
                                     categoria_id BIGINT NOT NULL DEFAULT nextval('comprasdb.categoria_id_seq'),
                                     nome_categoria VARCHAR NOT NULL,
                                     descricao VARCHAR,
                                     codigo VARCHAR NOT NULL,
                                     ativo BOOLEAN DEFAULT FALSE,
                                     data_criacao DATE NOT NULL,
                                     data_ultima_modificacao DATE NOT NULL,
                                     usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                     usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                     CONSTRAINT categoria_id PRIMARY KEY (categoria_id)
);


ALTER SEQUENCE comprasdb.categoria_id_seq OWNED BY comprasdb.categoria.categoria_id;

CREATE SEQUENCE comprasdb.perfil_id_seq;

CREATE TABLE comprasdb.perfil (
                                  perfil_id BIGINT NOT NULL DEFAULT nextval('comprasdb.perfil_id_seq'),
                                  codigo VARCHAR NOT NULL,
                                  descricao VARCHAR,
                                  permissoes VARCHAR NOT NULL,
                                  ativo BOOLEAN DEFAULT FALSE,
                                  data_criacao DATE NOT NULL,
                                  data_ultima_modificacao DATE NOT NULL,
                                  usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                  usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                  CONSTRAINT perfil_id PRIMARY KEY (perfil_id)
);


ALTER SEQUENCE comprasdb.perfil_id_seq OWNED BY comprasdb.perfil.perfil_id;

CREATE SEQUENCE comprasdb.usuario_perfil_id_seq;

CREATE TABLE comprasdb.usuario_perfil (
                                          usuario_perfil_id BIGINT NOT NULL DEFAULT nextval('comprasdb.usuario_perfil_id_seq'),
                                          usuario_id BIGINT NOT NULL,
                                          perfil_id BIGINT NOT NULL,
                                          CONSTRAINT usuario_perfil_id PRIMARY KEY (usuario_perfil_id)
);


ALTER SEQUENCE comprasdb.usuario_perfil_id_seq OWNED BY comprasdb.usuario_perfil.usuario_perfil_id;

CREATE SEQUENCE comprasdb.paises_id_seq;

CREATE TABLE comprasdb.paises (
                                  pais_id BIGINT NOT NULL DEFAULT nextval('comprasdb.paises_id_seq'),
                                  iso VARCHAR(2) NOT NULL,
                                  iso3 VARCHAR(3) NOT NULL,
                                  tel_codigo INTEGER NOT NULL,
                                  num_codigo SMALLINT DEFAULT NULL,
                                  nome_maiusculo VARCHAR(80) NOT NULL,
                                  nome VARCHAR(80) NOT NULL,
                                  ativo BOOLEAN DEFAULT FALSE,
                                  data_criacao DATE NOT NULL,
                                  usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                  usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                  data_ultima_modificacao DATE NOT NULL,
                                  CONSTRAINT pais_id PRIMARY KEY (pais_id)
);


ALTER SEQUENCE comprasdb.paises_id_seq OWNED BY comprasdb.paises.pais_id;

CREATE SEQUENCE comprasdb.status_compra_id_seq;

CREATE TABLE comprasdb.status_compra (
                                         status_compra_id BIGINT NOT NULL DEFAULT nextval('comprasdb.status_compra_id_seq'),
                                         descricao VARCHAR,
                                         codigo VARCHAR NOT NULL,
                                         ativo BOOLEAN DEFAULT FALSE,
                                         data_criacao DATE NOT NULL,
                                         data_ultima_modificacao DATE NOT NULL,
                                         usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                         usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                         CONSTRAINT status_compra_id PRIMARY KEY (status_compra_id)
);


ALTER SEQUENCE comprasdb.status_compra_id_seq OWNED BY comprasdb.status_compra.status_compra_id;

CREATE SEQUENCE comprasdb.tipo_endereco_id_seq;

CREATE TABLE comprasdb.tipo_endereco (
                                         tipo_endereco_id BIGINT NOT NULL DEFAULT nextval('comprasdb.tipo_endereco_id_seq'),
                                         codigo VARCHAR NOT NULL,
                                         descricao VARCHAR,
                                         ativo BOOLEAN DEFAULT FALSE,
                                         data_criacao DATE NOT NULL,
                                         data_ultima_modificacao DATE NOT NULL,
                                         usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                         usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                         CONSTRAINT tipo_endereco_id PRIMARY KEY (tipo_endereco_id)
);


ALTER SEQUENCE comprasdb.tipo_endereco_id_seq OWNED BY comprasdb.tipo_endereco.tipo_endereco_id;

CREATE SEQUENCE comprasdb.tipo_cliente_id_seq;

CREATE TABLE comprasdb.tipo_cliente (
                                        tipo_cliente_id BIGINT NOT NULL DEFAULT nextval('comprasdb.tipo_cliente_id_seq'),
                                        descricao VARCHAR,
                                        codigo VARCHAR NOT NULL,
                                        ativo BOOLEAN DEFAULT FALSE,
                                        data_ultima_modificacao DATE NOT NULL,
                                        data_criacao DATE NOT NULL,
                                        usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                        usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                        CONSTRAINT tipo_cliente_id PRIMARY KEY (tipo_cliente_id)
);


ALTER SEQUENCE comprasdb.tipo_cliente_id_seq OWNED BY comprasdb.tipo_cliente.tipo_cliente_id;

CREATE SEQUENCE comprasdb.produto_id_seq;

CREATE TABLE comprasdb.produtos (
                                    produto_id BIGINT NOT NULL DEFAULT nextval('comprasdb.produto_id_seq'),
                                    descricao VARCHAR,
                                    descricao_curta VARCHAR,
                                    valor_unitario NUMERIC(10,2) NOT NULL,
                                    ativo BOOLEAN DEFAULT FALSE,
                                    data_criacao DATE NOT NULL,
                                    data_ultima_modificacao DATE NOT NULL,
                                    usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                    usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                    CONSTRAINT produto_id PRIMARY KEY (produto_id)
);


ALTER SEQUENCE comprasdb.produto_id_seq OWNED BY comprasdb.produtos.produto_id;

CREATE SEQUENCE comprasdb.categoria_produto_id_seq;

CREATE TABLE comprasdb.categoria_produto (
                                             categoria_produto_id BIGINT NOT NULL DEFAULT nextval('comprasdb.categoria_produto_id_seq'),
                                             categoria_id BIGINT NOT NULL,
                                             produto_id BIGINT NOT NULL,
                                             CONSTRAINT categoria_produto_id PRIMARY KEY (categoria_produto_id)
);


ALTER SEQUENCE comprasdb.categoria_produto_id_seq OWNED BY comprasdb.categoria_produto.categoria_produto_id;

CREATE SEQUENCE comprasdb.cliente_id_seq;

CREATE TABLE comprasdb.clientes (
                                    cliente_id BIGINT NOT NULL DEFAULT nextval('comprasdb.cliente_id_seq'),
                                    tipo_cliente_id BIGINT NOT NULL,
                                    email VARCHAR NOT NULL,
                                    telefone VARCHAR,
                                    celular VARCHAR,
                                    nome VARCHAR NOT NULL,
                                    sobrenome VARCHAR NOT NULL,
                                    data_nascimento DATE NOT NULL,
                                    rg VARCHAR,
                                    cnpj VARCHAR,
                                    cpf VARCHAR,
                                    ativo BOOLEAN DEFAULT FALSE,
                                    data_criacao DATE NOT NULL,
                                    data_ultima_modificacao DATE NOT NULL,
                                    usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                    usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                    CONSTRAINT cliente_id PRIMARY KEY (cliente_id)
);


ALTER SEQUENCE comprasdb.cliente_id_seq OWNED BY comprasdb.clientes.cliente_id;

CREATE SEQUENCE comprasdb.compra_id_seq;

CREATE TABLE comprasdb.compras (
                                   compra_id BIGINT NOT NULL DEFAULT nextval('comprasdb.compra_id_seq'),
                                   status_compra_id BIGINT NOT NULL,
                                   cliente_id BIGINT NOT NULL,
                                   valor_total NUMERIC(10,2) NOT NULL,
                                   data_abertura DATE NOT NULL,
                                   data_fechamento DATE ,
                                   ativo BOOLEAN DEFAULT FALSE,
                                   data_criacao DATE NOT NULL,
                                   data_ultima_modificacao DATE NOT NULL,
                                   usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                   usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                   CONSTRAINT compra_id PRIMARY KEY (compra_id)
);


ALTER SEQUENCE comprasdb.compra_id_seq OWNED BY comprasdb.compras.compra_id;

CREATE SEQUENCE comprasdb.item_compra_id_seq;


CREATE TABLE comprasdb.itemCompra (
                                      item_compra_id BIGINT NOT NULL DEFAULT nextval('comprasdb.item_compra_id_seq'),
                                      produto_id BIGINT NOT NULL,
                                      compra_id BIGINT NOT NULL,
                                      valorTotal NUMERIC(10,2) NOT NULL,
                                      valorProdutoUnitarioCriacao NUMERIC(10,2) NOT NULL,
                                      quantidadeProduto INTEGER NOT NULL,
                                      ativo BOOLEAN DEFAULT FALSE,
                                      data_criacao DATE NOT NULL,
                                      data_ultima_modificacao DATE NOT NULL,
                                      usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                      usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                      CONSTRAINT item_compra_id PRIMARY KEY (item_compra_id)
);


ALTER SEQUENCE comprasdb.item_compra_id_seq OWNED BY comprasdb.itemCompra.item_compra_id;



CREATE SEQUENCE comprasdb.cliente_endereco_id_seq;

CREATE TABLE comprasdb.endereco_cliente (
                                            endereco_id BIGINT NOT NULL DEFAULT nextval('comprasdb.cliente_endereco_id_seq'),
                                            cliente_id BIGINT NOT NULL,
                                            tipo_endereco_id BIGINT NOT NULL,
                                            pais_id BIGINT NOT NULL,
                                            cidade VARCHAR NOT NULL,
                                            cep VARCHAR NOT NULL,
                                            logradouro VARCHAR NOT NULL,
                                            complemento VARCHAR NOT NULL,
                                            estado VARCHAR NOT NULL,
                                            numero VARCHAR NOT NULL,
                                            ativo BOOLEAN DEFAULT FALSE,
                                            data_criacao DATE NOT NULL,
                                            data_ultima_modificacao DATE NOT NULL,
                                            usuario_criacao BIGINT REFERENCES usuarios(usuario_id),
                                            usuario_atualizacao BIGINT REFERENCES usuarios(usuario_id),
                                            CONSTRAINT endereco_id PRIMARY KEY (endereco_id)
);


ALTER SEQUENCE comprasdb.cliente_endereco_id_seq OWNED BY comprasdb.endereco_cliente.endereco_id;