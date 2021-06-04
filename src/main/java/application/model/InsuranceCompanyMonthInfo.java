package application.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCompanyMonthInfo {

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
