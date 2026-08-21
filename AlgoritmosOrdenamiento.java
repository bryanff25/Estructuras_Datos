import java.util.List;

public class AlgoritmosOrdenamiento {

    public static void bubbleSortDirecto(List<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cursos.get(j).getIdCurso() > cursos.get(j + 1).getIdCurso()) {
                    Curso temp = cursos.get(j);
                    cursos.set(j, cursos.get(j + 1));
                    cursos.set(j + 1, temp);
                }
            }
        }
    }

    public static void bubbleSortInverso(List<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cursos.get(j).getIdCurso() < cursos.get(j + 1).getIdCurso()) {
                    Curso temp = cursos.get(j);
                    cursos.set(j, cursos.get(j + 1));
                    cursos.set(j + 1, temp);
                }
            }
        }
    }

    public static void insercionDirecta(List<Curso> cursos) {
        int n = cursos.size();
        for (int i = 1; i < n; ++i) {
            Curso clave = cursos.get(i);
            int j = i - 1;
            while (j >= 0 && cursos.get(j).getNombre().compareToIgnoreCase(clave.getNombre()) > 0) {
                cursos.set(j + 1, cursos.get(j));
                j = j - 1;
            }
            cursos.set(j + 1, clave);
        }
    }

    public static void seleccionDirecta(List<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (cursos.get(j).getNumeroInscritos() < cursos.get(minIdx).getNumeroInscritos()) {
                    minIdx = j;
                }
            }
            Curso temp = cursos.get(minIdx);
            cursos.set(minIdx, cursos.get(i));
            cursos.set(i, temp);
        }
    }
}
