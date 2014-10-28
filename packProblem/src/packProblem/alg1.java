package packProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class alg1 {
	private ArrayList<pack> packs;
	private PriorityQueue<multiCube> queMC = new PriorityQueue<multiCube>();
	/*
	 * make empty pag x,y z
	 * put max_X element in it
	 * get new empty pag with no filled space from max_X element
	 * make a list with all packs that can be put in this space
	 * run the full position tray function
	 */
	public alg1(ArrayList<pack> el) {
		int w = 0, d = 0, h = 0;
		pack first;
		multiCube mk1; 
		packs = el;
		first = findMax_XY(false);
		if (first != null) {
			d = first.getD();
		}
		first = findMax_XY(true);
		if (first != null) {
			w = first.getW();
			h = first.getH();
		}
		// emptySpace sp1 = new emptySpace( packsID, x, y, z, w, h, d)
		mk1 = new multiCube( w, d, h, 0);
		mk1.add(first, 0);
		queMC.add(mk1);		
		do{
			// wzemam  mowite to`ki za dostyp 
			// probwam da dobawqm paketi
			//kogato we`e nemo[e da se dobawqt paketi
			//trebwa da izbera nowi now kub
		}while (true);
		
		
	}

	private pack findMax_XY(Boolean fX) {
		int m_x = 0, j = -1, z;
		for (int i = 0; i < packs.size(); i++) {
			pack p = packs.get(i);
			z = getXY(fX, p);
			if (m_x < z) {
				m_x = z;
				j = i;
			}
		}
		if (j == -1)
			return null;
		return packs.get(j);
	}

	private int getXY(Boolean fX, pack p1) {
		return (fX) ? p1.getW() : p1.getD();
	}

	

}
