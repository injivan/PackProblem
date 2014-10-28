package packProblem;

import java.util.ArrayList;

public class multiCube extends pack {

	private int[] packsID;
	//private point myDims;
	private point myPoint;
	private ArrayList<pack> myPacks = new ArrayList<pack>();
	private ArrayList<point> myFreePoints = new ArrayList<point>();

	public multiCube(int w, int d, int h, int id) {
		super(w, d, h, id);
		myFreePoints.add(new point(0, 0, 0));
	}

	public boolean add(pack p, int pointId) {
		int a = 0, b = 0, c = 0;
		point point = myFreePoints.get(pointId);
		if (point.x + p.getW() <=) {
			if (point.y + p.getD() <= myDims.y) {
				if (point.z + p.getH() <= myDims.z) {
					copyAllData(newSpase);
					return 1;
				}
			}
		}
		
		if (myPacks.size() > 0) {
			pack p1 = myPacks.get(0);
			a = p1.getH();
			b = p1.getD();
			c = p1.getW();
		}

		int d = findMinVChose(a, b, c, p);
		if (d > 0) {
			if (d == 1) {
				a = 0;
				b = 0;
			}
			if (d == 2) {
				a = 0;
				c = 0;
			}
			if (d == 3) {
				b = 0;
				c = 0;
			}
			p.setX(c);
			p.setY(b);
			p.setZ(a);
			myPacks.add(p);
			return true;
		} else {
			return false;
		}

	}

	private double calcObem(int w, int d, int h) {
		double a = 0;
		if ((h <= this.getH()) && (d <= this.getD()) && (w <= this.getW())) {
			a =(double) w * d * h;
		}
		return a;
	}

	@Override
	public String toString() {
		StringBuffer s1 = new StringBuffer();
		for (int i = 0; i < myPacks.size(); i++) {
			pack p = myPacks.get(i);
			s1.append(p.toString());
			if (i < myPacks.size()-1)
				s1.append(" ");
		}

		return s1.toString();
	}
}
