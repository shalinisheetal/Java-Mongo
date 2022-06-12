Feature: Testing MongoDB-Java integration
  Background:
    * def MongoJavaUtil = Java.type("MongoJavaUtil")
  Scenario: Checking connection to database

      * def obj = new MongoJavaUtil()
      * def mongoClient = obj.connect()