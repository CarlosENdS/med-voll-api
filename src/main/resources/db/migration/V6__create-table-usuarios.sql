CREATE TABLE usuarios(
    
    id SERIAL,
    login varchar(100) NOT NULL,
    senha varchar(255) NOT NULL,

    PRIMARY KEY(id)
);