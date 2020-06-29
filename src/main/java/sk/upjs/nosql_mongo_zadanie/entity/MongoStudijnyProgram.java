package sk.upjs.nosql_mongo_zadanie.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;

import sk.upjs.nosql_data_source.entity.StudijnyProgram;

public class MongoStudijnyProgram implements Serializable {
	private static final long serialVersionUID = 911661511583476510L;
	private Long id;
	private String skratka;
	private String popis;
	
	


	public static MongoStudijnyProgram generateMongoStudijnyProgram(StudijnyProgram sp) {
		MongoStudijnyProgram program = new MongoStudijnyProgram();
		program.setPopis(sp.getPopis());
		program.setSkratka(sp.getSkratka());
		program.setId(sp.getId());
		return program;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkratka() {
		return skratka;
	}
	public void setSkratka(String skratka) {
		this.skratka = skratka;
	}
	public String getPopis() {
		return popis;
	}
	public void setPopis(String popis) {
		this.popis = popis;
	}
	@Override
	public String toString() {
		return "StudijnyProgram [id=" + id + ", skratka=" + skratka + ", popis=" + popis + "]";
	}	
}
