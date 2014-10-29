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
		multiCube cubMaxV = mk1.setNewCube();
		while (! queMC.isEmpty()){
			multiCube mk2 = queMC.poll();
			if (cubMaxV.compareTo(mk2)==0){
				cubMaxV=mk2.setNewCube();}
			if (cubMaxV.vK()>90) break;
			//get then access points count
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
						mk3_1.add(pNew1, i);
						mk3_2.add(pNew2, i);
						mk3_3.add(pNew3, i);
						queMC.add(mk3_1);
						queMC.add(mk3_2);
						queMC.add(mk3_3);
					}
				}
			}
			//kogato we`e nemo[e da se dobawqt paketi
			ArrayList<pack> usedPacks =  cubMaxV.getPacks();
			
			for(int i=0;i<usedPacks.size();i++){
				pack tmpPack = usedPacks.get(i);
				int j=tmpPack.getID();
				tmpPack.setUsed(1);
				packs.add(j, tmpPack);
			}
			//trebwa da izbera nowi now kub
		}
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
