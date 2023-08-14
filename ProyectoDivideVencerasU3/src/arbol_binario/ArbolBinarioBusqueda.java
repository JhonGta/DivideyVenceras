package arbol_binario;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda {
    public Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // Método para insertar un nodo en el árbol
    public void insertar(String mes, int ingreso) {
        raiz = insertarRecursivo(raiz, mes, ingreso);
    }

    // Método recursivo para insertar un nodo en el árbol
    private Nodo insertarRecursivo(Nodo nodo, String mes, int ingreso) {
        if (nodo == null) {
            return new Nodo(mes, ingreso);
        }

        if (ingreso < nodo.ingreso) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, mes, ingreso);
        } else if (ingreso > nodo.ingreso) {
            nodo.derecho = insertarRecursivo(nodo.derecho, mes, ingreso);
        }

        return nodo;
    }

    // Método para obtener el ingreso de un mes específico
    public int obteneringreso(String mes) {
        return obteneringresoRecursivo(raiz, mes);
    }

    // Método recursivo para obtener el ingreso de un mes específico
    private int obteneringresoRecursivo(Nodo nodo, String mes) {
        if (nodo == null) {
            return -1; // Si el nodo es nulo, el ingreso no está en el árbol, retorna -1.
        }

        if (mes.equals(nodo.mes)) {
            return nodo.ingreso; // Si el mes coincide con el nodo actual, devuelve el ingreso.
        } else if (mes.compareTo(nodo.mes) < 0) {
            return obteneringresoRecursivo(nodo.izquierdo, mes); // Busca en el subárbol izquierdo.
        } else {
            return obteneringresoRecursivo(nodo.derecho, mes); // Busca en el subárbol derecho.
        }
    }


    // Método para recorrer el árbol en orden y obtener una lista ordenada de los meses e ingresos
    public List<String> obtenerIngresosOrdenados() {
        List<String> resultado = new ArrayList<>(); // Crea una lista para almacenar los ingresos ordenados.
        obtenerIngresosOrdenadosRecursivo(raiz, resultado); // Inicia la búsqueda recursiva en el árbol.
        return resultado; // Devuelve la lista de ingresos ordenados.
    }


    // Método recursivo para recorrer el árbol en orden   (la del boton ordenar por ingreso)
    private void obtenerIngresosOrdenadosRecursivo(Nodo nodo, List<String> resultado) {
        if (nodo != null) {
            obtenerIngresosOrdenadosRecursivo(nodo.izquierdo, resultado);  //izquiera
            resultado.add(nodo.mes + " - ingreso: " + nodo.ingreso);    //raiz
            obtenerIngresosOrdenadosRecursivo(nodo.derecho, resultado);   //derecha
        }
    }
    public String recorridoPreorden() {
        StringBuilder sb = new StringBuilder();
        recorridoPreorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoPreorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.ingreso).append(" ");
            recorridoPreorden(nodo.izquierdo, sb);
            recorridoPreorden(nodo.derecho, sb);
        }
    }

    public String recorridoInorden() {
        StringBuilder sb = new StringBuilder();
        recorridoInorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoInorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo, sb);
            sb.append(nodo.ingreso).append(" ");
            recorridoInorden(nodo.derecho, sb);
        }
    }

    public String recorridoPosorden() {
        StringBuilder sb = new StringBuilder();
        recorridoPosorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoPosorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoPosorden(nodo.izquierdo, sb);
            recorridoPosorden(nodo.derecho, sb);
            sb.append(nodo.ingreso).append(" ");
        }
    }
    
    
    
    
    
    public void eliminar(String mes) {
        // Método público para iniciar la eliminación de un nodo con el mes dado.
        raiz = eliminarRecursivo(raiz, mes); // Llama al método recursivo de eliminación.
    }

    private Nodo eliminarRecursivo(Nodo nodo, String mes) {
        // Método recursivo que realiza la eliminación de un nodo con el mes dado.

        if (nodo == null) {
            return null; // Si el nodo es nulo, no hay nada que eliminar, devuelve nulo.
        }

        int resultadoComparacion = mes.compareTo(nodo.mes); // Compara el mes con el nodo actual.

        if (resultadoComparacion < 0) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, mes); // Busca en el subárbol izquierdo.
        } else if (resultadoComparacion > 0) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, mes); // Busca en el subárbol derecho.
        } else { // Se encontró el nodo a eliminar
            if (nodo.izquierdo == null) {
                return nodo.derecho; // Si solo hay un hijo derecho, reemplaza el nodo actual.
            } else if (nodo.derecho == null) {
                return nodo.izquierdo; // Si solo hay un hijo izquierdo, reemplaza el nodo actual.
            }

            Nodo temp = obtenerMinimo(nodo.derecho); // Encuentra el sucesor inmediato.
            nodo.mes = temp.mes;
            nodo.ingreso = temp.ingreso;
            nodo.derecho = eliminarRecursivo(nodo.derecho, temp.mes); // Elimina el sucesor inmediato.
        }

        return nodo; // Devuelve el nodo modificado o sin cambios.
    }

    private Nodo obtenerMinimo(Nodo nodo) {
        // Método para encontrar el nodo con el valor mínimo en un subárbol.

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo; // Sigue avanzando hacia la izquierda para encontrar el mínimo.
        }
        return nodo; // Devuelve el nodo con el valor mínimo.
    }

       
}

