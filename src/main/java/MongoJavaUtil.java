import static com.mongodb.client.model.Filters.eq;

import cucumber.api.java.eo.Do;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class MongoJavaUtil {
        private String username;
        private String password;
        private String dbName;

        public MongoJavaUtil(){
                try{
                        Properties props = new Properties();
                        props.load(MongoJavaUtil.class.getClassLoader().getResourceAsStream("project.properties"));

                        this.username = props.getProperty("username");
                        this.password = props.getProperty("password");
                        this.dbName = props.getProperty("dbName");
                }
                catch(Exception e){
                        System.out.println(e);
                }
        }

        public MongoClient connectToDB(){
                String uri = "mongodb+srv://"+this.username+":"+this.password+"@cluster0.qlb4z.mongodb.net/?retryWrites=true&w=majority";

                MongoClient mongoClient = MongoClients.create(uri);
                //System.out.println("Connected to database successfully.");
                return mongoClient;
        }

        public void insertIntoDB(MongoCollection<Document> collection, LinkedHashMap<String, String> doc){
                Document document = new Document();
                for (Map.Entry<String, String> mapElement :
                        doc.entrySet()) {

                        String key = mapElement.getKey();
                        String value = mapElement.getValue();

                        document.append(key, value);
                }
                collection.insertOne(document);
        }
        public static void main( String[] args ) {
                // uri string with your MongoDB deployment's connection string
                // MongoJavaUtil cred = new MongoJavaUtil();
                //System.out.println(cred.username);

//                try () {
//                        // access database
//                        MongoDatabase database = mongoClient.getDatabase(cred.dbName);
//
//                        // access collection
//                        MongoCollection<Document> collection = database.getCollection("Employees");
//
//                        // Create a document
//                        Document doc = new Document("name", "Shalini")
//                                        .append("profile", "BA4")
//                                        .append("gender", "female")
//                                        .append("age", 20);
//                        // insert the created document
//                        collection.insertOne(doc);
//
//                        Document myDoc = collection.find(eq("name", "Shalini")).first();
//                        System.out.println(myDoc.toJson());
//                }
//                catch(Exception e){
//                        System.out.println(e);
//                }
        }
}
