package org.zwobble.mammoth.tests.docx;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.zwobble.mammoth.docx.ContentTypes;
import org.zwobble.mammoth.xml.XmlElement;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.zwobble.mammoth.docx.ContentTypesXml.readContentTypesXmlElement;
import static org.zwobble.mammoth.xml.XmlNodes.element;

public class ContentTypesXmlTests {
    @Test
    public void contentTypesBasedOnDefaultForExtensionIfThereIsNoOverride() {
        XmlElement element = element("content-types:Types", ImmutableList.of(
            element("content-types:Default", ImmutableMap.of(
                "Extension", "png",
                "ContentType", "image/png"))));
        ContentTypes contentTypes = readContentTypesXmlElement(element);
        assertEquals(
            Optional.of("image/png"),
            contentTypes.findContentType("word/media/hat.png"));
    }
}
