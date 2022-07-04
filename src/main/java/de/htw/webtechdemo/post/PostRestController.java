package de.htw.webtechdemo.post;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@AllArgsConstructor
public class PostRestController {


    private final PostService postService;

    @PostMapping

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
