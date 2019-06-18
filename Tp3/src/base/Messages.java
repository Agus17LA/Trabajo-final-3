package base;

public class Messages {
	
	public Messages() {
		
	}
	//Error vida insuficiente
	public void hpError() {
		System.out.println("Error, vida insuficiente."+"\n");
	}
	//Error mana insuficiente
	public void manaError() {
		System.out.println("Error, mana insuficiente."+"\n");
	}
	//Error inventario, espacio insuficiente
	public void inventorySpaceError() {
		System.out.println("Error, no hay suficiente espacio en el inventario."+"\n");
	}
	//Error dodge insuficiente
	public void dodgeError() {
		System.out.println("Error, no hay suficientes puntos de dodge para realizar esa accion."+"\n");//dodge/esquive
	}
	//El personaje no puede subir mas de lvl porque ya esta en el lvl maximo
	public void lvlError() {
		System.out.println("No puede subir de nivel, ya se encuentra en el nivel maximo de personaje."+"\n");
	}
	//No puede subir de lvl, le falta ganar experiencia
	public void xpError() {
		System.out.println("No puede subir aun de nivel, experiencia: ");
	}
}
