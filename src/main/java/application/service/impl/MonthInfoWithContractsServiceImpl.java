package application.service.impl;

import application.dao.MonthInfoWithContractsDAO;
import application.model.MonthInfoWithContracts;
import application.service.MonthInfoWithContractsService;
import org.springframework.stereotype.Service;

@Service
public class MonthInfoWithContractsServiceImpl implements MonthInfoWithContractsService {

    private MonthInfoWithContractsDAO monthInfoWithContractsDAO;

    public MonthInfoWithContractsServiceImpl(MonthInfoWithContractsDAO monthInfoWithContractsDAO) {
        this.monthInfoWithContractsDAO = monthInfoWithContractsDAO;
    }

    @Override
    public void addContract(Integer monthId, Integer contractId) {
        MonthInfoWithContracts monthInfoWithContracts = new MonthInfoWithContracts();
        monthInfoWithContracts.setMonthInfoId(monthId);
        monthInfoWithContracts.setContractId(contractId);
        monthInfoWithContractsDAO.add(monthInfoWithContracts);
    }

    @Override
    public void deleteContract(Integer monthId, Integer contractId) {
        monthInfoWithContractsDAO.delete(monthId, contractId);
    }
}
