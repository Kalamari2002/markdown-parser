import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    MarkdownParse parser;
    @Before
    public void setUp() throws Exception{
        parser = new MarkdownParse();
    }

    @Test
    public void addition(){
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException{
        List expected = List.of("https://something.com", "some-thing.html");
        
        Path filePath = Path.of("additionaltests/test-file.md");
        String content = Files.readString(filePath);
        ArrayList<String> getLinksOutput = parser.getLinks(content);

        assertEquals(expected, getLinksOutput);

    }

    @Test
    public void getLinksNewTest() throws IOException{
        List expected = List.of("http://corndogoncorndog.com/", "corn-dog.html", "youtube.com", "https://www.ihasabucket.com/");
        
        Path filePath = Path.of("new-test-file.md");
        String content = Files.readString(filePath);
        ArrayList<String> getLinksOutput = parser.getLinks(content);

        assertEquals(expected, getLinksOutput);

    }

    @Test
    public void getLinksOtherTest() throws IOException{
        List expected = List.of("https://www.uol.com.br/");
        
        Path filePath = Path.of("other-test-file.md");
        String content = Files.readString(filePath);
        ArrayList<String> getLinksOutput = parser.getLinks(content);

        assertEquals(expected, getLinksOutput);

    }

    @Test
    public void getLinksLastTest() throws IOException{
        List expected = List.of("");
        
        Path filePath = Path.of("last-test-file.md");
        String content = Files.readString(filePath);
        ArrayList<String> getLinksOutput = parser.getLinks(content);

        assertEquals(expected, getLinksOutput);

    }
}
