package mflix.lessons;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mflix.api.daos.TicketTest;
import org.bson.Document;

import java.io.IOException;

public abstract class AbstractLesson extends TicketTest {
  protected MongoDatabase db;
  protected MongoDatabase testDb;
  protected MongoCollection<Document> moviesCollection;

  public AbstractLesson() {
    try {
      String mongoUri = getProperty("spring.mongodb.uri"); //spring.mongodb.uri=mongodb+srv://m220student:m220password@mflix-5vhc6.mongodb.net/test
      String databaseName = getProperty("spring.mongodb.database"); //spring.mongodb.database=mflix
      db = MongoClients.create(mongoUri).getDatabase(databaseName);
      moviesCollection = db.getCollection("movies");
      testDb = MongoClients.create(mongoUri).getDatabase("testDb");

    } catch (IOException e) {
      this.db = null;
    }
  }
}
