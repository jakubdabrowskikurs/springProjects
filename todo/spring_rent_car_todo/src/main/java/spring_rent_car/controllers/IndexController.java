package spring_rent_car.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring_rent_car.models.services.OptimalCarFounder;
import spring_rent_car.models.services.ResultToUser;
import spring_rent_car.models.CarModel;
import spring_rent_car.models.ResultModel;
import spring_rent_car.models.UserPreferencesModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired OptimalCarFounder optimalCarFounder;
    @Autowired ResultToUser resultToUser;
    List<CarModel> potentialRentCarList;
    List<ResultModel> resultModelList;
    StringBuilder sb;

    @GetMapping("/") public String getIndex(Model model){
        model.addAttribute("userPreferencesModel", new UserPreferencesModel());
        return "index";
    }

    @PostMapping("/") public String postIndex(@ModelAttribute UserPreferencesModel userPreferencesModel, Model model){

        optimalCarFounder = new OptimalCarFounder();
        resultToUser = new ResultToUser();
        potentialRentCarList = new ArrayList<>();
        resultModelList = new ArrayList<>();
        sb = new StringBuilder();

        potentialRentCarList = optimalCarFounder.optimalCarsToRent(userPreferencesModel);
        resultModelList = resultToUser.generateResults(potentialRentCarList, userPreferencesModel);

        model.addAttribute("message1", "Your Criteria match those cars:");
        for (int i = 0; i < resultModelList.size(); i++) {
            sb.append("CAR MODEL: " + resultModelList.get(i).getCarModel().getModel() +
            ", TOTAL COST: $" + resultModelList.get(i).getTotalCost() +
            ", COST PER EXTRA DAY: $" + resultModelList.get(i).getExtraDayCost() +
            ", COST PER EXTRA 100KM: $" + resultModelList.get(i).getExtraDistanceCostPer100Km() + "****");
        }
        model.addAttribute("message2", sb.toString());

        return "index";
    }

}
