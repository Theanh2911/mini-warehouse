package week1.internJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import week1.internJava.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/sell")
    public ResponseEntity<String> sellProduct(@RequestParam int productId, @RequestParam int quantity) {
        try {
            productService.sellProduct(productId, quantity);
            return ResponseEntity.ok("Product sold and recorded successfully!");
        } catch (Exception e) {
            System.out.println("Error while selling product: {}"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred"+ e.getMessage());
        }

    }

}
