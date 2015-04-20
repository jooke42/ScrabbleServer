import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Serveur implements Runnable{
	private Plateau plateau=new Plateau();
	private Joueur[] joueurs=new Joueur[3];
	public Serveur() {
		
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		Scanner lectureClavier = new Scanner(System.in);
		
		ObjectOutputStream outData;
		ServerSocket serveur;
		PrintWriter out;
		BufferedReader in;
		
		int nbJoueurConnecte = 0;
		int nbJoueurAttendu=0;
		
		do{
			System.out.println("Nombre de joueur ? (2 a 4)");
			nbJoueurAttendu=lectureClavier.nextInt();
		}while( nbJoueurAttendu>3 ||  nbJoueurAttendu<2);
			System.out.println("en attente de "+ nbJoueurAttendu +" joueurs");
			try {
				serveur=new ServerSocket(8888);
			
			for (nbJoueurConnecte = 0;nbJoueurConnecte<=nbJoueurAttendu;nbJoueurConnecte++) {
				Socket joueurSocket =serveur.accept();
				@SuppressWarnings("unused") //thread lancé dans le contructeur
				Joueur Joueur = new Joueur(joueurSocket, nbJoueurConnecte);
				this.joueurs[nbJoueurConnecte]=Joueur;
				System.out.println(nbJoueurConnecte+" / "+nbJoueurAttendu+ " sont connecte(s)");
			}
			System.out.println("Tous les joueurs sont connectes , debut de la partie");
			
			new ThreadSession(joueurs);
				
				
				
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
}
