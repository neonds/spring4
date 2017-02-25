package io.company.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.company.sample.SampleService;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private SampleService sampleService;
  
  @GetMapping
  public String index(Model model) {
    model.addAttribute("serviceMessage", sampleService.getServiceName());
    return "home/index";
  }
}
