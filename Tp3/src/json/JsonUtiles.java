/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

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

    public static void readWeapon() {
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

    public static void readArmor() {
        try {
            String c = new String(Files.readAllBytes(Paths.get("")));
            JSONObject object = new JSONObject(c);
            System.out.println("");
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e){
            System.out.println("Error");
            e.printStackTrace();
        }

    }
    
    public static void readEnemey() {
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
}
