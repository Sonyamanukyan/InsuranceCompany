package application.service;

public interface MonthInfoWithContractsService {

    void addContract(Integer monthId, Integer contractId);

    void deleteContract(Integer monthId, Integer contractId);
}
