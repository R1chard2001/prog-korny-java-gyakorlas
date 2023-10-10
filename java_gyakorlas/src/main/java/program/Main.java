package program;

import Gepkocsik.Allapot;
import Gepkocsik.Klima;
import Gepkocsik.Szemelygepkocsi;

public class Main {
    public static void main(String[] args) {
        Szemelygepkocsi szgk = new Szemelygepkocsi("ABC-001", 2021, 350000, Allapot.UJSZERU, 7, true, Klima.DIGITALIS_TOBBZONAS);
        System.out.println(szgk);
    }
}