package application.mapper.impl;

import application.mapper.InsuranceCompanyMonthInfoMapper;
import application.model.InsuranceCompanyMonthInfo;
import application.model.dto.InsuranceCompanyMonthInfoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsuranceCompanyMonthInfoMapperImpl implements InsuranceCompanyMonthInfoMapper {

    @Override
    public InsuranceCompanyMonthInfo fromDto(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfoDto) {
        return InsuranceCompanyMonthInfo.builder()
                .id(insuranceCompanyMonthInfoDto.getId())
                .monthNumber(insuranceCompanyMonthInfoDto.getMonthNumber())
                .companyCapital(insuranceCompanyMonthInfoDto.getCompanyCapital())
                .contractList(insuranceCompanyMonthInfoDto.getContractList())
                .numberOfHomeInsuranceSold(insuranceCompanyMonthInfoDto.getNumberOfHomeInsuranceSold())
                .numberOfCarInsuranceSold(insuranceCompanyMonthInfoDto.getNumberOfCarInsuranceSold())
                .numberOfHealthInsuranceSold(insuranceCompanyMonthInfoDto.getNumberOfHealthInsuranceSold())
                .totalEarnings(insuranceCompanyMonthInfoDto.getTotalEarnings())
                .insuranceCosts(insuranceCompanyMonthInfoDto.getInsuranceCosts())
                .monthTaxes(insuranceCompanyMonthInfoDto.getMonthTaxes())
                .build();
    }

    @Override
    public InsuranceCompanyMonthInfoDto toDto(InsuranceCompanyMonthInfo insuranceCompanyMonthInfo) {
        return InsuranceCompanyMonthInfoDto.builder()
                .id(insuranceCompanyMonthInfo.getId())
                .monthNumber(insuranceCompanyMonthInfo.getMonthNumber())
                .companyCapital(insuranceCompanyMonthInfo.getCompanyCapital())
                .contractList(insuranceCompanyMonthInfo.getContractList())
                .numberOfHomeInsuranceSold(insuranceCompanyMonthInfo.getNumberOfHomeInsuranceSold())
                .numberOfCarInsuranceSold(insuranceCompanyMonthInfo.getNumberOfCarInsuranceSold())
                .numberOfHealthInsuranceSold(insuranceCompanyMonthInfo.getNumberOfHealthInsuranceSold())
                .totalEarnings(insuranceCompanyMonthInfo.getTotalEarnings())
                .insuranceCosts(insuranceCompanyMonthInfo.getInsuranceCosts())
                .monthTaxes(insuranceCompanyMonthInfo.getMonthTaxes())
                .build();
    }

    @Override
    public List<InsuranceCompanyMonthInfo> fromDtoList(List<InsuranceCompanyMonthInfoDto> insuranceCompanyMonthInfoDtoList) {
        List<InsuranceCompanyMonthInfo> insuranceCompanyMonthInfoList = new ArrayList<>();
        for (InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo:
                insuranceCompanyMonthInfoDtoList) {
            insuranceCompanyMonthInfoList.add(fromDto(insuranceCompanyMonthInfo));
        }
        return insuranceCompanyMonthInfoList;
    }

    @Override
    public List<InsuranceCompanyMonthInfoDto> toDtoList(List<InsuranceCompanyMonthInfo> insuranceCompanyMonthInfoList) {
        List<InsuranceCompanyMonthInfoDto> insuranceCompanyMonthInfoDtoList = new ArrayList<>();
        for (InsuranceCompanyMonthInfo insuranceCompanyMonthInfo:
                insuranceCompanyMonthInfoList) {
            insuranceCompanyMonthInfoDtoList.add(toDto(insuranceCompanyMonthInfo));
        }
        return insuranceCompanyMonthInfoDtoList;
    }
}
