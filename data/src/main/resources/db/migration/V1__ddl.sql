create table transaction_category
(
    id UUID primary key,
    type integer,
    parent_category_id UUID constraint transaction_category_foreign_key
            references transaction_category(id)
);

alter table transaction_category owner to springboot;

create table transaction_entity
(
    id UUID  primary key,
    name varchar(255) not null,
    default_category_id UUID constraint transaction_entity_foreign_key
            references transaction_category(id)
);

alter table transaction_entity owner to springboot;

create table transaction
(
    id UUID primary key,
    amount double precision not null,
    transaction_date date,
    recipient_id UUID constraint transaction_foreign_key_transaction_entity
            references transaction_entity(id),
    account_number varchar(255),
    category_id UUID
        constraint transaction_foreign_key_transaction_category
            references transaction_category(id)
);

alter table transaction owner to springboot;

