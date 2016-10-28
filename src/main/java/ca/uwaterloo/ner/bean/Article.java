package ca.uwaterloo.ner.bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter(value = AccessLevel.PRIVATE)
public class Article
{
    private String value;
    private String title;
    private String comment;
    private String userid;
    private String articleid;
    private String version;
    private String date;
}
