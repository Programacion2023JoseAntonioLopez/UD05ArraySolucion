public class Main {
    public static void main(String[] args) {
       Asignatura mates=new Asignatura("Matematicas");
       mates.leerNotas(2);

       System.out.println(mates.primerMenor(4));
    }
}