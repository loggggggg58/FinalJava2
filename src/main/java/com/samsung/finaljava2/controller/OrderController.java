package com.samsung.finaljava2.controller;

import com.samsung.finaljava2.config.CustomUserDetails;
import com.samsung.finaljava2.service.ICatalogService;
import com.samsung.finaljava2.service.IOrderService;
import com.samsung.finaljava2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ICatalogService catalogService;

    @Autowired
    IProductService productService;

    @Autowired
    IOrderService orderService;

    @GetMapping("")
    public String order(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        model.addAttribute("catalogs", catalogService.getCatalogs());
        model.addAttribute("products", productService.getProducts());
        Long user_id = customUserDetails.getUser().getId();
        model.addAttribute("orders", orderService.getOrders(user_id));

        return "orderPage";
    }
}
