create table pet (
        id bigint primary key NOT NULL AUTO_INCREMENT,
        ativo boolean not null,
        idade integer not null,
        nome varchar(100) not null,
        peso float(53) not null,
        tipo varchar(50) check (tipo in ('CACHORRO','GATO','CANARIO','PORQUINHO_DA_INDIA','PEIXE','COELHO','FURAO','HAMSTER','PAPAGAIO','COBRA','IGUANA')),
        id_tutor bigint not null,
        foreign key(id_tutor) references tutor (id)
);