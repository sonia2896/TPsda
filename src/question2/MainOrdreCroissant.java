package question2;

import question1.TasBinaire;

public class MainOrdreCroissant {

    public static void main(String[] args) {
        // Tableau taille fixée.
        TasBinaire tasBinaire = new TasBinaire(200000);
        // Analyse du temps pris par les opérations.
        Analyzer time_analysis = new Analyzer();
        // Analyse de l'espace mémoire inutilisé.
        Analyzer memory_analysis = new Analyzer();
        long before, after;
        // Booléen permettant de savoir si une allocation a été effectuée.
        for(int i = 1; i < 200000 ; i++){
            // Ajout d'un élément et mesure du temps pris par l'opération.
            before = System.nanoTime();
            tasBinaire.insert(i);
            after = System.nanoTime();

            // Enregistrement du temps pris par l'opération
            time_analysis.append(after - before);
            // Enregistrement du nombre de copies efféctuées par l'opération.
            // Enregistrement de l'espace mémoire non-utilisé.
            memory_analysis.append( tasBinaire.getCapacity() - tasBinaire.getSize() );
        }
        // Sauvegarde les données de l'expérience: temps et nombre de copies effectuées par opération.
        time_analysis.save_values("../plots/fixe_array_time_java_croissant.plot");
        memory_analysis.save_values("../plots/fixe_array_memory_java_croissant.plot");
    }
}
