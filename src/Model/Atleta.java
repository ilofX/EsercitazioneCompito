/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Cecconato Filippo
 */
public class Atleta implements Serializable, Comparable<Atleta>{
    String nome,cognome,nazione,tipoGara;
    int nPettorina;
    Double tempoPercorrenza;

    public Atleta(String nome, String cognome, String nazione, String tipoGara, int nPettorina) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazione = nazione;
        this.tipoGara = tipoGara;
        this.nPettorina = nPettorina;
        this.tempoPercorrenza = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazione() {
        return nazione;
    }

    public String getTipoGara() {
        return tipoGara;
    }

    public int getnPettorina() {
        return nPettorina;
    }

    public Double getTempoPercorrenza() {
        return tempoPercorrenza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public void setTipoGara(String tipoGara) {
        this.tipoGara = tipoGara;
    }

    public void setnPettorina(int nPettorina) {
        this.nPettorina = nPettorina;
    }

    public void setTempoPercorrenza(Double tempoPercorrenza) {
        this.tempoPercorrenza = tempoPercorrenza;
    }

    @Override
    public String toString() {
        return "Atleta{" + "nome=" + nome + ", cognome=" + cognome + ", nazione=" + nazione + ", tipoGara=" + tipoGara + ", nPettorina=" + nPettorina + ", tempoPercorrenza=" + tempoPercorrenza + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atleta other = (Atleta) obj;
        if (this.nPettorina != other.nPettorina) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.nazione, other.nazione)) {
            return false;
        }
        if (!Objects.equals(this.tipoGara, other.tipoGara)) {
            return false;
        }
        if (!Objects.equals(this.tempoPercorrenza, other.tempoPercorrenza)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Atleta o) {
        if(this.tempoPercorrenza > o.getTempoPercorrenza()){
            return 1;
        }
        else if(this.tempoPercorrenza < o.getTempoPercorrenza()){
            return -1;
        }
        else{
            return 0;
        }
    }
     
}
