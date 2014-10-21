package packProblem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class packit {
	private static ArrayList<pack> myPacks = new ArrayList<pack>();

	public static void main(String[] args) {
		String sOut="";
	     try {
			System.setIn(new FileInputStream("in.txt"));
			// Open the standard input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while ((sOut = br.readLine()) != null)  {
				readLine(sOut);
			}
			multiCube m = new multiCube( 4000, 4000, 4000,0); 
			if (m.add(myPacks.get(0))==true){
				 m.add(myPacks.get(1));
			}
			System.out.println( m.toString());
			
			System.out.println("ok");
	     } catch (IOException e) {
	    	 System.out.println("Error");
		} 
	      
	}

	private static void readLine(String myLine) {		 
		String[] aS = myLine.split("[ ]");
		int id = Integer.parseInt(aS[0]);
		int d = (int) (Double.parseDouble(aS[1]) * 100);
		int w = (int) (Double.parseDouble(aS[2]) * 100);
		int h = (int) (Double.parseDouble(aS[3]) * 100);
		myPacks.add(new pack(w, d, h, id));
	}

}
