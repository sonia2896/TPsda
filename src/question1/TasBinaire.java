package question1;

/**
 * @author Yasmine HAMADOU
 */
public class TasBinaire {
    private int[] tas; // Structure de tas
    private int size; // nombre d'éléments dans le tas
    private int capacity;
    /**
     * Crée un Tas Binaire de maximum {@code n} éléments
     * @param n nombre d'éléments maximum dans le tas
     */
    public TasBinaire(int n) {
        tas = new int[n + 1]; // structure du tas commence à l'indice 1
        size = 0;
        size = 0;
        capacity = n;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * ajoute le sommet {@code s} au tas binaire
     *
     * @param s est le sommet ajouté au tas binaire
     *          pour l'instant, s est ajouté en dernière position et la taille du tas est incrémentée
     */

    public void insert(int v) {
        // TODO
        int i = size;
        if (size >= tas.length - 1) throw new IllegalArgumentException("le tas est plein");
        while (i> 0 && tas[(i-1)/2] <=v) {
			tas[i]= tas[(i-1)/2];
			i = (i-1)/2;
		}
        tas[i] = v;
        size++;
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
        int indiceMin = 1;
        for (int i = 2; i <= size; i++) {
            if (sMin < (tas[i]) ) {
                indiceMin = i;
                sMin = tas[i];
            }
        }
        return sMin;
    }

}
