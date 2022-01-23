package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaXLSX {

    private String nazwaOdbiorcy;
    private String adresOdbiorcy;
    private String NIPOdbiorcy;
    private Date dataWystawienia;
    private Date dataSprzedazy;
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

}