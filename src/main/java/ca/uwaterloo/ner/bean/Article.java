package ca.uwaterloo.ner.bean;

import ca.uwaterloo.ner.utils.WhiteSpaceRemovalDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String value;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String title;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String comment;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String userid;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String articleid;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String version;
    @JsonDeserialize(using = WhiteSpaceRemovalDeserializer.class)
    private String date;
    private List<Annotation> annotations;
}
