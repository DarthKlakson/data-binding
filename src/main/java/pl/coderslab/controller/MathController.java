package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.service.MathService;

@RestController
@RequestMapping("/api/mathes")
public class MathController {

    private final MathService mathService;

    public MathController(MathController mathController) {
        this.mathService = mathController.mathService;
    }

    @GetMapping("/sum/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b) {
        return mathService.sum(a, b);
    }

    @GetMapping("/subtract/{a}/{b}")
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return mathService.subtract(a, b);
    }

    @GetMapping("/multiply/{a}/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return mathService.multiply(a, b);
    }

    @GetMapping("/devide/{a}/{b}")
    public int devide(@PathVariable int a, @PathVariable int b) {
        return mathService.divide(a, b);
    }

    @GetMapping("/factorial/{a}")
    public int factorial(@PathVariable int a) {
        return mathService.factorial(a);
    }
}
