package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaCSV {

    private String nazwaOdbiorcy;
    private String adresOdbiorcy;
    private String NIPOdbiorcy;
    private String dataWystawienia;
    private String dataSprzedazy;
    private String nrFaktury;
    private String tytulPozycji;
    private String liczbaSztuk;
    private String cenaJednostkowa;
    private String stawkaPodatku;
    private String kwotaPodatku;
    private String cenaNettopozycji;
    private String cenaBruttopozycji;
    private String cenaNettofakturylacznie;
    private String cenaBruttofakturylacznie;


    /*
    @XmlElement(name = "nazwaOdbiorcy")
    public void setnazwaOdbiorcy(String nazwaOdbiorcy) {
        this.nazwaOdbiorcy = nazwaOdbiorcy;
    }

    @XmlElement(name = "adresOdbiorcy")
    public void setadresOdbiorcy(String adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    @XmlElement(name = "NIPOdbiorcy")
    public void setNIPOdbiorcy(String NIPOdbiorcy) {
        this.NIPOdbiorcy = NIPOdbiorcy;
    }

    @XmlElement(name = "dataWystawienia")
    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    @XmlElement(name = "dataSprzedazy")
    public void setDataSprzedazy(String dataSprzedazy) {
        this.dataSprzedazy = dataSprzedazy;
    }

    @XmlElement(name = "nrFaktury")
    public void setNrFaktury(String nrFaktury){this.nrFaktury = nrFaktury;}

    @XmlElement(name = "tytulpozycji")
    public void setTytulPozycji(String tytulPozycji){this.tytulPozycji = tytulPozycji;}

    @XmlElement(name = "liczbaSztuk")
    public void setLiczbaSztuk(String liczbaSztuk){this.liczbaSztuk = liczbaSztuk;}

    @XmlElement(name = "cenaJednostkowa")
    public void setcenaJednostkowa(String cenaJednostkowa){this.cenaJednostkowa = cenaJednostkowa;}

    @XmlElement(name = "stawkaPodatku")
    public void setStawkaPodatku(String stawkaPodatku){this.stawkaPodatku = stawkaPodatku;}

    @XmlElement(name = "kwotaPodatku")
    public void setKwotaPodatku(String kwotaPodatku){this.kwotaPodatku = kwotaPodatku;}

    @XmlElement(name = "cenaNettopozycji")
    public void setCenaNettopozycji(String cenaNettopozycji){this.cenaNettopozycji = cenaNettopozycji;}

    @XmlElement(name = "cenaBruttopozycji")
    public void setCenaBruttopozycji(String cenaBruttopozycji){this.cenaBruttopozycji = cenaBruttopozycji;}

    @XmlElement(name = "cenaNettofakturylacznie")
    public void setCenaNettofakturylacznie(String cenaNettofakturylacznie){this.cenaNettofakturylacznie = cenaNettofakturylacznie;}

    @XmlElement(name = "cenaBruttofakturylacznie")
    public void setCenaBruttofakturylacznie(String cenaBruttofakturylacznie){this.cenaBruttofakturylacznie = cenaBruttofakturylacznie;}

     */
}