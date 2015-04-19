import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


import java.nio.charset.StandardCharsets;

import org.json.simple.*;


public class Joueur implements Runnable{
	
	private Socket clientSocket;
	private ObjectOutputStream outData;
	private BufferedReader in ;
	private PrintWriter out;
	private int score = 0;
			
	
	public Joueur(Socket clientSocket) {
		this.clientSocket=clientSocket;
		try {
			
			in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			out= new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),true);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void startTour(){
		
	}
	
	@Override
	public void run() {
	
			try {
				JSONObject json = new JSONObject();
				json.put("test", new Integer(5));
				
				
			OutputStreamWriter out = new OutputStreamWriter(this.clientSocket.getOutputStream(), StandardCharsets.UTF_8);
				    out.write(json.toString());
				
				
				String rep=in.readLine();
				Json.createObjectBuilder();
				System.out.println(rep);
				if(rep.length()==0){
					throw new Error("text null");
				}
				
				
				out.flush();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
	
		
		
	}
	
	
}
