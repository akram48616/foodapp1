package com.tap.checkoutimpl;

import java.sql.*;
import java.util.*;
import com.checkoutimpl.OrderDao;
import com.tap.checkout.order;

public class OrderImpl implements OrderDao { // Corrected names

    private Connection conn;

    public OrderImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insertOrder(order order) {
        String sql = "INSERT INTO `order` (userid, restaid, orderdate, totalamount, status, paymentmethod) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestId());
            ps.setTimestamp(3, order.getOrderDate());
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentMethod());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    order.setOrderId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public order getOrderById(int orderId) {
        String sql = "SELECT * FROM `order` WHERE orderid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapOrder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<order> getOrdersByUserId(int userId) {
        String sql = "SELECT * FROM `order` WHERE userid = ?";
        List<order> orders = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<order> getOrdersByRestaurantId(int restId) {
        String sql = "SELECT * FROM `order` WHERE restaid = ?";
        List<order> orders = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, restId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<order> getAllOrders() {
        String sql = "SELECT * FROM `order`";
        List<order> orders = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE `order` SET status = ? WHERE orderid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePaymentMethod(int orderId, String paymentMethod) {
        String sql = "UPDATE `order` SET paymentmethod = ? WHERE orderid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, paymentMethod);
            ps.setInt(2, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM `order` WHERE orderid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private order mapOrder(ResultSet rs) throws SQLException {
        return new order(
            rs.getInt("orderid"),
            rs.getInt("userid"),
            rs.getInt("restaid"),
            rs.getTimestamp("orderdate"),
            rs.getDouble("totalamount"),
            rs.getString("status"),
            rs.getString("paymentmethod")
        );
    }
}
