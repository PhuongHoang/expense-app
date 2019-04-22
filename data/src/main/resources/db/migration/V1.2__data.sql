-- Insert some common transaction_category
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'salary');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'saving');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'grocery');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'drugs');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'fuel');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'internet');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'phone');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'insurance');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'mortgage');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'water payment');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'hydro payment');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'heating');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'shopping');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'dining');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'parking');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'other services');
insert into transaction_category (id, category_type)
values (uuid_generate_v4(), 'credit card payment');
--- Insert some common transaction_entity
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'food basics', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'produce depot', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'kowloon market', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'costco wholesale', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 't&t supermarket', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'wal-mart', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'wmt suprctr', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'metro', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'lim bangkok', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'phuoc loi', (select id from transaction_category where category_type = 'grocery'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'tim hortons', (select id from transaction_category where category_type = 'dining'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'subway', (select id from transaction_category where category_type = 'dining'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'chatime', (select id from transaction_category where category_type = 'dining'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'panda garden', (select id from transaction_category where category_type = 'dining'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), E'mcdonald\'s', (select id from transaction_category where category_type = 'dining'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'the home depot', (select id from transaction_category where category_type = 'shopping'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ikea ottawa', (select id from transaction_category where category_type = 'shopping'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ra-bayshore', (select id from transaction_category where category_type = 'shopping'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'toys ""r"" us', (select id from transaction_category where category_type = 'shopping'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'best buy', (select id from transaction_category where category_type = 'shopping'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'cheo foundation parkin', (select id from transaction_category where category_type = 'parking'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ottawa hospital - gene', (select id from transaction_category where category_type = 'parking'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'impark00110024u', (select id from transaction_category where category_type = 'parking'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'rexall pharmacy', (select id from transaction_category where category_type = 'drugs'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'interac e-trf', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'item returned nsf', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'nsf item fee', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ptb dep', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'e-trf autodeposit', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ont-govt-birth/other c', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'monthly fee', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'multiproduct rebate', (select id from transaction_category where category_type = 'other services'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'payment', (select id from transaction_category where category_type = 'credit card payment'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'capital one', (select id from transaction_category where category_type = 'credit card payment'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'costco gas', (select id from transaction_category where category_type = 'fuel'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'tsi internet', (select id from transaction_category where category_type = 'internet'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'videotron s.e.n.c.', (select id from transaction_category where category_type = 'phone'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'acms', (select id from transaction_category where category_type = 'salary'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'www trf dda', (select id from transaction_category where category_type = 'saving'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'mutual funds', (select id from transaction_category where category_type = 'saving'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'belair ins/ass.', (select id from transaction_category where category_type = 'insurance'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'mcap - rmg mtg', (select id from transaction_category where category_type = 'mortgage'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ott wtr & sewer', (select id from transaction_category where category_type = 'water payment'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'ottawa water', (select id from transaction_category where category_type = 'water payment'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'hydro ottawa', (select id from transaction_category where category_type = 'hydro payment'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'enbridge', (select id from transaction_category where category_type = 'heating'));
insert into transaction_entity (id, name, default_category_id) values (uuid_generate_v4(), 'enbridge gas', (select id from transaction_category where category_type = 'heating'));











