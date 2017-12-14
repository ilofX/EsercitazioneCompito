/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Atleta;
import Model.GestoreFile;
import View.Balcone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cecconato Filippo
 */
public class GestoreFinestra implements ActionListener{
    GestoreFile file;
    Balcone balcon;

    public GestoreFinestra(GestoreFile file, Balcone balcon) {
        this.file = file;
        this.balcon = balcon;
        balcon.getjButton1().addActionListener(this);
        balcon.getjButton2().addActionListener(this);
        balcon.getjButton3().addActionListener(this);
        balcon.getjButton4().addActionListener(this);
        balcon.getjButton5().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==balcon.getjButton1()){
            if(file.controlla(Integer.parseInt(balcon.getjTextField4().getText()))){
                String a="";
                if(balcon.getjRadioButton1().isSelected()){
                   a="dilettantistica"; 
                }
                else if(balcon.getjRadioButton2().isSelected()){
                    a="mezza cogliona";
                }
                else if(balcon.getjRadioButton3().isSelected()){
                    a="maialona";
                }
                Atleta x= new Atleta(balcon.getjTextField1().getText(), balcon.getjTextField2().getText(), balcon.getjTextField3().getText(),a, Integer.parseInt(balcon.getjTextField4().getText()));
                file.inserimento(x);
            }
            else{
                JOptionPane.showMessageDialog(balcon, "La pettorina inserita esiste", "di errore di errore", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==balcon.getjButton2()){
            balcon.getjTable1().setModel(file.stampa(balcon.getjTextField5().getText()));
        }
        else if(e.getSource()==balcon.getjButton3()){
            if(!balcon.getjTextField6().getText().isEmpty()){
                file.modifica(balcon.getjTable2().getSelectedRow(), Double.parseDouble(balcon.getjTextField6().getText()));
            }
            else{
                JOptionPane.showMessageDialog(balcon, "Inserire un tempo da inserire", "di errore di errore", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==balcon.getjButton4()){
            balcon.getjTable2().setModel(file.stampa(""));
        }
        else if(e.getSource()==balcon.getjButton5()){
            String filtro="";
            if(balcon.getjRadioButton4().isSelected()){
                filtro="dilettantistica";
            }
            else if(balcon.getjRadioButton5().isSelected()){
                filtro="mezza cogliona";
            }
            else if(balcon.getjRadioButton6().isSelected()){
                filtro="maialona";
            }
            
            ArrayList<Atleta> a = file.lettura();
            Collections.sort(a);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Posizione");
            model.addColumn("Pettorina");
            model.addColumn("Nome");
            model.addColumn("Cognome");
            model.addColumn("Nazione");
            model.addColumn("Tipo di gara");
            model.addColumn("Tempo");
            for(int i=0;i<a.size();i++){
                if(a.get(i).getTipoGara().equals(filtro)){
                    model.addRow(new String[]{""+i,""+a.get(i).getnPettorina(),a.get(i).getNome(),a.get(i).getCognome(),a.get(i).getNazione(),a.get(i).getTipoGara(),a.get(i).getTempoPercorrenza().toString()});
                }
            }
            balcon.getjTable3().setModel(model);
        }
        else{
            JOptionPane.showMessageDialog(balcon, "COGLIONE HAI INSERITO", "ERRORE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
}
