import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


import java.nio.charset.StandardCharsets;
import java.util.Calendar;

import org.json.simple.*;


public class Joueur{
	
	private Socket clientSocket;
	private OutputStreamWriter toClient;
	private BufferedReader fromClient ;
	private int score = 0;

	
	public Joueur(Socket clientSocket,int numJoueur) {
		this.clientSocket=clientSocket;
		try {
			this.clientSocket=clientSocket;
			this.toClient= new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8);
			this.fromClient =new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),StandardCharsets.UTF_8));
			JSONObject json = new JSONObject();
			json.put("position", numJoueur);
			toClient.write(json.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}


	public OutputStreamWriter getToClient() {
		return toClient;
	}


	public void setToClient(OutputStreamWriter toClient) {
		this.toClient = toClient;
	}


	public void yourTurn(Calendar limite) throws IOException {
		JSONObject yourTurn=new JSONObject();
		yourTurn.put("yourTurn", true);
		yourTurn.put("limite", limite);
		this.toClient.write(yourTurn.toString());
	}
public BufferedReader getFromClient() {
	return fromClient;
}
		
}
