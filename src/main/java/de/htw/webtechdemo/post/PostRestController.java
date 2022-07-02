package de.htw.webtechdemo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class PostRestController {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes model) {
        Post post = postService.findOne(id);
        if (post == null) {
            return "redirect:/";
        }
        postService.delete(post);

        model.addFlashAttribute("message", "post.successfully.deleted");
        return "redirect:/topic/" + post.getTopic().getId();
    }
}
