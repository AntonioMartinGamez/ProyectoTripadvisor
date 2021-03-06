package vistas;
import mof.mof.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class eresEmpresa extends FrameBase2 implements ActionListener {
	 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto;           // etiqueta o texto no editable
	
	private JLabel emailRestauranteLabel;           // etiqueta o texto no editable
	private JLabel passRestauranteLabel;           // etiqueta o texto no editable
    private JButton botonReturn;          // boton con una determinada accion



    private JTextField emailRestauranteText;        // caja de texto, para insertar datos
    private JTextField passUsuarioText;        // caja de texto, para insertar datos

    private JButton botonEmpresa;          // boton con una determinada accion

    public eresEmpresa() {
        super();                    // usamos el contructor de la clase padre JFrame
        inicializarComponentes();   // inicializamos los atributos o componentes
    }


    private void inicializarComponentes() {
        // creamos los componentes
        texto = new JLabel();
        emailRestauranteLabel = new JLabel();
        passRestauranteLabel = new JLabel();

        texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 33));        //caja = new JTextField();
        botonEmpresa = new JButton();
        emailRestauranteText = new JTextField();
        passUsuarioText = new JPasswordField();
        botonReturn = new JButton();

        // configuramos los componentes
        texto.setText("Logueate como empresa");    // colocamos un texto a la etiqueta
        texto.setBounds(250, 50, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)

        emailRestauranteLabel.setText("Email de Restaurante");    // colocamos un texto a la etiqueta
        emailRestauranteLabel.setBounds(250, 150, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        passRestauranteLabel.setText("Contraseña");    // colocamos un texto a la etiqueta
        passRestauranteLabel.setBounds(250, 250, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)

        botonReturn.setText("Return"); 		    // colocamos un texto al boton
        botonReturn.setBounds(20, 20, 80, 80);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 new primeraVista().setVisible(true);
			     setVisible(false);
				
			}
        });       

        
        
        emailRestauranteText.setBounds(400, 150, 150, 50);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        passUsuarioText.setBounds(400, 250, 150, 50);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        botonEmpresa.setText("Entrar"); 		    // colocamos un texto al boton
        botonEmpresa.setBounds(375, 350, 200, 100);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String emailRestaurante = emailRestauranteText.getText();
				String pass = passUsuarioText.getText();
				
				if(Restaurante.login(emailRestaurante, pass)){
					 System.out.print("si se ha podido loggear ");
					 
					 	//Usuario usuarioLogeado = Usuario.getUsuarioBynombreUsuario(nombreUsuario);
					 	new vistas.mostrarEmpresa(emailRestaurante).setVisible(true);
					 
					 
				}else{
					setVisible(true);

					
					 System.out.print("no se ha podido loggear"); //muestra que no logea
				} 

			}
        });       // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        
        
        // adicionamos los componentes a la ventana
        this.add(texto);
        this.add(emailRestauranteText);
        this.add(passUsuarioText);
        this.add(emailRestauranteLabel);
        this.add(passRestauranteLabel);
        this.add(botonReturn);

        this.add(botonEmpresa);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
    }

}