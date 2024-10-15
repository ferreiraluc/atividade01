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
