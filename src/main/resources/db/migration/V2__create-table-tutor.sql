create table tutor (
        id bigint NOT NULL AUTO_INCREMENT,
        ativo boolean,
        cpf VARCHAR(11) NOT NULL UNIQUE,
        email VARCHAR(50) NOT NULL UNIQUE,
        nome VARCHAR(100)NOT NULL,
        sexo VARCHAR(1),
        telefone VARCHAR(11) NOT NULL UNIQUE,
        bairro VARCHAR(255) NOT NULL,
        cep VARCHAR(8) NOT NULL,
        cidade VARCHAR(100) NOT NULL,
        complemento VARCHAR(100),
        logradouro VARCHAR(100) NOT NULL,
        numero VARCHAR(20) NOT NULL,
        uf VARCHAR(2) NOT NULL,
        primary key (id)
)