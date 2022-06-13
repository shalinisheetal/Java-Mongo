Feature: Testing MongoDB-Java integration
  Background:
    * def MongoJavaUtil = Java.type("MongoJavaUtil")
    * def obj = new MongoJavaUtil()
    * def mongoClient = obj.connectToDB()

    * def database = mongoClient.getDatabase("Employee")
    * def collection = database.getCollection("Employees")

  Scenario: Connection to database
      * print "Connected to MongoDB cluster successfully!"

  Scenario: Insertion into database
      * def emp =
    """
    {
      name: "Sonam",
      profile: "BA4",
      gender: "female",
      profile: "intern"
    }
    """
      * obj.insertIntoDB(collection, emp);