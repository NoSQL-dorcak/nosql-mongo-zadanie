package sk.upjs.nosql_mongo_zadanie.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import sk.upjs.nosql_data_source.entity.Student;
import sk.upjs.nosql_data_source.entity.Studium;

@Document("student")
public class MongoStudent implements Serializable{
	private static final long serialVersionUID = 5190927946812430075L;
	private Long id;
	private String meno;
	private String priezvisko;
	private char kodpohlavie;
	private String skratkaakadtitul;
	private List<MongoStudium> studium = new ArrayList<MongoStudium>();
	
	public static MongoStudent generateMongoStudent(Student student) {
		MongoStudent mst = new MongoStudent();
		mst.setId(student.getId());
		mst.setMeno(student.getMeno());
		mst.setPriezvisko(student.getPriezvisko());
		mst.setKodpohlavie(student.getKodpohlavie());
		mst.setSkratkaakadtitul(student.getSkratkaakadtitul());
		student.getStudium().forEach(st->mst.getStudium().add(MongoStudium.generateMongoStudium(st)));
		return mst;
		
	}
	@Override
	public String toString() {
		return "MongoStudent [id=" + id + ", meno=" + meno + ", priezvisko=" + priezvisko + ", kodpohlavie="
				+ kodpohlavie + ", skratkaakadtitul=" + skratkaakadtitul + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMeno() {
		return meno;
	}
	public void setMeno(String meno) {
		this.meno = meno;
	}
	public String getPriezvisko() {
		return priezvisko;
	}
	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}
	public char getKodpohlavie() {
		return kodpohlavie;
	}
	public void setKodpohlavie(char kodpohlavie) {
		this.kodpohlavie = kodpohlavie;
	}
	public String getSkratkaakadtitul() {
		return skratkaakadtitul;
	}
	public void setSkratkaakadtitul(String skratkaakadtitul) {
		this.skratkaakadtitul = skratkaakadtitul;
	}
	public List<MongoStudium> getStudium() {
		return studium;
	}
	public void setStudium(List<MongoStudium> studium) {
		this.studium = studium;
	}
	
	
}
