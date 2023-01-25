package com.muhammetcakir.controller;

import com.muhammetcakir.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim1");
        model.addAttribute("key_model2", "Ben modelden geldim2");
        return "thymeleaf1";
    }

    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim1");
        model.addAttribute("key_model2", "Ben modelden geldim2");
        return "thymeleaf_file/thymeleaf3";
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim4");
        return "thymeleaf4";
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Model Object göndermek
    //http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim5");

        ProductDto productDto =
                ProductDto
                        .builder()
                        .productId(0L)
                        .productName("Ürün adı")
                        .productPrice(2500)
                        .build();

        model.addAttribute("key_model2", productDto);

        return "thymeleaf5";
    }

    //Model Object List göndermek
    //http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim5");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productId(1L).productName("Ürün adı1").productPrice(1500).build());
        listem.add(ProductDto.builder().productId(2L).productName("Ürün adı2").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(3L).productName("Ürün adı3").productPrice(3500).build());
        listem.add(ProductDto.builder().productId(4L).productName("Ürün adı4").productPrice(4500).build());


        model.addAttribute("product_liste", listem);

        return "thymeleaf6";
    }

}
