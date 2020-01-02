package question3;

import java.util.Random;

import question1.TasBinaire;

public class MainOrdreAleatoire {

    public static void main(String[] args) {
        // Tableau taille fixée.
    	TasBinaireDynamique tasBinaire = new TasBinaireDynamique();
        // Analyse du temps pris par les opérations.
        Analyzer time_analysis = new Analyzer();
        // Analyse de l'espace mémoire inutilisé.
        Analyzer memory_analysis = new Analyzer();
        long before, after;
        // Booléen permettant de savoir si une a
        // Analyse du nombre de copies faites par les opérations.
        Analyzer copy_analysis = new Analyzer();
        
        Random r = new Random();
        // Booléen permettant de savoir si une allocation a été effectuée.
        boolean memory_allocation;
        for(int i = 1; i < 200000 ; i++){
        	// Ajout d'un élément et mesure du temps pris par l'opération.
        	 int valeur = 1 + r.nextInt(200000-1);
            before = System.nanoTime();
            memory_allocation = tasBinaire.insert(valeur);
            after = System.nanoTime();

            // Enregistrement du temps pris par l'opération
            time_analysis.append(after - before);
            // Enregistrement du nombre de copies efféctuées par l'opération.
            // Enregistrement de l'espace mémoire non-utilisé.
            memory_analysis.append( tasBinaire.getCapacity() - tasBinaire.getSize() );
            
            // Enregistrement du nombre de copies efféctuées par l'opération.
            // S'il y a eu réallocation de mémoire, il a fallu recopier tout le tableau.
            copy_analysis.append( (memory_allocation == true)? i: 1);
		}
        // Sauvegarde les données de l'expérience: temps et nombre de copies effectuées par opération.
        time_analysis.save_values("../plots/dynamyc_array_time_java_aleatoire.plot");
        memory_analysis.save_values("../plots/dynamyc_array_memory_java_aleatoire.plot");
    }
}
