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
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = ("/MainServlet"))
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

       if (request.getParameter("submitSelectUser") != null){
           User user = new User();
           try {
               user = UserService.selectUser(Integer.parseInt(request.getParameter("selectedUserId")));
               response.getOutputStream().print(user.toString());
               response.getOutputStream().print(MainServlet.printAllUsers());
               response.getOutputStream().close();
           } catch (Exception e){
               e.printStackTrace();
           }
       }

        if (request.getParameter("submitSetUser") != null) {
            User user = new User();
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Integer nationalityId = Integer.parseInt(request.getParameter("nationalityId"));
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setPhone(phone);
            user.setNationalityId(nationalityId);
            try {
                UserService.insertUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                response.getOutputStream().print("gonderildi");
                response.getOutputStream().print(MainServlet.printAllUsers());
                response.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (request.getParameter("updateUser") != null) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Integer nationalityId = Integer.parseInt(request.getParameter("nationalityId"));
            try {
              User user1 = UserService.selectUser(Integer.parseInt(request.getParameter("idUpdatedUser")));
              user1.setName(name);
              user1.setSurname(surname);
              user1.setEmail(email);
              user1.setPhone(phone);
              user1.setNationalityId(nationalityId);
              UserService.insertUser(user1);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("");
//        System.out.println("Alindi");
//        response.sendRedirect("index.jsp");

        if(request.getParameter("submitDeleteUser")  != null) {
            try {
                UserService.deleteUser(Integer.parseInt(request.getParameter("deletedUserId")));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String printAllUsers(){
        try {
            List<User> list = UserService.selectAllUsers();
            String str = "";
            for (User u : list) {
                str += u.toString() + "\n";
            }
            return str;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
