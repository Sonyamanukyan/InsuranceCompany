package application.model.dto;

import application.model.InsuranceContract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCompanyMonthInfoDto {

    private int id;
    private int monthNumber;
    private int companyCapital;
    private List<InsuranceContract> contractList = new ArrayList<InsuranceContract>();

    private int numberOfHomeInsuranceSold;
    private int numberOfCarInsuranceSold;
    private int numberOfHealthInsuranceSold;

    private int totalEarnings;
    private int insuranceCosts;
    private int monthTaxes;
}
