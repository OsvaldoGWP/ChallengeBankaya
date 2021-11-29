CREATE TABLE request_history
(

    id           int8           NOT NULL GENERATED ALWAYS AS IDENTITY,
    method       varchar(100)   NULL,
    source_ip    varchar(50)    NULL,
    request_date timestamptz(0) NOT NULL,
    successful   bool           NOT NULL,
    request      text           NULL,

    CONSTRAINT request_history_pk PRIMARY KEY (id)
);