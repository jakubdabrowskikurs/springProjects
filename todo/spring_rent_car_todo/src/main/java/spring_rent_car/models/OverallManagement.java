package spring_rent_car.models;

public class OverallManagement {

    private final static int COST_OF_ONE_FUEL = 5;
    private final static int INSURANCE = 22;
    private final static int CAR_EXPLORATION_PERIOD = 5;
    private final static int CAR_EXPLORATION_COST_EVERY_100KM = 10;

    public static int getCostOfOneFuel() {
        return COST_OF_ONE_FUEL;
    }

    public static int getInsurance() {
        return INSURANCE;
    }

    public static int getCarExplorationPeriod() {
        return CAR_EXPLORATION_PERIOD;
    }

    public static int getCarExplorationCostEvery100km() {
        return CAR_EXPLORATION_COST_EVERY_100KM;
    }
}
