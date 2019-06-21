package base;

public class Messages {
	
	public Messages() {
		
	}
	//Error vida insuficiente
	public String hpError() {
		return "Error, vida insuficiente."+"\n";
	}
	//Error mana insuficiente
	public String manaError() {
		return "Error, mana insuficiente."+"\n";
	}
	//Error inventario, espacio insuficiente
	public String inventorySpaceError() {
		return "Error, no hay suficiente espacio en el inventario."+"\n";
	}
	//Error dodge insuficiente
	public String dodgeError() {
		return "Error, no hay suficientes puntos de dodge para realizar esa accion."+"\n";//dodge/esquive
	}
	//El personaje no puede subir mas de lvl porque ya esta en el lvl maximo
	public String lvlError() {
		return "No puede subir de nivel, ya se encuentra en el nivel maximo de personaje."+"\n";
	}
	//No puede subir de lvl, le falta ganar experiencia
	public String xpError() {
		return "No puede subir aun de nivel, experiencia: "+"\n";
	}
        //Error Json no encontrado para guardar en archivo
        public String jsonError(){
            return "No se ha guardado ninguna partida todavía"+"\n";
        }
}
