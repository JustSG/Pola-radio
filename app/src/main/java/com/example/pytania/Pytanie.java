package com.example.pytania;

public class Pytanie {
    private String tresc;
    private String[] tab;
    private int odpowiedzPoprawna;
    private boolean czyUdzielonoPoprawnejOdpowiedzi;

    public Pytanie(String tresc, String odpowiedzA, String odpowiedzB, String odpowiedzC, int odpowiedzPoprawna) {
        this.tresc = tresc;
        this.tab = new String[]{odpowiedzA, odpowiedzB, odpowiedzC};
        this.odpowiedzPoprawna = odpowiedzPoprawna;
        this.czyUdzielonoPoprawnejOdpowiedzi = false;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String[] getTab() {
        return tab;
    }

    public void setTab(String[] tab) {
        this.tab = tab;
    }

    public int getOdpowiedzPoprawna() {
        return odpowiedzPoprawna;
    }

    public void setOdpowiedzPoprawna(int odpowiedzPoprawna) {
        this.odpowiedzPoprawna = odpowiedzPoprawna;
    }

    public boolean isCzyUdzielonoPoprawnejOdpowiedzi() {
        return czyUdzielonoPoprawnejOdpowiedzi;
    }

    public void setCzyUdzielonoPoprawnejOdpowiedzi(boolean czyUdzielonoPoprawnejOdpowiedzi) {
        this.czyUdzielonoPoprawnejOdpowiedzi = czyUdzielonoPoprawnejOdpowiedzi;
    }

    void sprawdzOdpowiedz(int udzielona){
        if(odpowiedzPoprawna == udzielona){
            czyUdzielonoPoprawnejOdpowiedzi = true;
        }else{
            czyUdzielonoPoprawnejOdpowiedzi = false;
        }
    }
}
