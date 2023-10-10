package Gepkocsik;

import java.time.LocalDateTime;

public class Gepkocsi {
    private String rendszam;

    public String getRendszam() {
        return rendszam;
    }

    private static String BETUK = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String SZAMOK = "0123456789";
    private void setRendszam(String rendszam) {
        if (rendszam == null)
            throw new RuntimeException("Rendszám nem lehet null!");
        if (rendszam.length() != 7)
            throw new RuntimeException("Rendszámnak pontosan 7 karakternek kell lennie!");
        for (int i = 0; i < 3; i++) {
            if (!BETUK.contains(rendszam.substring(i, i+1)))
                throw new RuntimeException("Rendszám első három karaktere ékezetmentes nagybetűnek kell lennie!");
        }
        if (rendszam.charAt(3) != '-')
            throw new RuntimeException("A rendszám középső karaktere '-' karakternek kell lennie!");
        int cZeroes = 0;
        for (int i = 4; i < 7; i++) {
            if (!SZAMOK.contains(rendszam.substring(i, i+1)))
                throw new RuntimeException("Rendszám utolsó három karaktere számnak kell lennie!");
            if (rendszam.charAt(i) == '0')
                cZeroes++;
        }
        if (cZeroes >= 3)
            throw new RuntimeException("A rendszám utolsó három karaktere nem lehet csupa 0!");
        this.rendszam = rendszam;
    }

    int evjarat;

    public int getEvjarat() {
        return evjarat;
    }

    private void setEvjarat(int evjarat) {
        if (evjarat < 1950)
            throw new RuntimeException("Az évjárat nem lehet kisebb mint 1950!");
        int now = LocalDateTime.now().getYear();
        if (evjarat > now)
            throw new RuntimeException("Az évjárat nem lehet nagyobb mint " + now + "!");
        this.evjarat = evjarat;
    }
    int eredetiAr;

    public int getEredetiAr() {
        return eredetiAr;
    }

    private void setEredetiAr(int eredetiAr) {
        if (eredetiAr < 300000)
            throw new RuntimeException("Az eredeti ár nem lehet kisebb mint 300 000!");
        if (eredetiAr > 12000000)
            throw new RuntimeException("Az eredeti ár nem lehet nagyobb mint 12 000 000!");
        this.eredetiAr = eredetiAr;
    }
    Allapot allapot;

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }
    public int getKor() {
        return LocalDateTime.now().getYear() - evjarat;
    }

    public int getExtraAr() {
        if (getKor() <= 2 && allapot == Allapot.UJSZERU)
            return eredetiAr / 100 * 2;
        return 0;
    }

    public Gepkocsi(String rendszam, int evjarat, int eredetiAr, Allapot allapot) throws RuntimeException {
        setRendszam(rendszam);
        setEvjarat(evjarat);
        setEredetiAr(eredetiAr);
        setAllapot(allapot);
    }
    public Gepkocsi(String rendszam, int evjarat, int eredetiAr) throws RuntimeException {
        this(rendszam, evjarat, eredetiAr, Allapot.MEGKIMELT);
    }
    public int VetelAr() {
        int result = eredetiAr;
        switch (allapot) {
            case UJSZERU ->
                result = (int)(result *  Math.pow(0.91, getKor()));
            case MEGKIMELT ->
                result = (int)(result * Math.pow(0.90, getKor()));
            case SERULT ->
                result = (int)(result * Math.pow(0.89, getKor()));
            case HIBAS ->
                result = (int)(result * Math.pow(0.88, getKor()));
        }
        return result + getExtraAr();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        Gepkocsi other = (Gepkocsi) obj;
        return rendszam.equals(other.rendszam);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rendszám: "); sb.append(rendszam); sb.append("\n");
        sb.append("Évjárat: "); sb.append(evjarat); sb.append("\n");
        sb.append("Eredeti ár: "); sb.append(eredetiAr); sb.append("\n");
        sb.append("Állapot: "); sb.append(allapot); sb.append("\n");
        sb.append("Kor: "); sb.append(getKor()); sb.append("\n");
        sb.append("Extra ár: "); sb.append(getExtraAr()); sb.append("\n");
        sb.append("Vételár: "); sb.append(VetelAr());
        return sb.toString();
    }
}
