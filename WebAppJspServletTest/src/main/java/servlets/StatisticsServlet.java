package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Statistic;

/**
 *
 * @author bhemrik
 */
@WebServlet({"", "/", "/statistics"})
public class StatisticsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        List<Statistic> statistics1 = new ArrayList<>();
        
        statistics1.add(new Statistic("Mária", "Kiss", "23/24", 400, 430, 12.2));
        statistics1.add(new Statistic("Mária", "Kiss", "22/23", 410, 450, 11.5));
        statistics1.add(new Statistic("Mária", "Kiss", "21/22", 350, 390, 13.6));
        statistics1.add(new Statistic("Mária", "Kiss", "20/21", 380, 420, 14.0));
        statistics1.add(new Statistic("Mária", "Kiss", "19/20", 420, 470, 13.4));
        
         List<Statistic> statistics2 = new ArrayList<>();
        
        statistics2.add(new Statistic("János", "Nagy", "23/24", 500, 600, 8.9));
        statistics2.add(new Statistic("János", "Nagy", "22/23", 550, 610, 9.7));
        statistics2.add(new Statistic("János", "Nagy", "21/22", 530, 610, 9.9));
        statistics2.add(new Statistic("János", "Nagy", "20/21", 480, 590, 8.5));
        statistics2.add(new Statistic("János", "Nagy", "19/20", 580, 630, 10.0));
        
        String listSelectionParam = req.getParameter("listSelection");
        int selectionValue = 1;
        if (listSelectionParam != null) {
            selectionValue = Integer.parseInt(listSelectionParam);
        }
        
        List<Statistic> returnList = statistics1;
        if (selectionValue == 2) {
            returnList = statistics2;
        }
        
        req.setAttribute("statistics", returnList);
        
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
    
}
