package sk.upjs.nosql_mongo_zadanie.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;

import sk.upjs.nosql_data_source.entity.Studium;
public class MongoStudium implements Serializable {
	private static final long serialVersionUID = 8448542295643128028L;
	private Long id;
	private Long zaciatokStudia;
	private Long koniecStudia;
	private MongoStudijnyProgram studijnyProgram;
	
	public static MongoStudium generateMongoStudium(Studium studium) {
		MongoStudium ms = new MongoStudium();
		ms.setId(studium.getId());
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.mm.yyyy");
		try {
			ms.setZaciatokStudia(dateformat.parse(studium.getZaciatokStudia()).getTime());
			ms.setKoniecStudia(dateformat.parse(studium.getKoniecStudia()).getTime());
		} catch (ParseException e) {
			// ak sa datum neda parsovat resp je prazdny pokracujeme bez vyhodenia vynimky
		}
		ms.setStudijnyProgram(MongoStudijnyProgram.generateMongoStudijnyProgram(studium.getStudijnyProgram()));
		return ms;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getZaciatokStudia() {
		return zaciatokStudia;
	}
	public void setZaciatokStudia(Long zaciatokStudia) {
		this.zaciatokStudia = zaciatokStudia;
	}
	public Long getKoniecStudia() {
		return koniecStudia;
	}
	public void setKoniecStudia(Long koniecStudia) {
		this.koniecStudia = koniecStudia;
	}
	public MongoStudijnyProgram getStudijnyProgram() {
		return studijnyProgram;
	}
	public void setStudijnyProgram(MongoStudijnyProgram studijnyProgram) {
		this.studijnyProgram = studijnyProgram;
	}
	@Override
	public String toString() {
		return "Studium [id=" + id + ", zaciatokStudia=" + zaciatokStudia + ", koniecStudia=" + koniecStudia
				+ ", studijnyProgram=" + studijnyProgram + "]";
	}
}
