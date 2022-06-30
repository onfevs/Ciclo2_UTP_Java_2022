public class interes {
    public static void main(String[] args) {
        double pMonto = 13000;
        double pInteres = 1.4;
        int pTiempo = 60;
        double intS;
        double intC;
        double compI;

        intS = Math.round(pMonto * (pInteres / 100) * pTiempo);
        intC = Math.round(pMonto * (Math.pow(1 + pInteres / 100, pTiempo) - 1));
        compI = intC - intS;

        System.out.println(intS);
        System.out.println(intC);
        System.out.println("La diferencia entre la proyección de interés compuesto e interés simple es: " + compI);
    }
}
