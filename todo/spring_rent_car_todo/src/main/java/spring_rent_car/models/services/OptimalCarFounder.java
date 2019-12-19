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
        for (int i = 0; i < listOfPotentialCarsToRent.size(); i++) {
            if (userPreferencesModel.getPassengerCapacity() > listOfPotentialCarsToRent.get(i).getPassengerCapacity()){
                listOfPotentialCarsToRent.remove(i);
                i--;
                continue;
            } else {
                //todo implement method part, calculate: potentialDistanceCost, potentialTotalDailyCost and potentialLeftMoney
                potentialDistanceCost = 10;
                potentialTotalDailyCost = 10;
                potentialLeftMoney = 10;
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
