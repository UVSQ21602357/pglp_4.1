package uvsq21602357;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	public PersonnelComposite root;
	
	
	@Test
	public void BuilderTest(){
	Personnel p1 = new Personnel.PersonelBuilder("Martin", "Jean", "Employé").build();
	assertEquals(p1.getPrenom(), "Jean");
	assertEquals(p1.getNom(), "Martin");
	assertEquals(p1.getFonction(), "Employé");
	
	}
	@Test
	public void compositeTest() {
		
		PersonnelType p1 = new Personnel.PersonelBuilder("Martin", "Jean", "Employé").build();
		int id = 1;
		PersonnelComposite groupe = new PersonnelComposite(id);
		groupe.add(p1);
		
		List<PersonnelType> expectedGroupePersons = new ArrayList<PersonnelType>();
		expectedGroupePersons.add(p1);
		assertEquals(groupe.getAllPersonnel(), expectedGroupePersons);
	}
	
	
	
	@Before
	public void setUP() {
		root = new PersonnelComposite(3);
		
	}
	
	@Test 
	public void testGetRootGroupeIteration() {
	   PersonnelTypeIterator t = root.groupeIteration();
	   assertEquals(t.getRoot(),root);
	}
	
	@Test 
	public void testEmptyGroupeIteration() {
	   PersonnelTypeIterator t = new GroupeIt(root);
	   assertFalse(t.hasNext());
	}
	
	
	@Test 
	public void testEmptyHierachicallIteration() {
	   PersonnelTypeIterator t = new HierarchieIt(root);
	   assertFalse(t.hasNext());
	}
	
}