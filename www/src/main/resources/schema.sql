-- crear clase persona
CREATE TABLE
    persona (
        id BIGINT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(255) NOT NULL,
        apellido VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    );
-- crear usuario
CREATE TABLE
    usuario (
        id BIGINT NOT NULL AUTO_INCREMENT,
        usuario VARCHAR(255) NOT NULL,
        contrasena VARCHAR(255) NOT NULL,
        persona_id BIGINT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (persona_id) REFERENCES persona(id)
    );