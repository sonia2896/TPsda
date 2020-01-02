package question3;

import java.util.ArrayList;

/**
 * @author Yasmine HAMADOU
 */
public class TasBinaireDynamique {
	  // Tableau dynamique en Java. Sa capacité réelle est masquée, mais on peut avoir un contrôle dessus.
	  private int[] tas;
	  // Capacité réelle du tableau data.
	  private int capacity;
	  // Nombre réel d'éléments dans le tableau.
	  private int size;
	  
    /**
     * Crée un Tas Binaire de maximum {@code n} éléments
     * @param n nombre d'éléments maximum dans le tas
     */
    public TasBinaireDynamique() {
        this.capacity = 4;
        this.tas = new int[this.capacity];
    }

    public int getSize() {
        return size;
    }

    /**
     * ajoute le sommet {@code s} au tas binaire
     *
     * @param s est le sommet ajouté au tas binaire
     *          pour l'instant, s est ajouté en dernière position et la taille du tas est incrémentée
     */

    public boolean insert(int v) {
        // TODO
        int i = size;
        boolean memory_allocation = do_we_need_to_enlarge_capacity();
        if( memory_allocation ){
            enlarge_capacity();
        }
        
        while (i> 0 && tas[(i-1)/2] <=v) {
			tas[i] = tas[(i-1)/2];
			i = (i-1)/2;
		}
        tas[i] = v;
        size++;
        return memory_allocation;
    }
     /**
	    Cette fonction augmente la capacité du tableau.
	 */
	 private void enlarge_capacity(){
		 tas = java.util.Arrays.copyOf(tas, capacity*2);
	     capacity *= 2;
	 }

	 /**
	 Renvoie la capacité de stockage du tableau.
	 Complexité en temps/espace, pire cas : O(1)
	 @returns le nombre d'éléments stockés dans le tableau.
	*/
	int getCapacity(){
	    return capacity;
	}
	   
   
    /**
     Cette fonction détermine la règle selon laquelle un espace mémoire plus grand sera alloué ou non.
     @returns true si le tableau doit être agrandi, false sinon.
     */
    private boolean do_we_need_to_enlarge_capacity() {
        return size >= (capacity * 3)/4;
    }


    /** retourner du tas le sommet de plus petite valeur
     *
     * @return le sommet de plus petite valeur
     */
    public int getMit() {
        // TODO
        if (size == 0) throw new IllegalArgumentException("le tas est vide");

        int sMin = tas[1];
        for (int i = 2; i <= size; i++) {
            if (sMin < (tas[i]) ) {
                sMin = tas[i];
            }
        }
        return sMin;
    }

}
