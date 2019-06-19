package base;

//clase buff que vendria a significar una "modificacion temporal" de las estadisticas
public class Buff extends Status {

    private int dmgB;
    private int accB;
    private int dodgeB;
    private int critB;
    private int defB;
    private boolean active; //sirve para ver si es la primera vez aplicando el buff, se muestra mejor mas adelante
    private boolean buffed;

    public Buff() {
        super(); //como siempre, el constructor de gameObject
        dmgB = 0;
        accB = 0;
        dodgeB = 0;
        critB = 0;
        defB = 0;
        active = false;/*se inicializa en false porque al momento de aplicarse sobre un obvjetivo
        se clona este objeto y se lo pasa al objetivo, necesitando que este este en "false" porque es un 
        buff "nuevo". Se ve mejor en la funcion statusTurn NUNCA tiene que inicializarse en true*/
        buffed = false;
    }

    
    public Buff(int dmgB, int accB, int dodgeB, int critB, int defB, int duration) {
        super(duration + 1);//el +1 es por la forma en la que funcionan los buffs en este juego, llameselo mal diseño o que juan no sabe como hacer que ande sin el +1
        this.dmgB = dmgB;
        this.accB = accB;
        this.dodgeB = dodgeB;
        this.critB = critB;
        this.defB = defB;
        active = false;
        buffed = true;//al no ser un constructor vacio se supone que existe
    }
    /*el constructor de clon es CLAVE para que ande bien este programa, si no pasamos un clon lo
    que sucederia es que a la hora de ir restandole duracion al status de un objetivo, le estariamos 
    restando la duracion al objeto en si de la habilidad que lo uso, haciendo que permanentemente 
    quede en 0 la duracion*/

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

    //getters y setters
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

    /*la funcion principal de cada heredero de status, en un resumen lo que hace es que lleva a cabo la
   accion de la afliccion en un turno, y resta duracion en el proceso*/
    public String statusTurn(Character c) {
        String res = " "; //12/06 todavia no andan los buffs, tampoco me puse a ver porque

        super.statusTurn(c); //este metodo lo que hace simplemente es restarle 1 a duracion.

        if (getDuration() > 0) { //si todavia tiene duracion disponible surge el efecto del status
            res = "La modificacion esta activa.";
            if (!active) {
                System.out.println("JOJOOOOO");
                /*aca es donde entra en juego el boolean de la clase, si es false quiere decir que 
                 es la primera vez que se le aplica el buff al objetivo, por ende hay que aplicarselo*/
                active = true;// se pasa el boolean a true para que no vuelva a entrar en esta seccion del codigo
                c.setDmg(c.getDmg() + dmgB);//se aplican los buffs/debuffs
                c.setAcc(c.getAcc() + accB);
                c.setDodge(c.getDodge() + dodgeB);
                c.setCrit(c.getCrit() + critB);
                c.setDef(c.getDef() + defB);

            }

        } else { /*se accede a este else cuando la duracion del buff es 0, habiendo 
            rminado el mismo simplemente restamos lo anteriormente sumado*/
            c.setDmg(c.getDmg() - dmgB);
            c.setAcc(c.getAcc() - accB);
            c.setDodge(c.getDodge() - dodgeB);
            c.setCrit(c.getCrit() - critB);
            c.setDef(c.getDef() - defB);

            res = c.getName() + " ya no sufre una modificacion en sus estadisticas";
        }
        return res;
        //tener en cuenta que si no tuvieramos el control de "active", el debuff simplemente se iria acumulando, lo cual no es la idea
    }

}
