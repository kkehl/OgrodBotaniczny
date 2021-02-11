package bada_proj;

public class Roslina {
	private int nr_rosliny;
	private String gatunek;
	private String nazwa_naukowa;
	private int ilosc;
	private int nr_sekcji;
	
	
	public Roslina() {
		
	}


	public Roslina(int nr_rosliny, String gatunek, String nazwa_naukowa, int ilosc, int nr_sekcji) {
		super();
		this.nr_rosliny = nr_rosliny;
		this.gatunek = gatunek;
		this.nazwa_naukowa = nazwa_naukowa;
		this.ilosc = ilosc;
		this.nr_sekcji = nr_sekcji;
	}


	public int getNr_rosliny() {
		return nr_rosliny;
	}


	public void setNr_rosliny(int nr_rosliny) {
		this.nr_rosliny = nr_rosliny;
	}


	public String getGatunek() {
		return gatunek;
	}


	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}


	public String getNazwa_naukowa() {
		return nazwa_naukowa;
	}


	public void setNazwa_naukowa(String nazwa_naukowa) {
		this.nazwa_naukowa = nazwa_naukowa;
	}


	public int getIlosc() {
		return ilosc;
	}


	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	
	public int getNr_sekcji() {
		return nr_sekcji;
	}


	public void setNr_sekcji(int nr_sekcji) {
		this.nr_sekcji = nr_sekcji;
	}


	@Override
	public String toString() {
		return "Roslina [nr_rosliny=" + nr_rosliny + ", gatunek=" + gatunek + ", nazwa_naukowa=" + nazwa_naukowa
				+ ", ilosc=" + ilosc + ", nr_sekcji=" + nr_sekcji + "]";
	}

	
}