package es.unican.is2.vista;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import es.unican.is2.modelo.Alarma;
import es.unican.is2.modelo.Alarmas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

@SuppressWarnings("serial")
public class VentanaAlarmas extends JFrame implements PropertyChangeListener {
	private Alarmas misAlarmas;
	private JLabel lblIDAlarma = new JLabel("ID Alarma");
	private JLabel lblHoraAlarma = new JLabel("Hora Alarma");
	private JTextField textFieldID = new JTextField();
	private Date date = new Date();
	private SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
	private JSpinner spinnerHora = new JSpinner(sm);
	private JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerHora, "dd/MM/yyyy hh:mm a");
	private JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
	private DefaultListModel<String> modelActivas = new DefaultListModel<String>();
	private JList<String> listActivas = new JList<String>(modelActivas);
	private JScrollPane listScrollerActivas = new JScrollPane();
	private JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivadas");
	private DefaultListModel<String> modelDesactivadas = new DefaultListModel<String>();
	private JList<String> listDesactivadas = new JList<String>(modelDesactivadas);
	private JScrollPane listScrollerDesactivadas = new JScrollPane();
	private JButton btnNuevaAlarma = new JButton("Nueva Alarma");
	private JButton btnApagar = new JButton("Apagar");
	private JButton btnOn = new JButton("On");
	private JButton btnOff = new JButton("Off");
	private JButton btnEliminar = new JButton("Eliminar");
	JPanel contentPane = new JPanel();

	/**
	 * Create the frame.
	 */
	public VentanaAlarmas(Alarmas a) {
		misAlarmas = a;
		misAlarmas.addPropertyChangeListener(this);
		init();
		setBounds(100, 100, 450, 300);
	}

	public void init() {
		setTitle("Alarmas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblIDAlarma.setBounds(20, 35, 77, 13);
		contentPane.add(lblIDAlarma);

		lblHoraAlarma.setBounds(20, 72, 77, 13);
		contentPane.add(lblHoraAlarma);

		textFieldID.setBounds(101, 32, 141, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		de.getTextField().setEditable( false );
		spinnerHora.setEditor(de);
		spinnerHora.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DATE));
		spinnerHora.setBounds(101, 69, 141, 20);
		contentPane.add(spinnerHora);

		lblAlarmasActivas.setBounds(281, 10, 124, 13);
		contentPane.add(lblAlarmasActivas);
		
		listScrollerActivas.setBounds(281, 24, 124, 61);
		listScrollerActivas.setViewportView(listActivas);
		contentPane.add(listScrollerActivas);

		lblAlarmasDesactivadas.setBounds(281, 99, 124, 13);
		contentPane.add(lblAlarmasDesactivadas);

		listScrollerDesactivadas.setBounds(281, 113, 124, 68);
		listScrollerDesactivadas.setViewportView(listDesactivadas);
		contentPane.add(listScrollerDesactivadas);

		btnNuevaAlarma.setBounds(20, 118, 222, 21);
		contentPane.add(btnNuevaAlarma);

		btnApagar.setBounds(20, 161, 222, 56);
		contentPane.add(btnApagar);

		btnOn.setBounds(281, 196, 57, 21);
		contentPane.add(btnOn);

		btnOff.setBounds(348, 196, 57, 21);
		contentPane.add(btnOff);

		btnEliminar.setBounds(281, 227, 124, 21);
		contentPane.add(btnEliminar);
	}

	public void setNuevaAction(Action action) {
		btnNuevaAlarma.setAction(action);
	}

	public void setApagarAction(Action action) {
		btnApagar.setAction(action);
	}

	public void setOnAction(Action action) {
		btnOn.setAction(action);
	}

	public void setOffAction(Action action) {
		btnOff.setAction(action);
	}

	public void setEliminarAction(Action action) {
		btnEliminar.setAction(action);
	}

	public String getId() {
		return textFieldID.getText();
	}

	public String getDate() {
		return de.getFormat().format(spinnerHora.getValue());
	}
	
	public String getActivaSeleccionada() {
		return listActivas.getSelectedValue();
	}
	
	public String getDesactivadaSeleccionada() {
		return listDesactivadas.getSelectedValue();
	}

	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("activa")) {
			@SuppressWarnings("unchecked")
			Queue<Alarma> alarmasActivas = (Queue<Alarma>) e.getNewValue();
			modelActivas.clear();
			for (Alarma al : alarmasActivas) {
				modelActivas.addElement(al.id());
			}
		} else if (e.getPropertyName().equals("desactivadas")) {
			@SuppressWarnings("unchecked")
			ArrayList<Alarma> alarmasDesactivadas = (ArrayList<Alarma>) e.getNewValue();
			modelDesactivadas.clear();
			for (Alarma al : alarmasDesactivadas) {
				modelDesactivadas.addElement(al.id());
			}
		} else if (e.getPropertyName().equals("sonando")) {
			modelActivas.clear();
			modelDesactivadas.clear();
			modelActivas.addElement("Sonando");
			modelDesactivadas.addElement("Sonando");
		} else if (e.getPropertyName().equals("parado")) {
			@SuppressWarnings("unchecked")
			Queue<Alarma> alarmasActivas = (Queue<Alarma>) e.getOldValue();
			modelActivas.clear();
			for (Alarma al : alarmasActivas) {
				modelActivas.addElement(al.id());
			}
			@SuppressWarnings("unchecked")
			ArrayList<Alarma> alarmasDesactivadas = (ArrayList<Alarma>) e.getNewValue();
			modelDesactivadas.clear();
			for (Alarma al : alarmasDesactivadas) {
				modelDesactivadas.addElement(al.id());
			}
		}
	}
}
