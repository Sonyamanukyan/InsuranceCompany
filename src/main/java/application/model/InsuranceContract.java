package application.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContract {

    private int id;
    private int monthlyFee;
    private int contractTimeInMonths;
    private int maximumInsuranceIndemnity;
    private int insuranceDeductible;
    private InsuranceType insuranceType;
}
