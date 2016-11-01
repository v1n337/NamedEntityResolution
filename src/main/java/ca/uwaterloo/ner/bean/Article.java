package ca.uwaterloo.ner.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter(value = AccessLevel.PRIVATE)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article
{
    private String value;
    private String title;
    private String comment;
    private String userid;
    private String articleid;
    private String version;
    private String date;
    private List<Annotation> annotations;
}
