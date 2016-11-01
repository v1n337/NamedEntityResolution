package ca.uwaterloo.ner.bean;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter(value = AccessLevel.PRIVATE)
@ToString
public class Annotation
{
    private String entity;
    private String tag;
}
