-- Adicionando índice à coluna 'cpf' da tabela 'paciente' para melhorar as buscas
CREATE INDEX idx_paciente_cpf ON paciente (cpf);

-- Adicionando restrição de não nulo à coluna 'endereco' em 'paciente'
ALTER TABLE paciente MODIFY endereco BIGINT NOT NULL;