ALTER TABLE t_cidade DROP CONSTRAINT FK_t_cidade_ID
ALTER TABLE t_pais DROP CONSTRAINT FK_t_pais_ID
DROP TABLE LIVRO
DROP TABLE PESSOA
DROP TABLE t_endereco
DROP TABLE t_cidade
DROP TABLE t_pais
DROP TABLE noticias
DROP TABLE T_Trilha_Musica
DROP TABLE T_Livros
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
