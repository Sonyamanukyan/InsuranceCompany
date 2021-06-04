package application.service.impl;

import application.dao.InsuranceContractDAO;
import application.mapper.InsuranceContractMapper;
import application.model.dto.InsuranceContractDto;
import application.service.InsuranceContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceContractServiceImpl implements InsuranceContractService {

    private InsuranceContractDAO insuranceCompanyDAO;
    private InsuranceContractMapper insuranceContractMapper;

    public InsuranceContractServiceImpl(InsuranceContractDAO insuranceCompanyDAO, InsuranceContractMapper insuranceContractMapper) {
        this.insuranceCompanyDAO = insuranceCompanyDAO;
        this.insuranceContractMapper = insuranceContractMapper;
    }

    public void add(InsuranceContractDto insuranceContract) {
        insuranceCompanyDAO.add(insuranceContractMapper.fromDto(insuranceContract));
    }

    public InsuranceContractDto findById(Integer id) {
        return insuranceContractMapper.toDto(insuranceCompanyDAO.findById(id));
    }

    public List<InsuranceContractDto> findAll() {
        return insuranceContractMapper.toDtoList(insuranceCompanyDAO.findAll());
    }

    public void update(InsuranceContractDto insuranceContract) {
        insuranceCompanyDAO.update(insuranceContractMapper.fromDto(insuranceContract));
    }

    public void deleteById(Integer id) {
        insuranceCompanyDAO.deleteById(id);
    }
}
