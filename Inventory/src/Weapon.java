
public class Weapon extends Item {

	private int damageMod;
	private int accurrancyMod;
	private int criticMod;

	public Weapon() {
		super();
		damageMod = 0;
		accurrancyMod = 0;
		criticMod = 0;
	}

	public Weapon(int id, String name, double weight, int sellPrice, int buyPrice, int total, int stackSize,
			int damageMod, int accurrancyMod, int criticMod) {
		super(id, name, weight, sellPrice, buyPrice, total, stackSize);
		this.damageMod = damageMod;
		this.accurrancyMod = accurrancyMod;
		this.criticMod = criticMod;
	}

	public Weapon(String name, double weight, int sellPrice, int buyPrice, int total, int stackSize, int damageMod,
			int accurrancyMod, int criticMod) {
		super(name, weight, sellPrice, buyPrice, total, stackSize);
		this.damageMod = damageMod;
		this.accurrancyMod = accurrancyMod;
		this.criticMod = criticMod;
	}

	public int getDamageMod() {
		return damageMod;
	}

	public void setDamageMod(int damageMod) {
		this.damageMod = damageMod;
	}

	public int getAccurrancyMod() {
		return accurrancyMod;
	}

	public void setAccurrancyMod(int accurrancyMod) {
		this.accurrancyMod = accurrancyMod;
	}

	public int getCriticMod() {
		return criticMod;
	}

	public void setCriticMod(int criticMod) {
		this.criticMod = criticMod;
	}

	public String toString() {
		return super.toString() + " Damage modifier: " + getDamageMod() + " Accurrancy modifier: " + getAccurrancyMod()
				+ " Critic modifier: " + getCriticMod();
	}
}
