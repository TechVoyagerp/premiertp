package web;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculDeMonImc") // Accessible via http://localhost:8080/myproject/CalculDeMonImc
public class CalculDeMonImc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalculDeMonImc() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupération des paramètres depuis l'URL
        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        if (poidsStr != null && tailleStr != null) {
            try {
                double poids = Double.parseDouble(poidsStr);
                double taille = Double.parseDouble(tailleStr);

                // Création de l'objet Imc et appel de la méthode calcul
                Imc imc = new Imc(taille, poids);
                double resultatImc = imc.calcul();

                // Affichage du résultat
                out.println("<html><head><title>IMC</title></head><body>");
                out.println("<h2>Votre IMC est : " + String.format("%.2f", resultatImc) + "</h2>");
                out.println("</body></html>");
            } catch (NumberFormatException e) {
                out.println("<h2>Erreur : veuillez entrer des nombres valides.</h2>");
            } catch (IllegalArgumentException e) {
                out.println("<h2>Erreur : " + e.getMessage() + "</h2>");
            }
        } else {
            out.println("<h2>Veuillez fournir poids et taille dans l'URL.</h2>");
        }
    }
    
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupération des paramètres envoyés dans le corps de la requête
        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        if (poidsStr != null && tailleStr != null) {
            try {
                double poids = Double.parseDouble(poidsStr);
                double taille = Double.parseDouble(tailleStr);

                if (taille > 0) {
                    double imc = poids / (taille * taille);
                    out.println("<html><head><title>IMC</title></head><body>");
                    out.println("<h2>Votre IMC est : " + String.format("%.2f", imc) + "</h2>");
                    out.println("</body></html>");
                } else {
                    out.println("<h2>Erreur : la taille doit être supérieure à zéro.</h2>");
                }
            } catch (NumberFormatException e) {
                out.println("<h2>Erreur : veuillez entrer des nombres valides.</h2>");
            }
        } else {
            out.println("<h2>Erreur : Veuillez remplir tous les champs.</h2>");
        }
    }*/

}
