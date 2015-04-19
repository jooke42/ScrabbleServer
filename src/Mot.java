


public class Mot {
	
	private Direction direction;
	private Lettre [] lettres;
	
	public Mot(Lettre[] lettres,Direction direction) {
		this.direction=direction;
		this.lettres=lettres;
	}
	public Direction getDirection() {
		return direction;
	}
	public Lettre[] getLettres() {
		return lettres;
	}
	
}
