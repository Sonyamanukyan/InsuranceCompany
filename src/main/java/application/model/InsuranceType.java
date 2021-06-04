package application.model;

public enum InsuranceType {

    HOME_INSURANCE(1),
    CAR_INSURANCE(2),
    HEALTH_INSURANCE(3);

    public int getValue() {
        return value;
    }

    private int value;

    InsuranceType(int value) {
        this.value = value;
    }
}
