CREATE SCHEMA public AUTHORIZATION postgres;

CREATE TABLE public.authorities (
	username varchar(50) NOT NULL,
	authority varchar(50) NOT NULL
);
CREATE UNIQUE INDEX ix_auth_username ON public.authorities USING btree (username, authority);

ALTER TABLE public.authorities ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username);

CREATE TABLE public.colaborador (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	sobrenome varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT colaborador_pkey PRIMARY KEY (id)
);

ALTER TABLE public.colaborador ADD CONSTRAINT fksilr07pau0rnr2ukps7qvecer FOREIGN KEY (username) REFERENCES public.users(username);

CREATE TABLE public.registro_ponto (
	id_registro bigserial NOT NULL,
	hora_registro time NULL,
	user_username varchar(255) NULL,
	data_registro date NULL,
	tipo_registro varchar(255) NULL,
	CONSTRAINT registro_ponto_pkey PRIMARY KEY (id_registro)
);

ALTER TABLE public.registro_ponto ADD CONSTRAINT fkdrpqflpml2yd9bi0md2beqs0s FOREIGN KEY (user_username) REFERENCES public.users(username);

CREATE TABLE public.users (
	username varchar(50) NOT NULL,
	"password" varchar(500) NOT NULL,
	enabled bool NOT NULL,
	id int8 NULL,
	id_discord int8 NULL,
	CONSTRAINT users_pkey PRIMARY KEY (username)
);

INSERT INTO public.users
(username, "password", enabled, id, id_discord)
VALUES('test', '$2a$10$YPZL1WQB21LIZzH5cq/pW.9vMH28PMC/NZ9mDXB/loPlStQRfqFN2', true, NULL, NULL);
INSERT INTO public.users
(username, "password", enabled, id, id_discord)
VALUES('admin', '$2a$10$Qo4UKOgKqRW71ddGjS92fenHo74vTb9FD8n8MECT1N163nfctNNkq', true, NULL, NULL);

INSERT INTO public.authorities
(username, authority)
VALUES('test', 'ROLE_ADM');
INSERT INTO public.authorities
(username, authority)
VALUES('admin', 'ROLE_ADM');
