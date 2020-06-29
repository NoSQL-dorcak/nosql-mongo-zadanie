package sk.upjs.nosql_mongo_zadanie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@ComponentScan(basePackages = "sk.upjs.nosql_mongo_zadanie")
@EnableMongoRepositories(basePackages = "sk.upjs.nosql_mongo_zadanie")
public class MongoConfig {
	private static final String HOST = "localhost"; 
	private static final int PORT = 27017; 
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE = "mydb";
	
	
	 public @Bean MongoClient getMongoClient() {
         String connectString = "mongodb://"  + USER + ":" + PASSWORD + "@" +  HOST + ":" + PORT;
         return MongoClients.create(connectString);
    }
	 
	 
	 public @Bean MongoTemplate mongoTemplate() {
	      return new MongoTemplate(getMongoClient(), DATABASE);
	  }
	 

}
