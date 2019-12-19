package spring_rent_car.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spring_rent_car.models.services.OptimalCarFounder;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OptimalCarFounderTest {

    private static OptimalCarFounder optimalCarFounder;

    @BeforeClass public static void start(){
        optimalCarFounder = new OptimalCarFounder();
    }

    @AfterClass public static void stop(){
        optimalCarFounder = null;
    }

    @Test public void testRentLogic(){
        assertNotNull(new OptimalCarFounder().optimalCarsToRent(new UserPreferencesModel(1000, 3, 100, 5)));

        List<CarModel> actualList = new OptimalCarFounder().optimalCarsToRent(new UserPreferencesModel(100, 3, 100, 3));
        List<CarModel> expectedList = Arrays.asList(new CarModel("Fiat124p",  4, 8, 5000));
        testArray(actualList, expectedList);

        actualList = new OptimalCarFounder().optimalCarsToRent(new UserPreferencesModel(500, 4, 500, 1));
        expectedList = Arrays.asList(new CarModel("Fiat500", 2, 4, 50000),
                new CarModel("Fiat124p",  4, 8, 5000),
                new CarModel("RenaultClio",  5, 5, 40000),
                new CarModel("VWTouran",  7, 7, 90000));
        testArray(actualList, expectedList);


        actualList = new OptimalCarFounder().optimalCarsToRent(new UserPreferencesModel(5000, 30, 10000, 5));
        expectedList = Arrays.asList(new CarModel("RenaultClio",  5, 5, 40000),
                new CarModel("VWTouran",  7, 7, 90000));
        testArray(actualList, expectedList);

        actualList = new OptimalCarFounder().optimalCarsToRent(new UserPreferencesModel(10000, 300, 8000, 3));
        expectedList = Arrays.asList(new CarModel("Fiat124p",  4, 8, 5000),
                new CarModel("RenaultClio",  5, 5, 40000));
        testArray(actualList, expectedList);

//        UserPreferencesModel userPreferencesModel = new UserPreferencesModel(5000, 30, 10000, 5);
//        List<CarModel> models = optimalCarFounder.optimalCarsToRent(userPreferencesModel);
//        models.forEach(e-> System.out.println(e.getModel()));

    }

    public void testArray(List<CarModel> actualList, List<CarModel> expectedList){
        assertEquals(actualList.size(), expectedList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(actualList.get(i).getModel(), expectedList.get(i).getModel());
        }
    }


}