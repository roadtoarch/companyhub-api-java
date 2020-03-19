create table if not exists companies (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	homepage_url VARCHAR(1000) NOT NULL,
	blog_url VARCHAR(1000) NOT NULL,
	twitter_username VARCHAR(50) NOT NULL,
	category_code VARCHAR(50) NOT NULL,
	founded_year VARCHAR(50) NOT NULL,
	email_address VARCHAR(50) NOT NULL,
	phone_number VARCHAR(50) NOT NULL,
	description VARCHAR(50) NOT NULL,
	updated_at DATE NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;

create table if not exists campuses (
	id INT NOT NULL AUTO_INCREMENT,
	campus_name VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	address VARCHAR(400) NOT NULL,
	company_id INT NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;

create table employees (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	phone VARCHAR(50) NOT NULL,
	job_title VARCHAR(50) NOT NULL,
	department VARCHAR(50) NOT NULL,
	ein VARCHAR(50) NOT NULL,
	gender VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
	machine_ip VARCHAR(20) NOT NULL,
	campus_id INT NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;
