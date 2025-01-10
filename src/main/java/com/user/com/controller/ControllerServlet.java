package com.studysphere.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String view = "";

        try {
            if (action == null || action.isEmpty()) {
                view = "home.jsp";
            } else {
                switch (action) {
                    case "login":
                        view = login(request, response);
                        break;
                    case "register":
                        view = register(request, response);
                        break;
                    case "viewMaterials":
                        view = viewMaterials(request, response);
                        break;
                    default:
                        view = "error.jsp";
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            view = "error.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password123".equals(password)) {
            request.setAttribute("message", "Login successful!");
            return "dashboard.jsp";
        } else {
            request.setAttribute("error", "Invalid credentials");
            return "login.jsp";
        }
    }

    private String register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("message", "Registration successful!");
        return "login.jsp";
    }

    private String viewMaterials(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("materials", "List of Study Materials");
        return "materials.jsp";
    }
}