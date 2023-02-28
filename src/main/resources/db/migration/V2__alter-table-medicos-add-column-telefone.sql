alter TABLE medicos add COLUMN telefone varchar(20);
UPDATE medicos SET telefone = '' WHERE telefone IS NULL ;
ALTER TABLE medicos ALTER COLUMN telefone SET NOT NULL;