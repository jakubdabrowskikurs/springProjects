package spring_rent_car.models.services;

import org.springframework.stereotype.Service;
import spring_rent_car.models.OverallManagement;

@Service
public class CarAmortization {

    public int dailyAmortization(int carValue){
        return carValue / (356 * OverallManagement.getCarExplorationPeriod()) > 10 ? carValue/(356 * OverallManagement.getCarExplorationPeriod()) : 10;
    }


    public int distanceAmortization(int carValue, int passengerCapacity, int fuelConsumption){
        return carValue / ((OverallManagement.getCarExplorationCostEvery100km()) * ((passengerCapacity + fuelConsumption) * 25));
    }



}
