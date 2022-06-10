import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
public class MongoDataUtil {
        private String username;
        private String password;
        private String dbName;

        public MongoDataUtil(){
                this.username = "admin-shalini";
                this.password = "shalini";
                this.dbName = "Employee";
        }

        public static void main( String[] args ) {
                // uri string with your MongoDB deployment's connection string
                MongoDataUtil cred = new MongoDataUtil();
                String uri = "mongodb+srv://"+cred.username+":"+cred.password+"@cluster0.qlb4z.mongodb.net/?retryWrites=true&w=majority";
                try (MongoClient mongoClient = MongoClients.create(uri)) {
                        // access database
                        MongoDatabase database = mongoClient.getDatabase(cred.dbName);

                        // access collection
                        MongoCollection<Document> collection = database.getCollection("Employees");

                        // Create a document
                        Document doc = new Document("name", "Shalini")
                                        .append("profile", "BA4")
                                        .append("gender", "female")
                                        .append("age", 20);
                        // insert the created document
                        collection.insertOne(doc);

                        Document myDoc = collection.find(eq("name", "Shalini")).first();
                        System.out.println(myDoc.toJson());
                }
        }
}
