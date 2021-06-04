package application.model.dto;


import application.model.InsuranceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContractDto {

    private int id;
    private int monthlyFee;
    private int contractTimeInMonths;
    private int maximumInsuranceIndemnity;
    private int insuranceDeductible;
    private InsuranceType insuranceType;
}
