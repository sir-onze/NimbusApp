INSERT INTO Funcionario VALUES ("onze","onze");
INSERT INTO Funcionario VALUES ("admin","admin");
INSERT INTO Funcionario VALUES ("fabrica","fabrica");

INSERT INTO Modelo VALUES ('Lestrange',10000,'Economico');
INSERT INTO Modelo VALUES ('Weasley',10000,'Familiar');
INSERT INTO Modelo VALUES ('Albus Severus',10000,'Gama Alta');
INSERT INTO Modelo VALUES ('Sirius',10000,' Gama Média');

INSERT INTO Pacote VALUES('Inside Tech',5000),('Inside Tech 1',10000),('Full Extras',15000);

INSERT INTO Componente VALUES('1.0 TDCI 85c',1,1000),('1.1 Ti-VCT 85c',1,2000),('1.5 ECOBOOST 100c',1,3000);

INSERT INTO ListaComponente VALUES('1.0 TDCI 85c',1);
INSERT INTO ListaComponente VALUES('Ti-VCT 85c',1);
SELECT * FROM Componente;

INSERT INTO Pacote (nome,preco) VALUES ('nice',10);
INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (0,null,1,0,1,1,0,1,0,1,0,1);
SELECT * FROM ListaComponente;



SELECT preco FROM Modelo ORDER BY preco DESC LIMIT 0, 1;

