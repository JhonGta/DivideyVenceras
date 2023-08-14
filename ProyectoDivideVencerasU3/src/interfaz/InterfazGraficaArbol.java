package interfaz;

import javax.swing.*;

import arbol_binario.ArbolBinarioBusqueda;
import arbol_binario.Nodo;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGraficaArbol extends JFrame {
    private ArbolBinarioBusqueda arbol;
    private JTextArea textoArea;

    public InterfazGraficaArbol() {
        arbol = new ArbolBinarioBusqueda();

        setTitle("Árbol Binario de Búsqueda");
        setSize(665, 388);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JButton botonAgregar = new JButton("Agregar Contabilidad");
        botonAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
        botonAgregar.setForeground(new Color(0, 0, 128));
        botonAgregar.setBackground(new Color(240, 240, 240));
        botonAgregar.setBounds(453, 46, 186, 25);

        // Agregar componentes al contenedor
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        	
        });
        
        // Crear el botón "Calcular Total"
        JButton btnCalcularTotal = new JButton("Calcular Total");
        btnCalcularTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCalcularTotal.setForeground(new Color(0, 0, 102));
        btnCalcularTotal.setBounds(243, 46, 186, 25);
        panel.add(btnCalcularTotal);
        
        
        
        
        
        
        
        

        // ActionListener para el botón "Calcular Total"
        btnCalcularTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotalIngresos();
            }
        });
        
        
        
        
        JButton btnBusqueda = new JButton("Busqueda");
        btnBusqueda.setForeground(new Color(0, 0, 102));
        btnBusqueda.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBusqueda.setBounds(10, 231, 186, 25);
        panel.add(btnBusqueda);
        
        btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarMes();
			}
		});
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(new Color(0, 0, 102));
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEliminar.setBounds(10, 277, 186, 25);
        panel.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarMes();
			}
		});
        
        JLabel lblNewLabel_1_1 = new JLabel("Guaman Jhon");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 30, 95, 26);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("Diaz Nicole");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 45, 77, 26);
        panel.add(lblNewLabel_1);
        btnSalir.setForeground(new Color(0, 0, 102));
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSalir.setBounds(10, 313, 186, 25);
        panel.add(btnSalir);
        
      
        JLabel lblNewLabel = new JLabel("Gestor de Ingresos Empresariales");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(22, 0, 617, 34);
        panel.add(lblNewLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 654, 2);
        panel.add(scrollPane);
        
        JButton botonOrdenar = new JButton("Ordenar por ingereso");
        botonOrdenar.setBackground(new Color(240, 240, 240));
        botonOrdenar.setFont(new Font("Tahoma", Font.BOLD, 14));
        botonOrdenar.setForeground(new Color(0, 0, 102));
        botonOrdenar.setBounds(453, 82, 186, 25);
        panel.add(botonOrdenar);
        
                // Acción del botón Ordenar por ingreso
                botonOrdenar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ordenarPorIngreso();
                    }
                });
        panel.add(botonAgregar);
        getContentPane().add(panel);
        textoArea = new JTextArea();
        textoArea.setFont(new Font("Monospaced", Font.BOLD, 15));
        textoArea.setForeground(Color.BLACK);  //color de letras del texArea
        textoArea.setBackground(new Color(255, 255, 255));
        textoArea.setBounds(226, 170, 426, 179);
        panel.add(textoArea);
        
        JButton botonRecorridos = new JButton("Recorridos");
        botonRecorridos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder sb = new StringBuilder();
                sb.append("Recorrido en preorden: ");
                sb.append(arbol.recorridoPreorden());
                sb.append("\nRecorrido en inorden: ");
                sb.append(arbol.recorridoInorden());
                sb.append("\nRecorrido en posorden: ");
                sb.append(arbol.recorridoPosorden());
                textoArea.setText(sb.toString());
        	}
        });
        botonRecorridos.setFont(new Font("Tahoma", Font.BOLD, 14));
        botonRecorridos.setForeground(new Color(0, 0, 102));
        botonRecorridos.setBounds(453, 116, 186, 25);
        panel.add(botonRecorridos);
        
        JLabel lblFondo = new JLabel("");
        lblFondo.setBackground(new Color(75, 0, 130));
        lblFondo.setBounds(0, 0, 654, 349);
        lblFondo.setIcon(new ImageIcon(InterfazGraficaArbol.class.getResource("/imagenes/gestion-empresarial.jpg")));
        panel.add(lblFondo);
        
        // Acción del botón Agregar mes
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContabilidad();
            }
        });
    }

    private void agregarContabilidad() {
        String mes = JOptionPane.showInputDialog(this, "Ingrese el mes ");
        
        if (mes != null && !mes.isEmpty()) {
            if (mesExists(mes)) {
                JOptionPane.showMessageDialog(this, "El mes ya existe en el árbol.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String ingeresoStr = JOptionPane.showInputDialog(this, "Ingreso del mes de " + mes);
                
                try {
                    int ingereso = Integer.parseInt(ingeresoStr);
                    arbol.insertar(mes, ingereso);
                    textoArea.append("agregado: " + mes + " - ingreso: " + ingereso + "$"+"\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingreso inválido. Ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean mesExists(String mes) {
        return mesExistsRecursivo(arbol.raiz, mes);
    }

    private boolean mesExistsRecursivo(Nodo nodo, String mes) {
        if (nodo == null) {
            return false;
        }

        int comparisonResult = mes.compareTo(nodo.mes);

        if (comparisonResult == 0) {
            return true; 
        } else if (comparisonResult < 0) {
            return mesExistsRecursivo(nodo.izquierdo, mes);
        } else {
            return mesExistsRecursivo(nodo.derecho, mes);
        }
    }

    private void ordenarPorIngreso() {
        List<String> MesesOrdenados = arbol.obtenerIngresosOrdenados();
        StringBuilder sb = new StringBuilder();
        for (String Mess : MesesOrdenados) {
            sb.append(Mess).append("\n");
        }
        textoArea.setText(sb.toString());
    }

    
    private void calcularTotalIngresos() {
        int totalIngresos = calcularTotalIngresosRecursivo(arbol.raiz);
        textoArea.append("Total de ingresos: " + totalIngresos + "$" + "\n");
    }
    
    private int calcularTotalIngresosRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int totalIzquierdo = calcularTotalIngresosRecursivo(nodo.izquierdo);
        int  totalDerecho = calcularTotalIngresosRecursivo(nodo.derecho);

        return nodo.ingreso + totalIzquierdo + totalDerecho;
    }
 
    
    
    private void buscarMes() {
        String mes = JOptionPane.showInputDialog(this, "Ingrese el nombre del mes a buscar:");
        if (mes != null && !mes.isEmpty()) {
            int ingreso = arbol.obteneringreso(mes);
            if (ingreso != -1) {
                textoArea.setText("Mes encontrado: " + mes + " - Ingreso: " + ingreso);
            } else {
                textoArea.setText("Mes no encontrado en el árbol.");
            }
        }
    }

    
    
    
    private void eliminarMes() {
        String mes = JOptionPane.showInputDialog(this, "Ingrese el nombre del mes a eliminar:");
        //this se utiliza para hacer referencia al objeto actual en el que se encuentra el código.
        if (mes != null && !mes.isEmpty()) {  //// Verifica si el valor de 'mes' no es nulo y no está vacío.
            arbol.eliminar(mes);
            textoArea.setText(""); // Limpiar el área de texto
            ordenarPorIngreso(); // Actualizar el área de texto con los resultados ordenados
        }
    }

    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazGraficaArbol ventana = new InterfazGraficaArbol();
                ventana.setVisible(true);
            }
            
            
        });
    }
}
