
import Control.GestoreFinestra;
import Model.GestoreFile;
import View.Balcone;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cecconato Filippo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Balcone x=new Balcone();
        x.setVisible(true);
        x.setResizable(false);
        GestoreFile y=new GestoreFile();
        GestoreFinestra z=new GestoreFinestra(y, x);
    }
    
}
