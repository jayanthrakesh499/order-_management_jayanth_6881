package dao;

import entity.Clothing;
import entity.Electronics;
import entity.Orders1;
import entity.Product;
import entity.User;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImp1 implements ProductService {
    // Your database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cc2";
    private static final String USER = "root";
    private static final String PASSWORD = "Password@1234";

    public Collection<Orders1> getOrderByUser1(int userId) {
        List<Orders1> orders = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Orders1 WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Orders1 order = new Orders1(
                                resultSet.getInt("orderId"),
                                resultSet.getInt("userId"),
                                resultSet.getInt("productId"),
                               
                                resultSet.getDouble("totalPrice"),
                                resultSet.getTimestamp("o_Date")
                        );
                        orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static void main(String[] args) {
        // Example usage
        OrderServiceImp1 orderService = new OrderServiceImp1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User ID to get orders:");
        int userId = scanner.nextInt();

        Collection<Orders1> orders = orderService.getOrderByUser(userId);

        if (orders.isEmpty()) {
            System.out.println("No orders found for the given User ID.");
        } else {
            System.out.println("Orders for User ID " + userId + ":");
            orders.forEach(System.out::println);
        }
    }


    public Orders1 getOrder(int orderId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Orders1 WHERE orderId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, orderId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Orders1(
                                resultSet.getInt("orderId"),
                                resultSet.getInt("userId"),
                                resultSet.getInt("productId"),
    
                                resultSet.getDate("o_Date").toLocalDate()
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Orders1> getOrdersByUser(int userId) {
        Collection<Orders1> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Orders1 WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Orders1 order = new Orders1(
                                resultSet.getInt("orderId"),
                                resultSet.getInt("userId"),
                                resultSet.getInt("productId"),
                              
                                resultSet.getDate("o_Date").toLocalDate()
                        );
                        orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders1> getAllOrders() {
        List<Orders1> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Orders1";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Orders1 order = new Orders1(
                                resultSet.getInt("orderId"),
                                resultSet.getInt("userId"),
                                resultSet.getInt("productId"),
                              
                                resultSet.getDate("o_Date").toLocalDate()
                        );
                        orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean updateOrder(Orders1 order) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "UPDATE Orders1 SET userId = ?, productId = ?, o_Date = ? WHERE orderId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, order.getUserId());
                statement.setInt(2, order.getProductId());
               
                statement.setDate(4, java.sql.Date.valueOf(order.getO_date()));
                statement.setInt(5, order.getOrderId());

                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOrder(int orderId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "DELETE FROM Orders1 WHERE orderId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, orderId);

                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean addProduct11(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateProduct1(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addProduct111(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addElectronics1(Electronics electronics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Electronics getElectronicsById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Electronics> getAllElectronics() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateElectronics1(Electronics electronics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteElectronics(int productId) {
		// TODO Auto-generated method stub
		
	}

	public void addClothing1(Clothing clothing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clothing getClothingById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clothing> getAllClothing() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateClothing1(Clothing clothing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClothing(int productId) {
		// TODO Auto-generated method stub
		
	}

	
	public void addUser1(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean updateUser1(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addOrder(Orders1 order) {
		// TODO Auto-generated method stub
		
	}

	
	public Orders1 getOrderById1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Iterable<Product> getOrderByUser1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean productExists(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userExists(int userId) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public User getUser(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Product> getOrdersByUsers1(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Orders1> getOrderByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProduct1(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addElectronics(Electronics electronics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateElectronics(Electronics electronics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClothing(Clothing clothing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClothing(Clothing clothing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Orders1 getOrderById(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Product> getOrderByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrder(Orders1 order) {
		// TODO Auto-generated method stub
		return false;
	}

    // Add other methods as needed

}

