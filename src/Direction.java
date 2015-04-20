
public enum Direction {
	HAUT(-1,0), BAS(1,0), DROITE(0,1), GAUCHE(0,-1);
	private int x,y;
	Direction(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
