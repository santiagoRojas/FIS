PGDMP     
                     w            Cajero    10.5    10.5 "               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393    Cajero    DATABASE     �   CREATE DATABASE "Cajero" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "Cajero";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16429    Administrador    TABLE     �   CREATE TABLE public."Administrador" (
    "idAdministrador" integer NOT NULL,
    nombre text,
    apellido text,
    cedula integer
);
 #   DROP TABLE public."Administrador";
       public         postgres    false    3            �            1259    16409    Cajero    TABLE     �   CREATE TABLE public."Cajero" (
    "idCajero" integer NOT NULL,
    deposito integer,
    "maxRetiroDia" integer,
    ubicacion text
);
    DROP TABLE public."Cajero";
       public         postgres    false    3            �            1259    16394    Cliente    TABLE     |   CREATE TABLE public."Cliente" (
    "idCliente" integer NOT NULL,
    nombre text,
    apellido text,
    cedula integer
);
    DROP TABLE public."Cliente";
       public         postgres    false    3            �            1259    16491    Registro    TABLE     �   CREATE TABLE public."Registro" (
    idregistro integer NOT NULL,
    fecha date,
    "montoRetirado" integer,
    "nitTarjetaCliente" integer,
    "idCajero" integer
);
    DROP TABLE public."Registro";
       public         postgres    false    3            �            1259    16489    Registro_idregistro_seq    SEQUENCE     �   CREATE SEQUENCE public."Registro_idregistro_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Registro_idregistro_seq";
       public       postgres    false    3    202                       0    0    Registro_idregistro_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Registro_idregistro_seq" OWNED BY public."Registro".idregistro;
            public       postgres    false    201            �            1259    16434    TarjetaAdministrador    TABLE     �   CREATE TABLE public."TarjetaAdministrador" (
    "idTarjetaAdministrador" integer NOT NULL,
    "estadoTarjeta" boolean,
    "contraseña" integer,
    "idAdministrador" integer
);
 *   DROP TABLE public."TarjetaAdministrador";
       public         postgres    false    3            �            1259    16399    TarjetaCliente    TABLE     �   CREATE TABLE public."TarjetaCliente" (
    "nitTarjetaCliente" integer NOT NULL,
    dinero integer,
    "estadoTarjeta" boolean,
    "contraseña" integer,
    "idCliente" integer
);
 $   DROP TABLE public."TarjetaCliente";
       public         postgres    false    3            �
           2604    16494    Registro idregistro    DEFAULT     ~   ALTER TABLE ONLY public."Registro" ALTER COLUMN idregistro SET DEFAULT nextval('public."Registro_idregistro_seq"'::regclass);
 D   ALTER TABLE public."Registro" ALTER COLUMN idregistro DROP DEFAULT;
       public       postgres    false    202    201    202                      0    16429    Administrador 
   TABLE DATA               V   COPY public."Administrador" ("idAdministrador", nombre, apellido, cedula) FROM stdin;
    public       postgres    false    199   &                 0    16409    Cajero 
   TABLE DATA               S   COPY public."Cajero" ("idCajero", deposito, "maxRetiroDia", ubicacion) FROM stdin;
    public       postgres    false    198   �&                 0    16394    Cliente 
   TABLE DATA               J   COPY public."Cliente" ("idCliente", nombre, apellido, cedula) FROM stdin;
    public       postgres    false    196   �&                 0    16491    Registro 
   TABLE DATA               i   COPY public."Registro" (idregistro, fecha, "montoRetirado", "nitTarjetaCliente", "idCajero") FROM stdin;
    public       postgres    false    202   '                 0    16434    TarjetaAdministrador 
   TABLE DATA               }   COPY public."TarjetaAdministrador" ("idTarjetaAdministrador", "estadoTarjeta", "contraseña", "idAdministrador") FROM stdin;
    public       postgres    false    200   N'                 0    16399    TarjetaCliente 
   TABLE DATA               t   COPY public."TarjetaCliente" ("nitTarjetaCliente", dinero, "estadoTarjeta", "contraseña", "idCliente") FROM stdin;
    public       postgres    false    197   �'                  0    0    Registro_idregistro_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Registro_idregistro_seq"', 4, true);
            public       postgres    false    201            �
           2606    16433     Administrador Administrador_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public."Administrador"
    ADD CONSTRAINT "Administrador_pkey" PRIMARY KEY ("idAdministrador");
 N   ALTER TABLE ONLY public."Administrador" DROP CONSTRAINT "Administrador_pkey";
       public         postgres    false    199            �
           2606    16413    Cajero Cajero_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Cajero"
    ADD CONSTRAINT "Cajero_pkey" PRIMARY KEY ("idCajero");
 @   ALTER TABLE ONLY public."Cajero" DROP CONSTRAINT "Cajero_pkey";
       public         postgres    false    198            �
           2606    16398    Cliente Cliente_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("idCliente");
 B   ALTER TABLE ONLY public."Cliente" DROP CONSTRAINT "Cliente_pkey";
       public         postgres    false    196            �
           2606    16496    Registro Registro_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "Registro_pkey" PRIMARY KEY (idregistro);
 D   ALTER TABLE ONLY public."Registro" DROP CONSTRAINT "Registro_pkey";
       public         postgres    false    202            �
           2606    16438 .   TarjetaAdministrador TarjetaAdministrador_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "TarjetaAdministrador_pkey" PRIMARY KEY ("idTarjetaAdministrador");
 \   ALTER TABLE ONLY public."TarjetaAdministrador" DROP CONSTRAINT "TarjetaAdministrador_pkey";
       public         postgres    false    200            �
           2606    16403 "   TarjetaCliente TarjetaCliente_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "TarjetaCliente_pkey" PRIMARY KEY ("nitTarjetaCliente");
 P   ALTER TABLE ONLY public."TarjetaCliente" DROP CONSTRAINT "TarjetaCliente_pkey";
       public         postgres    false    197            �
           2606    16439 '   TarjetaAdministrador FK_idAdministrador    FK CONSTRAINT     �   ALTER TABLE ONLY public."TarjetaAdministrador"
    ADD CONSTRAINT "FK_idAdministrador" FOREIGN KEY ("idAdministrador") REFERENCES public."Administrador"("idAdministrador");
 U   ALTER TABLE ONLY public."TarjetaAdministrador" DROP CONSTRAINT "FK_idAdministrador";
       public       postgres    false    199    2701    200            �
           2606    16497    Registro FK_idCajero    FK CONSTRAINT     �   ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "FK_idCajero" FOREIGN KEY ("idCajero") REFERENCES public."Cajero"("idCajero");
 B   ALTER TABLE ONLY public."Registro" DROP CONSTRAINT "FK_idCajero";
       public       postgres    false    202    198    2699            �
           2606    16404    TarjetaCliente FK_idCliente    FK CONSTRAINT     �   ALTER TABLE ONLY public."TarjetaCliente"
    ADD CONSTRAINT "FK_idCliente" FOREIGN KEY ("idCliente") REFERENCES public."Cliente"("idCliente");
 I   ALTER TABLE ONLY public."TarjetaCliente" DROP CONSTRAINT "FK_idCliente";
       public       postgres    false    196    197    2695            �
           2606    16502    Registro FK_nitTarjetaCliente    FK CONSTRAINT     �   ALTER TABLE ONLY public."Registro"
    ADD CONSTRAINT "FK_nitTarjetaCliente" FOREIGN KEY ("nitTarjetaCliente") REFERENCES public."TarjetaCliente"("nitTarjetaCliente");
 K   ALTER TABLE ONLY public."Registro" DROP CONSTRAINT "FK_nitTarjetaCliente";
       public       postgres    false    2697    202    197               a   x��;�  й=�'0��:;����(!Cp��2���\i���Mv�܆Mj(���3-��RkR��ruHY�yg�@�܉?�g��-�#"���         !   x�3�44�Nc(��e�i4��.\1z\\\ �n�         M   x��1
�0���0B�F�]\"�R��D'Oo�/`بo��}f��"�?�˚���6!���E�z��9푎��~��         0   x�3�420��54�561� HZrr�5A�54@������ �         /   x�340Bs�N a�e010
�Hc���%HHr��qqq (w	�         B   x�U�A
� C�ur�d�x��{�Ь><�p�W��C�
�f�OjZ�#��}����.$�;     