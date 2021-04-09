package es.unican.is2.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VentanaAlarmas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlarmas frame = new VentanaAlarmas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAlarmas() {
		super("Alarmas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIDAlarma = new JLabel("ID Alarma");
		lblIDAlarma.setBounds(45, 35, 64, 13);
		contentPane.add(lblIDAlarma);

		JLabel lblHoraAlarma = new JLabel("Hora Alarma");
		lblHoraAlarma.setBounds(45, 72, 64, 13);
		contentPane.add(lblHoraAlarma);

		textFieldID = new JTextField();
		textFieldID.setBounds(130, 32, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		JSpinner spinnerHora = new JSpinner(sm);

		JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerHora, "hh:mm a");
		de.getTextField().setEditable( false );
		spinnerHora.setEditor(de);
		spinnerHora.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		spinnerHora.setBounds(130, 69, 96, 20);
		contentPane.add(spinnerHora);

		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		lblAlarmasActivas.setBounds(281, 10, 104, 13);
		contentPane.add(lblAlarmasActivas);

		JTextPane textPaneActivas = new JTextPane();
		textPaneActivas.setBounds(281, 21, 104, 68);
		contentPane.add(textPaneActivas);

		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivadas");
		lblAlarmasDesactivadas.setBounds(281, 99, 104, 13);
		contentPane.add(lblAlarmasDesactivadas);

		JTextPane textPaneDesactivadas = new JTextPane();
		textPaneDesactivadas.setBounds(281, 113, 104, 68);
		contentPane.add(textPaneDesactivadas);

		JButton btnNuevaAlarma = new JButton("Nueva Alarma");
		btnNuevaAlarma.setBounds(45, 118, 181, 21);
		btnNuevaAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: crear alarma
			}
		});
		contentPane.add(btnNuevaAlarma);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(45, 161, 181, 56);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: dejar de sonar
			}
		});
		contentPane.add(btnApagar);

		JButton btnOn = new JButton("On");
		btnOn.setBounds(281, 196, 47, 21);
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: activar
			}
		});
		contentPane.add(btnOn);

		JButton btnOff = new JButton("Off");
		btnOff.setBounds(338, 196, 47, 21);
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: desactivar
			}
		});
		contentPane.add(btnOff);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(281, 227, 104, 21);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: borrar
			}
		});
		contentPane.add(btnEliminar);
	}
}
