insert into usuario (nome,tipo_usuario,email) values ('lucas', 'ADM', 'lucas@gmail.com');
insert into usuario (nome,tipo_usuario,email) values ('marcella', 'ADM', 'marcella@gmail.com');

INSERT INTO STATUS_MOTO (DESCRICAO) VALUES ('Disponível');
INSERT INTO STATUS_MOTO (DESCRICAO) VALUES ('Em manutenção');
INSERT INTO STATUS_MOTO (DESCRICAO) VALUES ('Roubada');

INSERT INTO PATIO (NOME, CIDADE, LAYOUT) VALUES ('Pátio Central', 'São Paulo', 'layout exemplo 1');
INSERT INTO PATIO (NOME, CIDADE, LAYOUT) VALUES ('Pátio Norte', 'Campinas', 'layout exemplo 2');

INSERT INTO MOTO (PLACA, MODELO, ID_PATIO, ID_STATUS, POS_X, POS_Y) VALUES ('ABC1D23', 'Honda CG 160', 1, 1, 10.5, 20.3);
INSERT INTO MOTO (PLACA, MODELO, ID_PATIO, ID_STATUS, POS_X, POS_Y) VALUES ('DEF4G56', 'Yamaha Fazer 250', 1, 2, 12.1, 18.7);
INSERT INTO MOTO (PLACA, MODELO, ID_PATIO, ID_STATUS, POS_X, POS_Y) VALUES ('GHI7J89', 'Suzuki GSR 150', 2, 1, 8.3, 22.5);

INSERT INTO SENSOR (ID_MOTO, TEMPERATURA, LIGADA) VALUES (1, 35.7, 'S');
INSERT INTO SENSOR (ID_MOTO, TEMPERATURA, LIGADA) VALUES (2, 30.2, 'N');

