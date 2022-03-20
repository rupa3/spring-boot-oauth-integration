package com.oauth.poc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping
  public String homePage(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
        model.addAttribute("roleType", "Role Type is USER");
      } else {
        model.addAttribute("roleType", "Role Type is ADMIN");
      }
  }
    model.addAttribute("titlePage", "Integrating Spring Boot With OAUTH");
    return "home";
  }
}
