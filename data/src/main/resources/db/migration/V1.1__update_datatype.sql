alter table transaction_category drop column type;
alter table transaction_category add column category_type varchar(255) constraint category_type_must_be_different unique;