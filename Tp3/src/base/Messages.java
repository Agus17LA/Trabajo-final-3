package base;
/**
 * Clase que contiene distintos mensajes de erro
 * @author Juan
 */
public class Messages {
	
	public Messages() {
		
	}
	/**
         * 
         * @return 
         */
	public String hpError() {
		return "Error, vida insuficiente."+"\n";
	}
	/**
         * 
         * @return 
         */
	public String manaError() {
		return "Error, mana insuficiente."+"\n";
	}
	/**
         * 
         * @return 
         */
	public String inventorySpaceError() {
		return "Error, no hay suficiente espacio en el inventario."+"\n";
	}
	/**
         * 
         * @return 
         */
	public String dodgeError() {
		return "Error, no hay suficientes puntos de dodge para realizar esa accion."+"\n";//dodge/esquive
	}
	/**
         * 
         * @return 
         */
	public String lvlError() {
		return "No puede subir de nivel, ya se encuentra en el nivel maximo de personaje."+"\n";
	}
	/**
         * 
         * @return 
         */
	public String xpError() {
		return "No puede subir aun de nivel, experiencia: "+"\n";
	}
        //Error Json no encontrado para guardar en archivo
        public String jsonError(){
            return "No se ha guardado ninguna partida todavía"+"\n";
        }
}
