package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bonjour") // Accès via http://localhost:8080/myproject/bonjour
public class firstservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // Spécifie que la réponse est du type HTML
        PrintWriter out = response.getWriter();

        // Génération de la page HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Example</title></head>");
        out.println("<body>");
        out.println("<p> C'est ma première servlet !</p>");
        out.println("</body></html>");
    }
	}

