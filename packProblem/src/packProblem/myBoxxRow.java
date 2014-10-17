package packProblem;

import java.util.ArrayList;

public class myBoxxRow {
	private pack startPoint=new pack(0, 0, 0);
	private ArrayList<pack> myPoints = new ArrayList<pack>(); 
	
	public void setWDH(int w, int d, int h) {
		startPoint.setW(w);
		startPoint.setH(h);
		startPoint.setD(d);
		myPoints.add(startPoint);
	}
	public void addPack(pack pack1){
		//find a free pleases to put the pack
		for (int i = 0; i < myPoints.size(); i++) {
			
		}
	}
}
