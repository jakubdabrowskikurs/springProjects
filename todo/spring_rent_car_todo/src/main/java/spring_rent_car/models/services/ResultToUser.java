package spring_rent_car.models.services;

import org.springframework.stereotype.Service;
import spring_rent_car.models.CarModel;
import spring_rent_car.models.ResultModel;
import spring_rent_car.models.UserPreferencesModel;

import java.util.List;

@Service
public class ResultToUser {

    private List<ResultModel> resultList;
    private int potentialTotalDailyCost;
    private int potentialDistanceCost;
    private CostCalculator costCalculator;

    public List<ResultModel> generateResults(List<CarModel> potentialCarsToRent, UserPreferencesModel userPreferencesModel){
        //todo implement first part of method

        for (int i = 0; i < potentialCarsToRent.size(); i++) {
            potentialDistanceCost = costCalculator.totalDistanceCost(userPreferencesModel.getProximalDistance(),
                    potentialCarsToRent.get(i).getCostPer100Km(), potentialCarsToRent.get(i).getFuelConsumption());
            potentialTotalDailyCost = costCalculator.dailyTotalRentCost(userPreferencesModel.getRentDuration(),
                    potentialCarsToRent.get(i).getDailyCost());
            resultList.add(new ResultModel(potentialCarsToRent.get(i), (potentialDistanceCost +
                    potentialTotalDailyCost), potentialCarsToRent.get(i).getDailyCost(), potentialCarsToRent.get(i).getCostPer100Km()));
        }

        //todo implement second part of the method

        return null;
    }

}
