--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-02-02 16:29:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16429)
-- Name: Administrador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Administrador" (
    "idAdministrador" integer NOT NULL,
    nombre text,
    apellido text,
    cedula integer
);


ALTER TABLE public."Administrador" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16409)
-- Name: Cajero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cajero" (
    "idCajero" integer NOT NULL,
    deposito integer,
    "maxRetiroDia" integer,
    ubicacion text
);


ALTER TABLE public."Cajero" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: Cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cliente" (
    "idCliente" integer NOT NULL,
    nombre text,
    apellido text,
    cedula integer
);


ALTER TABLE public."Cliente" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16491)
-- Name: Registro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Registro" (
    idregistro integer NOT NULL,
    fecha date,
    "montoRetirado" integer,
    "nitTarjetaCliente" integer,
    "idCajero" integer
);


ALTER TABLE public."Registro" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16489)
-- Name: Registro_idregistro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Registro_idregistro_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Registro_idregistro_seq" OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 201
-- Name: Registro_idregistro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Registro_idregistro_seq" OWNED BY public."Registro".idregistro;


--
-- TOC entry 200 (class 1259 OID 16434)
-- Name: TarjetaAdministrador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."TarjetaAdministrador" (
    "idTarjetaAdministrador" integer NOT NULL,
    "estadoTarjeta" boolean,
    "contraseña" integer,
    "idAdministrador" integer
);


ALTER TABLE public."TarjetaAdministrador" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16399)
-- Name: TarjetaCliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."TarjetaCliente" (
    "nitTarjetaCliente" integer NOT NULL,
    dinero integer,
    "estadoTarjeta" boolean,
    "contraseña" integer,
    "idCliente" integer
);


ALTER TABLE public."TarjetaCliente" OWNER TO postgres;

--
-- TOC entry 2693 (class 2604 OID 16494)
-- Name: Registro idregistro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Registro" ALTER COLUMN idregistro SET DEFAULT nextval('public."Registro_idregistro_seq"'::regclass);


--
-- TOC entry 2834 (class 0 OID 16429)
-- Dependencies: 199
-- Data for Name: Administrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Administrador" ("idAdministrador", nombre, apellido, cedula) FROM stdin;
1	Carlos Santiago	Rojas Moreno	1030681971
2	jeisson	rincon	1040251654
3	jorge	diaz	25145684
\.


--
-- TOC entry 2833 (class 0 OID 16409)
-- Dependencies: 198
-- Data for Name: Cajero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cajero" ("idCajero", deposito, "maxRetiroDia", ubicacion) FROM stdin;
2	100000000	3000000	C
1	60000000	2000000	D
\.


--
-- TOC entry 2831 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: Cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cliente" ("idCliente", nombre, apellido, cedula) FROM stdin;
1	pepito	perez	53355413
2	rosa	melano	5648175
3	elber	galarga	568492
\.


--
-- TOC entry 2837 (class 0 OID 16491)
-- Dependencies: 202
-- Data for Name: Registro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Registro" (idregistro, fecha, "montoRetirado", "nitTarjetaCliente", "idCajero") FROM stdin;
2	2008-12-31	200000	2020181	1
3	2008-12-31	200000	2020181	1
4	2008-12-31	1000000	2020181	1
\.


--
-- TOC entry 2835 (class 0 OID 16434)
-- Dependencies: 200
-- Data for Name: TarjetaAdministrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TarjetaAdministrador" ("idTarjetaAdministrador", "estadoTarjeta", "contraseña", "idAdministrador") FROM stdin;
102020078	t	78	2
102020405	t	405	3
102020095	t	95	1
\.


--
-- TOC entry 2832 (class 0 OID 16399)
-- Dependencies: 197
-- Data for Name: TarjetaCliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TarjetaCliente" ("nitTarjetaCliente", dinero, "estadoTarjeta", "contraseña", "idCliente") FROM stdin;
2020182	6000000	t	1234	1
2020184	18000000	t	4321	3
2020183	8000000	f	1234	2
2020181	20000000	f	1234	1
\.


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 201
-- Name: Registro_idregistro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Registro_idregistro_seq"', 4, true);


--
-- TOC entry 2701 (class 2606 OID 16433)
-- Name: Administrador Administrador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Administrador"
    ADD CONSTRAINT "Administrador_pkey" PRIMARY KEY ("idAdministrador");


--
-- TOC entry 2699 (class 2606 OID 16413)
-- Name: Cajero Cajero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cajero"
    ADD CONSTRAINT "Cajero_pkey" PRIMARY KEY ("idCajero");


--
-- TOC entry 2695 (class 2606 OID 16398)
-- Name: Cliente Cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("idCliente");


--
-- TOC entry 2705 (class 2606 OID 16496)
-- Name: Registro Registro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "Registro_pkey" PRIMARY KEY (idregistro);


--
-- TOC entry 2703 (class 2606 OID 16438)
-- Name: TarjetaAdministrador TarjetaAdministrador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "TarjetaAdministrador_pkey" PRIMARY KEY ("idTarjetaAdministrador");


--
-- TOC entry 2697 (class 2606 OID 16403)
-- Name: TarjetaCliente TarjetaCliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "TarjetaCliente_pkey" PRIMARY KEY ("nitTarjetaCliente");


--
-- TOC entry 2707 (class 2606 OID 16439)
-- Name: TarjetaAdministrador FK_idAdministrador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "FK_idAdministrador" FOREIGN KEY ("idAdministrador") REFERENCES public."Administrador"("idAdministrador");


--
-- TOC entry 2708 (class 2606 OID 16497)
-- Name: Registro FK_idCajero; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "FK_idCajero" FOREIGN KEY ("idCajero") REFERENCES public."Cajero"("idCajero");


--
-- TOC entry 2706 (class 2606 OID 16404)
-- Name: TarjetaCliente FK_idCliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "FK_idCliente" FOREIGN KEY ("idCliente") REFERENCES public."Cliente"("idCliente");


--
-- TOC entry 2709 (class 2606 OID 16502)
-- Name: Registro FK_nitTarjetaCliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "FK_nitTarjetaCliente" FOREIGN KEY ("nitTarjetaCliente") REFERENCES public."TarjetaCliente"("nitTarjetaCliente");


-- Completed on 2019-02-02 16:29:24

--
-- PostgreSQL database dump complete
--

