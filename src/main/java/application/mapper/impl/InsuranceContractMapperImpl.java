package application.mapper.impl;

import application.mapper.InsuranceContractMapper;
import application.model.InsuranceContract;
import application.model.dto.InsuranceContractDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsuranceContractMapperImpl implements InsuranceContractMapper {
    @Override
    public InsuranceContract fromDto(InsuranceContractDto insuranceContractDto) {
        return InsuranceContract.builder()
                .id(insuranceContractDto.getId())
                .monthlyFee(insuranceContractDto.getMonthlyFee())
                .contractTimeInMonths(insuranceContractDto.getContractTimeInMonths())
                .maximumInsuranceIndemnity(insuranceContractDto.getMaximumInsuranceIndemnity())
                .insuranceDeductible(insuranceContractDto.getInsuranceDeductible())
                .insuranceType(insuranceContractDto.getInsuranceType())
                .build();
    }

    @Override
    public InsuranceContractDto toDto(InsuranceContract insuranceContract) {
        return InsuranceContractDto.builder()
                .id(insuranceContract.getId())
                .monthlyFee(insuranceContract.getMonthlyFee())
                .contractTimeInMonths(insuranceContract.getContractTimeInMonths())
                .maximumInsuranceIndemnity(insuranceContract.getMaximumInsuranceIndemnity())
                .insuranceDeductible(insuranceContract.getInsuranceDeductible())
                .insuranceType(insuranceContract.getInsuranceType())
                .build();
    }

    @Override
    public List<InsuranceContract> fromDtoList(List<InsuranceContractDto> insuranceContractDtoList) {
        List<InsuranceContract> insuranceContractList = new ArrayList<>();
        for (InsuranceContractDto insuranceContractDto:
                insuranceContractDtoList) {
            insuranceContractList.add(fromDto(insuranceContractDto));
        }
        return insuranceContractList;
    }

    @Override
    public List<InsuranceContractDto> toDtoList(List<InsuranceContract> insuranceContractList) {
        List<InsuranceContractDto> insuranceContractDtoList = new ArrayList<>();
        for (InsuranceContract insuranceContract:
                insuranceContractList) {
            insuranceContractDtoList.add(toDto(insuranceContract));
        }
        return insuranceContractDtoList;
    }
}
