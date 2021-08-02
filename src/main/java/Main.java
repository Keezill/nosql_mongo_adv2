import dao.AccountDao;
import dao.UserDao;
import entity.Account;
import entity.User;

import java.util.Arrays;
import java.util.List;

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

        userDao.deleteAllData();
        accountDao.deleteAllData();

        System.out.println("CRUD / Create");
        userDao.createData(user1, user2, user3);
        accountDao.createData(acc1, acc2, acc3, acc4);

        System.out.println("CRUD / Read");
        userDao.readAllData();
        userDao.readUserByName("Forrest");
        userDao.readUserByAge(44);
        accountDao.readAllData();
        accountDao.readAccountByName("ChipleyAcc");

        System.out.println("CRUD / Update");
        userDao.readUser(user2);
        userDao.updateData(user2, user);
        userDao.readUser(user);
        accountDao.readAccount(acc3);
        accountDao.updateData(acc3, acc5);
        accountDao.readAccount(acc5);

        System.out.println("CRUD / Delete");
        userDao.readAllData();
        userDao.deleteData(user1);
        userDao.readAllData();
        accountDao.readAllData();
        accountDao.deleteData(acc4);
        accountDao.readAllData();

        accountDao.bindAccToUser(acc2.getId(), user3.getId());
        accountDao.bindAccToUser(acc1.getId(), user3.getId());
        accountDao.bindAccToUser(acc3.getId(), user.getId());


        userDao.bindUserToAcc(user3.getId(), Arrays.asList(acc2.getId(), acc1.getId()));
        userDao.bindUserToAcc(user.getId(), Arrays.asList(acc3.getId()));

        userDao.findUserByManyAcc(2);
    }
}
