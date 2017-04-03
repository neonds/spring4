CREATE TABLE USERS (
		ID INTEGER PRIMARY KEY,
		USER_NAME VARCHAR(100) NOT NULL,
		PASSWORD VARCHAR(100) NOT NULL,
		EMAIL VARCHAR(50) NOT NULL,
		NAME VARCHAR(100) NOT NULL,
		FATHERS_NAME VARCHAR(100) NOT NULL,
		MOTHERS_NAME VARCHAR(100) NOT NULL,
		DATE_BIRTH DATE NOT NULL,
		ACCOUNT_NON_EXPIRED INTEGER DEFAULT 1,
		CREDENTIALS_NON_EXPIRED INTEGER DEFAULT 1,
		ACCOUNT_NON_LOCKED INTEGER DEFAULT 1,
		LAST_PASSWORD_RESET_DATE TIMESTAMP,
		ENABLED INTEGER,
		CREATED_AT TIMESTAMP NOT NULL,
		UPDATED_AT TIMESTAMP NOT NULL
);


CREATE TABLE AUTHORITIES (
		ID INTEGER PRIMARY KEY,
		AUTHORITY VARCHAR(100) NOT NULL,
		ENABLED INTEGER DEFAULT 1,
		CREATED_AT DATE NOT NULL,
		UPDATED_AT DATE NOT NULL
);



CREATE TABLE USERS_AUTHORITIES(
	USER_ID INT NOT NULL,
	AUTHORITY_ID INT NOT NULL,
    PRIMARY KEY(USER_ID, AUTHORITY_ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
	FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITIES(ID)
);



CREATE TABLE SAMPLES (
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(50)
);