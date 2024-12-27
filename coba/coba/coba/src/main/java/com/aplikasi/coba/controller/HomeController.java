package com.aplikasi.coba.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import com.aplikasi.coba.model.Article;
import com.aplikasi.coba.service.ArticleService;


@Controller
        @RequestMapping("")
        public class HomeController {

            @Autowired
    private ArticleService articleService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }
    

    @GetMapping("/konsultasi")
    public String konsultasiPage() {
        return "konsultasi";
        }
        @GetMapping("/konsultasi/hasil")
    public String consultationResult(@RequestParam("issue") String issue, Model model) {
        
        String phoneNumber = "";
        String consultant = "";
        String whatsappLink = "";

        switch (issue) {


        case "Stres dan kecemasan":
            consultant = "Dr. Andi Psikolog";
            phoneNumber = "+6281770603717";
            break;
        case "Depresi":
            consultant = "Dr. Budi Psikolog";
            phoneNumber = "+6282345678901";
            break;
        case "Masalah hubungan":
            consultant = "Dr. Clara Psikolog";
            phoneNumber = "+6283456789012";
            break;
        case "Trauma":
            consultant = "Dr. Dini Psikolog";
            phoneNumber = "+6284567890123";
            break;
        default:
            consultant = "Konsultan tidak ditemukan.";
            phoneNumber = "";
        }
        if (!phoneNumber.isEmpty()) {
            whatsappLink = "https://wa.me/" + phoneNumber.replace("+", "").replace(" ", "");
        }

        model.addAttribute("issue", issue);
        model.addAttribute("consultant", consultant);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("whatsappLink", whatsappLink);
        return "konsultasi_hasil";

      }


        @GetMapping("/list_tips")
    public String listTips() {
        return "list_tips";
        }




        @GetMapping("/tips_trik")
        public String getArticle(@RequestParam Long id, Model model) {
            Optional<Article> optionalArticle = articleService.getArticleById(id);
        
            if (optionalArticle.isPresent()) {
                Article article = optionalArticle.get();
                model.addAttribute("title", article.getTitle());  // Kirimkan title
                model.addAttribute("content", article.getContent());  // Kirimkan content
                return "tips_trik"; // Ganti dengan nama template yang sesuai
            } else {
                return "tips_not_found"; // Template untuk artikel tidak ditemukan
            }
        }
        
}


            
