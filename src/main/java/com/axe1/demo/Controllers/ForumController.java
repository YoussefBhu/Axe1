package com.axe1.demo.Controllers;

import com.axe1.demo.Entities.Article;
import com.axe1.demo.Entities.Commentaire;
import com.axe1.demo.Exceptions.ForbiddenException;
import com.axe1.demo.Repositories.ArticleRepository;
import com.axe1.demo.Repositories.CommentaireRepository;
import com.axe1.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Articles")
public class ForumController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    @GetMapping(path= "/{Id}")
    public Article GetArticle(@PathVariable("Id") Long id){
        Article article =  articleRepository.findById(id).get();
        System.out.println(article.getCommentaires().size());
        return article;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String AddArticle(@RequestBody Article article){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        article.setAuteur(userRepository.findByUserName(auth.getName()));
        article.setDate(new Date());
        articleRepository.save(article);
        return "succès" ;
    }

    @PostMapping(path="/{id}/AddComment")
    @ResponseStatus(HttpStatus.OK)
    public String AddComment(@RequestBody Commentaire commentaire , @PathVariable("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        commentaire.setDate(new Date());
        commentaire.setAuteur(userRepository.findByUserName(auth.getName()));
        commentaire.setArticle(articleRepository.findById(id).get());
        commentaireRepository.save(commentaire);
        return "succès" ;
    }

    @DeleteMapping(path="/{Id}")
    public String DeleteArticle(@PathVariable("Id") Long id) throws ForbiddenException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Article article = articleRepository.findById(id).get();
        if(auth.getName().equals(article.getAuteur().getName() ) || auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
        {
            for(Commentaire c : article.getCommentaires())
                commentaireRepository.delete(c);
            articleRepository.delete(article);
            return "succès" ;
        }
        else throw new ForbiddenException() ;
    }

    @DeleteMapping(path="/Comments/{Id}")
    public String DeleteComment(@PathVariable("Id") Long id) throws ForbiddenException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Commentaire commentaire =  commentaireRepository.findById(id).get();
        if(auth.getName().equals(commentaire.getAuteur().getName() ) || auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
        {
            commentaireRepository.delete(commentaire);
            return "succès" ;
        }
        else throw new ForbiddenException() ;
    }




}
