INSERT INTO USERS (
					ID,
					USER_NAME,
					PASSWORD,
					EMAIL,
					NAME,
					FATHERS_NAME,
					MOTHERS_NAME,
					DATE_BIRTH,
					ACCOUNT_NON_EXPIRED,
					CREDENTIALS_NON_EXPIRED,
					ACCOUNT_NON_LOCKED,
					LAST_PASSWORD_RESET_DATE,
					ENABLED,
					CREATED_AT,
					UPDATED_AT )
				
values (1, 'admin', '$2a$06$Otz8Lg0p2sUqch5KVU7GX.AOdnMX0M8R3SbKk3DXORkNs7KChC9A.', 'diazgbs@gmail.com', 'Guillermo', 'Díaz', 'Solís', '1989-06-24', 1, 1, 1, '2015-07-07', 1, '2016-06-01', '2016-06-01');

INSERT INTO AUTHORITIES (
							ID,
							AUTHORITY,
							ENABLED,
							CREATED_AT,
							UPDATED_AT
						)
values (1, 'ROLE_ADMIN', 1, '2016-06-01', '2016-06-01');

INSERT INTO AUTHORITIES (
							ID,
							AUTHORITY,
							ENABLED,
							CREATED_AT,
							UPDATED_AT
						)
values (2, 'ROLE_MANAGER', 1, '2016-06-01', '2016-06-01');


INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (1, 2);

INSERT INTO SAMPLES (ID, NAME) VALUES (1, 'Main Test');
INSERT INTO SAMPLES (ID, NAME) VALUES (2, 'Main Test 2');
INSERT INTO SAMPLES (ID, NAME) VALUES (3, 'Main Test 3');
INSERT INTO SAMPLES (ID, NAME) VALUES (4, 'Main Test 4');
INSERT INTO SAMPLES (ID, NAME) VALUES (5, 'Main Test 5');
INSERT INTO SAMPLES (ID, NAME) VALUES (6, 'Main Test 6');
INSERT INTO SAMPLES (ID, NAME) VALUES (7, 'Main Test 7');
INSERT INTO SAMPLES (ID, NAME) VALUES (8, 'Main Test 8');
INSERT INTO SAMPLES (ID, NAME) VALUES (9, 'Main Test 9');