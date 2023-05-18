-- Tables

CREATE TABLE public.customer
(
    customer_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    contact_id bigint NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
    FOREIGN KEY (contact_id)
      REFERENCES contact (contact_id),
   FOREIGN KEY (order_id)
 	 REFERENCES order (order_id)
);

CREATE TABLE public.contact
(
    contact_id bigint NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    contact_id bigint NOT NULL,
    CONSTRAINT contact_pkey PRIMARY KEY (contact_id),
    FOREIGN KEY (customer_id)
      REFERENCES customer (customer)
);

CREATE TABLE public.order
(
    order_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    contact_id bigint NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
      REFERENCES order (customer_id),
   FOREIGN KEY (order_id)
 	 REFERENCES order(order_id)
);

CREATE TABLE public.product
(
    product_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    quantity bigint NOT character varying(255) COLLATE pg_catalog."default",,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
   FOREIGN KEY (order_id)
 	 REFERENCES order (order_id)
);

