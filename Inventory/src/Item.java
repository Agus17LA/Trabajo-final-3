
public class Item extends GameObject {

	private double weight;
	private int sellPrice;
	private int buyPrice;
	private int total;
	private int stackSize;

	public Item() {
		super();
		weight = 0;
		sellPrice = 0;
		buyPrice = 0;
		total = 0;
		stackSize = 0;
	}

	public Item(int id, String name, double weight, int sellPrice, int buyPrice, int total, int stackSize) {
		super(id, name);
		this.weight = weight;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.total = total;
		this.stackSize = stackSize;
	}

	public Item(String name, double weight, int sellPrice, int buyPrice, int total, int stackSize) {
		super(name);
		this.weight = weight;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.total = total;
		this.stackSize = stackSize;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStackSize() {
		return stackSize;
	}

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	public String toString() {
		return super.toString() + " Weight: " + getWeight() + " kg Sell price: $" + getSellPrice() + " Buy price: $"
				+ getBuyPrice() + " Total: " + getTotal() + " Stack size: " + getStackSize();
	}

}
