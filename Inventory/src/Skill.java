
public class Skill extends GameObject {

	private int cost;
	private int cooldown;
	private int defenseMod;
	private int speedMod;
	private int accurrancyMod;
	private int damageMod;
	private int criticMod;

	public Skill() {
		super();
		cost = 0;
		cooldown = 0;
		defenseMod = 0;
		speedMod = 0;
		accurrancyMod = 0;
		damageMod = 0;
		criticMod = 0;
	}

	public Skill(int id, String name, int cost, int cooldown, int defenseMod, int speedMod, int accurrancyMod,
			int damageMod, int criticMod) {
		super(id, name);
		this.cost = cost;
		this.cooldown = cooldown;
		this.defenseMod = defenseMod;
		this.speedMod = speedMod;
		this.accurrancyMod = accurrancyMod;
		this.damageMod = damageMod;
		this.criticMod = criticMod;
	}

	public Skill(String name, int cost, int cooldown, int defenseMod, int speedMod, int accurrancyMod, int damageMod,
			int criticMod) {
		super(name);
		this.cost = cost;
		this.cooldown = cooldown;
		this.defenseMod = defenseMod;
		this.speedMod = speedMod;
		this.accurrancyMod = accurrancyMod;
		this.damageMod = damageMod;
		this.criticMod = criticMod;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
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

	public int getCriticMod() {
		return criticMod;
	}

	public void setCriticMod(int criticMod) {
		this.criticMod = criticMod;
	}

	public String toString() {
		return super.toString() + " Cost: " + getCost() + " Cooldown: " + getCooldown() + " turns Defense modifier: "
				+ getDefenseMod() + " Speed modifier: " + getSpeedMod() + " Accurrancy modifier: " + getAccurrancyMod()
				+ " Damage modifier: " + getDamageMod() + " Critic modifier: " + getCriticMod();
	}
}
