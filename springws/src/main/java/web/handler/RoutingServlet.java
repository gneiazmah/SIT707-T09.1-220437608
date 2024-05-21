package web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam("username") String username,
                              @RequestParam("passwd") String password,
                              @RequestParam("dob") String dob,
                              RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        if (LoginService.login(username, password, dob)) {
            redirectView = new RedirectView("/q1", true);
        } else {
            redirectView = new RedirectView("/login", true);
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
        }
        return redirectView;
    }

    @GetMapping("/q1")
    public String q1View() {
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(@RequestParam("number1") String number1,
                           @RequestParam("number2") String number2,
                           @RequestParam("result") String resultUser,
                           RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        try {
            double calculatedResult = MathQuestionService.q1Addition(number1, number2);
            if (calculatedResult == Double.parseDouble(resultUser)) {
                redirectView = new RedirectView("/q2", true);
            } else {
                redirectView = new RedirectView("/q1", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (IllegalArgumentException e) {
            redirectView = new RedirectView("/q1", true);
            redirectAttributes.addFlashAttribute("message", "Invalid input: " + e.getMessage());
        }
        return redirectView;
    }

    @GetMapping("/q2")
    public String q2View() {
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(@RequestParam("number1") String number1,
                           @RequestParam("number2") String number2,
                           @RequestParam("result") String resultUser,
                           RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        try {
            double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
            if (calculatedResult == Double.parseDouble(resultUser)) {
                redirectView = new RedirectView("/q3", true);
            } else {
                redirectView = new RedirectView("/q2", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (IllegalArgumentException e) {
            redirectView = new RedirectView("/q2", true);
            redirectAttributes.addFlashAttribute("message", "Invalid input: " + e.getMessage());
        }
        return redirectView;
    }

    @GetMapping("/q3")
    public String q3View() {
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(@RequestParam("number1") String number1,
                           @RequestParam("number2") String number2,
                           @RequestParam("result") String resultUser,
                           RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        try {
            double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
            if (calculatedResult == Double.parseDouble(resultUser)) {
                redirectView = new RedirectView("/final", true);
            } else {
                redirectView = new RedirectView("/q3", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (IllegalArgumentException e) {
            redirectView = new RedirectView("/q3", true);
            redirectAttributes.addFlashAttribute("message", "Invalid input: " + e.getMessage());
        }
        return redirectView;
    }

    @GetMapping("/final")
    public String finalView() {
        return "view-final";
    }
}
