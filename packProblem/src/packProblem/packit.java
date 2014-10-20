package packProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class packit {
	private static ArrayList<pack> myPacks = new ArrayList<pack>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Open the standard input
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sOut="";
		System.out.println("ok");
		try {
			System.out.println("ok");
		//	sOut=br.readLine();
			
//			//while ((sOut = br.readLine()) != null)  {
//		//		System.out.println(sOut);
//	//			readLine(sOut);
//		//	}
//			multiCube m = new multiCube( myPacks.get(1));
//			if (m.add(myPacks.get(2))){
//				System.out.println( m.toString());
//			} 
			
			
		}finally{
			System.out.println("asasda");
		}
		
		System.out.println(sOut);

	}

	private static void readLine(String myLine) {
		System.out.println(myLine);
		String[] aS = myLine.split("[ ]");
		int id = Integer.parseInt(aS[0]);
		int d = (int) (Double.parseDouble(aS[1]) * 100);
		int w = (int) (Double.parseDouble(aS[1]) * 100);
		int h = (int) (Double.parseDouble(aS[1]) * 100);
		myPacks.add(new pack(w, d, h, id));
	}

}
