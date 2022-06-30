public class Constructor {

    int edad;
    String nombre;

    public Constructor() {
        edad = 20;
        nombre = "Jorge";
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor();
        System.out.println(obj1.edad);
        System.out.println(obj1.nombre);
    }
}
