package main.webapp;


import main.webapp.beans.User;
import main.webapp.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "MainServlet", urlPatterns = ("/MainServlet"))
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
//        List<Cokkie> listCokkie = new ArrayList<>();
 //       listCokkie = request.getCookies();
   //     System.out.println(listCokkie);
//        request.getHeader();
//        request.getQueryString();
//        request.getRequestedSessionId();
//        request.getSession();
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");
        user.setSurname(surname);
        user.setName(name);
        try {
            UserService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            response.getOutputStream().print("gonderildi");
            response.getOutputStream().close();
        } catch (Exception e){
            e.printStackTrace();
        }

//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("");
//        System.out.println("Alindi");
//        response.sendRedirect("index.jsp");
    }
}
