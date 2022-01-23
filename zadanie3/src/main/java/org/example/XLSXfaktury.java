package org.example;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Faktury")
public class XLSXfaktury {

    @XmlElement(name = "Faktura")
    private ArrayList<FakturaXLSX> lista;

    public void setLista(ArrayList<FakturaXLSX> lista) {
        this.lista = lista;
    }

    public ArrayList<FakturaXLSX> getLista() {
        return lista;
    }
}

