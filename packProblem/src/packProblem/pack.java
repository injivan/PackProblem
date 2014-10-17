package packProblem;

public class pack {
	private int w, d, h;

	public pack(int w, int d, int h) {
		this.w = w;
		this.d = d;
		this.h = h;
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
}
