package sk.upjs.nosql_mongo_zadanie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.upjs.nosql_data_source.entity.Student;
import sk.upjs.nosql_data_source.persist.DaoFactory;
import sk.upjs.nosql_data_source.persist.StudentDao;
import sk.upjs.nosql_mongo_zadanie.entity.MongoStudent;

@Service
public class MongoDBService {

	@Autowired
	private MongoDBRepository repository;

	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();

	public void fillDb() {
		repository.deleteAll();
		List<MongoStudent> students = new ArrayList<MongoStudent>();
		studentDao.getAll().stream().forEach(st->students.add(MongoStudent.generateMongoStudent(st)));;
		repository.saveAll(students);
	}

	public List<MongoStudent> getAllStudents() {
		List<MongoStudent> students = repository.findAll();
		return students;
	}

	public void printNamesByAcademicTitle(String title) {
		List<MongoStudent> students = repository.findNamesByAcademicTitle(title);
		students.forEach(item -> System.out
				.println(item.getSkratkaakadtitul() + " " + item.getMeno() + " " + item.getPriezvisko())
				);
	}

}
