-- Table: public."Cliente"

-- DROP TABLE public."Cliente";

CREATE TABLE public."Cliente"
(
    "ID_CLIENTE" integer NOT NULL,
    "CPF" character(11) COLLATE pg_catalog."default" NOT NULL,
    "NOME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "CEP" character varying(8) COLLATE pg_catalog."default",
    "ENDERECO" character varying(255) COLLATE pg_catalog."default",
    "MUNICIPIO" character varying(255) COLLATE pg_catalog."default",
    "RG" character(7) COLLATE pg_catalog."default" NOT NULL,
    "UF" character(2) COLLATE pg_catalog."default",
    "VL_RENDA" numeric(10,2),
    CONSTRAINT "Cliente_pkey" PRIMARY KEY ("ID_CLIENTE")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Cliente"
    OWNER to postgres;
	
	
-- Table: public."Veiculo"

-- DROP TABLE public."Veiculo";

CREATE TABLE public."Veiculo"
(
    "ID_VEICULO" integer NOT NULL,
    "PLACA_VEICULO" character(7) COLLATE pg_catalog."default" NOT NULL,
    "MODELO" character varying(100) COLLATE pg_catalog."default",
    "MARCA" character varying(100) COLLATE pg_catalog."default",
    "COR" character varying(50) COLLATE pg_catalog."default",
    "CHASSIS" character varying(50) COLLATE pg_catalog."default",
    "RESTRICOES" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Veiculo_pkey" PRIMARY KEY ("ID_VEICULO")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Veiculo"
    OWNER to postgres;
	

-- Table: public."ContratoFinanciamento"

-- DROP TABLE public."ContratoFinanciamento";

CREATE TABLE public."ContratoFinanciamento"
(
    "ID_FINANCIAMENTO" integer NOT NULL,
    "NUM_FINANCIAMENTO" integer NOT NULL,
    "ID_CLIENTE" integer NOT NULL,
    "ID_VEICULO" integer NOT NULL,
    "VALOR_BEM" numeric(10,2),
    "VALOR_ENTRADA" numeric(10,2),
    "NUMERO_PARCELAS" integer,
    "DATA_APROVACAO" date,
    "DATA_QUITACAO" date,
    "TAXA_JUROS" numeric(5,2),
    CONSTRAINT "ContratoFinanciamento_pkey" PRIMARY KEY ("ID_FINANCIAMENTO"),
    CONSTRAINT "ID_CLIENTE" FOREIGN KEY ("ID_CLIENTE")
        REFERENCES public."Cliente" ("ID_CLIENTE") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "ID_VEICULO" FOREIGN KEY ("ID_VEICULO")
        REFERENCES public."Veiculo" ("ID_VEICULO") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."ContratoFinanciamento"
    OWNER to postgres;
	
	
-- Table: public."Usuario"

-- DROP TABLE public."Usuario";

CREATE TABLE public."Usuario"
(
    "ID_USUARIO" integer NOT NULL,
    "LOGIN" character varying(50) COLLATE pg_catalog."default",
    "NOME" character varying(100) COLLATE pg_catalog."default",
    "SEXO" character(1) COLLATE pg_catalog."default",
    "SENHA" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT "Usuario_pkey" PRIMARY KEY ("ID_USUARIO")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Usuario"
    OWNER to postgres;