
CREATE TABLE IF NOT EXISTS users (
id serial PRIMARY KEY,
uname VARCHAR (50) NOT NULL,
pwd VARCHAR (50) NOT NULL,
name_surname VARCHAR (150) NOT NULL,
email VARCHAR (50)
);
CREATE TABLE IF NOT EXISTS project (
   id serial PRIMARY KEY,
   created_at TIMESTAMP NOT NULL,
   status boolean NOT NULL,
   project_code VARCHAR (50) NOT NULL,
   project_name VARCHAR (50) NOT NULL,
   manager_user_id serial NOT NULL,
   FOREIGN KEY(manager_user_id)
   		REFERENCES users (id)
);
CREATE TABLE IF NOT EXISTS issue (
   id serial PRIMARY KEY,
   created_at TIMESTAMP NOT NULL,
   status boolean NOT NULL,
   date TIMESTAMP NOT NULL,
   description VARCHAR (250),
   details VARCHAR (250),
   issue_status VARCHAR (250),
   assignee_user_id serial NOT NULL,
   project_id serial NOT NULL,
   FOREIGN KEY(assignee_user_id)
   REFERENCES users (id),
   FOREIGN KEY(project_id)
   REFERENCES project (id),
);
CREATE TABLE IF NOT EXISTS issue_history (
   id serial PRIMARY KEY,
   created_at TIMESTAMP NOT NULL,
   status boolean NOT NULL,
   date TIMESTAMP NOT NULL,
   description VARCHAR (250),
   details VARCHAR (250),
   issue_status VARCHAR (250),
   assignee_user_id serial NOT NULL,
   issue_id serial NOT NULL,
   FOREIGN KEY(assignee_user_id)
   REFERENCES users (id),
   FOREIGN KEY(issue_id)
   REFERENCES issue (id),
);



insert into users (id,uname,pwd,name_surname,email) values (1000,''david'',''123'',''David'',''david@outlook.com'');

insert into project(id,created_at,status,project_code,project_name,manager_user_id) values (1000,now(),true,''ISMAN'',''Issue Management System'',1000);

insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
values (1000,now(),true,now(),''Username should be unique'',''User registration step, username should be checked for unique username'',''IN_PROGRESS'',1000,1000);

insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
values (1001,now(),true,now(),''API throwing an exception for null values'',''API throwing an exception for null values'',''IN_REVIEW'',1000,1000);

insert into issue_history (id,created_at,status,date,description,details,issue_status,assignee_user_id,issue_id)
values (1000,now(),true,now(),''Username should be unique'',''User registration step, username should be checked for unique username'',''OPEN'',1000,1000);