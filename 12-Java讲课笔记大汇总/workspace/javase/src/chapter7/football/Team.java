package chapter7.football;

public class Team extends Base {

	private int gf;
	private int ga;

	public Team(String name, int gf, int ga) {
		super(name);
		this.gf = gf;
		this.ga = ga;
	}

	@Override
	public int getScore() {

		if (gf > ga) {
			return 100 * 3 + 10 * (gf - ga) + gf;
		} else if (gf == ga) {
			return 100 * 1 + 10 * (gf - ga) + gf;
		} else {
			return 10 * (gf - ga) + gf;
		}

	}

}
