package de.htw.webtechdemo.topic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewTopicForm {


    private String title;

    private String content;

    private int sectionId;
}
