package org.restaurant.models.services.dao;

/**
 * Imports section
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restaurant.models.Meal;
import org.restaurant.models.OrderR;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    private static OrderDaoImpl orderDao;

    @BeforeClass public static void start() {
        orderDao = new OrderDaoImpl();
    }

    @AfterClass public static void stop() throws Exception {
        orderDao = null;
    }

    @Test public void testOrder() throws Exception {
        assertNotNull(orderDao.getAllOrders());
        assertEquals(orderDao.getAllOrders().size(), 0);
        OrderR newOrder = new OrderR();
        orderDao.addOrder(newOrder);
        assertEquals(orderDao.getAllOrders().size(), 1);
        orderDao.removeOrder(newOrder);
        assertEquals(orderDao.getAllOrders().size(), 0);
        orderDao.addOrder(newOrder);
        OrderR testOrder = orderDao.getAllOrders().get(0);
        assertEquals(testOrder.getMealList().size(), 0);
        Meal pizza = new Meal("Pizza", 22);
        orderDao.addMealToOrder(testOrder, pizza);
        assertEquals(testOrder.getMealList().size(), 1);
        orderDao.addMealToOrder(testOrder, pizza);
        assertEquals(testOrder.getMealList().size(), 2);
        orderDao.removeMealFromOrder(testOrder, pizza);
        assertEquals(testOrder.getMealList().size(), 1);
        assertTrue(orderDao.checkIfMealAppearInOurOrder(testOrder, pizza));
        orderDao.removeMealFromOrder(testOrder, pizza);
        assertFalse(orderDao.checkIfMealAppearInOurOrder(testOrder, pizza));
        assertFalse(orderDao.checkIfMealAppearInOurOrder(testOrder, new Meal()));
        orderDao.addMealToOrder(testOrder, null);
        assertEquals(testOrder.getMealList().size(), 1);
    }
}