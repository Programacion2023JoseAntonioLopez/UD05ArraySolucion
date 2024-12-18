import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;

/**
 * Clase que representa una asignatura, permitiendo gestionar las notas de los alumnos
 * y realizar análisis sobre ellas.
 */
public class Asignatura {

    private String nombreAsignatura; // Nombre de la asignatura.
    private double[] listaNotas; // Array para almacenar las notas de los alumnos.

    /**
     * Constructor que inicializa una asignatura con un nombre.
     * @param nombreAsignatura Nombre de la asignatura.
     */
    public Asignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Constructor que inicializa una asignatura con un nombre y una lista de notas.
     * @param nombreAsignatura Nombre de la asignatura.
     * @param listaNotas Lista inicial de notas.
     */
    public Asignatura(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        if (listaNotas != null) {
            this.listaNotas = listaNotas; // Inicializa las notas si no son nulas.
        }
    }

    /**
     * Devuelve el nombre de la asignatura.
     * @return Nombre de la asignatura.
     */
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }

    /**
     * Permite introducir notas para un número determinado de alumnos.
     * Si ya hay notas, pregunta si se desean reintroducir.
     * @param totalAlumnos Número total de alumnos en la asignatura.
     */
    public void leerNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        boolean introducirNotas = true; // Indica si se deben introducir nuevas notas.

        // Si ya existen notas, se pregunta al usuario si desea reintroducirlas.
        if (listaNotas != null) {
            String opcion;
            do {
                System.out.print("Notas ya introducidas. ¿Desea introducirlas de nuevo? (s/n): ");
                opcion = sc.nextLine();
            } while (!(opcion.equals("s")) && !(opcion.equals("n")));
            introducirNotas = opcion.equals("s");
        }

        // Si se decide introducir nuevas notas, se inicializa el array y se piden las notas.
        if (introducirNotas) {
            listaNotas = new double[totalAlumnos];
            for (int i = 0; i < totalAlumnos; i++) {
                listaNotas[i] = leerNota(i); // Llama al método auxiliar para leer una nota.
            }
        }

        System.out.println(this); // Imprime la representación de la asignatura.
    }

    /**
     * Método auxiliar para leer la nota de un alumno, validando que esté entre 0 y 10.
     * @param alumno Índice del alumno.
     * @return Nota del alumno.
     */
    private double leerNota(int alumno) {
        Scanner sc = new Scanner(System.in);
        double nota;
        do {
            System.out.print(" Nota Alumno " + (alumno + 1) + " (Número entre 0.0 ... 10.0): ");
            nota = sc.nextDouble(); // Lee la nota desde la entrada.
        } while (nota < 0 || nota > 10); // Repite hasta que la nota sea válida.
        return nota;
    }


    /**
     * Calcula la media de las notas de los alumnos.
     * @return Media de las notas o -1 si no hay notas.
     */
    public double media() {
        double suma = 0;

        if (this.listaNotas != null) {
            // Suma todas las notas.
            for (double nota : this.listaNotas) {
                suma += nota;
            }
            return suma / this.listaNotas.length; // Devuelve la media.
        } else {
            return -1; // Indica que no hay notas disponibles.
        }
    }

    /**
     * Calcula la nota mínima entre los alumnos.
     * @return Nota mínima o -1 si no hay notas.
     */
    public double minimo() {
        double resultado = Double.MAX_VALUE;

        if (listaNotas != null) {
            for (double nota : this.listaNotas) {
                if (nota < resultado) { // Actualiza el mínimo si se encuentra una nota menor.
                    resultado = nota;
                }
            }
        } else {
            resultado = -1; // Indica que no hay notas.
        }
        return resultado;
    }

    /**
     * Calcula la nota máxima entre los alumnos.
     * @return Nota máxima o -1 si no hay notas.
     */
    public double maximo() {
        double resultado = Double.MIN_VALUE;

        if (this.listaNotas != null) {
            for (double nota : this.listaNotas) {
                if (nota > resultado) { // Actualiza el máximo si se encuentra una nota mayor.
                    resultado = nota;
                }
            }
        } else {
            resultado = -1; // Indica que no hay notas.
        }
        return resultado;
    }

    /**
     * Calcula el total de alumnos suspensos.
     * @return Número de suspensos o -1 si no hay notas.
     */
    public int totalSuspensos() {
        int suspensos = 0;

        if (this.listaNotas != null) {
            for (double nota : this.listaNotas) {
                if (nota < 5) { // Considera suspenso cualquier nota menor a 5.
                    suspensos++;
                }
            }
        } else {
            suspensos = -1; // Indica que no hay notas.
        }
        return suspensos;
    }

    /**
     * Calcula el total de alumnos aprobados.
     * @return Número de aprobados o -1 si no hay notas.
     */
    public int totalAprobados() {
        int aprobados = 0;

        if (this.listaNotas != null) {
            for (double nota : this.listaNotas) {
                if (nota >= 5) { // Considera aprobado cualquier nota igual o mayor a 5.
                    aprobados++;
                }
            }
        } else {
            aprobados = -1; // Indica que no hay notas.
        }
        return aprobados;
    }

    /**
     * Cambia la nota de un alumno dado su índice y la nueva nota.
     * Valida que la nueva nota sea válida y que el índice sea correcto.
     * @param nota Nueva nota.
     * @param alumno Índice del alumno.
     */
    public void cambiarNota(double nota, int alumno) {
        if (this.listaNotas == null) {
            System.out.println("Notas aún no introducidas.");
        } else if (nota < 0 || nota > 10) {
            System.out.println("Nota incorrecta (0..10).");
        } else if (alumno < 0 || alumno >= this.listaNotas.length) {
            System.out.println("Índice incorrecto (0.." + (listaNotas.length - 1) + ").");
        } else {
            listaNotas[alumno] = nota; // Actualiza la nota del alumno.
        }
    }
    /**
     * Devuelve el índice del alumno con la mejor nota.
     * @return Índice del mejor alumno o -1 si no hay notas.
     */
    public int mejorAlumno() {
        double mejorNota = Double.MIN_VALUE;
        int mejorAlumno = -1;

        if (this.listaNotas != null) {
            for (int i = 0; i < this.listaNotas.length; i++) {
                if (this.listaNotas[i] > mejorNota) {
                    mejorNota = this.listaNotas[i];
                    mejorAlumno = i;
                }
            }
        }
        return mejorAlumno;
    }

    /**
     * Devuelve el índice del alumno con la peor nota.
     * @return Índice del peor alumno o -1 si no hay notas.
     */
    public int peorAlumno() {
        double peorNota = Double.MAX_VALUE;
        int peorAlumno = -1;

        if (this.listaNotas != null) {
            for (int i = 0; i < this.listaNotas.length; i++) {
                if (this.listaNotas[i] < peorNota) {
                    peorNota = this.listaNotas[i];
                    peorAlumno = i;
                }
            }
        }
        return peorAlumno;
    }

    /**
     * Devuelve la nota de un alumno dado su índice.
     * Valida que el índice sea correcto y que existan notas.
     * @param alumno Índice del alumno.
     * @return Nota del alumno o -1 si el índice es incorrecto o no hay notas.
     */
    public double notaAlumno(int alumno) {
        double nota = 0;
        if (listaNotas != null && !(alumno < 0 || alumno >= listaNotas.length)) {
            nota = listaNotas[alumno]; // Devuelve la nota del alumno en el índice dado.
        } else {
            nota = -1; // Retorna -1 si no hay notas o el índice es inválido.
        }
        return nota;
    }

    /**
     * Devuelve un array con los índices de los alumnos aprobados.
     * @return Array de índices de alumnos aprobados, o null si no hay aprobados o notas.
     */
    public int[] dameAprobados() {
        int[] alumnosAprobados = null;
        int totalAprobados = totalAprobados();

        if (listaNotas != null && totalAprobados > 0) {
            alumnosAprobados = new int[totalAprobados];
            int indiceAprobados = 0;
            for (int i = 0; i < this.listaNotas.length; i++) {
                if (this.listaNotas[i] >= 5) { // Considera aprobado una nota >= 5.
                    alumnosAprobados[indiceAprobados] = i; // Guarda el índice del aprobado.
                    indiceAprobados++;
                }
            }
        }
        return alumnosAprobados;
    }

    /**
     * Devuelve un array con los índices de los alumnos suspensos.
     * @return Array de índices de alumnos suspensos, o null si no hay suspensos o notas.
     */
    public int[] dameSuspensos() {
        int[] alumnosSuspensos = null;
        int totalSuspensos = totalSuspensos();

        if (listaNotas != null && totalSuspensos > 0) {
            alumnosSuspensos = new int[totalSuspensos];
            int indiceSuspensos = 0;
            for (int i = 0; i < this.listaNotas.length; i++) {
                if (this.listaNotas[i] < 5) { // Considera suspenso una nota < 5.
                    alumnosSuspensos[indiceSuspensos] = i; // Guarda el índice del suspenso.
                    indiceSuspensos++;
                }
            }
        }
        return alumnosSuspensos;
    }

    /**
     * Encuentra el índice del primer alumno con una nota menor a un valor dado.
     * @param nota Valor de referencia.
     * @return Índice del primer alumno con nota menor al valor, o -1 si no hay ninguno.
     */
    public int primerMenor(double nota) {
        boolean encontrado = false;
        int indice = 0;

        if (this.listaNotas != null && (nota >= 0 && nota <= 10)) {
            while (!encontrado && (indice < listaNotas.length)) {
                if (listaNotas[indice] < nota) { // Encuentra el primer menor.
                    encontrado = true;
                } else {
                    indice++;
                }
            }
        }
        if (!encontrado) {
            indice = -1; // Retorna -1 si no se encuentra ningún valor menor.
        }
        return indice;
    }

    /**
     * Ordena las notas de los alumnos de menor a mayor.
     * @return Array de notas ordenadas, o null si no hay notas.
     */
    public double[] ordenar() {
        double[] listaNotasOrdenada = null;

        if (this.listaNotas != null) {
            listaNotasOrdenada = Arrays.copyOf(this.listaNotas, this.listaNotas.length);
            Arrays.sort(listaNotasOrdenada); // Usa el método de ordenación de Arrays.
        }
        return listaNotasOrdenada;
    }

    /**
     * Analiza el grupo y da recomendaciones basadas en la distribución de las notas.
     * - Fenomenal: Si más de dos tercios tienen nota > 7.
     * - Repaso: Si más de dos tercios tienen nota >= 5.
     * - Mal: Si más de dos tercios tienen nota < 5.
     * - Subgrupos: Si ninguna de las anteriores aplica.
     */
    public void analizaGrupo() {
        int fenomenal = 0;
        int repaso = 0;
        int mal = 0;

        if (this.listaNotas != null) {
            int dosTercios = (this.listaNotas.length / 3) * 2; // Calcula los dos tercios del grupo.
            for (int i = 0; i < this.listaNotas.length; i++) {
                double nota = this.listaNotas[i];
                if (nota > 7) {
                    fenomenal++;
                } else if (nota >= 5) {
                    repaso++;
                } else {
                    mal++;
                }
            }

            // Imprime el análisis basado en la cantidad de alumnos en cada categoría.
            if (fenomenal >= dosTercios) {
                System.out.println("VAMOS FENOMENAL");
            } else if (repaso >= dosTercios) {
                System.out.println("REPASAR EJERCICIOS CON DIFICULTAD");
            } else if (mal >= dosTercios) {
                System.out.println("VAMOS MAL. REPETIR EL TEMARIO");
            } else {
                System.out.println("HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD");
            }
        } else {
            System.out.println("No existen notas en la Array"); // Indica que no hay datos.
        }
    }

    /**
     * Devuelve una representación en cadena de la asignatura y sus notas.
     * @return Cadena con los detalles de la asignatura.
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        resultado.append(nombreAsignatura);

        if (listaNotas != null) {
            for (int i = 0; i < this.listaNotas.length; i++) {
                resultado.append("\nAlumno ").append(i + 1).append(": ").append(listaNotas[i]);
            }
        } else {
            resultado.append("\nSin notas por el momento");
        }
        return resultado.toString();
    }
}