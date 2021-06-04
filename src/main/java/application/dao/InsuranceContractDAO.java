package application.dao;


import application.model.EnumUtils;
import application.model.InsuranceContract;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InsuranceContractDAO extends DAO<InsuranceContract> {

    public InsuranceContractDAO() {
        tableName = "contracts";
        columns = new String[]{
                "monthly_fee",
                "contract_time_in_months",
                "maximum_insurance_indemnity",
                "insurance_deductible",
                "insurance_type"
        };
    }

    @Override
    protected List<InsuranceContract> convertFrom(ResultSet resultSet) throws SQLException {
        List<InsuranceContract> insuranceContracts = new ArrayList<>();
        while (resultSet.next()) {
            InsuranceContract insuranceContract = new InsuranceContract();

            insuranceContract.setId(resultSet.getInt("id"));
            insuranceContract.setMonthlyFee(resultSet.getInt(  "monthly_fee"));
            insuranceContract.setContractTimeInMonths(resultSet.getInt("contract_time_in_months"));
            insuranceContract.setMaximumInsuranceIndemnity(resultSet.getInt("maximum_insurance_indemnity"));
            insuranceContract.setInsuranceDeductible(resultSet.getInt("insurance_deductible"));
            insuranceContract.setInsuranceType(EnumUtils.defineInsuranceType(resultSet.getInt("insurance_type")));

            insuranceContracts.add(insuranceContract);
        }
        return insuranceContracts;
    }

    @Override
    protected String createInsertQuery(InsuranceContract insuranceContract) {
        String fields = String.join(", ", columns);

        String values =
                insuranceContract.getMonthlyFee() + ", "
                        + insuranceContract.getContractTimeInMonths() + ", "
                        + insuranceContract.getMaximumInsuranceIndemnity() + ", "
                        + insuranceContract.getInsuranceDeductible() + ", "
                        + insuranceContract.getInsuranceType().getValue();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(InsuranceContract insuranceContract) {
        String query =
                "UPDATE " + tableName + " SET "
                        + "monthly_fee = " + insuranceContract.getMonthlyFee() + ", "
                        + "contract_time_in_months = " + insuranceContract.getContractTimeInMonths() + ", "
                        + "maximum_insurance_indemnity = " + insuranceContract.getMaximumInsuranceIndemnity() + ", "
                        + "insurance_deductible = " + insuranceContract.getInsuranceDeductible() + ", "
                        + "insurance_type = " + insuranceContract.getInsuranceType().getValue() + " "
                        + "WHERE id = " + insuranceContract.getId();
        return query;
    }
}
