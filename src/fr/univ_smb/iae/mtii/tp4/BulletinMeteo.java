package fr.univ_smb.iae.mtii.tp4;

	import java.util.Date;

	public class BulletinMeteo {
		private Date date_avis;
		private String zone_geo, avis;

		// Constructeur
		public BulletinMeteo() {
			// on initialise la date de l'avis avec la date courante au moment 
			// de la creation de l'objet
			this.date_avis = new Date(); 
		}

		// Constructeur 2
		public BulletinMeteo(String avis) {
			this(); // appel au constructeur sans parametre...qui initialise la date
			// on initialise l'avis
			this.setAvis(avis); 
		}

		public String getZone_geo() {
			return zone_geo;
		}

		public void setZone_geo(String zone_geo) {
			this.zone_geo = zone_geo;
		}

		public String getAvis() {
			return avis;
		}

		public void setAvis(String avis) {
			this.avis = avis;
		}
		
		// Cette methode retourne la representation d'objet 
		// (ici un objet de type BulletinMeteo) sous forme de chaine de
		// caracteres.
		// Cette methode est couramment utilisee et son nom bien connu 
		// en Java est toString()
		public String toString() {
			return "Bulletin meteo du " +
					this.date_avis.toString() +
					" - Avis : " +
					this.getAvis();
		}

	}

