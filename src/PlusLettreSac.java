
public class PlusLettreSac extends Exception {
	private char lettre;
	public PlusLettreSac(char lettre) {
		this.lettre=lettre;
	}
	@Override
	public String toString() {
		return "plus de lettre "+lettre+" dans le sac";
	}
}
