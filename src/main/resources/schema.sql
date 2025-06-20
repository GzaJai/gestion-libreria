-- ========================
-- SCHEMA: gestion-libreria (SQLite)
-- ========================

-- Tabla: client
DROP TABLE IF EXISTS client;
CREATE TABLE client (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    dni INTEGER UNIQUE,
    cuit INTEGER UNIQUE,
    cuil INTEGER UNIQUE,
    category TEXT,
    description TEXT,
    email TEXT UNIQUE,
    phone_number INTEGER UNIQUE
);

-- Tabla: quote
DROP TABLE IF EXISTS quote;
CREATE TABLE quote (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    quote_number INTEGER UNIQUE NOT NULL,
    total REAL,
    subtotal REAL,
    iva REAL,
    date TEXT,
    client_id INTEGER,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Tabla: product
DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    code INTEGER NOT NULL UNIQUE,
    name TEXT,
    description TEXT,
    purchase_price REAL,
    sell_price REAL,
    suggested_price REAL,
    category TEXT
);
