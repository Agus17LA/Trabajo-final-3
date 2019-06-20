/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import base.Playable;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Bian
 */
public class JsonUtiles {
    //La idea general para implementar Json es, cargar en un Json varios GameObject 
    //(Enemigos, Skills, Weapons, Armors, etc), meter los JsonObects en un JsonArray de 
    //cada tipo; y de ahí pasarlos a un Vector <GameObject> y que levante objetos por id 
    //el juego según vaya necesitando

    public static void writeStates(JSONObject o) {
        try {
            FileWriter file = new FileWriter("partida.json");
            file.write(o.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarPartida(Playable player) { //idea que se me ocurrio para implementar json con la cargada de partida
        try {
            JSONObject gameStates = new JSONObject();
            JSONObject playableStates = new JSONObject();
            playableStates.put("id", player.getId());
            playableStates.put("name", player.getName());
            playableStates.put("hp", player.getHp());
            playableStates.put("hp max", player.getMaxHp());
            playableStates.put("mana", player.getMana());
            playableStates.put("mana max", player.getMaxMana());
            playableStates.put("dmg", player.getDmg());
            playableStates.put("dmg max", player.getMaxDmg());
            playableStates.put("acc", player.getAcc());
            playableStates.put("dodge", player.getDodge());
            playableStates.put("crit", player.getCrit());
            playableStates.put("def", player.getDef());
            playableStates.put("xp", player.getXp());
            playableStates.put("lvl", player.getLvl());
            playableStates.put("xp max", player.getXpMax());
            playableStates.put("stun", player.isStunned());
            playableStates.put("poison", player.isPoisonned());
            playableStates.put("buff", player.isBuffed());

            JSONArray playableStatus = new JSONArray();
            playableStates.put("status", playableStatus);//ver como agregar status actuales
            /* boolean flag=player.isStunned();
            if(flag){
                playableStatus.put("duration",player.stun.);
            }*/
            JSONArray playableSkills = new JSONArray();
            playableStates.put("skills", playableSkills);
            JSONObject skill1 = new JSONObject();
            JSONObject skill2 = new JSONObject();
            JSONObject skill3 = new JSONObject();
            JSONObject skill4 = new JSONObject();
            skill1.put("id", player.vSkills.get(0).getId());
            skill1.put("name", player.vSkills.get(0).getName());
            skill1.put("dmg mod", player.vSkills.get(0).getDmgMod());
            skill1.put("acc mod", player.vSkills.get(0).getAccMod());
            skill1.put("crit mod", player.vSkills.get(0).getCritMod());
            skill1.put("mana cost", player.vSkills.get(0).getManaCost());
            skill1.put("status chance", player.vSkills.get(0).getStatusChance());

            skill2.put("id", player.vSkills.get(1).getId());
            skill2.put("name", player.vSkills.get(1).getName());
            skill2.put("dmg mod", player.vSkills.get(1).getDmgMod());
            skill2.put("acc mod", player.vSkills.get(1).getAccMod());
            skill2.put("crit mod", player.vSkills.get(1).getCritMod());
            skill2.put("mana cost", player.vSkills.get(1).getManaCost());
            skill2.put("status chance", player.vSkills.get(1).getStatusChance());

            skill3.put("id", player.vSkills.get(2).getId());
            skill3.put("name", player.vSkills.get(2).getName());
            skill3.put("dmg mod", player.vSkills.get(2).getDmgMod());
            skill3.put("acc mod", player.vSkills.get(2).getAccMod());
            skill3.put("crit mod", player.vSkills.get(2).getCritMod());
            skill3.put("mana cost", player.vSkills.get(2).getManaCost());
            skill3.put("status chance", player.vSkills.get(2).getStatusChance());

            skill4.put("id", player.vSkills.get(3).getId());
            skill4.put("name", player.vSkills.get(3).getName());
            skill4.put("dmg mod", player.vSkills.get(3).getDmgMod());
            skill4.put("acc mod", player.vSkills.get(3).getAccMod());
            skill4.put("crit mod", player.vSkills.get(3).getCritMod());
            skill4.put("mana cost", player.vSkills.get(3).getManaCost());
            skill4.put("status chance", player.vSkills.get(3).getStatusChance());

            playableSkills.put(0, skill1);
            playableSkills.put(1, skill2);
            playableSkills.put(2, skill3);
            playableSkills.put(3, skill4);

            JSONObject playableWeapon = new JSONObject();
            JSONObject playableArmor = new JSONObject();

            playableWeapon.put("id", player.getWeapon().getId());
            playableWeapon.put("name", player.getWeapon().getName());
            playableWeapon.put("weight", player.getWeapon().getWeight());
            playableWeapon.put("dmg mod", player.getWeapon().getDmgMod());
            playableWeapon.put("acc mod", player.getWeapon().getAccMod());
            playableWeapon.put("crit mod", player.getWeapon().getCritMod());
            
            playableStates.put("weapon",playableWeapon);

            playableArmor.put("id", player.getArmor().getId());
            playableArmor.put("name", player.getArmor().getName());
            playableArmor.put("weight", player.getArmor().getWeight());
            playableArmor.put("hp mod", player.getArmor().getHpMod());
            playableArmor.put("dodge mod", player.getArmor().getDodgeMod());
            playableArmor.put("def mod", player.getArmor().getDefMod());
            
            playableStates.put("armor",playableArmor);
            
            gameStates.put("playable", playableStates);

        } catch (JSONException e) {

            e.printStackTrace();
        }
    }

    public static void readWeapon() {
        try {
            String c = new String(Files.readAllBytes(Paths.get(" ")));
            JSONObject object = new JSONObject(c);

            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON Error");
            e.printStackTrace();
        }

    }

    public static void readArmor() {
        try {
            String c = new String(Files.readAllBytes(Paths.get(" ")));
            JSONObject object = new JSONObject(c);

            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    public Playable readPlayer() {
        Playable p = new Playable();
        try {
            String c = new String(Files.readAllBytes(Paths.get("partida.json")));
            JSONObject player = new JSONObject(c);
            p = new Playable(player.getInt("hp"), player.getInt("mana"),player.getInt("dmg"), player.getInt("dmg max"), player.getInt("acc"),player.getInt("dodge"),player.getInt("crit"),player.getInt("def"),
            player.getInt("xp"),player.getInt("lvl"),player.getInt("xp max"),player.getString("name"), player.getInt("id"));
            p.setMaxHp(player.getInt("hp max"));
            p.setMaxMana(player.getInt("mana max"));
            
            player.getInt("stun");
            player.getInt("poison");
            player.getInt("buff");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON Error");
            e.printStackTrace();
        }
        return p;  
    }

   /* public static void readPartida() {
        try {
            String c = new String(Files.readAllBytes(Paths.get("patida.json")));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON Error");
            e.printStackTrace();
        }
    }*/
}
