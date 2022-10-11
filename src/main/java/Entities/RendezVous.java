package Entities;

public class RendezVous {
	private int id ; 
	private String date ; 
	private String heure ; 
	private String numTel ; 
	private Logement l ; 
	
	public RendezVous() {}

 

	public RendezVous(int id, String date, String heure, String numTel, Logement l) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.numTel = numTel;
		this.l = l;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	

	public Logement getL() {
		return l;
	}



	public void setL(Logement l) {
		this.l = l;
	}



	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", date=" + date + ", heure=" + heure + ", numTel=" + numTel + "]";
	} ;
	

}
