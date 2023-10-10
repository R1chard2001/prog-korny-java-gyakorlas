package Gepkocsik;

import java.util.Arrays;

public class Szemelygepkocsi extends Gepkocsi{
    public Szemelygepkocsi(String rendszam, int evjarat, int eredetiAr, Allapot allapot, int szallithatoSzemelyekSzama, boolean vanEVonohorog, Klima klima) throws RuntimeException {
        super(rendszam, evjarat, eredetiAr, allapot);
        setSzallithatoSzemelyekSzama(szallithatoSzemelyekSzama);
        setVanEVonohorog(vanEVonohorog);
        setKlima(klima);
    }
    public Szemelygepkocsi(String rendszam, int evjarat, int eredetiAr, int szallithatoSzemelyekSzama, boolean vanEVonohorog) throws RuntimeException {
        this(rendszam, evjarat, eredetiAr, Allapot.MEGKIMELT, szallithatoSzemelyekSzama, vanEVonohorog, Klima.DIGITALIS);
    }
    static int[] SZEMELYTOMB = {2, 4, 5, 7};
    int szallithatoSzemelyekSzama;

    public int getSzallithatoSzemelyekSzama() {
        return szallithatoSzemelyekSzama;
    }

    private void setSzallithatoSzemelyekSzama(int szallithatoSzemelyekSzama) {
        if (Arrays.stream(SZEMELYTOMB).noneMatch(x -> { return x == szallithatoSzemelyekSzama; }))
            throw new RuntimeException("Szállítható személyek száma 2, 4, 5 illetve 7 lehet!");
        this.szallithatoSzemelyekSzama = szallithatoSzemelyekSzama;
    }
    boolean vanEVonohorog;

    public boolean vanEVonohorog() {
        return vanEVonohorog;
    }
    public void setVanEVonohorog(boolean vanEVonohorog) {
        this.vanEVonohorog = vanEVonohorog;
    }
    Klima klima;

    public Klima getKlima() {
        return klima;
    }

    public void setKlima(Klima klima) {
        this.klima = klima;
    }

    @Override
    public int VetelAr() {
        int result = eredetiAr;
        double temp = 1;
        if (szallithatoSzemelyekSzama == 7)
            temp = 1.2;
        switch (allapot) {
            case UJSZERU ->
                    result = (int)(result * Math.pow(0.92 / temp, getKor()));
            case MEGKIMELT ->
                    result = (int)(result * Math.pow(0.91 / temp, getKor()));
            case SERULT ->
                    result = (int)(result * Math.pow(0.88 / temp, getKor()));
            case HIBAS ->
                    result = (int)(result * Math.pow(0.87 / temp, getKor()));
        }
        return result + getExtraAr();
    }

    @Override
    public int getExtraAr() {
        int result = 0;
        if (szallithatoSzemelyekSzama == 7)
            result += 100000;
        if (vanEVonohorog)
            result += 60000;
        switch (klima) {
            case MANUALIS ->
                result += 40000;
            case DIGITALIS ->
                result += 150000;
            case DIGITALIS_TOBBZONAS ->
                result += 350000;
            default -> {}
        }
        return super.getExtraAr() + result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nSzállítható személyek száma: "); sb.append(szallithatoSzemelyekSzama);
        sb.append("\nVan-e vonóhorog: "); sb.append(vanEVonohorog ? "van" : "nincs");
        sb.append("\nKlíma: "); sb.append(klima);
        return super.toString();
    }
}
