package application.service;

import application.model.dto.InsuranceContractDto;

import java.util.List;

public interface InsuranceContractService {

    void add(InsuranceContractDto insuranceContract);

    InsuranceContractDto findById(Integer id);

    List<InsuranceContractDto> findAll();

    void update(InsuranceContractDto insuranceContract);

    void deleteById(Integer id);
}
