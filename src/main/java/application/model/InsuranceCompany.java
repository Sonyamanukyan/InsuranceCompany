package application.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InsuranceCompany {

    private String companyName;
    private int companyCapital;

    private int homeInsuranceBaseDemand;
    private int carInsuranceBaseDemand;
    private int healthInsuranceBaseDemand;

    private List<InsuranceContract> contractList = new ArrayList<InsuranceContract>();
    private List<InsuranceCompanyMonthInfo> monthInfoList = new ArrayList<InsuranceCompanyMonthInfo>();

    private Manager manager;
}
