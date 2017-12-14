/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cecconato Filippo
 */
public class GestoreFile {
    File file;
    FileInputStream fInput;
    FileOutputStream fOut;
    ObjectInputStream in;
    ObjectOutputStream out;

    public GestoreFile() {
        file=new File("Atleti.dat");
    }
    
    public void inserimento(Atleta x){
        if(file.exists()){
            try {
                fOut=new FileOutputStream(file,true);
                out=new AppendObjectOutputStream(fOut);
            }   catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
             
            }   catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                fOut=new FileOutputStream(file);
                out=new ObjectOutputStream(fOut);
            }   catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        try {
            out.writeObject(x);
            fOut.close();
        } catch (IOException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public boolean controlla (int pettorina){
        boolean controllo=true;
        if(file.exists()){
            try {
                fInput=new FileInputStream(file);
            }   catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in=new ObjectInputStream(fInput);
            }   catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (controllo) {            
                try {
                    Atleta a = (Atleta)in.readObject();
                    if(a.getnPettorina()==pettorina){
                        controllo=false;
                    }
                } catch (IOException ex) {
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                fInput.close();
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return controllo;
    }

    public ArrayList<Atleta> lettura(){
        ArrayList<Atleta> ris = new ArrayList<>();
        if(file.exists()){
            try {
                fInput=new FileInputStream(file);
                in=new ObjectInputStream(fInput);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (true) {                
                try {
                    Atleta x=(Atleta)in.readObject();
                    ris.add(x);
                } catch (IOException ex) {
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                fInput.close();
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        return ris;
    }
    
    public DefaultTableModel stampa (String nazione){
        DefaultTableModel stampa=new DefaultTableModel();
        stampa.addColumn("Pettorina");
        stampa.addColumn("Nome");
        stampa.addColumn("Cognome");
        stampa.addColumn("Nazione");
        stampa.addColumn("Tipo di gara");
        stampa.addColumn("Tempo");
        if(file.exists()){
            try {
                fInput=new FileInputStream(file);
                in=new ObjectInputStream(fInput);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (true) {                
                try {
                    Atleta x=(Atleta)in.readObject();
                    if(x.getNazione().equals(nazione) || nazione.equals("")){
                        stampa.addRow(new String[]{""+x.getnPettorina(),x.getNome(),x.getCognome(),x.getNazione(),x.getTipoGara(),x.getTempoPercorrenza().toString()});
                    }
                } catch (IOException ex) {
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                fInput.close();
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stampa;
    }
    
    public void modifica(Integer index,Double tempo){
        File tempFile = new File("temp.dat");
        int i=0;
        if(file.exists()){
            try {
                this.fInput= new FileInputStream(file);
                this.in = new ObjectInputStream(fInput);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while(true){
                if(tempFile.exists()){
                    try {
                        this.fOut = new FileOutputStream(tempFile,true);
                        this.out = new AppendObjectOutputStream(fOut);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                    }       
                }
                else {
                    try {
                        this.fOut = new FileOutputStream(tempFile);
                        this.out = new ObjectOutputStream(fOut);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    if(i!=index){
                        out.writeObject(in.readObject());
                    }    
                    else{
                        Atleta a = (Atleta) in.readObject();
                        a.setTempoPercorrenza(tempo);
                        out.writeObject(a);
                    }
                    fOut.close();
                } catch (IOException ex) {
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
                }   
            i++;
            }
            try {
                fOut.close();
                fInput.close();
                file.delete();
                tempFile.renameTo(file);
            } catch (IOException ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } 
    }
    
    
}
