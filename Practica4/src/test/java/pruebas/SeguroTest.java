package pruebas;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;

import es.unican.is2.modelo.*;

public class SeguroTest {
	private Seguro seguro;
	private Cliente clienteConMinusvalia;
	private Cliente clienteSinMinusvalia;

	@Before
	public void setUp() throws Exception {
		clienteSinMinusvalia = new Cliente("Pepe","72183939H",false);
		clienteConMinusvalia = new Cliente("Pepe","72183939H",true);
	}

	@Test
	public void testSeguro() {
		// CASOS DE PRUEBA VALIDOS
		try {
			seguro = new Seguro(1, clienteSinMinusvalia, Cobertura.TERCEROS);
			assertTrue(seguro!=null);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		try {
			seguro = new Seguro(1, clienteSinMinusvalia, Cobertura.TODORIESGO);
			assertTrue(seguro!=null);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		try {
			seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROSLUNAS);
			assertTrue(seguro!=null);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		// CASOS DE PRUEBA NO VALIDOS
		// Potencia = 0
		try {
			seguro = new Seguro(0, clienteSinMinusvalia, Cobertura.TERCEROS);
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }

		// Potencia = -5
		try {
			seguro = new Seguro(-5, clienteSinMinusvalia, Cobertura.TERCEROS);
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }

		// Cliente = null
		try {
			seguro = new Seguro(1, null, Cobertura.TERCEROS);
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }

		// Cobertura = null
		try {
			seguro = new Seguro(1, clienteSinMinusvalia, null);
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
	}
	
	@Test
	public void testPrecio() {
		// CASOS DE PRUEBA VALIDOS
		try {
			seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			assertTrue(seguro.precio()==450);
		} catch (Exception e) {
			fail("Lanza excepcion");
		}
		
		try {
			seguro = new Seguro(90, clienteSinMinusvalia, Cobertura.TODORIESGO);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(3));
			assertTrue(seguro.precio()==1100);
		} catch (Exception e) {
			fail("Lanza excepcion");
		}
		
		try {
			seguro = new Seguro(111, clienteConMinusvalia, Cobertura.TERCEROSLUNAS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(4));
			assertTrue(seguro.precio()==540);
		} catch (Exception e) {
			fail("Lanza excepcion");
		}
		
		// CASOS DE PRUEBA NO VALIDOS
		// Cobertura = null
		try {
			seguro = new Seguro(1, clienteConMinusvalia, null);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
		
		// Potencia = 0
		try {
			seguro = new Seguro(0, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
		
		// Potencia = -10
		try {
			seguro = new Seguro(-10, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
		
		// Fecha = fechaActual + 1 día
		try {
			seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().plusDays(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
		
		// Fecha = fechaActual + 1 semana
		try {
			seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().plusWeeks(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
		
		// Cliente = null
		try {
			seguro = new Seguro(1, null, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			fail("No deberia llegar a esta linea");
		} catch (DatoIncorrectoException e) { }
	}
	
	@Test
	public void testFechaUltimoSiniestro() {
		try {
			seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS);
			seguro.setFechaUltimoSiniestro(LocalDate.now().minusYears(1));
			assertTrue(seguro.getFechaUltimoSiniestro().equals(LocalDate.now().minusYears(1)));
		} catch (Exception e) {
			fail("Lanza excepcion");
		}
	}
}
