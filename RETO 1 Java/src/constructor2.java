public class constructor2 {
    String nombre;
    int nota;

    public constructor2(String nom, int not) {
        nombre = nom;
        nota = not;
    }

    public static void main(String[] args) {
        constructor2 obj1 = new constructor2("Jorge", 10);
        System.out.println(obj1.nombre);
        System.out.println(obj1.nota);
    }

}
