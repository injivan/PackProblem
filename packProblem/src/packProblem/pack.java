package packProblem;

public class pack implements Comparable<pack> {
	private int w, d, h;
	private int x, y, z,id;

	public pack(int w, int d, int h,int id) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	public int getID() {
		return id;
	}

	/*
	 * public void setX(int x) { this.x = x; } public void setY(int y) { this.y
	 * = y; } public void setZ(int z) { this.z = z; }
	 */

	@Override
	public int compareTo(pack m) {
		return (this.w > m.w) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "ID = " + this.id + " (" + this.x / 100 + " " + this.y / 100 + " " +  this.z / 100 + ")";
	}
}
