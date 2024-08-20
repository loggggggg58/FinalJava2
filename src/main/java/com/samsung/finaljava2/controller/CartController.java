package com.samsung.finaljava2.controller;

import com.samsung.finaljava2.config.CustomUserDetails;
import com.samsung.finaljava2.service.ICartService;
import com.samsung.finaljava2.service.ICatalogService;
import com.samsung.finaljava2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @Autowired
    ICatalogService catalogService;

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String cart(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        model.addAttribute("catalogs", catalogService.getCatalogs());
        model.addAttribute("products", productService.getProducts());

        Long user_id = customUserDetails.getUser().getId();
        model.addAttribute("carts", cartService.getCart(user_id));

        model.addAttribute("count", cartService.countProduct(user_id));
        model.addAttribute("totalPrice", cartService.totalPrice(user_id));
        return "cartPage";
    }

    @PostMapping("/add/{id}")
    public String addCart(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long id) {
        Long user_id = customUserDetails.getUser().getId();
        Long product_id = id;
        cartService.addCart(user_id, product_id, 1);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeProductInCart(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable Long id) {
        Long user_id = customUserDetails.getUser().getId();
        Long product_id = id;
        cartService.removeProductInCart(user_id, product_id);
        return "redirect:/cart";
    }


    @PostMapping("/checkout")
    public String checkout(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long user_id = customUserDetails.getUser().getId();
        cartService.checkout(user_id);
        return "redirect:/catalog";
    }
}
