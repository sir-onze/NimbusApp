INSERT INTO Funcionario VALUES ("onze","onze");
INSERT INTO Funcionario VALUES ("admin","admin");
INSERT INTO Funcionario VALUES ("fabrica","fabrica");


INSERT INTO Modelo VALUES ('Lestrange(Modelo Económico)',10000,'Economico');
INSERT INTO Modelo VALUES ('Weasley(Modelo Família)',10000,'Familiar');
INSERT INTO Modelo VALUES ('Sirius(Modelo Gama Média)',10000,'Gama Alta');
INSERT INTO Modelo VALUES ('Albus Severus(Modelo Gama Alta)',10000,' Gama Média');

INSERT INTO PacoteInt VALUES('Pack Inside Tech(Básico)',5000),('Pack Inside Tech 1(Intermédio)',10000),('Pack Full Extras',15000);

INSERT  INTO PacoteExt VALUES ('Pack Outside Tech(Básico)',69);
INSERT  INTO PacoteExt VALUES ('Pack Outside Tech 1(Intermédio)',69);
INSERT  INTO PacoteExt VALUES ('Pack Full Extras',69);

INSERT INTO Componente VALUES(null,'1.0 TDCI 85c',1,1000,null),(null,'1.1 Ti-VCT 85c',1,2000,null),(null,'1.5 ECOBOOST 100c',1,3000,null);

INSERT INTO Componente VALUES('Pack Inside Tech(Básico)','Consola central c/ Ecrã LCD + GPS',1,100,null),('Pack Inside Tech(Básico)','Bancos Desportivos',0,200,null),
															('Pack Inside Tech 1(Intermédio)','Sistema de Som Pioneer',0,100,null),('Pack Inside Tech 1(Intermédio)','Luzes interior RGB',0,300,null);

INSERT INTO Componente VALUES(null,'Vidros fumados',0,100,'Pack Outside Tech(Básico)'),(null,'Suporte de bicicletas',0,200,'Pack Outside Tech(Básico)'),
															(null,'Escape CorsairGT',0,300,'Pack Outside Tech 1(Intermédio)'),(null,'Spoiler Sparco',0,400,'Pack Outside Tech 1(Intermédio)');

INSERT INTO ListaComponente VALUES('1.0 TDCI 85c',1);
INSERT INTO ListaComponente VALUES('Ti-VCT 85c',1);
SELECT * FROM Componente;

INSERT INTO Pacote (nome,preco) VALUES ('nice',10);
INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (0,null,1,0,1,1,0,1,0,1,0,1);
SELECT * FROM ListaComponente;

SELECT idEncomenda FROM Encomenda ORDER BY idEncomenda DESC LIMIT 0, 1;

SELECT * FROM PacoteInt ;

SELECT preco FROM Modelo ORDER BY preco DESC LIMIT 0, 1;

SELECT nome FROM PacoteExt WHERE preco <69 OR preco = 42 AND preco=12;

SELECT * FROM Componente ;