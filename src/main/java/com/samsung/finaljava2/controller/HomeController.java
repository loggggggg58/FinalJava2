package com.samsung.finaljava2.controller;

import com.samsung.finaljava2.config.CustomUserDetails;
import com.samsung.finaljava2.service.ICatalogService;
import com.samsung.finaljava2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    ICatalogService catalogService;

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String home() {
        return "redirect:/catalog";
    }

    @GetMapping("/catalog")
    public String catalogAll(Model model) {
        model.addAttribute("catalogs", catalogService.getCatalogs());
        model.addAttribute("products", productService.getProducts());
        return "catalogPage";
    }

    @GetMapping("/catalog/{id}")
    public String catalogById(Model model, @PathVariable int id) {
        model.addAttribute("catalogs", catalogService.getCatalogs());
        model.addAttribute("products", productService.getProductsByCatalogId((long) id));
        return "catalogPage";
    }
}
