package arbol_binario;

public class Nodo {
    public int ingreso;
    public String mes;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(String mes, int ingreso) {
        this.mes = mes;
        this.ingreso = ingreso;
        this.izquierdo = null;
        this.derecho = null;
    }

	public int getingreso() {
		return ingreso;
	}

	public void setingreso(int ingreso) {
		this.ingreso = ingreso;
	}

	public String getmes() {
		return mes;
	}

	public void setmes(String mes) {
		this.mes = mes;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}
    
}