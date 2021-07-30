package dao;

import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.User;
import org.bson.Document;
import utils.MongoUtils;

import java.util.Arrays;
import java.util.List;

public class UserDao {
    private final MongoDatabase database = connect("aLevel");

    public void createData(User... users) {
        for (User user : users) {
            final Document document = mapperFrom(user);
            MongoCollection<Document> userList = database.getCollection("users");
            List<Document> documents = Arrays.asList(document);
            userList.insertMany(documents);
        }
    }

    public void readAllData() {
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find();
        for (Document document : documents) {
            System.out.println(document);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void readOneData(User user) {
        final Document filter = new Document();
        filter.append("firstName", user.getFirstName());
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void updateData(User userToUpdate, User user) {
        final Document filter = new Document();
        filter.append("firstName", userToUpdate.getFirstName());

        final Document newData = new Document();
        newData.append("firstName", user.getFirstName());
        newData.append("lastName", user.getLastName());
        newData.append("age", user.getAge());
        newData.append("workplace", user.getWorkplace());
        newData.append("city", user.getCity());

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        MongoCollection<Document> users = database.getCollection("users");
        users.updateOne(filter, updateObject);
    }

    public void deleteData(User user) {
        final Document filter = new Document();
        filter.append("id", user.getId());

        MongoCollection<Document> users = database.getCollection("users");
        users.deleteOne(filter);
    }

    public void deleteAllData() {
        MongoCollection<Document> users = database.getCollection("users");
        users.deleteMany(new Document());
    }

    public static MongoDatabase connect(String databaseName) {
        return MongoUtils.getMongoClient(null).getDatabase(databaseName);
    }

    /*public static MongoDatabase connect(String databaseName, MongoCredential credential) {
        return MongoUtils.getMongoClient(credential).getDatabase(databaseName);
    }*/


    public static Document mapperFrom(User user) {
        final Document document = new Document();
        document.append("firstName", user.getFirstName());
        document.append("lastName", user.getLastName());
        document.append("age", user.getAge());
        document.append("workplace", user.getWorkplace());
        document.append("city", user.getCity());
        return document;
    }

    public static User mapperTo(Document document) {
        final User user = new User(
                document.get("firstName", String.class),
                document.get("lastName", String.class),
                document.get("age", Integer.class),
                document.get("workplace", String.class),
                document.get("city", String.class)
        );
        user.setId(document.get("_id", String.class));
        return user;
    }

}
