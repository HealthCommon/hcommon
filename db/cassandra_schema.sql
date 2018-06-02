CREATE KEYSPACE hcommon WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
CREATE TABLE hc_users (
	user_id UUID PRIMARY KEY,
	full_name varchar,
	email varchar,
	mobile varchar,
	password varchar,
	image_url text,
	otp varchar
);
INSERT INTO hc_users (user_id, full_name,email,mobile,password, image_url,otp) 
VALUES(cfd66ccc-d857-4e90-b1e5-df98a3d40cd6, 'Amit Jha', 'akjha@globaxon.com', '9810314644', 'password', 'test', '123456');

CREATE TABLE hc_patients (
	patient_id UUID PRIMARY KEY,
	user_id UUID,
	devices text,
	full_name varchar,
	age varchar,
	gender varchar,
	weight varchar,
	height varchar,
	critical_disease text,
	tags text	
);

INSERT INTO hc_patients (patient_id, user_id, full_name, age, gender, weight, height, critical_disease, tags) 
VALUES(0bf06878-dda2-11e7-9296-cec278b6b50a, cfd66ccc-d857-4e90-b1e5-df98a3d40cd6, 'Vipul Kr', '35 Yrs', 'M', '90Kg', '172cm', 'BP Blood Sugar','test');
UPDATE hc_patients set devices='52438b3112ac18d6' where patient_id=0bf06878-dda2-11e7-9296-cec278b6b50a;
UPDATE hc_patients set devices='304fe0dbdf5954a4' where patient_id=0bf06878-dda2-11e7-9296-cec278b6b50a;

select * from hc_device_data where device_id='304fe0dbdf5954a4' and data_type='BLOOD_PRESSURE_OXYGEN' ALLOW FILTERING;
CREATE TABLE hc_documents (
	document_id UUID PRIMARY KEY,
	patient_id UUID,
	docu_name varchar,
	docu_meta text,
	validated boolean,
	tags text
);

CREATE TABLE hc_device_data (
	row_id UUID PRIMARY KEY,
	mobile varchar,
	device_id varchar,
	patient_id UUID,
	data_type varchar,
	data varchar,
	unique_id varchar,
	date_time varchar,
	timestamp bigint
);

UPDATE hc_patients set devices='52438b3112ac18d6' where patient_id=c28df178-d275-271d-5f14-288ed2b54b7f;
UPDATE hc_patients set devices='304fe0dbdf5954a4' where patient_id=c28df178-d275-271d-5f14-288ed2b54b7f;