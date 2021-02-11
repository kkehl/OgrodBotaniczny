package bada_proj;

public class SekcjaOgrodu {
	private	int nr_sekcji;
	private String nazwa;
	private String typ;
	private String powierzchnia;
	private Number temperatura_powietrza;
	private Number wilgotnosc_powietrza;
	private String opis;
	
	
	public SekcjaOgrodu(int nr_sekcji, String nazwa, String typ, String powierzchnia, Number temperatura_powietrza,
			Number wilgotnosc_powietrza, String opis) {
		super();
		this.nr_sekcji = nr_sekcji;
		this.nazwa = nazwa;
		this.typ = typ;
		this.powierzchnia = powierzchnia;
		this.temperatura_powietrza = temperatura_powietrza;
		this.wilgotnosc_powietrza = wilgotnosc_powietrza;
		this.opis = opis;
	}

	public SekcjaOgrodu() {
	}

	public int getNr_sekcji() {
		return nr_sekcji;
	}

	public void setNr_sekcji(int nr_sekcji) {
		this.nr_sekcji = nr_sekcji;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getPowierzchnia() {
		return powierzchnia;
	}

	public void setPowierzchnia(String powierzchnia) {
		this.powierzchnia = powierzchnia;
	}

	public Number getTemperatura_powietrza() {
		return temperatura_powietrza;
	}

	public void setTemperatura_powietrza(Number temperatura_powietrza) {
		this.temperatura_powietrza = temperatura_powietrza;
	}

	public Number getWilgotnosc_powietrza() {
		return wilgotnosc_powietrza;
	}

	public void setWilgotnosc_powietrza(Number wilgotnosc_powietrza) {
		this.wilgotnosc_powietrza = wilgotnosc_powietrza;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "SekcjaOgrodu [nr_sekcji=" + nr_sekcji + ", nazwa=" + nazwa + ", typ=" + typ + ", powierzchnia="
				+ powierzchnia + ", temperatura_powietrza=" + temperatura_powietrza + ", wilgotnosc_powietrza="
				+ wilgotnosc_powietrza + ", opis=" + opis + "]";
	}
	
	
}