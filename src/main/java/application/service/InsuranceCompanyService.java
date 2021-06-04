package application.service;

import application.model.dto.InsuranceCompanyMonthInfoDto;

import java.util.List;

public interface InsuranceCompanyService {

    void add(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo);

    InsuranceCompanyMonthInfoDto findById(Integer id);

    List<InsuranceCompanyMonthInfoDto> findAll();

    void update(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo);

    void deleteById(Integer id);
}
