CREATE TABLE PRODUCT(
    ID SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR(200),
    CATEGORY VARCHAR(200),
    PRICE NUMERIC,
    QUANTITY INT,
    DESCRIPTION VARACHAR(200)
)