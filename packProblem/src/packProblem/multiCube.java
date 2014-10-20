package packProblem;

import java.util.ArrayList;

public class multiCube extends pack {
	 
	private int w, d, h;
	private ArrayList<pack> myPacks=new ArrayList<pack>(); 
	public multiCube(pack p) {
		super(p.getW(), p.getD(), p.getH(), p.getID());
		// Set my multicube dimensions
		// have to check if added pack can be placed in multicube.
	}

	public boolean add(pack p) {
		int a, b, c;
		a = (this.h > p.getH()) ? this.h : p.getH();
		b = (this.d > p.getD()) ? this.d : p.getD();
		c = this.w + p.getW();
		if ((a <= this.h) && (b <= this.d) && (c <= this.w)) {
			this.h = a;
			this.d = b;
			this.w = c;
			myPacks.add(p);
			return true;
		} else {
			return false;
		}

	}
}
