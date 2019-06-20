
package base;

//otro status mas, ya esta explicado en buff y status
public class Poison extends Status{
    private int dmg;
    private boolean poisoned;
    
    
    public Poison(){
        super();
        dmg=0;
        poisoned=false; //esta funcion sirve para identificar si la habilidad aplica este estatus o no 
    }
    public Poison(int dmg,int duration){
        super(duration);
        this.dmg=dmg;
        this.poisoned=true;
    }
    public Poison(Poison poison){
        super(poison.getDuration());
        this.dmg=poison.dmg;
        this.poisoned=poison.isPoisoned();
        
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }
    
    @Override
    public boolean isPoison(){
        return true;
    }
    
    @Override
    public String statusTurn(Character c){
        String res=" "; 
            super.statusTurn(c);
            c.setHp(c.getHp()-dmg);
            /*el veneno es conocido como algo dañino por eso hace daño*/
                 res= c.getName() + " sufre "+dmg+ " de daño por veneno! *";          
        return res;
        
    }
   
}
