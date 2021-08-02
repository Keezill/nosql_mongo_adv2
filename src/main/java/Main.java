import dao.AccountDao;
import dao.UserDao;
import entity.Account;
import entity.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        User user1 = new User("Bruce", "Smith", 25, "Bank", "London");
        User user2 = new User("Chip", "Skin", 31, "MCdonalds", "New-York");
        User user3 = new User("Forrest", "Green", 44, "BarberShop", "Sidney");
        User user = new User("Chipley", "Skinny", 32, "NIX", "New-York");

        AccountDao accountDao = new AccountDao();

        Account acc1 = new Account("ForrestAcc1", "53524");
        Account acc2 = new Account("ForrestAcc2", "100000");
        Account acc3 = new Account("ChipleyAcc", "120");
        Account acc4 = new Account("BruceAcc", "200055");
        Account acc5 = new Account("ChipleyAcc2", "2000");

        // CRUD / Delete all
        userDao.deleteAllData();
        accountDao.deleteAllData();

        // CRUD / Create
        System.out.println("CRUD / Create");
        userDao.createData(user1, user2, user3);
        accountDao.createData(acc1, acc2, acc3, acc4);

        // CRUD / Read
        System.out.println("CRUD / Read");
        userDao.readAllData();
        userDao.readUserByName("Forrest");
        userDao.readUserByAge(44);
        accountDao.readAllData();
        accountDao.readAccountByName("ChipleyAcc");

        // CRUD / Update
        System.out.println("CRUD / Update");
        userDao.readUser(user2);
        userDao.updateData(user2, user);
        userDao.readUser(user3);
        accountDao.readAccount(acc3);
        accountDao.updateData(acc3, acc5);
        accountDao.readAccount(acc5);

        // CRUD / Delete
        System.out.println("CRUD / Delete");
        userDao.readAllData();
        userDao.deleteData(user3);
        userDao.readAllData();
        accountDao.readAllData();
        accountDao.deleteData(acc1);
        accountDao.readAllData();

        accountDao.bindAccToUser(acc2.getId(), user2.getId());
    }
}
