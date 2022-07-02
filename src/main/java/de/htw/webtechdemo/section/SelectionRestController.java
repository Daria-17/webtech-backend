package de.htw.webtechdemo.section;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.topic.TopicEntity;
import de.htw.webtechdemo.topic.TopicService;
import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/selections")
public class SelectionRestController {

    private final SectionService sectionService;

    public SelectionRestController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Section>> fetchSections() {
        return ResponseEntity.ok(sectionService.findAll());
    }

    @GetMapping(path = "/{id}/topics")
    public ResponseEntity<Section> fetchSectionByIdIncludeTopics(@PathVariable Long id) {
        var section = sectionService.findOne(id);
        Set<Topic> topics = topicService.findBySection(id);
        return section != null ? ResponseEntity.ok(section) : ResponseEntity.notFound().build();
    }

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

    @PostMapping("")
    public ResponseEntity<Void> createSection(@RequestBody SectionManipulationRequest request) throws URISyntaxException {
        var section = sectionService.create(request);
        URI uri = new URI("/api/v1/sections/" + section.getId());
        return ResponseEntity.created(uri).build();
    }

//    @PostMapping(value = "new")
//    public String processAndNewSection(@Valid
//                                       @ModelAttribute("newSection") NewSectionForm newSection,
//                                       BindingResult result) {
//        if (result.hasErrors()) {
//            return "new_section_form";
//        }
//        SectionManipulationRequest request = new SectionManipulationRequest();
//        request.setName(newSection.getName());
//        request.setDescription(newSection.getDescription());
//        Section section = sectionService.save(request);
//        return "redirect:/section/" + section.getId();
//    }
//    @GetMapping(value = "delete/{id}")
//    public String delete(@PathVariable Long id, RedirectAttributes model){
//
//        sectionService.delete(id);
//        model.addFlashAttribute("message", "section.successfully.deleted");
//        return "redirect:/home";
//    }


}



