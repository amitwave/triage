insert into TITLE values(1, 'MR', 'Mr');
insert into TITLE values(2, 'Mrs', 'Mrs');


insert into ETHNICITY values(1, 'BRITISH', 'BRITISH');
insert into ETHNICITY values(2, 'INDIAN', 'INDIAN');

insert into USER  (ID, USER_NAME, PASSWORD, DISPLAY_NAME) values(1, 'admin', 'admin', 'Administrator');
insert into USER  (ID, USER_NAME, PASSWORD, DISPLAY_NAME) values(2, 'facilitator', 'facilitator', 'Facilitator');
insert into USER  (ID, USER_NAME, PASSWORD, DISPLAY_NAME) values(3, 'doctor', 'doctor', 'Doctor');
insert into USER  (ID, USER_NAME, PASSWORD, DISPLAY_NAME) values(4, 'validator', 'validator', 'Validator');


insert into ROLE (ID, NAME, DESCRIPTION, active) VALUES (1, 'admin', 'Admin', TRUE );
insert into ROLE (ID, NAME, DESCRIPTION, active) VALUES (2, 'facilitator', 'facilitator', TRUE );
insert into ROLE (ID, NAME, DESCRIPTION, active) VALUES (3, 'doctor', 'doctor', TRUE );
insert into ROLE (ID, NAME, DESCRIPTION, active) VALUES (4, 'validator', 'validator', TRUE );


insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (1,1);
insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (1,2);
insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (1,3);

insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (2,2);
insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (3,3);
insert into USER_ROLE (USER_ID, ROLE_ID) VALUES (4,4);



