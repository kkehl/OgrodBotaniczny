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
public class RoslinyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public RoslinyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Roslina> list(){
		String sql = "SELECT * FROM Rosliny";
		List<Roslina> listRosliny = 
			jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Roslina.class));
		return listRosliny;
	}
	
	
	public void save(Roslina roslina){
		System.out.println(roslina);
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("rosliny").usingColumns("gatunek","nazwa_naukowa","ilosc", "nr_sekcji");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(roslina);
		insertActor.execute(param);
	}
	
	
	public Roslina get(int nr_rosliny){
	    Object[] args = {nr_rosliny};
	    String sql = "SELECT * FROM ROSLINY WHERE nr_rosliny = " + args[0];
	    Roslina roslina = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Roslina.class));
	    return roslina;
	}
	
	
	public void update(Roslina roslina){
		String sql = "UPDATE ROSLINY SET gatunek=:gatunek, nazwa_naukowa=:nazwa_naukowa, ilosc=:ilosc, nr_sekcji=:nr_sekcji WHERE nr_rosliny=:nr_rosliny";
	    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(roslina);
	 
	    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
	    template.update(sql, param); 
	}
	
	public void delete(int nr_rosliny){
		String sql = "DELETE FROM ROSLINY WHERE nr_rosliny = " + String.valueOf(nr_rosliny);
		jdbcTemplate.update(sql);
	}
	
	

}
