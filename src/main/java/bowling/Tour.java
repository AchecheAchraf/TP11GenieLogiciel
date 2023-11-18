package bowling;

public class Tour {

	private int numTour;
	private int nbQuilleTombeesLancer1 = 0;
	private int nbQuilleTombeesLancer2 = 0;
	private int nbQuilleTombeesLancer3 = 0;
	private int numCoup = 1;
	boolean estFini = false;

	public Tour(int numTour){
		this.numTour = numTour;
	}

	public boolean estFini(){
		return estFini;
	}

	public boolean estStrike(){
		return nbQuilleTombeesLancer1 == PartieMonoJoueur.nbQuilles;
	}

	public boolean estSpare(){
		return numCoup == 2 && nbQuilleTombeesLancer1+nbQuilleTombeesLancer2 == PartieMonoJoueur.nbQuilles && numTour != PartieMonoJoueur.nbTours;
	}

	public void lancer(int valeur){
		switch (numCoup){
			case 1:
				nbQuilleTombeesLancer1 += valeur;
				if (nbQuilleTombeesLancer1 == PartieMonoJoueur.nbQuilles && numTour != PartieMonoJoueur.nbTours) estFini = true;
				else if (nbQuilleTombeesLancer1 == PartieMonoJoueur.nbQuilles) numCoup += 1;
				else numCoup++;
				break;
			case 2:
				nbQuilleTombeesLancer2 += valeur;
				estFini = true;
				if (numTour == PartieMonoJoueur.nbTours) {
					if (!(nbQuilleTombeesLancer1+nbQuilleTombeesLancer2 < PartieMonoJoueur.nbQuilles)){
						numCoup++;
						estFini = false;
					}
				}
				break;
			case 3:
				nbQuilleTombeesLancer3 += valeur;
				estFini = true;
				break;
		}
	}

	public int getNbQuilleTombeesLancer1() {
		return nbQuilleTombeesLancer1;
	}

	public int getNbQuilleTombeesLancer2() {
		return nbQuilleTombeesLancer2;
	}

	public int getNbQuilleTombeesLancer3() {
		return nbQuilleTombeesLancer3;
	}

	public int getNumCoup() {
		return numCoup;
	}
}