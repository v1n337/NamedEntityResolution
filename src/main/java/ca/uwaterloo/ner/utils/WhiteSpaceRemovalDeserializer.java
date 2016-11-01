package ca.uwaterloo.ner.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class WhiteSpaceRemovalDeserializer extends JsonDeserializer<String>
{
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt)
    {
        return p.getCurrentToken().asString().trim();
    }
}
