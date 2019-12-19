package spring_rent_car.models.bags;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spring_rent_car.models.services.OptimalCarFounder;
import spring_rent_car.models.services.ResultToUser;
import spring_rent_car.models.CarModel;
import spring_rent_car.models.ResultModel;
import spring_rent_car.models.UserPreferencesModel;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultToUserTest {

    private static ResultToUser resultToUser;
    private static OptimalCarFounder optimalCarFounder;

    @BeforeClass public static void start(){
        resultToUser = new ResultToUser();
        optimalCarFounder = new OptimalCarFounder();
    }

    @AfterClass public static void stop(){
        resultToUser = null;
        optimalCarFounder = null;
    }

    @Test public void testResult(){
        CarModel fiat500 = new CarModel("Fiat500", 2, 4, 50000);
        CarModel fiat124 = new CarModel("Fiat124p",  4, 8, 5000);
        CarModel clio = new CarModel("RenaultClio",  5, 5, 40000);
        CarModel vw = new CarModel("VWTouran",  7, 7, 90000);

        List<CarModel> potentialCarList = Arrays.asList(fiat500, fiat124, clio, vw);

        List<ResultModel> expectedResultList = Arrays.asList(
                new ResultModel(fiat500, 377, 28, 33),
                new ResultModel(fiat124,  245, 10, 1),
                new ResultModel(clio,  293, 22, 16),
                new ResultModel(vw,  500, 50, 25));

        List<ResultModel> resultList = resultToUser.generateResults(potentialCarList, new UserPreferencesModel(500, 4, 500, 1));
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i).getCarModel().getModel() + ", " + resultList.get(i).getTotalCost() + ", " +
                    resultList.get(i).getExtraDayCost()+ ", " + resultList.get(i).getExtraDistanceCostPer100Km());
        }
        testArray(resultList, expectedResultList);
    }

    public void testArray(List<ResultModel> actualList, List<ResultModel> expectedList){
        assertEquals(actualList.size(), expectedList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(actualList.get(i).getCarModel(), expectedList.get(i).getCarModel());
            System.out.println("Car model: " + actualList.get(i).getCarModel().getModel() + " : " + expectedList.get(i).getCarModel().getModel());
            assertEquals(actualList.get(i).getExtraDayCost(), expectedList.get(i).getExtraDayCost());
            System.out.println("Day Cost: " + actualList.get(i).getExtraDayCost() + " : " + expectedList.get(i).getExtraDayCost());
            assertEquals(actualList.get(i).getExtraDistanceCostPer100Km(), expectedList.get(i).getExtraDistanceCostPer100Km());
            System.out.println("Distance per 100 KM : " + actualList.get(i).getExtraDistanceCostPer100Km() + " : " + expectedList.get(i).getExtraDistanceCostPer100Km());
            assertEquals(actualList.get(i).getTotalCost(), expectedList.get(i).getTotalCost());
            System.out.println("Total Cost : " + actualList.get(i).getTotalCost() + " : " + expectedList.get(i).getTotalCost());
        }
    }

}