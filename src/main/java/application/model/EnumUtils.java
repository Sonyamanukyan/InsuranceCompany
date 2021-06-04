package application.model;

public class EnumUtils {

    public static InsuranceType defineInsuranceType(int value) {
        for (InsuranceType i:
             InsuranceType.values()) {
            if (i.getValue() == value) {
                return i;
            }
        }
        return null;
    }
}
