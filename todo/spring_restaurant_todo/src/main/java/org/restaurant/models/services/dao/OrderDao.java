package org.restaurant.models.services.dao;

import org.restaurant.models.Meal;
import org.restaurant.models.OrderR;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface OrderDao {

    List<OrderR> getAllOrders();

    void addOrder(OrderR order);

    void removeOrder(OrderR order);

    void addMealToOrder(OrderR order, Meal meal);

    void removeMealFromOrder(OrderR order, Meal meal);

    boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal);
}