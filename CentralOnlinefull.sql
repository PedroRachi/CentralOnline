
create database if not exists CentralOnline;
use CentralOnline;

create table if not exists Empresa (
	id			int 		not null auto_increment unique,
	empresaCNPJ 			varchar(14) 	null,
    senhaAcesso				varchar(16)		null,
    razaoSocial 			varchar(100) 	null,
    logradouro 				varchar(50) 	null,
    cidade 					varchar(20) 	null,
    estado					varchar(2) 		null,
	cep 					int(10) 		null,
	telEmpresa 				varchar(15) 	null,
	contatoPrincipalNome 	varchar(30) 	null, 
	contatoPrincipalCPF 	varchar(14) 	null, 
	contatoPrincipalEmail 	varchar(50) 	null, 
    situacaoCadastral 		varchar(20)		null,
	site 					varchar(50),
	dataAbertura 			varchar(15),
    tipoPerfil              varchar(30) ,
	descriAtvEconomicas 	varchar(200),
    primary key(empresaCNPJ)
    );
    
    create table if not exists Cartorio (
    id			int 			not null auto_increment unique,
    cartorioCNPJ 			varchar(14) 	null,
	senhaAcesso				varchar(16)		null,
    numeroCartorio 			varchar(10) 	null,
    razaoSocial 			varchar(100) 	null,
	logradouro 				varchar(50) 	null,
	cidade 					varchar(20) 	null,
    estado 					varchar(2) 		null,
	cep 					int(10) 		null,
	tabeliaoNome			varchar(30) 	null,
    tabeliaoCPF 			varchar(14) 	null, 
	tabeliaoEmail	 		varchar(50) 	null, 
    substitutoNome 			varchar(30) 	null, 
	substitutoCPF 			varchar(14) 	null, 
	substitutoEmail 		varchar(50) 	null, 
    telCartorio 			varchar(15) 	null,
	tipoPerfil              varchar(30) ,
    situacaoCadastral 		varchar(20) 	null,
    site 					varchar(50),
    dataHoraFuncionamento 	varchar(15),
    primary key(cartorioCNPJ)
    );
    
   CREATE TABLE tipo_perfil (
  id int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
	
     insert into Tipo_Perfil (Descricao) values('Dono');
     insert into Tipo_Perfil  (Descricao) values('Usuario Principal');
	 insert into Tipo_Perfil  (Descricao) values('Coloaborador');
	 insert into Tipo_Perfil  (Descricao) values('Administrador');
     
     drop database CentralOnline;
     select * from tipo_perfil;
     
	CREATE TABLE usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nomeUsuario varchar(100) DEFAULT NULL,
  emailUsuario varchar(100) DEFAULT NULL,
  documentoCPF_CNPJ varchar(14) DEFAULT NULL,
  situacaoCadastral varchar(15) DEFAULT NULL,
  documentoEmpresa varchar(14) DEFAULT NULL,
  tipoCadastro varchar(50) DEFAULT NULL,
  idPerfil int(11) DEFAULT NULL,
  senha int(11) NOT NULL,
  
  PRIMARY KEY (id),
  KEY fk_idPerfil_idx (idPerfil),
  CONSTRAINT fk_tipoperfil FOREIGN KEY (idPerfil) REFERENCES tipo_perfil (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
 

create table precadastro(
id int auto_increment primary key,
documentoCpfCnpj varchar(14),
email varchar(200),
razao_social varchar(200),
tipoCadastro varchar(50),
situacao varchar(50)
);
  
    
    
    
    
		
   
    
	
