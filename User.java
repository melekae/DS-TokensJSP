/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


@WebServlet(urlPatterns = {"/user"})
public class User extends HttpServlet {

    // Metoda koja se izvršava prilikom HTTP POST zahteva
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Uzimanje vrednosti parametra "user_text" iz zahteva
        String p = request.getParameter("user_text");
        
        // Definisanje vrednosti promenljive "pag" koja predstavlja naziv ciljne JSP stranice
        String pag = "index1.jsp";
        
        
        // Uzimanje vrednosti recenice iz parametra "user_text"
        String rec = request.getParameter("user_text");
        
        // Definisanje regularnog izraza za razdvajanje recenice na tokene
        String regex = "[\\p{L}\\p{M}\\p{N}]+(?:\\p{P}[\\p{L}\\p{M}\\p{N}]+)*|[\\p{P}\\p{S}]";
        
        // Pronalaženje tokena u recenici na osnovu regularnog izraza
        String[] tokens = Pattern.compile(regex).matcher(rec).results().map(MatchResult::group).toArray(String[]::new);
        
        // Kreiranje stringa koji sadrži razdvojene tokene
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token).append(", ");
        }
        
        // Postavljanje atributa "recenica" u zahtev koji sadrži razdvojenu recenicu
        request.setAttribute("recenica", "Recenica podeljena na tokene: " + "[" + sb + "]");
        
        // Preusmeravanje zahteva na ciljnu JSP stranicu
        //ove linije koda omogućavaju preusmeravanje zahteva 
        //sa trenutnog servleta na drugu JSP stranicu kako bi se generisao odgovor za klijenta.
        RequestDispatcher dis = request.getRequestDispatcher(pag);
        dis.forward(request, response);
    }

}

