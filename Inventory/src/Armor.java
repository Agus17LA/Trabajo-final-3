
public class Armor extends Item {

	private int hitPointsMod;
	private int dodgeMod;
	private int defenseMod;
	private int speedMod;

	public Armor() {
		super();
		hitPointsMod = 0;
		dodgeMod = 0;
		defenseMod = 0;
		speedMod = 0;
	}

	public Armor(int id, String name, double weight, int sellPrice, int buyPrice, int total, int stackSize,
			int hitPointsMod, int dodgeMod, int defenseMod, int speedMod) {
		super(id, name, weight, sellPrice, buyPrice, total, stackSize);
		this.hitPointsMod = hitPointsMod;
		this.dodgeMod = dodgeMod;
		this.defenseMod = defenseMod;
		this.speedMod = speedMod;
	}

	public Armor(String name, double weight, int sellPrice, int buyPrice, int total, int stackSize, int hitPointsMod,
			int dodgeMod, int defenseMod, int speedMod) {
		super(name, weight, sellPrice, buyPrice, total, stackSize);
		this.hitPointsMod = hitPointsMod;
		this.dodgeMod = dodgeMod;
		this.defenseMod = defenseMod;
		this.speedMod = speedMod;
	}

	public int getHitPointsMod() {
		return hitPointsMod;
	}

	public void setHitPointsMod(int hitPointsMod) {
		this.hitPointsMod = hitPointsMod;
	}

	public int getDodgeMod() {
		return dodgeMod;
	}

	public void setDodgeMod(int dodgeMod) {
		this.dodgeMod = dodgeMod;
	}

	public int getDefenseMod() {
		return defenseMod;
	}

	public void setDefenseMod(int defenseMod) {
		this.defenseMod = defenseMod;
	}

	public int getSpeedMod() {
		return speedMod;
	}

	public void setSpeedMod(int speedMod) {
		this.speedMod = speedMod;
	}

	public String toString() {
		return super.toString() + " Hit Points modifier: " + getHitPointsMod() + " Dodge modifier: " + getDodgeMod()
				+ " Defense modifier: " + getDefenseMod() + " Speed modifier: " + getSpeedMod();
	}
}
