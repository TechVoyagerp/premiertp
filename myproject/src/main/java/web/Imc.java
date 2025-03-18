package web;

public class Imc {
    private double taille;
    private double poids;

    // Constructeur avec les paramètres taille et poids
    public Imc(double taille, double poids) {
        this.taille = taille;
        this.poids = poids;
    }

    // Méthode pour calculer l'IMC
    public double calcul() {
        if (taille > 0) {
            return poids / (taille * taille);
        }
        return 0; // Si la taille est 0 ou invalide, retourner 0 pour éviter la division par zéro
    }
}