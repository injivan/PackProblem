package packProblem;

//import java.awt.Point;
import java.util.ArrayList;

public class multiCube extends pack implements Comparable<multiCube> {

	private double V1 = 0;// clear V
	private int w1 = 0, h1 = 0, d1 = 0;

	private ArrayList<Integer> packsID = new ArrayList<Integer>();
	// private point myDims;
	//private point myPoint;
	private ArrayList<pack> myPacks = new ArrayList<pack>();
	private ArrayList<point> myFreePoints = new ArrayList<point>();

	public multiCube(int w, int d, int h, int id) {
		super(w, d, h, id);
		w1 = w;
		d1 = d;
		h1 = h;
		myFreePoints.add(new point(0, 0, 0));
	}

	public void add(pack p) {

		point point = myFreePoints.get(0);
		//myFreePoints.remove(0);
		if (point.x + p.getW() <= this.getW()) {
			if (point.y + p.getD() <= this.getD()) {
				if (point.z + p.getH() <= this.getH()) {
					// add the pack
					p.setX(point.x);
					p.setY(point.y);
					p.setZ(point.z);
					myPacks.add(p);
					// packsID.add(p.getID());

					// add the new free points
					point point1 = new point(0, 0, 0);
					point point2 = new point(0, 0, 0);
					point point3 = new point(0, 0, 0);
					point1.x = point.x + p.getW();
					point1.y = point.y;
					point1.z = point.z;
					myFreePoints.add(point1);
					point2.x = point.x + p.getW();
					point2.y = point.y + p.getD();
					point2.z = point.z;
					myFreePoints.add(point2);
					point3.x = point.x;
					point3.y = point.y + p.getD();
					point3.z = point.z;
					myFreePoints.add(point3);

					// new obem V1
					V1 = V1 + p.getV();
					// new w d and h
					if ((point.x + p.getW()) > w1)
						w1 = (point.x + p.getW());
					if ((point.y + p.getD()) > d1)
						d1 = (point.y + p.getD());
					
				}
			}
		}

	}
	
	public multiCube setNewCube(){
		multiCube m1 = new multiCube(getW(), getD(), getH(), getID());
		for (int i = 0; i < myPacks.size(); i++) {
			m1.myPacks.add(this.myPacks.get(i));
		}
		//myFreePoints
		m1.myFreePoints.remove(0); 
		for (int i = 0; i < myFreePoints.size(); i++) {
			m1.myFreePoints.add(this.myFreePoints.get(i));
		}
		return m1;
	}
	
	public int freePointsCo(){
		return myFreePoints.size();
	}
	@Override
	public String toString() {
		StringBuffer s1 = new StringBuffer();
		for (int i = 0; i < myPacks.size(); i++) {
			pack p = myPacks.get(i);
			s1.append(p.toString());
			if (i < myPacks.size() - 1)
				s1.append(" ");
		}
		return s1.toString();
	}
	public double vK (){
		return (V1/w1*d1*h1)*100;
	}
	public ArrayList<pack> getPacks() {
		return myPacks;
	}

	@Override
	public int compareTo(multiCube o) {
		return (this.vK() > o.vK()) ? 1 : 0;
	}
}
