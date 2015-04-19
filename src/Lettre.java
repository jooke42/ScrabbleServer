
public class Lettre {
	
	private int valeur;
	private char lettre;
	
	
	public Lettre(char lettre) {
		this.lettre=lettre;
		switch(lettre){
		case 'A':
			this.valeur=1;
			break;
		case 'B':
			this.valeur=3;
			break;
		case 'C':
			this.valeur=3;
			break;
		case 'D':
			this.valeur=2;
			break;
		case 'E':
			this.valeur=1;
			break;
		case 'F':
			this.valeur=4;
			break;
		case 'G':
			this.valeur=2;
			break;
		case 'H':
			this.valeur=4;
			break;
		case 'I':
			this.valeur=1;
			break;
		case 'J':
			this.valeur=8;
			break;
		case 'K':
			this.valeur=10;
			break;
		case 'L':
			this.valeur=1;
			break;
		case 'M':
			this.valeur=2;
			break;
		case 'N':
			this.valeur=1;
			break;
		case 'O':
			this.valeur=1;
			break;
		case 'P':
			this.valeur=3;
			break;
		case 'Q':
			this.valeur=8;
			break;
		case 'R':
			this.valeur=1;
			break;
		case 'S':
			this.valeur=1;
			break;
		case 'T':
			this.valeur=1;
			break;
		case 'U':
			this.valeur=1;
			break;
		case 'V':
			this.valeur=4;
			break;
		case 'W':
			this.valeur=10;
			break;
		case 'X':
			this.valeur=10;
			break;
		case 'Y':
			this.valeur=10;
			break;
		case 'Z':
			this.valeur=10;
			break;
		}
	
	}
	public char getLettre() {
		return lettre;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	

}
