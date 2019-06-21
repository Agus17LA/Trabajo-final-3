package base;

/**
 * Clase de buff(modificacion de estadisticas) sus atributos indican el valor
 * que van a modificar del que lo reciba
 *
 * @author Juan
 */
public class Buff extends Status {

    private int dmgB;
    private int accB;
    private int dodgeB;
    private int critB;
    private int defB;
    private boolean active; //sirve para ver si es la primera vez aplicando el buff, se muestra mejor mas adelante
    private boolean buffed;

    /**
     * Constructor vacio, aunque crea un nuevo objeto este nunca va a usarse ya
     * que indica que la habildiad que lo tenga no tiene la capacidad de aplicar
     * este status Active se inicializa en false porque al momento de aplicarse
     * sobre un objetivo se clona este objeto y se lo pasa al objetivo,
     * necesitando que este este en "false" porque es un buff "nuevo". Se ve
     * mejor en la funcion statusTurn nunca tiene que inicializarse en true.
     */
    public Buff() {
        super();
        dmgB = 0;
        accB = 0;
        dodgeB = 0;
        critB = 0;
        defB = 0;
        active = false;
        buffed = false;
    }

    /**
     *
     * @param dmgB
     * @param accB
     * @param dodgeB
     * @param critB
     * @param defB
     * @param duration
     */
    public Buff(int dmgB, int accB, int dodgeB, int critB, int defB, int duration) {
        super(duration + 1);
        this.dmgB = dmgB;
        this.accB = accB;
        this.dodgeB = dodgeB;
        this.critB = critB;
        this.defB = defB;
        active = false;
        buffed = true;
    }

    /**
     * El constructor de clon sirve para a la hora de aplicar un status y
     * modificar su duracion la que se modifique no sea la duracion del objeto
     * original presente en la habilidad sino el objeto que va a formar parte
     * del vector de status de Character, sin esto el objeto status de la
     * habilidad quedaria en 0 permanentemente ya que le pasariamos una
     * referencia
     */
    public Buff(Buff b) {
        super(b.getDuration());
        this.dmgB = b.getDmgB();
        this.accB = b.getAccB();
        this.dodgeB = b.getDodgeB();
        this.critB = b.getCritB();
        this.defB = b.getDefB();
        active = false;
        buffed = true;
    }

    public int getDmgB() {
        return dmgB;
    }

    public void setDmgB(int dmgB) {
        this.dmgB = dmgB;
    }

    public int getAccB() {
        return accB;
    }

    public void setAccB(int accB) {
        this.accB = accB;
    }

    public int getDodgeB() {
        return dodgeB;
    }

    public void setDodgeB(int dodgeB) {
        this.dodgeB = dodgeB;
    }

    public int getCritB() {
        return critB;
    }

    public void setCritB(int critB) {
        this.critB = critB;
    }

    public int getDefB() {
        return defB;
    }

    public void setDefB(int defB) {
        this.defB = defB;
    }

    public boolean isBuffed() {
        return buffed;
    }

    public boolean isBuff() {
        return true;
    }

    /*la funcion principal de cada heredero de status, en un resumen lo que hace es que lleva a cabo la
   accion de la afliccion en un turno, y resta duracion en el proceso*/
    public String statusTurn(Character c) {
        String res = " ";

        super.statusTurn(c); //este metodo lo que hace simplemente es restarle 1 a duracion.

        if (getDuration() > 0) { //si todavia tiene duracion disponible surge el efecto del status
            res = "La modificacion esta activa. *";
            if (!active) {
                /*aca es donde entra en juego el boolean de la clase, si es false quiere decir que 
                 es la primera vez que se le aplica el buff al objetivo, por ende hay que aplicarselo*/
                active = true;// se pasa el boolean a true para que no vuelva a entrar en esta seccion del codigo
                c.setDmg(c.getDmg() + dmgB);//se aplican los buffs/debuffs
                c.setMaxDmg(c.getMaxDmg() + dmgB);
                c.setAcc(c.getAcc() + accB);
                c.setDodge(c.getDodge() + dodgeB);
                c.setCrit(c.getCrit() + critB);
                c.setDef(c.getDef() + defB);

            }

        } else {
            /*se accede a este else cuando la duracion del buff es 0, habiendo 
            rminado el mismo simplemente restamos lo anteriormente sumado*/
            c.setDmg(c.getDmg() - dmgB);
            c.setMaxDmg(c.getMaxDmg() - dmgB);
            c.setAcc(c.getAcc() - accB);
            c.setDodge(c.getDodge() - dodgeB);
            c.setCrit(c.getCrit() - critB);
            c.setDef(c.getDef() - defB);

            res = c.getName() + " ya no sufre una modificacion en sus estadisticas *";
        }
        return res;
        //tener en cuenta que si no tuvieramos el control de "active", el debuff simplemente se iria acumulando, lo cual no es la idea
    }

}
