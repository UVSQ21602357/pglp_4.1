package fr.uvsq.uvsq21600767;

import java.time.LocalDate;

public final class Personnel implements PersonnelInterface {
	private final String Nom;
	private final String Prenom;
	private final LocalDate DateDeNaissance;
	
	private final String NumeroTelephone;
	private final String Fonction;
	
	@Override
    public void print() {
        System.out.println(Nom + " " + Prenom);
    }
	
	public static class Builder {
		private final String Nom;
		private final String Prenom;
		private final LocalDate DateDeNaissance;
		
		private String NumeroTelephone = "00 00 00 00 00";
		private String Fonction = "Employé";
		
		public Builder(String nom, String Prenom) {
			this.Nom = nom;
			this.Prenom = Prenom;
			this.DateDeNaissance = LocalDate.now();
		}
		
		public Builder NumeroTelephone(String Num)
		{
			NumeroTelephone = Num;
			return this;
		}
		
		public Builder Fonction(String fonction)
		{
			Fonction = fonction;
			return this;
		}
		
		public Personnel build()
		{
			return new Personnel(this);
		}
		
		
	}
	
	private Personnel(Builder builder)
	{
		Prenom = builder.Prenom;
		Nom = builder.Nom;
		DateDeNaissance = builder.DateDeNaissance;
		Fonction = builder.Fonction;
		NumeroTelephone = builder.NumeroTelephone;
	}
	
	public static void main() {
		Personnel perso = new Personnel.Builder("Smith", "John").NumeroTelephone("06 66 66 66 66").build();
		System.out.println("Termine, num = "+perso.NumeroTelephone+", et nom et prenom sont: "+perso.Nom+" "+perso.Prenom);
	}
}
