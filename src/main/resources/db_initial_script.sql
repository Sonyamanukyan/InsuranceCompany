DROP TABLE IF EXISTS month_info CASCADE;
DROP TABLE IF EXISTS contracts CASCADE;
DROP TABLE IF EXISTS month_info_with_contracts CASCADE;

CREATE TABLE IF NOT EXISTS month_info
(
    id                              SERIAL PRIMARY KEY,
    month_number                    BIGINT NOT NULL,
    company_capital                 BIGINT NOT NULL,
    number_of_home_insurance_sold   BIGINT NOT NULL,
    number_of_car_insurance_sold    BIGINT NOT NULL,
    number_of_health_insurance_sold BIGINT NOT NULL,
    total_earnings                  BIGINT NOT NULL,
    insurance_costs                 BIGINT NOT NULL,
    month_taxes                     BIGINT NOT NULL
);


CREATE TABLE IF NOT EXISTS contracts
(
    id                          SERIAL PRIMARY KEY,
    monthly_fee                 BIGINT NOT NULL,
    contract_time_in_months     BIGINT NOT NULL,
    maximum_insurance_indemnity BIGINT NOT NULL,
    insurance_deductible        BIGINT NOT NULL,
    insurance_type              BIGINT NOT NULL
);


CREATE TABLE IF NOT EXISTS month_info_with_contracts
(
    month_info_id BIGINT,
    contract_id   BIGINT,

    CONSTRAINT month_info_id_fk FOREIGN KEY (month_info_id) REFERENCES month_info (id),
    CONSTRAINT contracts_id_fk FOREIGN KEY (contract_id) REFERENCES contracts (id),
    CONSTRAINT month_info_with_contracts_id PRIMARY KEY (month_info_id, contract_id)
);



INSERT INTO contracts(monthly_fee,
                      contract_time_in_months,
                      maximum_insurance_indemnity,
                      insurance_deductible,
                      insurance_type)
VALUES (50,
        24,
        200,
        2000,
        1);

INSERT INTO contracts(monthly_fee,
                      contract_time_in_months,
                      maximum_insurance_indemnity,
                      insurance_deductible,
                      insurance_type)
VALUES (40,
        24,
        100,
        2000,
        2);

INSERT INTO contracts(monthly_fee,
                      contract_time_in_months,
                      maximum_insurance_indemnity,
                      insurance_deductible,
                      insurance_type)
VALUES (70,
        24,
        300,
        1000,
        3);

insert into month_info(
    month_number,
    company_capital,
    number_of_home_insurance_sold,
    number_of_car_insurance_sold,
    number_of_health_insurance_sold,
    total_earnings,
    insurance_costs,
    month_taxes
) values (1,
          100000,
          10,
          20,
          30,
          10000,
          5000,
          5000);

insert into month_info_with_contracts (month_info_id, contract_id)
values (1, 1);

insert into month_info_with_contracts (month_info_id, contract_id)
values (1, 2);

insert into month_info_with_contracts (month_info_id, contract_id)
values (1, 3);
