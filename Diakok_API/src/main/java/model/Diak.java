package model;

import business.Tagozat;
import business.iDiak;

public class Diak implements iDiak {

    private String id;
    private String nev;
    private Integer kor;
    private Integer osztaly;
    private Tagozat tag;

    public Diak() {
    }

    public Diak(String nev, Integer kor, Integer osztaly) {
        this.nev = nev;
        this.kor = kor;
        this.osztaly = osztaly;
    }

    public Diak(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Integer getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(Integer osztaly) {
        this.osztaly = osztaly;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getKor() {
        return kor;
    }

    public void setKor(Integer kor) {
        this.kor = kor;
    }

    public Tagozat getTagozat() {
        return tag;
    }

    private void setTagozat(Tagozat tag) {
        this.tag = tag;
    }

    @Override
    public void tValaszto(Diak osztaly) {
        if (this.osztaly < 5) {
            this.setTagozat(Tagozat.Alsó);
        } else if (this.osztaly < 1 || this.osztaly > 8) {
            this.setTagozat(Tagozat.HIBAS_ERTEK);
        } else {
            this.setTagozat(Tagozat.Felső);
        }
    }

}
