package thread;

import java.io.File;

import userInterface.PlanetariumController;
import javafx.scene.image.Image;
import model.Planetarium;
import model.Publicity;

public class PlanetariumThread extends Thread{
	    
    private PlanetariumController view;
   
    // CONSTRUCTOR
    public PlanetariumThread(PlanetariumController control)  {
    	view=control;    	
    }
    
    public void run () {
            Planetarium p = view.getMyPlanetarium();
            Publicity temp = p.getPublicity();
            while(true) {
            	
    		File file1 = new File(temp.getRuta());
            Image a = new Image(file1.toURI().toString());
            view.setImage(a);
        	try {
        		Thread.sleep(2000);
        		} 
        	catch (InterruptedException e) {
        			e.printStackTrace();
        	}
        	temp = temp.getNext()== null ? p.getPublicity():temp.getNext();
            }
    }  	
}