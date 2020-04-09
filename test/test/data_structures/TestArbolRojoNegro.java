package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArbolRojoNegroBTS;
import model.logic.Modelo;

public class TestArbolRojoNegro {
	private Modelo modelo;
	private ArbolRojoNegroBTS linear;
	private static int CAPACIDAD=256;
	
	@Before
	public void setUp1() 
	{
		linear= new ArbolRojoNegroBTS();
		
		for(Integer i=0;i<CAPACIDAD;i++) 
		{
			linear.put(i, i);
		}
	}
	
	
	@Test
	public void testSize() {
		// TODO
		assertEquals(256,linear.size());
	}
	@Test
	public void testEmpty() {
		// TODO
		assertFalse(linear.isEmpty());
	}
	@Test
	public void testContains() {
		// TODO
		assertTrue(linear.contains(20));
		assertFalse(linear.contains(257));
	}
	
	@Test
	public void testHeight() {
		// TODO
		assertEquals(8,linear.height());
	}
	
	@Test
	public void testGetHeight() {
		// TODO
		Integer nuevo1=199;
		assertEquals(4,linear.getHeight(nuevo1));
		Integer nuevo=127;
		assertEquals(0,linear.getHeight(nuevo));
	}
	
	
	
	@Test
	public void testPut() {
		// TODO
		Integer nuevo= 257;
		linear.put(nuevo, nuevo);
		assertEquals(257,linear.size());
		assertTrue(linear.contains(257));
	}
	
	@Test
	public void testGet() {
		// TODO
		Integer nuevo= 50;
		assertEquals(50,linear.get(nuevo));
	}
	
	@Test
	public void testMin() {
		// TODO
		assertEquals(0,linear.min());
		
	}
	
	@Test
	public void testMax() {
		// TODO
		assertEquals(255,linear.max());
	}
	
	
}
