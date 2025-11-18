package com.checkoutimpl;

import java.util.List;
import com.tap.checkout.order;

public interface OrderDao { // Corrected name
    // Create
    boolean insertOrder(order order);

    // Read
    order getOrderById(int orderId);
    List<order> getOrdersByUserId(int userId);
    List<order> getOrdersByRestaurantId(int restId);
    List<order> getAllOrders();

    // Update
    boolean updateOrderStatus(int orderId, String status);
    boolean updatePaymentMethod(int orderId, String paymentMethod);

    // Delete
    boolean deleteOrder(int orderId);
}
