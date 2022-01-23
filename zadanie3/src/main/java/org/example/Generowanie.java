package org.example;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Faktury")
public class Generowanie {

    @XmlElement(name = "Faktura")
    private ArrayList<Faktura> lista;

    public void setLista(ArrayList<Faktura> lista) {
        this.lista = lista;
    }

    public ArrayList<Faktura> getLista() {
        return lista;
    }
}

