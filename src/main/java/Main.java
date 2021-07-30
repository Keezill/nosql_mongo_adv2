import dao.UserDao;
import entity.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user1 = new User("Bruce", "Smith", 25, "Bank", "London");
        User user2 = new User("Chip", "Skin", 31, "MCdonalds", "New-York");
        User user3 = new User("Forrest", "Green", 44, "BarberShop", "Sidney");
        User user = new User("Chipley", "Skinny", 32, "NIX", "New-York");

        // CRUD / Delete all
        userDao.deleteAllData();

        // CRUD / Create
        userDao.createData(user1, user2, user3);

        // CRUD / Read
        userDao.readAllData();

        // CRUD / Update
        userDao.readOneData(user2);
        userDao.updateData(user2, user);
        userDao.readOneData(user);

        // CRUD / Delete
        userDao.readAllData();
        userDao.deleteData(user3);
        userDao.readAllData();
    }
}
