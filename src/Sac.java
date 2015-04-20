
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Sac {
	
	private HashMap<Lettre, Integer>   alphabet=new HashMap<Lettre, Integer>();
	
	public Sac( ) {
		
		this.alphabet.put(new Lettre('A'), 9);
		this.alphabet.put(new Lettre('B'), 2);
		this.alphabet.put(new Lettre('C'), 2);
		this.alphabet.put(new Lettre('D'), 3);
		this.alphabet.put(new Lettre('E'), 15);
		this.alphabet.put(new Lettre('F'), 2);
		this.alphabet.put(new Lettre('G'), 2);
		this.alphabet.put(new Lettre('H'), 2);
		this.alphabet.put(new Lettre('I'), 8);
		this.alphabet.put(new Lettre('J'), 1);
		this.alphabet.put(new Lettre('K'), 1);
		this.alphabet.put(new Lettre('L'), 5);
		this.alphabet.put(new Lettre('M'), 3);
		this.alphabet.put(new Lettre('N'), 6);
		this.alphabet.put(new Lettre('O'), 6);
		this.alphabet.put(new Lettre('P'), 2);
		this.alphabet.put(new Lettre('Q'), 1);
		this.alphabet.put(new Lettre('R'), 6);
		this.alphabet.put(new Lettre('S'), 6);
		this.alphabet.put(new Lettre('T'), 6);
		this.alphabet.put(new Lettre('U'), 6);
		this.alphabet.put(new Lettre('V'), 2);
		this.alphabet.put(new Lettre('W'), 1);
		this.alphabet.put(new Lettre('X'), 1);
		this.alphabet.put(new Lettre('Y'), 1);
		this.alphabet.put(new Lettre('Z'), 1);
		
	}
	public void enleverLettre(char lettre) throws PlusLettreSac{
		
		if(!this.alphabet.containsKey(new Lettre(lettre))){
			
			throw new PlusLettreSac(lettre);
			
		}else{
			
			if(this.alphabet.get(new Lettre(lettre))==1){
				
				this.alphabet.remove(new Lettre(lettre));
				
			}else{
				
				int quantite=this.alphabet.get(new Lettre(lettre));
				quantite--;
				this.alphabet.put(new Lettre(lettre), quantite);
				
			}
		}
		
		
	}
	
public void ajouterLettre(char lettre) {
	int quantite=this.alphabet.get(new Lettre(lettre));
	quantite++;
	this.alphabet.put(new Lettre(lettre), quantite);
		
	}
	
	
	public void echangerLettre(char positionLettreRendu,char positionLettreADonner ) throws PlusLettreSac{
		this.enleverLettre(positionLettreADonner);
		this.ajouterLettre(positionLettreRendu);
		
	}
	public boolean PasVide() {
		return !this.alphabet.isEmpty();
	}
	
	 public  Lettre randomGen() throws PlusLettreSac
	    {
	            
		 Random       random    = new Random();
		 List<Lettre> keys      = new ArrayList<Lettre>(this.alphabet.keySet());
		 Lettre       randomKey = keys.get( random.nextInt(keys.size()) );
		 	enleverLettre(randomKey.getLettre());
	             return randomKey;
	            

	    }

}
