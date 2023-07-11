package br.edu.ifpr.rest.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paginas")
public class AppResource {


    @GetMapping("/categorias")
    public ModelAndView page(){

        return new ModelAndView("categorias_page");

    }

}
