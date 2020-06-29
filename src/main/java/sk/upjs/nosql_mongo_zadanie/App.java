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
    	//naplnenie databazy
    	service.fillDb();
    	//otestovanie vytvorenia db - vypis studentov
    	List<MongoStudent> students = service.getAllStudents();
    	for (MongoStudent student : students) {
			System.out.println(student);
		}
    	//vypis podla akademickeho titulu, vytahovanie pomocou projekcie
    	service.printNamesByAcademicTitle("Mgr.");
    	//vypis podla roku a skratky studijneho programu
    	// - s indexom trval dopyt 10-12ms
    	// - bez indexu  dopyt 7-8ms
    	// - nakolko hladam podla skratky studijneho programu aj index je vytvoreny priamo na skratku
    	service.printStudentsByYearAndStudProg(2000, "MCH");
    	
    	context.close();
    }
}
