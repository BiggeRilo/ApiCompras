CREATE TABLE SESDB.product_discount
(
    product_discount_id SERIAL               NOT NULL,
    description         VARCHAR(255)         NOT NULL,
    code                VARCHAR(50)          NOT NULL,
    discount            NUMERIC(10, 2)       NOT NULL,
    active              BOOLEAN DEFAULT TRUE NOT NULL,
    updated_at          TIMESTAMPTZ          NOT NULL,
    created_at          TIMESTAMPTZ          NOT NULL,
    CONSTRAINT product_discount_id PRIMARY KEY (product_discount_id)
);


CREATE TABLE SESDB.cupom
(
    cupom_id    SERIAL               NOT NULL,
    code        VARCHAR(50)          NOT NULL,
    description VARCHAR(255)         NOT NULL,
    discount    NUMERIC(10, 2)       NOT NULL,
    created_at  TIMESTAMPTZ          NOT NULL,
    active      BOOLEAN DEFAULT TRUE NOT NULL,
    updated_at  TIMESTAMPTZ          NOT NULL,
    CONSTRAINT cupom_id PRIMARY KEY (cupom_id)
);


CREATE TABLE SESDB.product_iventory
(
    product_iventory BIGSERIAL            NOT NULL,
    quantity         INTEGER              NOT NULL,
    created_at       TIMESTAMPTZ          NOT NULL,
    active           BOOLEAN DEFAULT TRUE NOT NULL,
    updated_at       TIMESTAMPTZ          NOT NULL,
    CONSTRAINT product_iventory_id PRIMARY KEY (product_iventory)
);


CREATE TABLE SESDB.product_category
(
    product_category_id BIGSERIAL            NOT NULL,
    created_at          TIMESTAMPTZ          NOT NULL,
    active              BOOLEAN DEFAULT TRUE NOT NULL,
    updated_at          TIMESTAMPTZ          NOT NULL,
    CONSTRAINT product_category_id PRIMARY KEY (product_category_id)
);


CREATE TABLE SESDB.order_payment_status
(
    order_payment_status_id SERIAL               NOT NULL,
    code                    VARCHAR(50)          NOT NULL,
    active                  BOOLEAN DEFAULT TRUE NOT NULL,
    created_at              TIMESTAMPTZ          NOT NULL,
    description             VARCHAR(255)         NOT NULL,
    updated_at              TIMESTAMPTZ          NOT NULL,
    CONSTRAINT order_payment_status_id PRIMARY KEY (order_payment_status_id)
);


CREATE TABLE SESDB.order_status
(
    order_status_id SERIAL               NOT NULL,
    description     VARCHAR(255)         NOT NULL,
    code            VARCHAR(50)          NOT NULL,
    created_at      TIMESTAMPTZ          NOT NULL,
    updated_at      TIMESTAMPTZ          NOT NULL,
    active          BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT order_status_id PRIMARY KEY (order_status_id)
);


CREATE TABLE SESDB.order_payment_details
(
    order_payment_details_id BIGSERIAL            NOT NULL,
    code                     VARCHAR(50)          NOT NULL,
    provider                 VARCHAR(255)         NOT NULL,
    amount                   INTEGER              NOT NULL,
    order_payment_status_id  BIGINT               NOT NULL,
    active                   BOOLEAN DEFAULT TRUE NOT NULL,
    created_at               TIMESTAMPTZ          NOT NULL,
    description              VARCHAR(255)         NOT NULL,
    updated_at               TIMESTAMPTZ          NOT NULL,
    CONSTRAINT order_payment_id PRIMARY KEY (order_payment_details_id)
);


CREATE TABLE SESDB.product
(
    product_id          BIGSERIAL            NOT NULL,
    product_category_id BIGINT               NOT NULL,
    product_iventory    BIGINT               NOT NULL,
    product_discount_id BIGINT               NOT NULL,
    SKU                 VARCHAR(50)          NOT NULL,
    code                VARCHAR(50)          NOT NULL,
    name                VARCHAR(255)         NOT NULL,
    description         VARCHAR(255)         NOT NULL,
    price               NUMERIC(10, 2)       NOT NULL,
    created_at          TIMESTAMPTZ          NOT NULL,
    updated_at          TIMESTAMPTZ          NOT NULL,
    active              BOOLEAN DEFAULT TRUE NOT NULL,
    deleted_at          TIMESTAMPTZ,
    CONSTRAINT product_id PRIMARY KEY (product_id)
);


CREATE TABLE SESDB.adress_type
(
    adress_type_id SERIAL               NOT NULL,
    code           VARCHAR(50)          NOT NULL,
    active         BOOLEAN DEFAULT TRUE NOT NULL,
    created_at     TIMESTAMPTZ          NOT NULL,
    description    VARCHAR(255)         NOT NULL,
    updated_at     TIMESTAMPTZ          NOT NULL,
    CONSTRAINT adress_type_id PRIMARY KEY (adress_type_id)
);


CREATE TABLE SESDB.country
(
    country_id   SERIAL       NOT NULL,
    country_name VARCHAR(255) NOT NULL,
    iso          VARCHAR(2)   NOT NULL,
    iso3         VARCHAR(3)   NOT NULL,
    CONSTRAINT country_id PRIMARY KEY (country_id)
);


CREATE TABLE SESDB.payment_type
(
    payment_type_id SERIAL               NOT NULL,
    description     VARCHAR(255)         NOT NULL,
    code            VARCHAR(50)          NOT NULL,
    updated_at      TIMESTAMPTZ          NOT NULL,
    created_at      TIMESTAMPTZ          NOT NULL,
    active          BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT payment_type_id PRIMARY KEY (payment_type_id)
);


CREATE TABLE SESDB.payment
(
    payment_id      SERIAL               NOT NULL,
    payment_type_id BIGINT               NOT NULL,
    description     VARCHAR(255)         NOT NULL,
    expiration_date DATE                 NOT NULL,
    provider        VARCHAR(255)         NOT NULL,
    account_number  INTEGER              NOT NULL,
    created_at      TIMESTAMPTZ          NOT NULL,
    updated_at      TIMESTAMPTZ          NOT NULL,
    active          BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT payment_id PRIMARY KEY (payment_id)
);


CREATE TABLE SESDB.address
(
    address_id     BIGSERIAL            NOT NULL,
    user_id        BIGINT               NOT NULL,
    adress_type_id BIGINT               NOT NULL,
    country_id     BIGINT               NOT NULL,
    phone_number   VARCHAR(15),
    city           VARCHAR(255)         NOT NULL,
    state          VARCHAR(255)         NOT NULL,
    street         VARCHAR(255)         NOT NULL,
    zipcode        VARCHAR(255)         NOT NULL,
    updated_at     TIMESTAMPTZ          NOT NULL,
    created_at     TIMESTAMPTZ          NOT NULL,
    active         BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT adress_id PRIMARY KEY (address_id)
);


CREATE TABLE SESDB.user
(
    user_id         BIGSERIAL            NOT NULL,
    first_name      VARCHAR(50)          NOT NULL,
    last_name       VARCHAR(50)          NOT NULL,
    phone_number    VARCHAR(15)          NOT NULL,
    celphone_number VARCHAR(15)          NOT NULL,
    updated_at      TIMESTAMPTZ          NOT NULL,
    created_at      TIMESTAMPTZ          NOT NULL,
    active          BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT user_id PRIMARY KEY (user_id)
);


CREATE TABLE SESDB.order
(
    order_id                 BIGSERIAL            NOT NULL,
    cupom_id                 INTEGER              NOT NULL,
    user_id                  BIGINT               NOT NULL,
    order_payment_details_id BIGINT               NOT NULL,
    order_status_id          INTEGER              NOT NULL,
    total                    NUMERIC(10, 2)       NOT NULL,
    updated_at               TIMESTAMPTZ          NOT NULL,
    created_at               TIMESTAMPTZ          NOT NULL,
    active                   BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT order_id PRIMARY KEY (order_id)
);


CREATE TABLE SESDB.order_item
(
    order_item_id BIGINT               NOT NULL,
    product_id    BIGINT               NOT NULL,
    order_id      BIGINT               NOT NULL,
    quantity      INTEGER              NOT NULL,
    created_at    TIMESTAMPTZ          NOT NULL,
    updated_at    TIMESTAMPTZ          NOT NULL,
    active        BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT order_item_id PRIMARY KEY (order_item_id)
);


CREATE TABLE SESDB.user_payment
(
    payment_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    CONSTRAINT user_payment_id PRIMARY KEY (payment_id, user_id)
);


CREATE TABLE SESDB.shopping_session
(
    shopping_session_id BIGSERIAL            NOT NULL,
    user_id             BIGINT               NOT NULL,
    total               NUMERIC(15, 2)       NOT NULL,
    created_at          TIMESTAMPTZ          NOT NULL,
    updated_at          TIMESTAMPTZ          NOT NULL,
    active              BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT shopping_session_id PRIMARY KEY (shopping_session_id)
);


CREATE TABLE SESDB.cart_item
(
    cart_item_id        BIGINT               NOT NULL,
    shopping_session_id BIGINT               NOT NULL,
    product_id          BIGINT               NOT NULL,
    quantity            INTEGER              NOT NULL,
    updated_at          TIMESTAMPTZ          NOT NULL,
    created_at          TIMESTAMPTZ          NOT NULL,
    active              BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT cart_item_id PRIMARY KEY (cart_item_id)
);


CREATE TABLE SESDB.roles
(
    roles_id    SERIAL               NOT NULL,
    code        VARCHAR(50)          NOT NULL,
    active      BOOLEAN DEFAULT TRUE NOT NULL,
    created_at  TIMESTAMP            NOT NULL,
    description VARCHAR(255)         NOT NULL,
    updated_at  TIMESTAMPTZ          NOT NULL,
    CONSTRAINT roles_id PRIMARY KEY (roles_id)
);


CREATE TABLE SESDB.user_roles
(
    roles_id BIGINT NOT NULL,
    user_id  BIGINT NOT NULL,
    CONSTRAINT user_roles_id PRIMARY KEY (roles_id, user_id)
);
