create table NAME
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  TITLE_ID BIGINT NULL,
  FIRST_NAME VARCHAR(1024)  NULL,
  MIDDLE_NAME VARCHAR(1024)  NULL,
  LAST_NAME VARCHAR(1024)  NULL,
  PREFERRED_NAME VARCHAR(1024)  NULL,
  LAST_UPDATED_DATE DATE,
  constraint NAME primary key (ID)
)
;

ALTER TABLE NAME ADD FOREIGN KEY (TITLE_ID) REFERENCES TITLE(ID)
;

create table ADDRESS
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  LINE1 VARCHAR(1024)  NULL,
  LINE2 VARCHAR(1024)  NULL,
  LINE3 VARCHAR(1024)  NULL,
  CITY VARCHAR(1024)  NULL,
  COUNTY VARCHAR(1024)  NULL,
  POST_CODE VARCHAR(1024)  NULL,
  LAST_UPDATED_DATE DATE,
  constraint ADDRESS primary key (ID)
)
;

create table CONTACT_DETAILS
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  MOBILE VARCHAR(1024)  NULL,
  PHONE VARCHAR(1024)  NULL,
  EMAIL VARCHAR(1024)  NULL,
  PREFERRED_CONTACT VARCHAR(1024)  NULL,
  LAST_UPDATED_DATE DATE,
  constraint CONTACT_DETAILS primary key (ID)
)
;

create table PATIENT
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NHS_NUMBER VARCHAR(1024)  NULL,
  NAME_ID BIGINT  NULL,
  DOB DATE,
  ETHNICITY_ID BIGINT  NULL,
  GENDER_ID BIGINT  NULL,
  LAST_UPDATED_DATE DATE,
  ACTIVE BOOLEAN DEFAULT 0  NULL,
  CONTACT_DETAILS_ID BIGINT  NULL,
  ADDRESS_ID  BIGINT  NULL,
  constraint PATIENT primary key (ID)
)
;

ALTER TABLE PATIENT ADD FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ID)
;

ALTER TABLE PATIENT ADD FOREIGN KEY (CONTACT_DETAILS_ID) REFERENCES CONTACT_DETAILS(ID)
;

ALTER TABLE PATIENT ADD FOREIGN KEY (ETHNICITY_ID) REFERENCES ETHNICITY(ID)
;

ALTER TABLE PATIENT ADD FOREIGN KEY (GENDER_ID) REFERENCES GENDER(ID)
;

ALTER TABLE PATIENT ADD FOREIGN KEY (NAME_ID) REFERENCES NAME(ID)
;



create table REFERRER
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NAME_ID BIGINT  NULL,
  LAST_UPDATED_DATE DATE,
  ACTIVE BOOLEAN DEFAULT 0  NULL,
  CONTACT_DETAILS_ID BIGINT  NULL,
  ADDRESS_ID  BIGINT  NULL,
  constraint REFERRER primary key (ID)
)
;

ALTER TABLE REFERRER ADD FOREIGN KEY (NAME_ID) REFERENCES NAME(ID)
;

create table REFERRAL
(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  UBRN VARCHAR(1024)  NULL,
  TYPE VARCHAR(1024)  NULL,
  DESCRIPTION VARCHAR(5120)  NULL,
  CREATE_DATE DATE,
  LAST_UPDATED_DATE DATE,
  ACTIVE BOOLEAN DEFAULT 0  NULL,
  USER_ID BIGINT  NULL,
  PATIENT_ID BIGINT  NULL,
  REFERRER_ID BIGINT  NULL,

  constraint REFERRAL primary key (ID)
)
;

ALTER TABLE REFERRAL ADD FOREIGN KEY (USER_ID) REFERENCES USER(ID)
;

ALTER TABLE REFERRAL ADD FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(ID)
;

ALTER TABLE REFERRAL ADD FOREIGN KEY (REFERRER_ID) REFERENCES REFERRER(ID)
;
