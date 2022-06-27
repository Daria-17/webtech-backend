package de.htw.webtechdemo.section;

import de.htw.webtechdemo.topic.TopicService;
import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
public class SelectionRestController {

    private final SectionService sectionService;

    public SelectionRestController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    public String getTopicsFromSection(@PathVariable Long id, Model model) {
        model.addAttribute("sections", sectionService.findOne(id));
        model.addAttribute("topics", topicService.findBySection(id));
        return "sections";
    }

    @GetMapping(value = "new")
    public String getNewSectionForm(Model model) {
        model.addAttribute("newSection", new NewSectionForm());
        return "new_section_form";
    }

    @PostMapping(value = "new")
    public String processAndNewSection(@Valid
            @ModelAttribute("newSection") NewSectionForm newSection,
            BindingResult result) {
        if (result.hasErrors()) {
            return "new_section_form";
        }
        SectionManipulationRequest request = new SectionManipulationRequest();
        request.setName(newSection.getName());
        request.setDescription(newSection.getDescription());
        Section section = sectionService.save(request);
        return "redirect:/section/" + section.getId();
    }
//    @GetMapping(value = "delete/{id}")
//    public String delete(@PathVariable Long id, RedirectAttributes model){
//
//        sectionService.delete(id);
//        model.addFlashAttribute("message", "section.successfully.deleted");
//        return "redirect:/home";
//    }


}



