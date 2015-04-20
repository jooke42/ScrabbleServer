
public class Case {
	
	private int multiplicateur ;
	int x,y;
	private Lettre contenu=null;
	
	public Case(int x, int y, int multiplicateur) {
		this.x=x;
		this.y=y;
		this.multiplicateur=multiplicateur;
	}
	public void setContenu(Lettre contenu) {
		this.contenu = contenu;
	}
	public Lettre getContenu() {
		return contenu;
	}
}
