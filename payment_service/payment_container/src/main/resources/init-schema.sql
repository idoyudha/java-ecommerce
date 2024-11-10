DROP SCHEMA IF EXISTS "payment" CASCADE;

CREATE SCHEMA "payment";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS payment_status;
CREATE TYPE payment_status AS ENUM ('ONPROCESS', 'SUCCESS', 'FAILED');

DROP TYPE IF EXISTS payment_method;
CREATE TYPE payment_method AS ENUM ('DEBIT', 'CREDIT', 'CASH', 'QRIS');

DROP TABLE IF EXISTS "payment"."payment";

CREATE TABLE "payment"."payment" (
    "id" UUID NOT NULL,
    "reference_id" UUID NOT NULL,
    "payment_method" payment_method NOT NULL,
    "payment_status" payment_status NOT NULL,
    "failed_message" VARCHAR(255),
    "amount" DECIMAL NOT NULL,
    "created_at" TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY ("id")
);

CREATE INDEX idx_payment_reference_id ON "payment"."payment" ("reference_id");