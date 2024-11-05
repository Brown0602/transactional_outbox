CREATE TABLE orders(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   address VARCHAR(255) NOT NULL,
   payment_method VARCHAR(32) NOT NULL,
   comments VARCHAR(255) NOT NULL,
   user_email VARCHAR(255) NOT NULL,
   user_id INT NOT NULL,
   datetime TIMESTAMP NOT NULL
   );

CREATE TABLE users(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   first_name VARCHAR(64) NOT NULL,
   last_name VARCHAR(64) NOT NULL,
   email VARCHAR(255) NOT NULL
   );