package application.mapper;

import application.model.InsuranceCompanyMonthInfo;
import application.model.dto.InsuranceCompanyMonthInfoDto;

import java.util.List;

public interface InsuranceCompanyMonthInfoMapper {
    InsuranceCompanyMonthInfo fromDto(InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfoDto);

    InsuranceCompanyMonthInfoDto toDto(InsuranceCompanyMonthInfo insuranceCompanyMonthInfo);

    List<InsuranceCompanyMonthInfo> fromDtoList(List<InsuranceCompanyMonthInfoDto> insuranceCompanyMonthInfoDtoList);

    List<InsuranceCompanyMonthInfoDto> toDtoList(List<InsuranceCompanyMonthInfo> insuranceCompanyMonthInfoList);
}
