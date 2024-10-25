CREATE TABLE tb_endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cl_estado VARCHAR(255),
    cl_cidade VARCHAR(255),
    cl_rua VARCHAR(255),
    cl_numero INT,
    cl_cep VARCHAR(20)
);


CREATE TABLE paciente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco BIGINT,
    FOREIGN KEY (endereco) REFERENCES tb_endereco(id)
);


CREATE TABLE consulta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME NOT NULL,
    paciente_id BIGINT,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


