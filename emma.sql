--Car Rental System V2
create table Company(
company_id integer not null,
company_name varchar2(100)
);
alter table Company add constraint Company_PK primary  key(company_id);

CREATE TABLE CompanyUsers (
    user_id INTEGER,
    username VARCHAR(50),
    company_role VARCHAR(20) 
);
alter table CompanyUsers add constraint CompanyUsers_PK primary key(user_id);

CREATE TABLE CompanyClient (
    client_id INTEGER,
    client_name VARCHAR(50),
    client_phone VARCHAR(50),
    client_email VARCHAR(100),
    client_rating INTEGER
);
alter table CompanyClient add constraint CompanyClient_PK primary key(client_id);

--rental 
CREATE TABLE Rental (
    rental_id INTEGER NOT NULL,
    client_id INTEGER,
    car_id INTEGER,
    operator_id INTEGER,
    rent_date DATE,
    expected_rent_date DATE,
    return_date DATE,
    init_mileage NUMBER,
    return_mileage NUMBER,
    total_cost NUMBER,
    rental_status VARCHAR(20)
);
alter table Rental add constraint Rental_PK primary key(rental_id);
--conditionReport
CREATE TABLE ConditionReport (
    report_id INTEGER,
    rental_id INTEGER,
    scratches VARCHAR(100),
    interior_damage VARCHAR(100),
    tire_condition VARCHAR(30),
    notes VARCHAR(100),
    report_stage VARCHAR(100)
);
alter table ConditionReport add constraint ConditionReport_PK primary key(report_id);
alter table ConditionReport drop constraint ConditionReport_PK ;
--Damages
CREATE TABLE Damage (
    damage_id INTEGER,
    rental_id INTEGER,
    cost NUMBER,
    description VARCHAR(100)
    
);
alter table Damage add constraint Damage_PK primary key(damage_id);
--Car
CREATE TABLE Car (
    car_id INTEGER,
    brand VARCHAR(70),
    car_model VARCHAR(50),
    car_year INTEGER,
    car_class VARCHAR (20),
    car_category VARCHAR(20),
    smoking_allowed VARCHAR(7),
    daily_rate NUMBER,
    km_rate NUMBER,
    mileage NUMBER,
    car_status VARCHAR(20)   
);
alter table Car add constraint Car_PK primary key(car_id);
--CarCharacteristics
CREATE TABLE CarCharacteristics (
    car_id INTEGER,
    fuel_type VARCHAR(20),
    gear_box VARCHAR(20),
    horse_power NUMBER,
    color VARCHAR(30)
);
