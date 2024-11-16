DROP SCHEMA IF EXISTS "order" CASCADE;

CREATE SCHEMA "order";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS order_status;
CREATE TYPE order_status AS ENUM ('PENDING', 'PAID', 'FAILED');

DROP TABLE IF EXISTS "order"."orders";

CREATE TABLE "order"."orders" (
  "id" UUID NOT NULL,
  "user_id" UUID NOT NULL,
  "order_status" order_status NOT NULL,
  "payment_id" UUID UNIQUE,
  "total_price" NUMERIC(10,2) NOT NULL,
  "note" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
  CONSTRAINT orders_pkey PRIMARY KEY ("id")
);

CREATE INDEX idx_user_id ON "order"."orders" ("user_id");
CREATE INDEX idx_payment_reference_id ON "order"."orders" ("payment_id");

DROP TABLE IF EXISTS "order".order_items CASCADE;

CREATE TABLE "order".order_items (
  "id" UUID NOT NULL,
  "order_id" UUID UNIQUE NOT NULL,
  "product_id" UUID NOT NULL,
  "quantity" UUID NOT NULL,
  "price" NUMERIC(10,2) NOT NULL,
  "sub_total" NUMERIC(10,2) NOT NULL,
  CONSTRAINT order_items_pkey PRIMARY KEY (id, order_id)
);

ALTER TABLE "order".order_items
ADD CONSTRAINT "FK_ORDER_ID" FOREIGN KEY (order_id)
REFERENCES "order".orders (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE CASCADE
NOT VALID;

DROP TABLE IF EXISTS "order".order_address CASCADE;

CREATE TABLE "order".order_address (
  "id" UUID NOT NULL,
  "order_id" UUID UNIQUE NOT NULL,
  "address" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  "city" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  "state" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  "country" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  "zip_code" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT order_address_pkey PRIMARY KEY (id, order_id)
);

ALTER TABLE "order".order_address
ADD CONSTRAINT "FK_ORDER_ID" FOREIGN KEY (order_id)
REFERENCES "order".orders (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE CASCADE
NOT VALID;

