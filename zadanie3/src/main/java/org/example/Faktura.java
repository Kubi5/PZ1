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
public class Faktura {

    @XmlElement(name = "nazwaOdbiorcy")
    private String nazwaOdbiorcy;

    @XmlElement(name = "adresOdbiorcy")
    private String adresOdbiorcy;

    @XmlElement(name = "NIPOdbiorcy")
    private String NIPOdbiorcy;

    @XmlElement(name = "dataWystawienia")
    private String dataWystawienia;

    @XmlElement(name = "dataSprzedazy")
    private String dataSprzedazy;

    @XmlElement(name = "nrFaktury")
    private String nrFaktury;

    @XmlElement(name = "tytulpozycji")
    private String tytulPozycji;

    @XmlElement(name = "liczbaSztuk")
    private String liczbaSztuk;

    @XmlElement(name = "cenaJednostkowa")
    private String cenaJednostkowa;

    @XmlElement(name = "stawkaPodatku")
    private String stawkaPodatku;

    @XmlElement(name = "kwotaPodatku")
    private String kwotaPodatku;

    @XmlElement(name = "cenaNettopozycji")
    private String cenaNettopozycji;

    @XmlElement(name = "cenaBruttopozycji")
    private String cenaBruttopozycji;

    @XmlElement(name = "cenaNettofakturylacznie")
    private String cenaNettofakturylacznie;

    @XmlElement(name = "cenaBruttofakturylacznie")
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