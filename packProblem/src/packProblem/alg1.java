package packProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class alg1 {
	private ArrayList<pack> packs;
	private PriorityQueue<multiCube> queMC = new PriorityQueue<multiCube>();

	/*
	 * make empty pag x,y z put max_X element in it get new empty pag with no
	 * filled space from max_X element make a list with all packs that can be
	 * put in this space run the full position tray function
	 */
	public alg1(ArrayList<pack> el) {
		int w = 0, d = 0, h = 0, h1 = 0;
		pack first;

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
		do {
			testme(w, d, h, h1, first);
			// get new first
			first = findMax_XY(true);
			h1 = h;
			if (first != null) {
				h = first.getH();
			} else {
				break;
			}

		} while (true);

	}

	private void testme(int w, int d, int h, int h1, pack first) {
		multiCube mk1 = new multiCube(w, d, h, 0);
		mk1.setZ(h1);
		mk1.add(first);
		queMC.add(mk1);
		multiCube cubMaxV = mk1.setNewCube();
		while (!queMC.isEmpty()) {
			multiCube mk2 = queMC.poll();
			if (cubMaxV.compareTo(mk2) == 0) {
				cubMaxV = mk2.setNewCube();
			}
			if (cubMaxV.vK() > 90)
				break;
			// get then access points count
			int frP = mk1.freePointsCo();
			// probwam da dobawqm paketi
			for (int i = 0; i < frP; i++) {
				for (int j = 0; j < packs.size(); j++) {
					if (packs.get(j).getUsed() == 0) {
						multiCube mk3_1 = mk2.setNewCube();
						multiCube mk3_2 = mk2.setNewCube();
						multiCube mk3_3 = mk2.setNewCube();
						pack pNew1 = packs.get(j).getNewPack();
						pack pNew2 = packs.get(j).getNewPack();
						pack pNew3 = packs.get(j).getNewPack();
						pNew1.rotate(1);
						pNew2.rotate(2);
						pNew3.rotate(3);
						mk3_1.add(pNew1);
						mk3_2.add(pNew2);
						mk3_3.add(pNew3);
						queMC.add(mk3_1);
						queMC.add(mk3_2);
						queMC.add(mk3_3);
					}
				}
				mk2.remuvePoint();
			}
		}
		// kogato we`e nemo[e da se dobawqt paketi
		ArrayList<pack> usedPacks = cubMaxV.getPacks();

		for (int i = 0; i < usedPacks.size(); i++) {
			pack tmpPack = usedPacks.get(i);
			int j = tmpPack.getID() - 1;
			tmpPack.setUsed(1);
			packs.remove(j);
			packs.add(j, tmpPack);
		}
		// trebwa da izbera nowi now kub
	}

	private pack findMax_XY(Boolean fX) {
		int m_x = 0, j = -1, z;
		for (int i = 0; i < packs.size(); i++) {
			pack p = packs.get(i);
			if (p.getUsed() == 0) {
				z = getXY(fX, p);
				if (m_x < z) {
					m_x = z;
					j = i;
				}
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
