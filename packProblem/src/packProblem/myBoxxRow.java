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

	public void addPack(pack pack1) {
		// find a free pleases to put the pack
		boolean flIn = true;
		for (int i = 0; i < myPoints.size(); i++) {
			pack pointx = myPoints.get(i);
			if (canAddPack(pointx, pack1)){
				//have to add a new pack and make new addPints
			}
			 
		}
	}

	private boolean canAddPack(pack point1, pack addetPack) {
		boolean flIn = false;
		int x, y, z;
		x = point1.getX() + point1.getW() + addetPack.getX();
		y = point1.getY() + point1.getH() + addetPack.getY();
		z = point1.getZ() + point1.getD() + addetPack.getZ();
		if (x <= startPoint.getW()) {
			if (y <= startPoint.getH()) {
				if (z <= startPoint.getD()) {
					flIn = true;
				}
			}
		}
		return flIn;
	}
}
