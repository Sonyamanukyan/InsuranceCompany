package application.dao;


import application.model.EnumUtils;
import application.model.InsuranceCompanyMonthInfo;
import application.model.InsuranceContract;
import application.model.MonthInfoWithContracts;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MonthInfoWithContractsDAO extends DAO<MonthInfoWithContracts> {

    public MonthInfoWithContractsDAO() {
        tableName = "month_info_with_contracts";
        columns = new String[]{
                "month_info_id",
                "contract_id",
        };
    }

    @Override
    protected String createInsertQuery(MonthInfoWithContracts monthInfoWithContracts) {
        String fields = String.join(", ", columns);

        String values =
                monthInfoWithContracts.getMonthInfoId() + ", "
                        + monthInfoWithContracts.getContractId();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected List<MonthInfoWithContracts> convertFrom(ResultSet resultSet) throws SQLException {
        List<MonthInfoWithContracts> monthInfoWithContractsList = new ArrayList<>();
        while (resultSet.next()) {
            MonthInfoWithContracts monthInfoWithContracts = new MonthInfoWithContracts();
            monthInfoWithContracts.setMonthInfoId(resultSet.getInt(  "month_info_id"));
            monthInfoWithContracts.setContractId(resultSet.getInt("contract_id"));

            monthInfoWithContractsList.add(monthInfoWithContracts);
        }
        return monthInfoWithContractsList;
    }

    public boolean delete(Integer monthId, Integer contractId) {
        final String query = String.format("DELETE FROM %s WHERE month_info_id = %d and contract_id = %d", tableName,
               monthId, contractId);
        return executeModifyQuery(query);
    }

    @Override
    protected String createUpdateQuery(MonthInfoWithContracts entity) {
        return "";
    }
}
