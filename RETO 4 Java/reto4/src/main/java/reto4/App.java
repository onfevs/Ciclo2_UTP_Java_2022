package reto4;

import reto4.view.ReportesView;

public class App {
    public static void main(String[] args) {
        System.out.println("Requerimiento 1");
        ReportesView reportesView = new ReportesView();
        String banco = "Conavi ";
        reportesView.proyectosFinanciadosPorBanco(banco);

        System.out.println("Requerimiento 2 ");
        ReportesView reportesView1 = new ReportesView();
        reportesView1.totalAdeudadoPorProyectosSuperioresALimite(50000.0);

        System.out.println("\nRequerimiento 3 ");
        ReportesView reportesView2 = new ReportesView();
        reportesView2.lideresQueMasGastan();
    }
}
