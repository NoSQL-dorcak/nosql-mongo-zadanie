package sk.upjs.nosql_mongo_zadanie;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import sk.upjs.nosql_mongo_zadanie.entity.MongoStudent;

public interface MongoDBRepository extends MongoRepository<MongoStudent, Long>{
	
    List<MongoStudent> findByPriezvisko(String priezvisko);
    List<MongoStudent> findAll();
    @Query(value="{ 'skratkaakadtitul' : ?0 }",
    		fields="{"
    		+ " 'meno' : 1,"
    		+ " 'priezvisko' : 1,"
    		+ " 'skratkaakadtitul' : 1,"
    		+ " }")
    List<MongoStudent> findNamesByAcademicTitle(String title);


}
