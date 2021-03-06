drop table reservation if exists;

				drop table schedule if exists;

				drop table schedule_reservations if exists;

				drop table tennis_court if exists;

				create table guest (
					   id bigint generated by default as identity,
						date_create timestamp,
						date_update timestamp,
						ip_number_create varchar(255),
						ip_number_update varchar(255),
						user_create bigint,
						user_update bigint,
						name varchar(255) not null,
						primary key (id)
					);
					
				create table reservation (
					   id bigint generated by default as identity,
						date_create timestamp,
						date_update timestamp,
						ip_number_create varchar(255),
						ip_number_update varchar(255),
						user_create bigint,
						user_update bigint,
						refund_value decimal(19,2),
						reservation_status integer not null,
						value decimal(19,2) not null,
						guest_id bigint,
						schedule_id bigint not null,
						primary key (id)
					);
					
				create table schedule (
					   id bigint generated by default as identity,
						date_create timestamp,
						date_update timestamp,
						ip_number_create varchar(255),
						ip_number_update varchar(255),
						user_create bigint,
						user_update bigint,
						end_date_time timestamp not null,
						start_date_time timestamp not null,
						tennis_court_id bigint not null,
						primary key (id)
					);
					
				create table schedule_reservations (
					   schedule_id bigint not null,
						reservations_id bigint not null
					);
					
				create table tennis_court (
					   id bigint generated by default as identity,
						date_create timestamp,
						date_update timestamp,
						ip_number_create varchar(255),
						ip_number_update varchar(255),
						user_create bigint,
						user_update bigint,
						name varchar(255) not null,
						primary key (id)
					);
					
				alter table schedule_reservations 
					add constraint UK_dvhq9k9bdljtip54918xcdvar unique (reservations_id);
					   
				alter table reservation 
					add constraint FK8rduaf1n8es4jf5wagbjhjepj 
					foreign key (guest_id) 
					references guest;
					   
				alter table reservation 
					add constraint FKjhy65q5kmadkpjil9wlyp5o64 
					foreign key (schedule_id) 
					references schedule;
					   
				alter table schedule 
					add constraint FKdy2fv6a47hjklcexsu9xvlssx 
					foreign key (tennis_court_id) 
					references tennis_court;
					   
				alter table schedule_reservations 
					add constraint FK2avksdo3gdtfc1xooue74s162 
					foreign key (reservations_id) 
					references reservation;
					   
				alter table schedule_reservations 
					add constraint FKmto48hgtug2e1bvoq5gj0wky1 
					foreign key (schedule_id) 
					references schedule;