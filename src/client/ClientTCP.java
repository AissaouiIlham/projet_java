package client;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
	public static void main(String args[]) throws Exception {
		// Cr?ation d'un socket client et connexion avec un serveur fonctionnant sur la m?me machine et sur le port 40000
		Socket sc = new Socket("localhost", 40001);
		
		// Construction d'un BufferedReader pour lire du texte envoy? ? travers la connexion socket
		BufferedReader entreeSocket = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		// Construction d'un PrintStream pour envoyer du texte ? travers la connexion socket
		PrintStream sortieSocket = new PrintStream(sc.getOutputStream());
					
		String chaine = "";
		
		// Scanner sur System.in
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tapez vos phrases ou FIN pour arr?ter :");
					
		while(!chaine.equalsIgnoreCase("FIN")) {
			// lecture clavier
			chaine = scanner.nextLine();
			sortieSocket.println(chaine); // on envoie la chaine au serveur
			
			// lecture d'une chaine envoy?e ? travers la connexion socket
			chaine = entreeSocket.readLine();
			System.out.println("Chaine re?ue : "+chaine);
		}
		
		// on ferme nous aussi la connexion
		sc.close();
	}
}
