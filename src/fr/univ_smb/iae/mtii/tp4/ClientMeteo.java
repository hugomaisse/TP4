package fr.univ_smb.iae.mtii.tp4;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.Socket;
	import java.util.Scanner;

	/**
	 * Client qui va se connecter au serveur.
	 */
	public class ClientMeteo {
		
		private int port = 9090; // un attribut de type Entier (int) pour le numéro de port

		// Methode pour ouvrir une connexion (socket) avec le serveur
	    public Socket ouvrirConnexion(String ip) throws IOException {
	        Socket s = new Socket(ip, this.getPort()); // tentative de connexion au serveur
	        return s;
	    }
	 
	    public ClientMeteo(int p) {
	    	this.setPort(p);
	    }
	    
	    // Methode pour demander la météo au serveur
	    public String demanderMeteo(Socket socket) throws IOException {
	        BufferedReader input =
	            new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        String messageRecu = input.readLine();
	        return messageRecu;
	    }
	    
	    // Methode pour afficher sur la console Java le message recu du serveur
	    public void afficherMeteo(String msg) {
	    	System.out.println("============== Meteo recue du serveur ===============\n");
	    	System.out.println(msg); // on affiche ce que retourne le serveur (le messageRecu)
	    	System.out.println("================ Fin de l'avis météo ================\n");
	    }
	 
	    /**
	     * Le client est une application Java.
	     * Il demande à l'utilisateur de saisir l'adresse IP du serveur de météo 
	     * ou son nom (hostname).
	     * Ensuite, il se connecte à ce serveur et affiche ce qui lui retourne le serveur.
	     */
	    public static void main(String[] args) throws IOException {
	    	// On cree un client (au sens un objet de type Client qui va se connecter au serveur...
	    	ClientMeteo client = new ClientMeteo(9090);
	        String adresseDuServeur = client.demanderSaisieIP();
	        Socket socket = client.ouvrirConnexion(adresseDuServeur);
	        client.afficherMeteo(client.demanderMeteo(socket));
	        System.exit(0);
	    }
	    
	    // Methode pour demander à l'utilisateur de saisir l'adresse IP
	    // du serveur sous forme d'une chaîne de caractères
		public String demanderSaisieIP() {
			Scanner clavier = new Scanner(System.in);
			System.out.println("Saisir l'adresse IP du serveur météo (port 9090): ");
			String ip = clavier.next();
			return ip;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			if (port >= 8500 && port <= 9500) {// Intervalle de valeur autorisee du port 
				this.port = port;
				System.out.println("Le port a ete modifie. Il faudrait relancer le client !\n");
			}
			else
				System.out.println("Valeur non autorisee: le port n'a pas ete modifie.\n");
		}
	}
