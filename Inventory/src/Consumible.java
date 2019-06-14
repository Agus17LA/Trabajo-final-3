
public class Consumible extends Item {

	private int hitPointsMod;
	private int defenseMod;
	private int manaMod;
	private boolean poison;
	private boolean stun;
	private int speedMod;
	private int accurrancyMod;
	private int damageMod;
	private int dodgeMod;
	private int criticMod;
	private int uses;

	public Consumible() {
		super();
		hitPointsMod = 0;
		defenseMod = 0;
		manaMod = 0;
		poison = false;
		stun = false;
		speedMod = 0;
		accurrancyMod = 0;
		damageMod = 0;
		dodgeMod = 0;
		criticMod = 0;
		uses = 0;
	}

	public Consumible(int id, String name, double weight, int sellPrice, int buyPrice, int total, int stackSize,
			int hitPointsMod, int defenseMod, int manaMod, boolean poison, boolean stun, int speedMod,
			int accurrancyMod, int damageMod, int dodgeMod, int criticMod, int uses) {
		super(id, name, weight, sellPrice, buyPrice, total, stackSize);
		this.hitPointsMod = hitPointsMod;
		this.defenseMod = defenseMod;
		this.manaMod = manaMod;
		this.poison = poison;
		this.stun = stun;
		this.speedMod = speedMod;
		this.accurrancyMod = accurrancyMod;
		this.damageMod = damageMod;
		this.dodgeMod = dodgeMod;
		this.criticMod = criticMod;
		this.uses = uses;
	}

	public Consumible(String name, double weight, int sellPrice, int buyPrice, int total, int stackSize,
			int hitPointsMod, int defenseMod, int manaMod, boolean poison, boolean stun, int speedMod,
			int accurrancyMod, int damageMod, int dodgeMod, int criticMod, int uses) {
		super(name, weight, sellPrice, buyPrice, total, stackSize);
		this.hitPointsMod = hitPointsMod;
		this.defenseMod = defenseMod;
		this.manaMod = manaMod;
		this.poison = poison;
		this.stun = stun;
		this.speedMod = speedMod;
		this.accurrancyMod = accurrancyMod;
		this.damageMod = damageMod;
		this.dodgeMod = dodgeMod;
		this.criticMod = criticMod;
		this.uses = uses;
	}

	public int getHitPointsMod() {
		return hitPointsMod;
	}

	public void setHitPointsMod(int hitPointsMod) {
		this.hitPointsMod = hitPointsMod;
	}

	public int getDefenseMod() {
		return defenseMod;
	}

	public void setDefenseMod(int defenseMod) {
		this.defenseMod = defenseMod;
	}

	public int getManaMod() {
		return manaMod;
	}

	public void setManaMod(int manaMod) {
		this.manaMod = manaMod;
	}

	public boolean getPoison() {
		return poison;
	}

	public void setPoison(boolean poison) {
		this.poison = poison;
	}

	public boolean getStun() {
		return stun;
	}

	public void setStun(boolean stun) {
		this.stun = stun;
	}

	public int getSpeedMod() {
		return speedMod;
	}

	public void setSpeedMod(int speedMod) {
		this.speedMod = speedMod;
	}

	public int getAccurrancyMod() {
		return accurrancyMod;
	}

	public void setAccurrancyMod(int accurrancyMod) {
		this.accurrancyMod = accurrancyMod;
	}

	public int getDamageMod() {
		return damageMod;
	}

	public void setDamageMod(int damageMod) {
		this.damageMod = damageMod;
	}

	public int getDodgeMod() {
		return dodgeMod;
	}

	public void setDodgeMod(int dodgeMod) {
		this.dodgeMod = dodgeMod;
	}

	public int getCriticMod() {
		return criticMod;
	}

	public void setCriticMod(int criticMod) {
		this.criticMod = criticMod;
	}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}

	public String toString() {
		return super.toString() + " HP modifier: " + getHitPointsMod() + " Defense modifier: " + getDefenseMod()
				+ " Mana modifier: " + getManaMod() + " Poison: " + getPoison() + " Stun: " + getStun()
				+ " Speed modifier: " + getSpeedMod() + " Accurrancy modifier: " + getAccurrancyMod()
				+ " Damage modifier: " + getDamageMod() + " Dodge modifier: " + getDodgeMod() + " Critic modifier: "
				+ getCriticMod() + " Uses: " + getUses();
	}

}
