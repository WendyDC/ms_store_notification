CREATE TABLE IF NOT EXISTS product (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DOUBLE PRECISION NOT NULL,
    type INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS customer (
    id INTEGER PRIMARY KEY,
    id_type VARCHAR(2) NOT NULL,
    id_number VARCHAR(20) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(20) NOT NULL,
    type INTEGER NOT NULL
);

INSERT INTO product (id, name, description, price, type)
VALUES (1, 'Portavaso pokemon', 'Porcelana, color variado, anime, set 4 unidades', 25000, 1);

INSERT INTO customer (id, id_type, id_number, full_name, email, type)
VALUES (1, 'CC', '1090000000', 'nombre test apellido test', 'email@email.com', 1);