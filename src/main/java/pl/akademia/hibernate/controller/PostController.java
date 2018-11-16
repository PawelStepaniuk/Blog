package pl.akademia.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademia.hibernate.dao.CommentDao;
import pl.akademia.hibernate.dao.PostDao;
import pl.akademia.hibernate.model.Comment;
import pl.akademia.hibernate.model.Post;

@Controller
public class PostController {
    //Generuje komponent
    @Autowired
    private PostDao postDao;
    @GetMapping("/posts/add")
    public String addPost() {
        return "posts/add";
    }

    @PostMapping("/posts")
    public String create(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts/all";
    }
    @GetMapping("/posts/all")
    public String All(ModelMap modelMap){
        modelMap.put("posts",postDao.findAll());
        return "posts/all";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable Long id, ModelMap modelMap){
        modelMap.put("post",postDao.findById(id).get());
        return "posts/show";
    }
    @Autowired
    private CommentDao commentDao;

    @PostMapping("/posts/addComment")
    public String addComment(@ModelAttribute Comment comment,
                             RedirectAttributes redirectAttributes){
        commentDao.save(comment);
        redirectAttributes.addFlashAttribute("message","Pomyślnie dodano komentarz");
        return "redirect:/posts/"+comment.getPost().getId();
    }
}
