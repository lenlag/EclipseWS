package main;

import junit.framework.TestCase;

public class SetDeviceTest extends TestCase {
	
	private SetDevice set;
	private int nbInit = 0;
	
			
	@Override
	protected void setUp() throws Exception { // protected, car override, impossible de changer type
		super.setUp();
		set=new SetDevice();
		set.list().add("AAA");
		set.list().add("BBB");
		set.list().add("CCC");
		nbInit = 3;
	}
	
	
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}



	public void testList () throws Exception {
		assertEquals(nbInit, set.list().size());
		
	}
	
	public void testAdd () throws Exception {
		String x = "coucou";
		set.add(x);
		assertEquals (nbInit+1, set.list().size());
		assertTrue (set.list().contains(x));
		
	
		String y = null;
		set.add(y);
		assertEquals(nbInit+1, set.list().size());
		
	}
	
	
	public void testRemove () {
		set.remove("AAA");
		assertEquals (nbInit-1, set.list().size());
		assertFalse (set.list().contains("AAA"));
		
		set.remove(null);
		assertEquals(nbInit-1, set.list().size());
	}

	public void testUpdate () throws Exception {
		String d = "DDD";
		set.update("AAA", d);
		assertEquals(nbInit, set.list().size());
		assertTrue(set.list().contains(d));
		
		String n = null;
		set.update("AAA", null);
		assertEquals(nbInit, set.list().size());
		
		setUp();		// on reinitialise le set
		set.update(null, d);
		assertEquals(nbInit, set.list().size());
		assertFalse(set.list().contains(d));

		String old = "DDD";
		String nouv = "EEE";
		set.update(old, nouv);
		assertEquals(nbInit, set.list().size());
		assertFalse (set.list().contains(nouv)); // que la nous valeur n's pas été rajoutée

		String nouv1 = "BBB";
		String old1 = "AAA";
		set.update(old1, nouv1);
		assertEquals (nbInit, set.list().size());
		assertTrue (set.list().contains(old1)); // si l'ancienne valeur est tjrs présente
		}
	
	
}
