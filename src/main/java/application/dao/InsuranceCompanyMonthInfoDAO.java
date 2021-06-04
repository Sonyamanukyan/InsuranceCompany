package application.dao;


import application.model.InsuranceCompanyMonthInfo;
import application.model.InsuranceContract;
import application.model.MonthInfoWithContracts;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InsuranceCompanyMonthInfoDAO extends DAO<InsuranceCompanyMonthInfo> {

    private MonthInfoWithContractsDAO monthInfoWithContractsDAO;
    private InsuranceContractDAO insuranceContractDAO;

    public InsuranceCompanyMonthInfoDAO(MonthInfoWithContractsDAO monthInfoWithContractsDAO, InsuranceContractDAO insuranceContractDAO) {

        this.monthInfoWithContractsDAO = monthInfoWithContractsDAO;
        this.insuranceContractDAO = insuranceContractDAO;

        tableName = "month_info";
        columns = new String[]{
                "month_number",
                "company_capital",
                "number_of_home_insurance_sold",
                "number_of_car_insurance_sold",
                "number_of_health_insurance_sold",
                "total_earnings",
                "insurance_costs",
                "month_taxes"
        };
    }

    @Override
    protected List<InsuranceCompanyMonthInfo> convertFrom(ResultSet resultSet) throws SQLException {
        List<InsuranceCompanyMonthInfo> insuranceCompanyMonthInfos = new ArrayList<>();
        while (resultSet.next()) {
            InsuranceCompanyMonthInfo insuranceCompanyMonthInfo = new InsuranceCompanyMonthInfo();

            insuranceCompanyMonthInfo.setId(resultSet.getInt("id"));
            insuranceCompanyMonthInfo.setMonthNumber(resultSet.getInt("month_number"));
            insuranceCompanyMonthInfo.setCompanyCapital(resultSet.getInt("company_capital"));
            insuranceCompanyMonthInfo.setNumberOfHomeInsuranceSold(resultSet.getInt("number_of_home_insurance_sold"));
            insuranceCompanyMonthInfo.setNumberOfCarInsuranceSold(resultSet.getInt("number_of_car_insurance_sold"));
            insuranceCompanyMonthInfo.setNumberOfHealthInsuranceSold(resultSet.getInt("number_of_health_insurance_sold"));
            insuranceCompanyMonthInfo.setTotalEarnings(resultSet.getInt("total_earnings"));
            insuranceCompanyMonthInfo.setInsuranceCosts(resultSet.getInt("insurance_costs"));
            insuranceCompanyMonthInfo.setMonthTaxes(resultSet.getInt("month_taxes"));

            List<InsuranceContract> contractList = new ArrayList<>();

            List<Integer> contractsId = new ArrayList<>();

            List<MonthInfoWithContracts> monthInfoWithContractsList = monthInfoWithContractsDAO.findAll();
            for (MonthInfoWithContracts m:
                   monthInfoWithContractsList) {
                if (m.getMonthInfoId() == insuranceCompanyMonthInfo.getId()) {
                    contractsId.add(m.getContractId());
                }
            }

            List<InsuranceContract> insuranceContractList = insuranceContractDAO.findAll();
            for (InsuranceContract c:
                    insuranceContractList) {
                if (contractsId.contains(c.getId())) {
                    contractList.add(c);
                }
            }

            insuranceCompanyMonthInfo.setContractList(contractList);

            insuranceCompanyMonthInfos.add(insuranceCompanyMonthInfo);
        }
        return insuranceCompanyMonthInfos;
    }

    @Override
    protected String createInsertQuery(InsuranceCompanyMonthInfo insuranceCompanyMonthInfo) {
        String fields = String.join(", ", columns);
        String values =
                insuranceCompanyMonthInfo.getMonthNumber() + ", "
                        + insuranceCompanyMonthInfo.getCompanyCapital() + ", "
                        + insuranceCompanyMonthInfo.getNumberOfHomeInsuranceSold() + ", "
                        + insuranceCompanyMonthInfo.getNumberOfCarInsuranceSold() + ", "
                        + insuranceCompanyMonthInfo.getNumberOfHealthInsuranceSold() + ", "
                        + insuranceCompanyMonthInfo.getTotalEarnings() + ", "
                        + insuranceCompanyMonthInfo.getInsuranceCosts() + ", "
                        + insuranceCompanyMonthInfo.getMonthTaxes();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(InsuranceCompanyMonthInfo insuranceCompanyMonthInfo) {
        String query =
                "UPDATE " + tableName + " SET "
                        + "month_number = " + insuranceCompanyMonthInfo.getMonthNumber() + ", "
                        + "company_capital = " + insuranceCompanyMonthInfo.getCompanyCapital() + ", "
                        + "number_of_home_insurance_sold = " + insuranceCompanyMonthInfo.getNumberOfHomeInsuranceSold() + ", "
                        + "number_of_car_insurance_sold = " + insuranceCompanyMonthInfo.getNumberOfCarInsuranceSold() + ", "
                        + "number_of_health_insurance_sold = " + insuranceCompanyMonthInfo.getNumberOfHealthInsuranceSold() + ", "
                        + "total_earnings = " + insuranceCompanyMonthInfo.getTotalEarnings() + ", "
                        + "insurance_costs = " + insuranceCompanyMonthInfo.getInsuranceCosts() + ", "
                        + "month_taxes = " + insuranceCompanyMonthInfo.getMonthTaxes() + " "
                        + "WHERE id = " + insuranceCompanyMonthInfo.getId();
        return query;
    }
}
