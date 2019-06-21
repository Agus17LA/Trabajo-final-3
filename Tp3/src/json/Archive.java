/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import base.Messages;
import base.Playable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Bian
 */
public class Archive {
/**
 * Este metodo se encarga de guardar un objeto (el recibido del json) en un archivo dat
 */
    public void writeFile() {

        try {
            File archive = new File("partida.json");
            if (archive.exists()) {//si el archivo json existe 
                FileOutputStream fo = new FileOutputStream("partida.dat");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                JsonUtiles j = new JsonUtiles();
                Playable p = new Playable();
                p = j.readPlayer();//se guarda en el objeto Playable, los datos levantados del json
                oo.writeObject(p);
                fo.close();
            } else {
                Messages m = new Messages();
                StringBuilder builder = new StringBuilder();
                builder.append(m.jsonError());
                System.out.println(builder.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
