--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-14 16:25:50

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
-- TOC entry 2838 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 16429)
-- Name: Administrador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Administrador" (
    "idAdministrador" integer NOT NULL,
    nombre "text",
    apellido "text",
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
    ubicacion "text"
);


ALTER TABLE public."Cajero" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: Cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cliente" (
    "idCliente" integer NOT NULL,
    nombre "text",
    apellido "text",
    cedula integer
);


ALTER TABLE public."Cliente" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16414)
-- Name: HistorialRegistro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."HistorialRegistro" (
    "idHistorialRegistro" integer NOT NULL,
    fecha date,
    "montoRetirado" integer,
    "nitTarjetaCliente" integer,
    "idCajero" integer
);


ALTER TABLE public."HistorialRegistro" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16434)
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
-- TOC entry 2829 (class 0 OID 16429)
-- Dependencies: 200
-- Data for Name: Administrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Administrador" ("idAdministrador", nombre, apellido, cedula) FROM stdin;
1	CarlosSantiago	RojasMoreno	1030681971
2	jeisson	Rincon	1040251654
3	jorge	Dias	25145684
\.


--
-- TOC entry 2827 (class 0 OID 16409)
-- Dependencies: 198
-- Data for Name: Cajero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cajero" ("idCajero", deposito, "maxRetiroDia", ubicacion) FROM stdin;
1	50000000	2000000	Dg42a#81
2	100000000	3000000	Carr82#13
\.


--
-- TOC entry 2825 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: Cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cliente" ("idCliente", nombre, apellido, cedula) FROM stdin;
1	pepito	perez	53355413
2	juanito	sanchez	5648175
3	elber	galarga	568492
\.


--
-- TOC entry 2828 (class 0 OID 16414)
-- Dependencies: 199
-- Data for Name: HistorialRegistro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."HistorialRegistro" ("idHistorialRegistro", fecha, "montoRetirado", "nitTarjetaCliente", "idCajero") FROM stdin;
\.


--
-- TOC entry 2830 (class 0 OID 16434)
-- Dependencies: 201
-- Data for Name: TarjetaAdministrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TarjetaAdministrador" ("idTarjetaAdministrador", "estadoTarjeta", "contraseña", "idAdministrador") FROM stdin;
102020095	t	0095	1
102020078	t	0078	2
102020405	t	0405	3
\.


--
-- TOC entry 2826 (class 0 OID 16399)
-- Dependencies: 197
-- Data for Name: TarjetaCliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TarjetaCliente" ("nitTarjetaCliente", dinero, "estadoTarjeta", "contraseña", "idCliente") FROM stdin;
202020182	6000000	t	1234	1
202020183	8000000	f	1234	2
202020184	18000000	t	4321	3
202020181	20000000	t	1234	1
\.


--
-- TOC entry 2697 (class 2606 OID 16433)
-- Name: Administrador Administrador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Administrador"
    ADD CONSTRAINT "Administrador_pkey" PRIMARY KEY ("idAdministrador");


--
-- TOC entry 2693 (class 2606 OID 16413)
-- Name: Cajero Cajero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cajero"
    ADD CONSTRAINT "Cajero_pkey" PRIMARY KEY ("idCajero");


--
-- TOC entry 2689 (class 2606 OID 16398)
-- Name: Cliente Cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("idCliente");


--
-- TOC entry 2695 (class 2606 OID 16418)
-- Name: HistorialRegistro HistorialRegistro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."HistorialRegistro"
    ADD CONSTRAINT "HistorialRegistro_pkey" PRIMARY KEY ("idHistorialRegistro");


--
-- TOC entry 2699 (class 2606 OID 16438)
-- Name: TarjetaAdministrador TarjetaAdministrador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "TarjetaAdministrador_pkey" PRIMARY KEY ("idTarjetaAdministrador");


--
-- TOC entry 2691 (class 2606 OID 16403)
-- Name: TarjetaCliente TarjetaCliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "TarjetaCliente_pkey" PRIMARY KEY ("nitTarjetaCliente");


--
-- TOC entry 2703 (class 2606 OID 16439)
-- Name: TarjetaAdministrador FK_idAdministrador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "FK_idAdministrador" FOREIGN KEY ("idAdministrador") REFERENCES public."Administrador"("idAdministrador");


--
-- TOC entry 2702 (class 2606 OID 16424)
-- Name: HistorialRegistro FK_idCajero; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."HistorialRegistro"
    ADD CONSTRAINT "FK_idCajero" FOREIGN KEY ("idCajero") REFERENCES public."Cajero"("idCajero");


--
-- TOC entry 2700 (class 2606 OID 16404)
-- Name: TarjetaCliente FK_idCliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "FK_idCliente" FOREIGN KEY ("idCliente") REFERENCES public."Cliente"("idCliente");


--
-- TOC entry 2701 (class 2606 OID 16419)
-- Name: HistorialRegistro FK_nitTarjetaCliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."HistorialRegistro"
    ADD CONSTRAINT "FK_nitTarjetaCliente" FOREIGN KEY ("nitTarjetaCliente") REFERENCES public."TarjetaCliente"("nitTarjetaCliente");


-- Completed on 2018-10-14 16:25:50

--
-- PostgreSQL database dump complete
--

