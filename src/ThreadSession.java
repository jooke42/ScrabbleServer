import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ThreadSession implements Runnable {
	  private Joueur[] players;
	 private Plateau plateau=new Plateau();
	  
	  private Sac sac= new Sac();
	  // Continue to play
	  private boolean continueToPlay = true;
	 // Dictionary  dict=new Dictionary();
	  /** Construct a thread */
	  public ThreadSession(Joueur[] players){
	   this.players=players;   
	  }

	   
	   /** Implement the run() method for the thread */
	  public void run() {
		  for (Joueur joueur : this.players) {
				this.genererMain(7,joueur.getToClient());
			}
	    try {
while(this.sac.PasVide()){
				
				for (Joueur joueur : this.players) {
					
					
					Calendar limite =Calendar.getInstance();
					limite.add(Calendar.MINUTE, 1);
					Calendar now =  Calendar.getInstance();
					joueur.yourTurn(limite);
					
					while(limite.after(now)){
						 now =  Calendar.getInstance();
						 String response=joueur.getFromClient().readLine();
						 JSONParser parseur= new JSONParser();
						 JSONObject reponse =(JSONObject) parseur.parse(response);
						 int rep=(int) reponse.get("action");
						 switch (rep){
						 case 1 :
							 JSONArray motJoue = (JSONArray) reponse.get("mot");
							 int nbLettreJouer=0;
							 
							 ArrayList<Character> lettres= new ArrayList<Character>();
							 for (Object object : motJoue) {
					
										lettres.add((Character)object);
								nbLettreJouer++;
							}
							 genererMot(lettres);
							 break;
						 }
					}
					 
					for (Joueur joueurplateau : this.players) {
						//this.MiseAJourPlateau(7,joueurplateau.getToClient());
					}
					
				}
				
			}
	    	
	     

	    
	      
	     
	     
	        
	    }//end of try
	    catch(IOException ex) {
	      System.err.println(ex);
	    }//end of catch
	  }//end of run()



	   


	private void genererMot(ArrayList<Case> lettres) {
		Direction d;
		if(lettres.get(0).x==lettres.get(1).x){
			if(lettres.get(0).y>lettres.get(1).y){
				d=  Direction.GAUCHE;
			}else{
				d=  Direction.DROITE;
			}
			
		}else{
			if(lettres.get(0).x>lettres.get(1).x){
				d=  Direction.HAUT;
			}else{
				d=  Direction.BAS;
			}
			
		}
		for (int i = 0; i < lettres.size(); i++) {
			Case caseTemp=lettres.get(i);
			switch (d){
			case HAUT:
				plateau.cases[caseTemp.x][caseTemp.y].getContenu();
				break;
			case BAS:
				break;
			case DROITE:
				break;
			case GAUCHE:
				break;
			}
			caseTemp=lettres.get(i);
			
			
			
		}
		
		
	}
	private Case caseDebut(Direction d,Case first){
		if(d==Direction.HAUT){
			d=Direction.BAS;
		}
		return null;
		
	}


	private void sendMove(DataOutputStream out, tempTiles tile)
	      throws IOException {
	       out.writeInt(tile.geti());
	       out.writeInt(tile.getj());
	       out.writeChar(tile.getTile());
	  }


	  


	   private void genererMain(int stop,OutputStreamWriter out) throws PlusLettreSac, IOException{
		   		JSONObject main = new JSONObject();
		   		JSONArray array= new JSONArray();
	           
	            for(int i=0;i<stop;i++){
	        
	            	array.add(this.sac.randomGen());
	             
	            }
	           main.put("Lettres", array);
	           out.write(main.toString());
	           
	    }




	private boolean checkWord(String word)
	    {
	        if(dict.SearchDict(word))
	           return true;
	       return false;
	    }



	private int calcuScore(tempTiles[] tile,int stop)
	    {
	    int score =0;
	    for(int i=0 ; i<stop; i++)
	            {

	                if (tile[i].getMultiplier().equals("2") || tile[i].getMultiplier().equals("3"))
	            {
	                score += Integer.parseInt(tile[i].getMultiplier()) * LetterScore(tile[i].getTile());


	            }
	                else
	                {
	                    score  +=  LetterScore(tile[i].getTile());

	                }
	            }
	           for(int i=0; i<stop ;i++)
	           {
	              if (tile[i].getMultiplier().equals("4"))
	              {
	                  score*=2;

	              }
	              else if(tile[i].getMultiplier().equals("5"))
	              {
	                  score *=3;
	                  
	              }
	          }

	       return score;
	}



	private void sendScore(int score,DataOutputStream out1,DataOutputStream out2)throws IOException
	    {
	    out1.writeInt(score);
	    out2.writeInt(score);
	}
}


