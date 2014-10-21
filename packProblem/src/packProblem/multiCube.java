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

		a = (a > p.getH()) ? a : p.getH();
		b = (b > p.getD()) ? b : p.getD();
		c = c + p.getW();
		if ((a <= this.getH()) && (b <= this.getD()) && (c <= this.getW())) {
			myPacks.add(p);
			return true;
		} else {
			return false;
		}
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
