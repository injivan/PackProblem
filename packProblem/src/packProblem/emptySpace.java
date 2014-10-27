package packProblem;

import java.util.ArrayList;

public class emptySpace {

	private int[] packsID;
	private point myDims;
	private point myPoint;
	private ArrayList<pack> myPacks = new ArrayList<pack>();
	private ArrayList<point> myFreePoints = new ArrayList<point>();

	public emptySpace( int x, int y, int z, int w, int h, int d) {
		super();
		// setup dimensions of the box
		myPoint = new point(x, y, z);
		myDims = new point(w, d, h);
		myFreePoints.add(new point(0, 0, 0));
		 
	}

	public int canAddPack(int pointNom, pack packToAdd) {
		// add a new pack to the one of the empty points
		// after adding have to remove this point and add tree new points

		point point = myFreePoints.get(pointNom);
		if (point.x + packToAdd.getW() <= myDims.x) {
			if (point.y + packToAdd.getD() <= myDims.y) {
				if (point.z + packToAdd.getH() <= myDims.z) {
					return 1;
				}
			}
		}
		return 0;
	}

	private void copyAllData(emptySpace newSpase) {
		// packsID,myDims,myPoint,myPacks,myFreePoints

		// myDims
		copyPoint(newSpase.myDims, this.myDims);
		// myPoint
		copyPoint(newSpase.myPoint, this.myPoint);
		//myPacks
		for (int i = 0; i < myPacks.size(); i++) {
			pack p1 = this.myPacks.get(i);
			newSpase.myPacks.add(p1);
		}
		//myFreePoints
		for (int i = 0; i < myFreePoints.size(); i++) {
			point p1 = this.myFreePoints.get(i);
			newSpase.myFreePoints.add(p1);
		}
		newSpase.packsID=new int[this.packsID.length+1];
		for (int i = 0; i < this.packsID.length; i++) {
			newSpase.packsID[i]= this.packsID[i];
		}
	}

	private void copyPoint(point pNew, point pOld) {
		pNew.x = pOld.x;
		pNew.y = pOld.y;
		pNew.z = pOld.z;

	}

	public int AddPackHere(int pointNom, pack packToAdd, emptySpace newSpase) {
		//add all data from here to the new Object
		
		point point = myFreePoints.get(pointNom);
		if (point.x + packToAdd.getW() <= myDims.x) {
			if (point.y + packToAdd.getD() <= myDims.y) {
				if (point.z + packToAdd.getH() <= myDims.z) {
					return 1;===
				}
			}
		}
		return 0;
	}

	public void makeArrayPacks(int[] packs) {
		packsID = new int[packs.length];
		for (int i = 0; i < packs.length; i++) {
			packsID[i] = packs[i];
		}
	}

	public int nextElementID() {
		int z = 0;
		for (int i = 0; i < packsID.length; i++) {
			if (packsID[i] > 0) {
				z = packsID[i];
				packsID[i] = 0;
				break;
			}
		}
		return z;
	}
	public int PointCount() {
		return	myFreePoints.size();
	}
}
