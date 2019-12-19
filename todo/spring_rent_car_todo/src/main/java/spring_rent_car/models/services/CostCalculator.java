package spring_rent_car.models.services;

import org.springframework.stereotype.Service;
import spring_rent_car.models.OverallManagement;

@Service
public class CostCalculator {

    public int dailyTotalRentCost(int userDailyRentTime, int carDailyRentTime){
        return userDailyRentTime * carDailyRentTime;
    }

    public int carAmortizationPer100Km(int proximalDistance, int carCostPer100Km){
        //todo implement method
        return 120;
    }

    public int costOfFuelConsumption(int proximalDistance, int carFuelConsumption){
        return ((carFuelConsumption * proximalDistance) / 100) * OverallManagement.getCostOfOneFuel() > 200 ?
                200 : ((carFuelConsumption * proximalDistance) / 100) * OverallManagement.getCostOfOneFuel();
    }

    public int totalDistanceCost(int proximalDistance, int carCostPer100Km, int carFuelConsumption){
        return carAmortizationPer100Km(proximalDistance, carCostPer100Km) + costOfFuelConsumption(proximalDistance, carFuelConsumption);
    }

    public int totalPodentialCost(int potentialTotalDistanceCost, int potentialTotalDailyCost){
        return potentialTotalDistanceCost + potentialTotalDailyCost;
    }
    }
