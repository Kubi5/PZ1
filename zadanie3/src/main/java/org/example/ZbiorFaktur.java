package org.example;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;


/** Zbior faktur is a class which is being marshalled, it carry Faktura's set only */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Faktury")
public class ZbiorFaktur {

    @XmlElement(name = "Faktura")
    private ArrayList<Faktura> lista;

    public void setLista(ArrayList<Faktura> lista) {
        this.lista = lista;
    }

    public ArrayList<Faktura> getLista() {
        return lista;
    }
}
