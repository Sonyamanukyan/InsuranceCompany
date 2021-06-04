package application.mapper;

import application.model.InsuranceContract;
import application.model.dto.InsuranceContractDto;

import java.util.List;

public interface InsuranceContractMapper {

    InsuranceContract fromDto(InsuranceContractDto insuranceContractDto);

    InsuranceContractDto toDto(InsuranceContract insuranceContract);

    List<InsuranceContract> fromDtoList(List<InsuranceContractDto> insuranceContractDtoList);

    List<InsuranceContractDto> toDtoList(List<InsuranceContract> insuranceContractList);
}
