ALTER TABLE SESDB.product
    ADD CONSTRAINT product_discount_product_fk
        FOREIGN KEY (product_discount_id)
            REFERENCES SESDB.product_discount (product_discount_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order
    ADD CONSTRAINT cupom_order_fk
        FOREIGN KEY (cupom_id)
            REFERENCES SESDB.cupom (cupom_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.product
    ADD CONSTRAINT product_iventory_product_fk
        FOREIGN KEY (product_iventory)
            REFERENCES SESDB.product_iventory (product_iventory)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.product
    ADD CONSTRAINT product_category_product_fk
        FOREIGN KEY (product_category_id)
            REFERENCES SESDB.product_category (product_category_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order_payment_details
    ADD CONSTRAINT order_payment_status_order_payment_fk
        FOREIGN KEY (order_payment_status_id)
            REFERENCES SESDB.order_payment_status (order_payment_status_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order
    ADD CONSTRAINT order_status_order_fk
        FOREIGN KEY (order_status_id)
            REFERENCES SESDB.order_status (order_status_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order
    ADD CONSTRAINT order_payment_order_fk
        FOREIGN KEY (order_payment_details_id)
            REFERENCES SESDB.order_payment_details (order_payment_details_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.cart_item
    ADD CONSTRAINT product_cart_item_fk
        FOREIGN KEY (product_id)
            REFERENCES SESDB.product (product_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order_item
    ADD CONSTRAINT product_order_item_fk
        FOREIGN KEY (product_id)
            REFERENCES SESDB.product (product_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.address
    ADD CONSTRAINT adress_type_address_fk
        FOREIGN KEY (adress_type_id)
            REFERENCES SESDB.adress_type (adress_type_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.address
    ADD CONSTRAINT user_id_address_fk
        FOREIGN KEY (user_id)
            REFERENCES SESDB.user (user_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;



ALTER TABLE SESDB.address
    ADD CONSTRAINT country_address_fk
        FOREIGN KEY (country_id)
            REFERENCES SESDB.country (country_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.payment
    ADD CONSTRAINT payment_type_payment_fk
        FOREIGN KEY (payment_type_id)
            REFERENCES SESDB.payment_type (payment_type_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.user_payment
    ADD CONSTRAINT payment_user_payment_fk
        FOREIGN KEY (payment_id)
            REFERENCES SESDB.payment (payment_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;



ALTER TABLE SESDB.shopping_session
    ADD CONSTRAINT user_shopping_session_fk
        FOREIGN KEY (user_id)
            REFERENCES SESDB.user (user_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.user_payment
    ADD CONSTRAINT user_user_payment_fk
        FOREIGN KEY (user_id)
            REFERENCES SESDB.user (user_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;


ALTER TABLE SESDB.order
    ADD CONSTRAINT user_order_fk
        FOREIGN KEY (user_id)
            REFERENCES SESDB.user (user_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.order_item
    ADD CONSTRAINT order_order_item_fk
        FOREIGN KEY (order_id)
            REFERENCES SESDB.order (order_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE SESDB.cart_item
    ADD CONSTRAINT shopping_session_cart_item_fk
        FOREIGN KEY (shopping_session_id)
            REFERENCES SESDB.shopping_session (shopping_session_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;


ALTER TABLE SESDB.user_roles ADD CONSTRAINT user_user_roles_fk
    FOREIGN KEY (user_id)
        REFERENCES SESDB.user (user_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE SESDB.user_roles ADD CONSTRAINT roles_user_roles_fk
    FOREIGN KEY (roles_id)
        REFERENCES SESDB.roles (roles_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;
