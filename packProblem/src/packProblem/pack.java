package packProblem;

import java.text.DecimalFormat;

/**
 * @author XPMUser
 * 
 */
public class pack {
	private int w, d, h, id, used=0;
	private point myPoint;
	private int poz;// 001 0x1 rotateRight
					// 010 0x2 pushRight
					// 100 0x4 pushUp

	public pack(int w, int d, int h, int id) {
		myPoint = new point(0, 0, 0);
		this.w = w;
		this.d = d;
		this.h = h;
		this.id = id;
		makecube();
	}

	private void makecube() {
		poz = 0;
		if (w < d) {
			poz = poz | 0x1;
			rotateRight(w, d);
		}
		if (w < h) {
			poz = poz | 0x2;
			pushRight(w, h);
		}
		if (d < h) {
			poz = poz | 0x4;
			pushUp(d, h);
		}
	}
	public pack getNewPack() {
		pack p = new pack(w, d, h, id);		
		p.myPoint.x = this.myPoint.x;
		p.myPoint.y = this.myPoint.y;
		p.myPoint.z = this.myPoint.z;
		p.poz = this.poz;
		p.used= this.used;
		return p;
	}
	private void rotateRight(int a, int b) {
		d = a;
		w = b;
	}

	private void pushRight(int a, int b) {
		h = a;
		w = b;

	}
	public void rotate(int poz) {
		int i =0;
		switch (poz) {
		case 1:
		 	i = poz & 0x1;
			rotateRight(w, d);
			break;
		case 2:
			i = poz & 0x2;
			pushRight(w, h);
			break;
		case 3:
			i = poz & 0x4;
			pushUp(d, h);
			break;
		default:
			break;
		}
		poz = poz ^ i;
	}
	private void pushUp(int a, int b) {
		h = a;
		d = b;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	public int getUsed() {
		return used;
	}

	public void setUsed(int h) {
		this.used = h;
	}

	/*public int getX() {
		return x;
	}*/
	//
	// public int getY() {
	// return y;
	// }
	//
	public int getZ() {
		return this.myPoint.z;
	}
	public int getID() {
		return id;
	}

	public double getV() {
		return (double) w * d * h ;
	}

	public void setX(int x) {
		this.myPoint.x = x;
	}

	public void setY(int y) {
		this.myPoint.y = y;
	}

	public void setZ(int z) {
		this.myPoint.z = z;
	}

	@Override
	public String toString() {

		//System.out.println(Integer.toBinaryString(poz));

		StringBuffer s1 = new StringBuffer();
		for (int i = 1; i < 9; i++) {
			s1.append(printPoint(i));
			if (i < 8)
				s1.append(" ");
		}
		// s1.append("\n");
		return s1.toString();
	}

	private String printPoint(int n) {
		int w1 = this.w, h1 = this.h, d1 = this.d;
		int i;
		if ((poz & 0x1) > 0) {
			i = d1;
			d1 = w1;
			w1 = i;
		}
		if ((poz & 0x2) > 0) {
			i = h1;
			h1 = w1;
			w1 = i;
		}
		if ((poz & 0x4) > 0) {
			i = h1;
			h1 = d1;
			d1 = i;
		}
		switch (n) {
		case 1:
			h1 = 0;
			w1 = 0;
			d1 = 0;
			break;
		case 2:
			h1 = 0;
			d1 = 0;
			break;
		case 3:
			h1 = 0;
			break;
		case 4:
			h1 = 0;
			w1 = 0;
			break;
		case 5:
			w1 = 0;
			d1 = 0;
			break;
		case 6:
			d1 = 0;
			break;
		case 7:
			break;
		case 8:
			w1 = 0;
			break;
		default:
			break;
		}
		return "(" + formatMe((double) (this.myPoint.x + w1) / 100) + " "
				+ formatMe((double) (this.myPoint.y + d1) / 100) + " "
				+ formatMe((double) (this.myPoint.z + h1) / 100) + ")";
	}

	private String formatMe(double d1) {
		// DecimalFormat decimalFormat = new DecimalFormat("0.00",
		// decimalFormatSymbols);
		DecimalFormat a = new DecimalFormat("0.00");
		return a.format(d1);

		// return System.out.format("%.2f%n", d1);
	}
}
