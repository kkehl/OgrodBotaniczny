package bada_proj;


import java.sql.Date;


public class Pracownik {
	private int nr_pracownika;
	private String imie;
	private String nazwisko;
	private Date data_urodzenia;
	private String plec;
	private Date data_zatrudnienia;
	private String nr_konta;
	private String pesel;
	private String email;
	private String nr_telefonu;
	private String stanowisko;
	private Integer nr_sekcji;
	
	public Pracownik(int nr_pracownika, String imie, String nazwisko, Date data_urodzenia, String plec,
			Date data_zatrudnienia, String nr_konta, String pesel, String email, String nr_telefonu,
			String stanowisko, Integer nr_sekcji) {
		super();
		this.nr_pracownika = nr_pracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.data_zatrudnienia = data_zatrudnienia;
		this.nr_konta = nr_konta;
		this.pesel = pesel;
		this.email = email;
		this.nr_telefonu = nr_telefonu;
		this.stanowisko = stanowisko;
		this.nr_sekcji = nr_sekcji;
	}

	public Pracownik() {
	}

	public int getNr_pracownika() {
		return nr_pracownika;
	}

	public void setNr_pracownika(int nr_pracownika) {
		this.nr_pracownika = nr_pracownika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	

	public Date getData_urodzenia() {
		return data_urodzenia;
	}

	public void setData_urodzenia(Date data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}

	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	

	public Date getData_zatrudnienia() {
		return data_zatrudnienia;
	}

	public void setData_zatrudnienia(Date data_zatrudnienia) {
		this.data_zatrudnienia = data_zatrudnienia;
	}

	public String getNr_konta() {
		return nr_konta;
	}

	public void setNr_konta(String nr_konta) {
		this.nr_konta = nr_konta;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNr_telefonu() {
		return nr_telefonu;
	}

	public void setNr_telefonu(String nr_telefonu) {
		this.nr_telefonu = nr_telefonu;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Integer getNr_sekcji() {
		return nr_sekcji;
	}

	public void setNr_sekcji(Integer nr_sekcji) {
		this.nr_sekcji = nr_sekcji;
	}

	@Override
	public String toString() {
		return "Pracownik [nr_pracownika=" + nr_pracownika + ", imie=" + imie + ", nazwisko=" + nazwisko
				+ ", data_urodzenia=" + data_urodzenia + ", plec=" + plec + ", data_zatrudnienia=" + data_zatrudnienia
				+ ", nr_konta=" + nr_konta + ", pesel=" + pesel + ", email=" + email + ", nr_telefonu=" + nr_telefonu
				+ ", stanowisko=" + stanowisko + ", nr_sekcji=" + nr_sekcji + "]";
	}

	
}
