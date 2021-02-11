package bada_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class PracownicyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PracownicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Pracownik> list(){
		String sql = "SELECT * FROM Pracownicy";
		List<Pracownik> listPracownicy = 
			jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
		return listPracownicy;
	}
	
	
	public void save(Pracownik pracownik) throws Exception {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		System.out.println("PATRZ TUTAJ" + pracownik.getData_urodzenia());
		if(pracownik.getData_urodzenia().equals("") || pracownik.getData_zatrudnienia().equals("")){
			throw new Exception();
		}
		insertActor.withTableName("pracownicy").usingColumns(
				"imie",
				"nazwisko",
				"data_urodzenia",
				"plec",
				"data_zatrudnienia",
				"nr_konta",
				"pesel",
				"email",
				"nr_telefonu",
				"stanowisko",
				"nr_sekcji");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
		insertActor.execute(param);
	}
	
	
	public Pracownik get(int nr_pracownika){
	    Object[] args = {nr_pracownika};
	    String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika = " + args[0];
	    Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
	    return pracownik;
	}
	
	
	public void update(Pracownik pracownik){
		String sql = "UPDATE PRACOWNICY SET "
				+ "imie=:imie,"
				+ " nazwisko=:nazwisko,"
				+ " data_urodzenia=:data_urodzenia,"
				+ " plec=:plec,"
				+ " data_zatrudnienia=:data_zatrudnienia,"
				+ " nr_konta=:nr_konta,"
				+ " pesel=:pesel,"
				+ " email=:email,"
				+ " nr_telefonu=:nr_telefonu,"
				+ " stanowisko=:stanowisko,"
				+ " nr_sekcji=:nr_sekcji"
				+ " WHERE nr_pracownika=:nr_pracownika";
	    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
	 
	    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
	    template.update(sql, param); 
	}
	
	public void delete(int nr_pracownika){
		String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika = " + String.valueOf(nr_pracownika);
		jdbcTemplate.update(sql);
	}
	
}
