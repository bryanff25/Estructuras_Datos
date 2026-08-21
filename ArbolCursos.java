public class ArbolCursos {
    private NodoArbolCurso raiz;

    public void insertar(Curso curso) {
        raiz = insertarRec(raiz, curso);
    }

    private NodoArbolCurso insertarRec(NodoArbolCurso raiz, Curso curso) {
        if (raiz == null) {
            return new NodoArbolCurso(curso);
        }
        if (curso.getIdCurso() < raiz.curso.getIdCurso()) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, curso);
        } else if (curso.getIdCurso() > raiz.curso.getIdCurso()) {
            raiz.derecho = insertarRec(raiz.derecho, curso);
        }
        return raiz;
    }

    public Curso buscar(int idCurso) {
        return buscarRec(raiz, idCurso);
    }

    private Curso buscarRec(NodoArbolCurso raiz, int idCurso) {
        if (raiz == null || raiz.curso.getIdCurso() == idCurso) {
            return (raiz != null) ? raiz.curso : null;
        }
        if (idCurso < raiz.curso.getIdCurso()) {
            return buscarRec(raiz.izquierdo, idCurso);
        }
        return buscarRec(raiz.derecho, idCurso);
    }

    public void recorridoInorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(NodoArbolCurso raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.println(raiz.curso);
            inordenRec(raiz.derecho);
        }
    }
}
