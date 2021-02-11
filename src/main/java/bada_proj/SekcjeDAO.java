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
public class SekcjeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public SekcjeDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<SekcjaOgrodu> list(){
		String sql = "SELECT * FROM SEKCJE_OGRODU";
		List<SekcjaOgrodu> listSekcje = 
			jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(SekcjaOgrodu.class));
		return listSekcje;
	}
	
	
	public void save(SekcjaOgrodu sekcjaOgrodu){
		System.out.println(sekcjaOgrodu);
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("sekcje_ogrodu").usingColumns("nazwa","typ","powierzchnia","temperatura_powietrza","wilgotnosc_powietrza","opis");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sekcjaOgrodu);
		insertActor.execute(param);
	}
	
	
	public SekcjaOgrodu get(int nr_sekcji){
	    Object[] args = {nr_sekcji};
	    String sql = "SELECT * FROM SEKCJE_OGRODU WHERE nr_sekcji = " + args[0];
	    SekcjaOgrodu sekcjaOgrodu = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(SekcjaOgrodu.class));
	    return sekcjaOgrodu;
	}
	
	
	public void update(SekcjaOgrodu sekcjaOgrodu){
		String sql = "UPDATE SEKCJE_OGRODU SET nazwa=:nazwa, typ=:typ, powierzchnia=:powierzchnia, temperatura_powietrza=:temperatura_powietrza, wilgotnosc_powietrza=:wilgotnosc_powietrza, opis=:opis WHERE nr_sekcji=:nr_sekcji";
	    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sekcjaOgrodu);
	 
	    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
	    template.update(sql, param); 
	}
	
	public void delete(int nr_sekcji){
		String sql = "DELETE FROM SEKCJE_OGRODU WHERE nr_sekcji = " + String.valueOf(nr_sekcji);
		jdbcTemplate.update(sql);
	}
	
	

}
