package packProblem;

import java.text.DecimalFormat;

/**
 * @author XPMUser
 *
 */
public class pack implements Comparable<pack> {
	private int w, d, h, id;
	private point myPoint;

	public pack(int w, int d, int h,int id) {
		myPoint = new point(0, 0, 0);
		this.w = w;
		this.d = d;
		this.h = h;
		this.id=id;
		makecube();
	}

	private void makecube() {
		if (w < d)
			rotateRight(w, d);
		if (w < h)
			pushRight(w, h);
		if (d < h)
			pushUp(d, h);
	}

	private void rotateRight(int a, int b) {
		d = a;
		w = b;
	}

	private void pushRight(int a, int b) {
		h = a;
		w = b;
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

//	public int getX() {
//		return x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public int getZ() {
//		return z;
//	}
	public int getID() {
		return id;
	}
	public int getV() {
		return w*d*h;
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
	public int compareTo(pack m) {
		return (this.w > m.w) ? 1 : -1;
	}

	@Override
	public String toString() {
		StringBuffer s1 = new StringBuffer();
		for(int i=1;i<9;i++){
			s1.append( printPoint(i));
			if (i<8) s1.append(" ");
		}
		//s1.append("\n");
		return s1.toString();
	}
	
	private String printPoint(int n) {
		int w1 = this.w, h1 = this.h, d1 = this.d;
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
		return "(" + formatMe((double)(this.myPoint.x + w1) / 100) + " "
				+ formatMe((double)(this.myPoint.y + d1) / 100) + " "
				+ formatMe((double)(this.myPoint.z + h1) / 100) + ")";
	}
	private String formatMe(double d1){
		//DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
		DecimalFormat a= new DecimalFormat("0.00");
		return a.format(d1);  

		//return System.out.format("%.2f%n", d1);
	}
}
