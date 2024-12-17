package com.badabdd.beautysal00n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";  // Wskazuje stronę główną, dostępna tylko dla zalogowanych użytkowników
    }

    @GetMapping("/")
    public String homePage() {
        return "index";  // Strona główna dostępna bez logowania
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Strona logowania
    }
    @GetMapping("/employee")
    public String employeeDashboard() {
        return "employee-dashboard"; // Widok danych pracownika
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin-dashboard"; // Widok administracyjny
    }

}
