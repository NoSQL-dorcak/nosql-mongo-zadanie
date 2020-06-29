package sk.upjs.nosql_mongo_zadanie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import sk.upjs.nosql_data_source.entity.Student;
import sk.upjs.nosql_data_source.persist.DaoFactory;
import sk.upjs.nosql_data_source.persist.StudentDao;
import sk.upjs.nosql_mongo_zadanie.entity.MongoStudent;

@Service
public class MongoDBService {

	@Autowired
	private StudentRepository repository;
	@Autowired
	private MongoTemplate template;

	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();

	public void fillDb() {
		repository.deleteAll();
		List<MongoStudent> students = new ArrayList<MongoStudent>();
		//staticke metody s menami generateMongoXYZ su vytvorene kvoli potrebe obist konstruktor, ktory sa repository snazil zavolat pri vytahovani z db 
		studentDao.getAll().stream().forEach(st -> students.add(MongoStudent.generateMongoStudent(st)));
		repository.saveAll(students);
	}

	public List<MongoStudent> getAllStudents() {
		List<MongoStudent> students = repository.findAll();
		return students;
	}

	public void printNamesByAcademicTitle(String title) {
		List<MongoStudent> students = repository.findNamesByAcademicTitle(title);
		students.forEach(item -> System.out
				.println(item.getSkratkaakadtitul() + " " + item.getMeno() + " " + item.getPriezvisko()));
	}
	

	public void printStudentsByYearAndStudProg(int year, String program) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.mm.yyyy");
		Date begining = null;
		Date next = null;
		try {
			begining = dateformat.parse("1.1." + year);
			next = dateformat.parse("1.1." + (year + 1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Long start = System.currentTimeMillis();
		List<MongoStudent> students = template
				.find(Query.query(new Criteria().andOperator(
						Criteria.where("studium.zaciatokStudia").lt(next),
						Criteria.where("studium.koniecStudia").gte(begining),
						Criteria.where("studium.studijnyProgram.skratka").is(program))
						), MongoStudent.class);
		Long end = System.currentTimeMillis() - start;
		students.forEach(item -> System.out.println(item));
		System.out.println("Trvanie dopytu: " + end + "ms");

	}
	
	public void name() {
		
	}

}
