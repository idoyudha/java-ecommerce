DROP SCHEMA IF EXISTS "payment" CASCADE;

CREATE SCHEMA "payment";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS payment_status;
CREATE TYPE payment_status AS ENUM ('ONPROCESS', 'SUCCESS', 'FAILED');

DROP TYPE IF EXISTS payment_method;
CREATE TYPE payment_method AS ENUM ('DEBIT', 'CREDIT', 'CASH', 'QRIS');

DROP TABLE IF EXISTS "payment"."payments";

CREATE TABLE "payment"."payments" (
    "id" UUID NOT NULL,
    "reference_id" UUID UNIQUE NOT NULL,
    "payment_method" payment_method NOT NULL,
    "payment_status" payment_status NOT NULL,
    "failed_message" CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
    "amount" NUMERIC(10,2) NOT NULL,
    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT payments_pkey PRIMARY KEY ("id")
);

CREATE INDEX idx_payment_reference_id ON "payment"."payments" ("reference_id");