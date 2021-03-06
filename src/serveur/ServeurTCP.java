package serveur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {
	public static void main(String args[]) throws Exception {	
		
		// Cr?ation d'un socket serveur g?n?rique sur le port 40000
		ServerSocket ssg = new ServerSocket(40001);
		
		while(true) {
			// On attend une connexion puis on l'accepte
			Socket sss = ssg.accept();
			
			// Construction d'un BufferedReader pour lire du texte envoy? ? travers la connexion socket
			BufferedReader entreeSocket = new BufferedReader(new InputStreamReader(sss.getInputStream()));
			// Construction d'un PrintStream pour envoyer du texte ? travers la connexion socket
			PrintStream sortieSocket = new PrintStream(sss.getOutputStream());
			
			String chaine = "";
			
			while(chaine != null) {
				// lecture d'une chaine envoy?e ? travers la connexion socket
				chaine = entreeSocket.readLine();
				if (chaine != null)
				if(chaine.equalsIgnoreCase("ilham"))
					sortieSocket.println("siftili a ilham msg"); // on envoie la chaine au client
				
				// si elle est nulle c'est que le client a ferm? la connexion
				
					sortieSocket.println(chaine); // on envoie la chaine au client
			}
			
			// on ferme nous aussi la connexion
			sss.close();
		}
	}
}