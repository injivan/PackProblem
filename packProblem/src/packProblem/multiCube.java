package packProblem;

import java.util.ArrayList;

public class multiCube extends pack {

	private ArrayList<pack> myPacks = new ArrayList<pack>();

	public multiCube(int w, int d, int h, int id) {
		super(w, d, h, id);
	}

	public boolean add(pack p) {
		int a = 0, b = 0, c = 0;

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

	private int findMinVChose(int a, int b, int c, pack p2) {
		// make max weight
		int w, d, h, chose = 0;
		double d1, ob1 = Double.MAX_VALUE; 
		 
		h = (a > p2.getH()) ? a : p2.getH();
		d = (b > p2.getD()) ? b : p2.getD();
		w = c + p2.getW();
		d1 = calcObem(w, d, h);
		if (d1 > 0) {
			if (d1 < ob1) {
				ob1 = d1;
				chose = 1;
			}
		}

		h = (a > p2.getH()) ? a : p2.getH();
		d = b + p2.getD();
		w = (c > p2.getW()) ? c : p2.getW();
		d1 = calcObem(w, d, h);
		if (d1 > 0) {
			if (d1 < ob1) {
				ob1 = d1;
				chose = 2;
			}
		}

		h = a + p2.getH();
		d = (b > p2.getD()) ? b : p2.getD();
		w = (c > p2.getW()) ? c : p2.getW();
		d1 = calcObem(w, d, h);
		if (d1 > 0) {
			if (d1 < ob1) {
				ob1 = d1;
				chose = 3;
			}
		}
		return chose;
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
			if (i < myPacks.size())
				s1.append(" ");
		}

		return s1.toString();
	}
}
