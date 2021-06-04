package application.service.impl;

import application.dao.InsuranceCompanyMonthInfoDAO;
import application.mapper.InsuranceCompanyMonthInfoMapper;
import application.model.dto.InsuranceCompanyMonthInfoDto;
import application.service.InsuranceCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceCompanyMonthInfoServiceImpl implements InsuranceCompanyService {

    private InsuranceCompanyMonthInfoDAO insuranceCompanyDAO;
    private InsuranceCompanyMonthInfoMapper insuranceCompanyMonthInfoMapper;

    public InsuranceCompanyMonthInfoServiceImpl(InsuranceCompanyMonthInfoDAO insuranceCompanyDAO, InsuranceCompanyMonthInfoMapper insuranceCompanyMonthInfoMapper) {
        this.insuranceCompanyDAO = insuranceCompanyDAO;
        this.insuranceCompanyMonthInfoMapper = insuranceCompanyMonthInfoMapper;
    }

    public void add(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo) {
        insuranceCompanyDAO.add(insuranceCompanyMonthInfoMapper.fromDto(insuranceCompanyMonthInfo));
    }

    public InsuranceCompanyMonthInfoDto findById(Integer id) {
        return insuranceCompanyMonthInfoMapper.toDto(insuranceCompanyDAO.findById(id));
    }

    public List<InsuranceCompanyMonthInfoDto> findAll() {
        return insuranceCompanyMonthInfoMapper.toDtoList(insuranceCompanyDAO.findAll());
    }

    public void update(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo) {
        insuranceCompanyDAO.update(insuranceCompanyMonthInfoMapper.fromDto(insuranceCompanyMonthInfo));
    }

    public void deleteById(Integer id) {
        insuranceCompanyDAO.deleteById(id);
    }
}
