package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.containers.ListaOrdenada;


public class ListaOrdenadaTest {

	ListaOrdenada<Integer> lista;
	int elemento;
	int size;

	@Before
	public void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		lista = new ListaOrdenada<Integer>();
	}

	@Test
	public void testAdd() {
		// CASOS DE PRUEBA VALIDOS
		// Añadir a lista vacia
		try {
			lista.add(2);
			assertTrue(lista.get(0)==2);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Añadir al final
		try {
			lista.add(4);
			assertTrue(lista.get(1)==4);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Añadir en el medio
		try {
			lista.add(3);
			assertTrue(lista.get(1)==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Añadir repetido
		try {
			lista.add(3);
			assertTrue(lista.get(1)==3 && lista.get(2)==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		// CASOS DE PRUEBA NO VALIDOS
		// Añadir nulo
		try {
			lista = new ListaOrdenada<Integer>();
			lista.add(2);
			lista.add(null);
			fail("No deberia llegar a esta linea");
		} catch (Exception e) { }
	}

	@Test
	public void testGet() {
		// CASOS DE PRUEBA VALIDOS
		// Lista con 1 elemento
		try {
			lista.add(2);
			elemento = lista.get(0);
			assertTrue(elemento==2);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 2 elementos
		try {
			lista = new ListaOrdenada<Integer>();
			lista.add(2);
			lista.add(3);
			elemento = lista.get(1);
			assertTrue(elemento==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 3 elementos (cogemos el intermedio)
		try {
			lista = new ListaOrdenada<Integer>();
			lista.add(2);
			lista.add(3);
			lista.add(4);
			elemento = lista.get(1);
			assertTrue(elemento==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 3 elementos (cogemos el ultimo)
		try {
			lista = new ListaOrdenada<Integer>();
			lista.add(2);
			lista.add(3);
			lista.add(4);
			elemento = lista.get(2);
			assertTrue(elemento==4);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		// CASOS DE PRUEBA NO VALIDOS
		// Lista vacia
		try {
			lista = new ListaOrdenada<Integer>();
			elemento = lista.get(0);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 1 elemento (cogemos un indice no valido negativo)
		try {
			lista.add(2);
			elemento = lista.get(-3);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 1 elemento (cogemos un indice no valido positivo)
		try {
			elemento = lista.get(50);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 3 elementos (cogemos un indice = size)
		try {
			lista.add(3);
			lista.add(4);
			elemento = lista.get(3);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
	}

	@Test
	public void testRemove() {
		// CASOS DE PRUEBA VALIDOS
		// Lista con 1 elemento
		try {
			lista.add(2);
			elemento = lista.remove(0);
			assertTrue(elemento==2);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 2 elementos
		try {
			lista.add(2);
			lista.add(3);
			elemento = lista.remove(1);
			lista.clear();
			assertTrue(elemento==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 3 elementos (cogemos el intermedio)
		try {
			lista.add(2);
			lista.add(3);
			lista.add(4);
			elemento = lista.remove(1);
			lista.clear();
			assertTrue(elemento==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 3 elementos (cogemos el ultimo)
		try {
			lista.add(2);
			lista.add(3);
			lista.add(4);
			elemento = lista.remove(2);
			lista.clear();
			assertTrue(elemento==4);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}

		// CASOS DE PRUEBA NO VALIDOS
		// Lista vacia
		try {
			elemento = lista.remove(0);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 1 elemento (cogemos un indice no valido negativo)
		try {
			lista.add(2);
			elemento = lista.remove(-3);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 1 elemento (cogemos un indice no valido positivo)
		try {
			elemento = lista.remove(50);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
		// Lista con 3 elementos (cogemos un indice = size)
		try {
			lista.add(3);
			lista.add(4);
			elemento = lista.remove(3);
			fail("No deberia llegar a esta linea");
		} catch (IndexOutOfBoundsException e) { }
	}

	@Test
	public void testSize() {
		// CASOS DE PRUEBA VALIDOS
		// Lista vacia
		try {
			size = lista.size();
			assertTrue(size==0);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 1 elemento
		try {
			lista.add(2);
			size = lista.size();
			assertTrue(size==1);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 1 elemento
		try {
			lista.add(3);
			lista.add(4);
			size = lista.size();
			assertTrue(size==3);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
	}

	@Test
	public void testClear() {
		// CASOS DE PRUEBA VALIDOS
		// Lista vacia
		try {
			lista.clear();
			assertTrue(lista.size()==0);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
		// Lista con 2 elementos
		try {
			lista.add(2);
			lista.add(3);
			lista.clear();
			assertTrue(lista.size()==0);
		} catch (Exception e) {
			fail("No debería lanzar la excepción");
		}
	}

}
