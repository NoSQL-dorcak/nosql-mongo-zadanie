package sk.upjs.nosql_mongo_zadanie;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sk.upjs.nosql_mongo_zadanie.entity.MongoStudent;


public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
    	MongoDBService service = context.getBean(MongoDBService.class);
    	service.fillDb();
    	List<MongoStudent> students = service.getAllStudents();
    	for (MongoStudent student : students) {
			System.out.println(student);
		}
    	service.printNamesByAcademicTitle("");
    }
}
