package spring_rent_car.models.services;


import org.springframework.stereotype.Service;
import spring_rent_car.models.OverallManagement;

@Service
public class CarAmortization {

    public static int dailyAmortization(int carValue){
        //todo implement function
        return 10;
    }

    public static int distanceAmortization(int carValue, int passengerCapacity, int fuelConsumption){
        return carValue / ((OverallManagement.getCarExplorationCostEvery100km()) * ((passengerCapacity + fuelConsumption) * 25));
    }
}
