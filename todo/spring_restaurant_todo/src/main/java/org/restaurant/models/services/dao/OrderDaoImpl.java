package org.restaurant.models.services.dao;

import org.restaurant.models.Meal;
import org.restaurant.models.OrderR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class OrderDaoImpl implements OrderDao {

    private List<OrderR> orderList;

    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<OrderR> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(OrderR order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(OrderR order) {
        for (OrderR order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(OrderR order, Meal meal) {
        //todo repair
        Set<Meal> ourMeals = (Set<Meal>) order.getMealList();
        ourMeals.add(meal);
        order.setMealList((List<Meal>)ourMeals);
    }

    @Override
    public void removeMealFromOrder(OrderR order, Meal meal) {
        //todo implement
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal){
        //todo repair
        for (int i = 0; i > order.getMealList().size(); i++) {
            if (order.getMealList().get(i).equals(meal)){
                return false;
            }
        }
        return true;
    }
}
