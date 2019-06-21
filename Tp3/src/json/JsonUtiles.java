/*
 * To change this license header, choose License 
Headers in Project Properties.
 * To change this template file, choose Tools | 
Templates
 * and open the template in the editor.
 */
package json;

import base.Armor;
import base.Playable;
import base.Skill;
import base.Weapon;
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
    //La idea general para implementar Json es, cargar en un Json varios GameObject //(Enemigos, Skills, Weapons, Armors, etc), meter los JsonObects en un JsonArray de //cada tipo; y de ahí pasarlos a un Vector <GameObject> y que levante objetos por id //el juego según vaya necesitando


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
    

    public void guardarPartida(Playable player) {//pide por parametro el personaje que se está utilizando en la partida actualmente para poder guardar los datos que tiene en ese mismo momento en un json
        try {
            JSONObject gameStates = new JSONObject();
            JSONObject playableStates = new JSONObject();
            playableStates.put("id", player.getId());
            playableStates.put("name",
                    player.getName());
            playableStates.put("hp", player.getHp());
            playableStates.put("hp max",
                    player.getMaxHp());
            playableStates.put("mana",
                    player.getMana());
            playableStates.put("mana max",
                    player.getMaxMana());
            playableStates.put("dmg", player.getDmg());
            playableStates.put("dmg max",
                    player.getMaxDmg());
            playableStates.put("acc", player.getAcc());
            playableStates.put("dodge",
                    player.getDodge());
            playableStates.put("crit",
                    player.getCrit());
            playableStates.put("def", player.getDef());
            playableStates.put("xp", player.getXp());
            playableStates.put("lvl", player.getLvl());
            playableStates.put("xp max",
                    player.getXpMax());

            JSONArray playableSkills = new JSONArray();
            playableStates.put("skills",
                    playableSkills);
            JSONObject skill1 = new JSONObject();
            JSONObject skill2 = new JSONObject();
            JSONObject skill3 = new JSONObject();
            JSONObject skill4 = new JSONObject();
            skill1.put("id", player.vSkills.get(0).getId());
            skill1.put("name", player.vSkills.get(0).getName());
            skill1.put("dmg mod",
                    player.vSkills.get(0).getDmgMod());
            skill1.put("acc mod",
                    player.vSkills.get(0).getAccMod());
            skill1.put("crit mod",
                    player.vSkills.get(0).getCritMod());
            skill1.put("mana cost",
                    player.vSkills.get(0).getManaCost());
            skill1.put("status chance",
                    player.vSkills.get(0).getStatusChance());

            skill2.put("id", player.vSkills.get(1).getId());
            skill2.put("name", player.vSkills.get(1).getName());
            skill2.put("dmg mod",
                    player.vSkills.get(1).getDmgMod());
            skill2.put("acc mod",
                    player.vSkills.get(1).getAccMod());
            skill2.put("crit mod",
                    player.vSkills.get(1).getCritMod());
            skill2.put("mana cost",
                    player.vSkills.get(1).getManaCost());
            skill2.put("status chance",
                    player.vSkills.get(1).getStatusChance());

            skill3.put("id", player.vSkills.get(2).getId());
            skill3.put("name", player.vSkills.get(2).getName());
            skill3.put("dmg mod",
                    player.vSkills.get(2).getDmgMod());
            skill3.put("acc mod",
                    player.vSkills.get(2).getAccMod());
            skill3.put("crit mod",
                    player.vSkills.get(2).getCritMod());
            skill3.put("mana cost",
                    player.vSkills.get(2).getManaCost());
            skill3.put("status chance",
                    player.vSkills.get(2).getStatusChance());

            skill4.put("id", player.vSkills.get(3).getId());
            skill4.put("name", player.vSkills.get(3).getName());
            skill4.put("dmg mod",
                    player.vSkills.get(3).getDmgMod());
            skill4.put("acc mod",
                    player.vSkills.get(3).getAccMod());
            skill4.put("crit mod",
                    player.vSkills.get(3).getCritMod());
            skill4.put("mana cost",
                    player.vSkills.get(3).getManaCost());
            skill4.put("status chance",
                    player.vSkills.get(3).getStatusChance());

            playableSkills.put(0, skill1);
            playableSkills.put(1, skill2);
            playableSkills.put(2, skill3);
            playableSkills.put(3, skill4);

            JSONObject playableWeapon = new JSONObject();
            JSONObject playableArmor = new JSONObject();

            playableWeapon.put("id",
                    player.getWeapon().getId());
            playableWeapon.put("name",
                    player.getWeapon().getName());
            playableWeapon.put("dmg mod",
                    player.getWeapon().getDmgMod());
            playableWeapon.put("acc mod",
                    player.getWeapon().getAccMod());
            playableWeapon.put("crit mod",
                    player.getWeapon().getCritMod());

            playableStates.put("weapon",
                    playableWeapon);

            playableArmor.put("id", player.getArmor().getId());
            playableArmor.put("name",
                    player.getArmor().getName());
            playableArmor.put("dodge mod",
                    player.getArmor().getDodgeMod());
            playableArmor.put("def mod",
                    player.getArmor().getDefMod());

            playableStates.put("armor",
                    playableArmor);

            gameStates.put("playable",
                    playableStates);

            writeStates(gameStates);

        } catch (JSONException e) {

            e.printStackTrace();
        }
    }

    public Playable readPlayer() { //lee de un json ya guardado anteriormente los datos del personaje guardado y los carga en un nuevo objeto Playable y lo retrona Playable p = new Playable();
        Playable p=new Playable();
        try {
            String c = new String(Files.readAllBytes(Paths.get("partida.json")));
            JSONObject player = new JSONObject(c);
            p.setHp(player.getJSONObject("playable").getInt("hp"));
            p.setMana(player.getJSONObject("playable").getInt("mana"));
            p.setDmg(player.getJSONObject("playable").getInt("dmg"));
            p.setMaxDmg(player.getJSONObject("playable").getInt("dmg max"));
            p.setAcc(player.getJSONObject("playable").getInt("acc"));
            p.setDodge(player.getJSONObject("playable").getInt("dodge"));
            p.setCrit(player.getJSONObject("playable").getInt("crit"));
            p.setDef(player.getJSONObject("playable").getInt("def"));
            p.setXp(player.getJSONObject("playable").getInt("xp"));
            p.setLvl(player.getJSONObject("playable").getInt("lvl"));
            p.setXpMax(player.getJSONObject("playable").getInt("xp max"));
            p.setName(player.getJSONObject("playable").getString("name"));
            p.setId(player.getJSONObject("playable").getInt("id"));
            p.setMaxHp(player.getJSONObject("playable").getInt("hp max"));
            p.setMaxMana(player.getJSONObject("playable").getInt("mana max"));
            
            Skill s1 = new Skill();
            s1.setId(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("id"));
            s1.setName(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getString("name"));
            s1.setDmgMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("dmg mod"));
            s1.setAccMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("acc mod"));
            s1.setCritMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("crit mod"));
            s1.setManaCost(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("mana cost"));
            s1.setStatusChance(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("status chance"));
            p.addSkill(s1);

            Skill s2 = new Skill();
            s2.setId(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("id"));
            s2.setName(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getString("name"));
            s2.setDmgMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("dmg mod"));
            s2.setAccMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("acc mod"));
            s2.setCritMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("crit mod"));
            s2.setManaCost(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("mana cost"));
            s2.setStatusChance(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("status chance"));
            p.addSkill(s2);

            Skill s3 = new Skill();
            s3.setId(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("id"));
            s3.setName(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getString("name"));
            s3.setDmgMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("dmg mod"));
            s3.setAccMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("acc mod"));
            s3.setCritMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("crit mod"));
            s3.setManaCost(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("mana cost"));
            s3.setStatusChance(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("status chance"));
            p.addSkill(s3);

            Skill s4 = new Skill();
            s4.setId(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("id"));
            s4.setName(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getString("name"));
            s4.setDmgMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("dmg mod"));
            s4.setAccMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("acc mod"));
            s4.setCritMod(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("crit mod"));
            s4.setManaCost(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("mana cost"));
            s4.setStatusChance(player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("status chance"));
            p.addSkill(s4);

            Weapon w = new Weapon();
            w.setId(player.getJSONObject("playable").getJSONObject("weapon").getInt("id"));
            w.setName(player.getJSONObject("playable").getJSONObject("weapon").getString("name"));
            w.setDmgMod(player.getJSONObject("playable").getJSONObject("weapon").getInt("dmg mod"));
            w.setAccMod(player.getJSONObject("playable").getJSONObject("weapon").getInt("acc mod"));
            w.setCritMod(player.getJSONObject("playable").getJSONObject("weapon").getInt("crit mod"));
            p.setWeapon(w);

            Armor a = new Armor();
            a.setId(player.getJSONObject("playable").getJSONObject("armor").getInt("id"));
            a.setName(player.getJSONObject("playable").getJSONObject("armor").getString("name"));
            a.setDodgeMod(player.getJSONObject("playable").getJSONObject("armor").getInt("dodge mod"));
            a.setDefMod(player.getJSONObject("playable").getJSONObject("armor").getInt("def mod"));
            p.setArmor(a);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON Error");
            e.printStackTrace();
        }
      return p;      
    }

    public static void readPartida() { //lee de un json ya cargado los datos del personaje guardado y los devuelve en la consola con systems out
        try {
            String c = new String(Files.readAllBytes(Paths.get("partida.json")));
            JSONObject player = new JSONObject(c);
            System.out.println("Personaje" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getString("name"));
            System.out.println("Hp: "+player.getJSONObject("playable").getInt("hp"));
            System.out.println("Hp max: "+player.getJSONObject("playable").getInt("hp max"));
            System.out.println("Mana: "+player.getJSONObject("playable").getInt("mana"));
            System.out.println("Mana max: "+player.getJSONObject("playable").getInt("mana max"));
            System.out.println("Daño: "+player.getJSONObject("playable").getInt("dmg"));
            System.out.println("Daño max: "+player.getJSONObject("playable").getInt("dmg max"));
            System.out.println("Punteria: "+player.getJSONObject("playable").getInt("acc"));
            System.out.println("Evasion: "+player.getJSONObject("playable").getInt("dodge"));
            System.out.println("Critico: "+player.getJSONObject("playable").getInt("crit"));
            System.out.println("Defensa: "+player.getJSONObject("playable").getInt("def"));
            System.out.println("Experiencia: "+player.getJSONObject("playable").getInt("xp"));
            System.out.println("Experiencia max: "+player.getJSONObject("playable").getInt("xp max"));
            System.out.println("Nivel: "+player.getJSONObject("playable").getInt("lvl"));
            System.out.println("Arma" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONObject("weapon").getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONObject("weapon").getString("name"));
            System.out.println("Mod daño: "+player.getJSONObject("playable").getJSONObject("weapon").getInt("dmg mod"));
            System.out.println("Mod punteria: "+player.getJSONObject("playable").getJSONObject("weapon").getInt("acc mod"));
            System.out.println("Mod critico: "+player.getJSONObject("playable").getJSONObject("weapon").getInt("crit mod"));
            System.out.println("Armadura" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONObject("armor").getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONObject("armor").getString("name"));
            System.out.println("Mos evasion: "+player.getJSONObject("playable").getJSONObject("armor").getInt("dodge mod"));
            System.out.println("Mod defensa: "+player.getJSONObject("playable").getJSONObject("armor").getInt("def mod"));
            System.out.println("Habilidades" + "\n");
            System.out.println("Habilidad 1" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getString("name"));
            System.out.println("Mod daño: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("dmg mod"));
            System.out.println("Mod punteria: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("acc mod"));
            System.out.println("Mod critico: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("crit mod"));
            System.out.println("Costo de mana: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("mana cost"));
            System.out.println("Chance de generar un status: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(0).getInt("status chance"));
            System.out.println("Habilidad 2" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getString("name"));
            System.out.println("Mod daño:"+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("dmg mod"));
            System.out.println("Mod punteria: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("acc mod"));
            System.out.println("Mod critico: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("crit mod"));
            System.out.println("Costo de mana: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("mana cost"));
            System.out.println("Chance de generar un status: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(1).getInt("status chance"));
            System.out.println("Habilidad 3" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getString("name"));
            System.out.println("Mod daño: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("dmg mod"));
            System.out.println("Mod punteria: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("acc mod"));
            System.out.println("Mod critico: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("crit mod"));
            System.out.println("Costo de mana: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("mana cost"));
            System.out.println("Chance de generar un status: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(2).getInt("status chance"));
            System.out.println("Habilidad 4" + "\n");
            System.out.println("Id: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("id"));
            System.out.println("Nombre: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getString("name"));
            System.out.println("Mod daño: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("dmg mod"));
            System.out.println("Mod punteria: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("acc mod"));
            System.out.println("Mod critico: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("crit mod"));
            System.out.println("Costo de mana: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("mana cost"));
            System.out.println("Chance de generar un status: "+player.getJSONObject("playable").getJSONArray("skills").getJSONObject(3).getInt("status chance"));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON Error");
            e.printStackTrace();
        }
    }
}
