public class Main {
    public static void main(String[] args) {
       Grupo grupoPrueba=new Grupo();
       System.out.println("Mostrar Alumnos");
       //grupoPrueba.mostrarAlumnos();
       System.out.println(grupoPrueba);
       System.out.println("Medias");
       grupoPrueba.mostrarMedias();
       System.out.println("Asignatura mínima"+grupoPrueba.dameAsignaturaMinima());
       System.out.println("Alumno mejor media: "+grupoPrueba.dameMejorAlumnoMedia());
       grupoPrueba.dameAlumnoMedia(2);
       System.out.println("Media máxima: "+grupoPrueba.dameAsignaturaMaxima());
       System.out.println("Suspensos alumno 2: "+grupoPrueba.dameAlumnoSuspensos(2));
       grupoPrueba.muestraMediaAlumnos();
       grupoPrueba.muestraRepetidores();
       grupoPrueba.analizaAsignaturas();
       grupoPrueba.analizaCurso();



       //System.out.println(mates.primerMenor(4));
    }
}