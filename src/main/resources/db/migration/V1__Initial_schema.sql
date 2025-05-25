CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    corporate_name VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    state_registration VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    barcode VARCHAR(100),
    purchase_price DECIMAL(10,2) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0,
    supplier_id INTEGER REFERENCES supplier(id)
);

CREATE TABLE invoicing (
    number VARCHAR(50) PRIMARY KEY,
    issue_date DATE NOT NULL,
    entry_date DATE NOT NULL,
    supplier_id INTEGER NOT NULL REFERENCES supplier(id)
);

CREATE TABLE invoicing_item (
    id SERIAL PRIMARY KEY,
    invoicing_number VARCHAR(50) NOT NULL REFERENCES invoicing(number),
    product_id INTEGER NOT NULL REFERENCES product(id),
    quantity INTEGER NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE account_payable (
    id SERIAL PRIMARY KEY,
    invoicing_number VARCHAR(50) NOT NULL UNIQUE REFERENCES invoicing(number),
    amount DECIMAL(10,2) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE user_account (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),
    district VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code VARCHAR(8) NOT NULL,
    user_id INTEGER NOT NULL REFERENCES user_account(id)
);

CREATE TABLE sale (
    id SERIAL PRIMARY KEY,
    number VARCHAR(50) NOT NULL UNIQUE,
    date TIMESTAMP NOT NULL,
    user_id INTEGER NOT NULL REFERENCES user_account(id),
    delivery_address_id INTEGER NOT NULL REFERENCES address(id),
    delivery_status VARCHAR(20) NOT NULL
);

CREATE TABLE sale_item (
    id SERIAL PRIMARY KEY,
    sale_id INTEGER NOT NULL REFERENCES sale(id),
    product_id INTEGER NOT NULL REFERENCES product(id),
    quantity INTEGER NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE payment (
    id SERIAL PRIMARY KEY,
    sale_id INTEGER NOT NULL REFERENCES sale(id),
    method VARCHAR(20) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    installments INTEGER NOT NULL DEFAULT 1,
    payment_data TEXT
);

CREATE TABLE account_receivable (
    id SERIAL PRIMARY KEY,
    sale_id INTEGER NOT NULL REFERENCES sale(id),
    amount DECIMAL(10,2) NOT NULL,
    due_date DATE NOT NULL,
    receipt_date DATE,
    installment INTEGER NOT NULL,
    total_installments INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE delivery_tracking (
    id SERIAL PRIMARY KEY,
    sale_id INTEGER NOT NULL UNIQUE REFERENCES sale(id),
    tracking_code VARCHAR(50) NOT NULL UNIQUE,
    delivery_attempts INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE delivery_event (
    id SERIAL PRIMARY KEY,
    tracking_id INTEGER NOT NULL REFERENCES delivery_tracking(id),
    date_time TIMESTAMP NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE user_roles (
    user_id INTEGER NOT NULL REFERENCES user_account(id),
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, role)
);
