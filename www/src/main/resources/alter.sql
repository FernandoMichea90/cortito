-- Active: 1703204464405@@127.0.0.1@3306@cortito
ALTER TABLE short_url DROP COLUMN IF EXISTS short_url

-- urldisponibles:: disponible set default true 
ALTER TABLE url_disponible
ALTER COLUMN disponible SET DEFAULT true

-- urldiponibles:: cambiar a true los null
UPDATE url_disponible disponible
SET disponible = true
WHERE disponible IS NULL

