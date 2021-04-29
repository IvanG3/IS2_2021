package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.unican.is2.modelo.Cobertura;
import es.unican.is2.modelo.Seguro;
import es.unican.is2.modelo.SegurosGUI;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GUITest {

	private FrameFixture demo;

	@Before
	public void setUp() {
		SegurosGUI gui = new SegurosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}

	@After
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		// CASOS NO VALIDOS
		// Fecha ultimo siniestro = null
		demo.textBox("txtFechaUltimoSiniestro").setText(null);
		demo.radioButton("btnMinusvalia").click();
		demo.comboBox("comboCobertura").selectItem(0);
		demo.textBox("txtPotencia").setText("50");
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("La fecha no se pudo parsear");
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Probando fecha = cadena erronea
		demo.textBox("txtFechaUltimoSiniestro").setText("aaa");
		demo.radioButton("btnMinusvalia").click();
		demo.comboBox("comboCobertura").selectItem(0);
		demo.textBox("txtPotencia").setText("50");
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("La fecha no se pudo parsear");
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Probando potencia = cadena erronea
		demo.textBox("txtFechaUltimoSiniestro").setText("06/05/2020");
		demo.radioButton("btnMinusvalia").click();
		demo.comboBox("comboCobertura").selectItem(0);
		demo.textBox("txtPotencia").setText("aaa");
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("¡Dato de entrada erróneo!");

		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
