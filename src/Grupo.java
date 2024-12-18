import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que representa un grupo de alumnos con asignaturas y notas asociadas.
 * Permite gestionar alumnos, asignaturas y realizar análisis sobre las notas del grupo.
 */
public class Grupo {

    private String nombreGrupo;       // Nombre del grupo
    private String[] alumnos;         // Array de nombres de los alumnos
    private Asignatura[] asignaturas; // Array de asignaturas del grupo
    int totalAlumnos;                 // Total de alumnos en el grupo
    int totalAsignaturas;             // Total de asignaturas en el grupo

    /**
     * Constructor por defecto.
     * Inicializa el grupo con valores predefinidos.
     */
    public Grupo() {
        this.nombreGrupo = "Prueba";
        this.totalAlumnos = 10;
        alumnos = new String[10];
        this.totalAsignaturas = 5;
        asignaturas = new Asignatura[5];
        inicializarArrays(); // Inicializa los arrays con valores de ejemplo.
    }

    /**
     * Constructor parametrizado.
     * @param nombreGrupo Nombre del grupo.
     * @param totalAlumnos Total de alumnos en el grupo.
     * @param totalAsignaturas Total de asignaturas en el grupo.
     */
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas) {
        this.nombreGrupo = nombreGrupo;

        // Inicializa los arrays de alumnos y asignaturas.
        this.totalAlumnos = totalAlumnos;
        alumnos = new String[totalAlumnos];
        this.totalAsignaturas = totalAsignaturas;
        asignaturas = new Asignatura[totalAsignaturas];
    }

    /**
     * Método privado para inicializar arrays con datos de ejemplo.
     * Este método es usado solo para pruebas.
     */
    private void inicializarArrays() {
        // Inicializa los nombres de los alumnos
        this.alumnos[0] = "Pablo";
        this.alumnos[1] = "Ana";
        this.alumnos[2] = "Luis";
        this.alumnos[3] = "María";
        this.alumnos[4] = "Carlos";
        this.alumnos[5] = "Laura";
        this.alumnos[6] = "Pedro";
        this.alumnos[7] = "Sofía";
        this.alumnos[8] = "Javier";
        this.alumnos[9] = "Isabel";

        // Inicializa las asignaturas con nombres y arrays de notas
        double[] notasMates = {7, 5, 4, 6, 9, 10, 3, 8, 8, 9};
        this.asignaturas[0] = new Asignatura("Mates", notasMates);

        double[] notasFisica = {10, 9, 10, 10, 8, 10, 9, 10, 10, 10};
        this.asignaturas[1] = new Asignatura("Fisica", notasFisica);

        double[] notasCocina = {10, 9, 8, 5, 7, 6, 4, 3, 5, 2};
        this.asignaturas[2] = new Asignatura("Cocina", notasCocina);

        double[] notasDiseno = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        this.asignaturas[3] = new Asignatura("Diseño", notasDiseno);

        double[] notasTenis = {6, 7, 8, 9, 10, 5, 4, 3, 2, 1};
        this.asignaturas[4] = new Asignatura("Tenis", notasTenis);
    }

    /**
     * Método para leer los nombres de los alumnos desde consola.
     * Valida que los nombres no estén vacíos.
     */
    public void leerAlumnos() {
        Scanner sc = new Scanner(System.in);
        String nombre;

        for (int i = 0; i < totalAlumnos; i++) {
            do {
                System.out.print("[?] Nombre del alumno " + (i + 1) + ": ");
                nombre = sc.nextLine();
            } while (nombre.equals("")); // Asegura que no se ingrese un nombre vacío.

            alumnos[i] = nombre;
        }

        // Ordena alfabéticamente los nombres de los alumnos
        Arrays.sort(alumnos);
    }

    /**
     * Muestra en consola los nombres de todos los alumnos del grupo.
     */
    public void mostrarAlumnos() {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Alumno " + (i + 1) + ": " + alumnos[i]);
        }
    }

    /**
     * Método para leer las asignaturas desde consola.
     * Solicita el nombre de cada asignatura y las notas de los alumnos.
     */
    public void leerAsignaturas() {
        Scanner sc = new Scanner(System.in);
        String nombreAsig;

        for (int i = 0; i < asignaturas.length; i++) {
            System.out.print("Nombre de la asignatura " + (i + 1) + ": ");
            nombreAsig = sc.nextLine();
            asignaturas[i] = new Asignatura(nombreAsig);
            asignaturas[i].leerNotas(totalAlumnos); // Lee las notas de la asignatura.
        }
    }

    /**
     * Muestra los nombres de las asignaturas del grupo.
     */
    public void mostrarAsignaturas() {
        for (int i = 0; i < totalAsignaturas; i++) {
            System.out.println(asignaturas[i].getNombreAsignatura());
        }
    }

    /**
     * Muestra la media de las notas de cada asignatura.
     */
    public void mostrarMedias() {
        StringBuilder sb = new StringBuilder();

        // Encabezado con los nombres de las asignaturas
        for (int j = 0; j < totalAsignaturas; j++) {
            sb.append(String.format("%-10s", asignaturas[j].getNombreAsignatura()));
        }
        sb.append("\n");

        // Media de las notas de cada asignatura
        for (int j = 0; j < totalAsignaturas; j++) {
            sb.append(String.format("%-10s", asignaturas[j].media()));
        }
        System.out.println(sb);
    }

    /**
     * Devuelve la asignatura con la nota mínima más baja.
     * @return Nombre de la asignatura con la nota mínima más baja.
     */
    public String dameAsignaturaMinima() {
        double notaMinima = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < totalAsignaturas; i++) {
            if (asignaturas[i].minimo() < notaMinima) {
                notaMinima = asignaturas[i].minimo();
                res = asignaturas[i].getNombreAsignatura();
            }
        }
        return res;
    }

    /**
     * Devuelve la asignatura con la nota máxima más alta.
     * @return Nombre de la asignatura con la nota máxima más alta.
     */
    public String dameAsignaturaMaxima() {
        double notaMaxima = Integer.MIN_VALUE;
        String res = "";

        for (int i = 0; i < totalAsignaturas; i++) {
            if (asignaturas[i].maximo() > notaMaxima) {
                notaMaxima = asignaturas[i].maximo();
                res = asignaturas[i].getNombreAsignatura();
            }
        }
        return res;
    }


    /**
     * Calcula la media de una asignatura específica.
     *
     * @param indice Índice de la asignatura en el array.
     * @return Media de la asignatura si el índice es válido, -1 en caso contrario.
     */
    public double dameMediaAsignatura(int indice) {
        double media = -1;

        // Validación del índice
        if (indice > totalAsignaturas || indice < 0) {
            System.out.println("[!] Indice no Válido");
        } else {
            // Calcula la media usando el método de la clase Asignatura
            media = asignaturas[indice].media();
        }
        return media;
    }

    /**
     * Calcula la media de notas de un alumno en todas las asignaturas.
     *
     * @param indice Índice del alumno en el array.
     * @return Media del alumno si el índice es válido, -1 en caso contrario.
     */
    public double dameAlumnoMedia(int indice) {
        double media = -1;

        // Validación del índice
        if (indice > totalAlumnos || indice < 0) {
            System.out.println("[!] Indice no Válido");
        } else {
            media = 0;

            // Suma las notas del alumno en todas las asignaturas
            for (int i = 0; i < totalAsignaturas; i++) {
                media += asignaturas[i].notaAlumno(indice);
            }

            // Calcula la media dividiendo entre el total de asignaturas
            media = media / totalAsignaturas;
        }
        return media;
    }

    /**
     * Cuenta cuántas asignaturas tiene suspendidas un alumno.
     *
     * @param indice Índice del alumno en el array.
     * @return Número de suspensos si el índice es válido, -1 en caso contrario.
     */
    public int dameAlumnoSuspensos(int indice) {
        int suspensos = -1;

        // Validación del índice
        if (indice > totalAlumnos || indice < 0) {
            System.out.println("[!] Indice no Válido");
        } else {
            suspensos = 0;

            // Cuenta las asignaturas con notas menores a 5
            for (int i = 0; i < totalAsignaturas; i++) {
                if (asignaturas[i].notaAlumno(indice) < 5) {
                    suspensos++;
                }
            }
        }
        return suspensos;
    }

    /**
     * Encuentra al alumno con la mejor media del grupo.
     *
     * @return Nombre del alumno con la mejor media.
     */
    public String dameMejorAlumnoMedia() {
        double mejorMedia = Double.MIN_VALUE;
        String mejorAlumno = " ";
        double media;

        // Recorre todos los alumnos calculando su media
        for (int i = 0; i < totalAlumnos; i++) {
            media = dameAlumnoMedia(i);
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = alumnos[i];
            }
        }
        return mejorAlumno;
    }

    /**
     * Muestra en consola la media de notas de todos los alumnos.
     */
    public void muestraMediaAlumnos() {
        StringBuilder sb = new StringBuilder();

        // Encabezado con nombres de los alumnos
        for (int i = 0; i < totalAlumnos; i++) {
            sb.append(String.format("%-15s", alumnos[i]));
        }
        sb.append("\n");

        // Muestra las medias calculadas para cada alumno
        for (int i = 0; i < totalAlumnos; i++) {
            sb.append(String.format("%-15s", dameAlumnoMedia(i)));
        }
        System.out.println(sb);
    }

    /**
     * Identifica y muestra los alumnos repetidores (más de 2 suspensos).
     */
    public void muestraRepetidores() {
        for (int i = 0; i < totalAlumnos; i++) {
            if (dameAlumnoSuspensos(i) > 2) {
                System.out.println("Repetidor: " + alumnos[i]);
            }
        }
    }

    /**
     * Analiza las notas de cada asignatura y muestra estadísticas.
     */
    public void analizaAsignaturas() {
        for (int i = 0; i < totalAsignaturas; i++) {
            System.out.println(" ----- " + asignaturas[i].getNombreAsignatura() + " ----- ");
            asignaturas[i].analizaGrupo();
            System.out.println();
        }
    }

    /**
     * Realiza un análisis global del curso considerando todas las medias de alumnos.
     */
    public void analizaCurso() {
        double[] medias = new double[totalAlumnos];

        // Calcula las medias de todos los alumnos
        for (int i = 0; i < totalAlumnos; i++) {
            medias[i] = dameAlumnoMedia(i);
        }

        // Crea una "asignatura ficticia" con estas medias y realiza el análisis
        Asignatura mediaAsignaturas = new Asignatura("Analisis " + nombreGrupo, medias);
        mediaAsignaturas.analizaGrupo();
    }

    /**
     * Devuelve una representación del grupo como una tabla de alumnos y notas.
     *
     * @return String con el formato de la tabla.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Encabezado de la tabla
        sb.append(String.format("%-15s", "Alumno"));
        for (int j = 0; j < totalAsignaturas; j++) {
            sb.append(String.format("%-15s", asignaturas[j].getNombreAsignatura()));
        }
        sb.append("\n");

        // Cuerpo de la tabla con nombres y notas
        for (int i = 0; i < totalAlumnos; i++) {
            sb.append(String.format("%-15s", alumnos[i]));
            for (int y = 0; y < totalAsignaturas; y++) {
                sb.append(String.format("%-15.2f", asignaturas[y].notaAlumno(i)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}