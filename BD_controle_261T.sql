CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    estoque INTEGER DEFAULT 0,
    valor_venda NUMERIC(10,2) CHECK (valor_venda >= 0)
);
