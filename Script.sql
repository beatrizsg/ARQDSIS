drop database RESTAURANTE;
create database RESTAURANTE;
use RESTAURANTE;

desc pedido;

create table PEDIDO (
numeroPedido int auto_increment,
numeroMesa int not null,
valorTotal double not null,
status varchar(50) not null,
dataEntrada VARCHAR(100),
prioridade int not null,
garcom varchar(100) not null,
dataSaida VARCHAR(500), 
cpf varchar(11) not null,
quantidade int not null,
primary key (numeroPedido)
);

select * from pedido;