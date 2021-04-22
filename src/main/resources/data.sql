INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$00UvuDptCC9BYP5Np4OUFuKuave.wWsVRkI2GSw25O1k6saGSGHAq');
INSERT INTO usuario (email, nome, senha) VALUES ('professor@email.com', 'Professor', '$2a$10$00UvuDptCC9BYP5Np4OUFuKuave.wWsVRkI2GSw25O1k6saGSGHAq');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO perfil (nome) VALUES ('ROLE_ALUNO');
INSERT INTO perfil (nome) VALUES ('ROLE_MODERADOR');

INSERT INTO usuario_perfis VALUES (1,1);
INSERT INTO usuario_perfis VALUES (2,2);