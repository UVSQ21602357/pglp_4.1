package fr.uvsq.uvsq21600767;

import java.util.ArrayList;
import java.util.List;

public class PersonnelComposite implements PersonnelInterface{
	    private List<Personnel> personnelsList = new ArrayList<Personnel>();

	    public void add(Personnel personnel){
	        personnelsList.add(personnel);
	    }

	    public void remove(Personnel personnel){
	        personnelsList.remove(personnel);
	    }

	    @Override
	    public void print() {
	        for(Personnel personnel : personnelsList){
	            System.out.println(personnel);
	        }
	    }
}
