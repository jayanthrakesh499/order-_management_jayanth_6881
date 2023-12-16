package dao;

import entity.Clothing;
import entity.Electronics;
import entity.Orders1;
import entity.Product;
import entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public  class ProductServiceImp2 implements ProductService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cc2";
    private static final String USER = "root";
    private static final String PASSWORD = "Password@1234";
    private Scanner scanner = null;

    public ProductServiceImp2() {
        this.scanner = scanner;
    }
    @Override
    public boolean createUser(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "INSERT INTO User (userId, userName, password, role) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user.getUserId());
                statement.setString(2, user.getUsername());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getRole());

                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUser(int userId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM User WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new User(
                                resultSet.getInt("userId"),
                                resultSet.getString("userName"),
                                resultSet.getString("password"),
                                resultSet.getString("role")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<User> getAllUser() {
        Collection<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM User";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        User user = new User(
                                resultSet.getInt("userId"),
                                resultSet.getString("userName"),
                                resultSet.getString("password"),
                                resultSet.getString("role")
                        );
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "UPDATE User SET userName = ?, password = ?, role = ? WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getRole());
                statement.setInt(4, user.getUserId());

                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "DELETE FROM User WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("User deleted successfully.");
                    return true;
                } else {
                    System.out.println("User not found or deletion failed.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Iterable<Product> getOrdersByUsers1(int userId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT p.* FROM Orders o " +
                         "JOIN Product p ON o.productId = p.productId " +
                         "WHERE o.userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Product> orderedProducts = new ArrayList<>();
                    while (resultSet.next()) {
                        orderedProducts.add(new Product(
                                resultSet.getInt("productId"),
                                resultSet.getString("productName"),
                                resultSet.getString("description"),
                                resultSet.getDouble("price"),  // Corrected from (int) resultSet.getDouble("price")
                                resultSet.getInt("quantityInStock"),
                                resultSet.getString("type")
                        ));
                    }
                    return orderedProducts;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception appropriately
            return Collections.emptyList();  // Return an empty list in case of an exception
        }
    }

	public Collection<Orders1> getOrdersByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addProduct(Product product) {
		return false;
		// TODO Auto-generated method stub
		
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
	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addElectronics(Electronics electronics) {
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
	@Override
	public void updateElectronics(Electronics electronics) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteElectronics(int productId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addClothing(Clothing clothing) {
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
	@Override
	public void updateClothing(Clothing clothing) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteClothing(int productId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addUser(User user) {
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
	@Override
	public void addOrder(Orders1 order) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Orders1 getOrderById(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Orders1> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateOrder(Orders1 order) {
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean deleteOrder(int orderId) {
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	public Collection<Orders1> getOrderByUser(int userId) {
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
	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addProduct1(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean createOrder(Orders1 order) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Orders1 getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Product> getOrderByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}


