-- Table: public."Usuario"
-- Primeira carga na tabela usuarios:

INSERT INTO public."Usuario"(
	"ID_USUARIO", "LOGIN", "NOME", "SEXO", "SENHA")
	VALUES (1, 'admin', 'admin', 'M', '123');
	
-- Criação das SEQUENCES necessarias para o controle dos IDS:
-- SEQUENCE: public.clientes_id_seq

-- DROP SEQUENCE public.clientes_id_seq;

CREATE SEQUENCE public.clientes_id_seq;

ALTER SEQUENCE public.clientes_id_seq
    OWNER TO postgres;
	
-- SEQUENCE: public.veiculos_id_seq

-- DROP SEQUENCE public.veiculos_id_seq;

CREATE SEQUENCE public.veiculos_id_seq;

ALTER SEQUENCE public.veiculos_id_seq
    OWNER TO postgres;

-- SEQUENCE: public.financiamentos_id_seq

-- DROP SEQUENCE public.financiamentos_id_seq;

CREATE SEQUENCE public.financiamentos_id_seq;

ALTER SEQUENCE public.financiamentos_id_seq
    OWNER TO postgres;	