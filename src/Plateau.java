
public class Plateau {
	Sac sac;
	Case[][] cases=new Case[15][15];
	public Plateau() {
		this.sac=new Sac();
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				this.cases[x][y]=new Case(x,y,1);
			}
			
		}
	}
}
