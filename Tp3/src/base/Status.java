package base;

/**
 *Representa el estado, envenenado, aturdido etc.
 * @author Juan
 */
public abstract class Status { 
    protected int duration;
    
    

    /**
     * La forma en la que se implemente este metodo depende del tipo de status
     * @param c
     * @return 
     */
    public abstract String statusTurn(Character c);

    
}
