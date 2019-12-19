package spring_rent_car.models.services;

import org.springframework.stereotype.Service;
import spring_rent_car.models.CarGarage;
import spring_rent_car.models.CarModel;
import spring_rent_car.models.UserPreferencesModel;

import java.util.List;

@Service
public class OptimalCarFounder {

    private List<CarModel> listOfPotentialCarsToRent;
    private int potentialLeftMoney;
    private int potentialTotalDailyCost;
    private int potentialDistanceCost;
    private CostCalculator costCalculator;
    private CarGarage carGarage;

    public List<CarModel> optimalCarsToRent(UserPreferencesModel userPreferencesModel){
        carGarage = new CarGarage();
        listOfPotentialCarsToRent = carGarage.getAvailableModels();
        costCalculator = new CostCalculator();
        for (int i = 0; i < listOfPotentialCarsToRent.size(); i++) {
            if (userPreferencesModel.getPassengerCapacity() > listOfPotentialCarsToRent.get(i).getPassengerCapacity()){
                listOfPotentialCarsToRent.remove(i);
                i--;
                continue;
            } else {
                potentialDistanceCost = costCalculator.totalDistanceCost(userPreferencesModel.getProximalDistance(),
                        listOfPotentialCarsToRent.get(i).getCostPer100Km(), listOfPotentialCarsToRent.get(i).getFuelConsumption());
                potentialTotalDailyCost = costCalculator.dailyTotalRentCost(userPreferencesModel.getRentDuration(),
                        listOfPotentialCarsToRent.get(i).getDailyCost());
                potentialLeftMoney = userPreferencesModel.getMoneyForRent() - potentialDistanceCost - potentialTotalDailyCost;
                if (potentialLeftMoney<0){
                    listOfPotentialCarsToRent.remove(i);
                    i--;
                    continue;
                }
            }
        }
        return listOfPotentialCarsToRent;
    }


}