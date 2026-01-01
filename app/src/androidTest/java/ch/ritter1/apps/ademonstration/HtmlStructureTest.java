package ch.ritter1.apps.ademonstration;

import static org.junit.Assert.assertEquals;import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Instrumented test to verify the structure of HTML files in the assets.
 * This test runs on an Android device or emulator.
 */
@RunWith(AndroidJUnit4.class)
public class HtmlStructureTest {

    private Context context;

    @Before
    public void setup() {
        // Gets the app context to access the assets
        context = ApplicationProvider.getApplicationContext();
    }

    /**
     * Reads the content of a file from the 'assets' folder.
     */
    private String readAssetFile(String fileName) throws Exception {
        InputStream inputStream = context.getAssets().open(fileName);
        // Uses a scanner to efficiently convert the stream to a string
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name()).useDelimiter("\\A")) {
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    @Test
    public void verifyHeadingsStructure_In_DarkModeHeadingFile() throws Exception {
        // Load and parse the HTML file once
        String htmlContent = readAssetFile("dark_mode_heading.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for dark_mode_heading.html ---

        // Check H1
        Element h1 = doc.select("h1").first();
        assertNotNull("The <h1> tag was not found in dark_mode_heading.html.", h1);
        assertEquals("The text in the <h1> tag is not correct.", "Headings Structure", h1.text());

        // Check H2
        Element h2 = doc.select("h2:contains(Output of TalkBack)").first();
        assertNotNull("h2 'Output of TalkBack' not found in dark_mode_heading.html.", h2);
        assertEquals("h2 text does not match.", "Output of TalkBack", h2.text());

        // Check H3s
        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Not enough h3 tags found in dark_mode_heading.html. Expected: 2, Found: " + h3s.size());
        }
        assertEquals("First h3 should be 'Native Apps'.", "Native Apps", h3s.get(0).text());
        assertEquals("Second h3 should be 'HTML content'.", "HTML content", h3s.get(1).text());
    }

    @Test
    public void verifyHeadingsStructure_In_HeadingFile() throws Exception {
        String htmlContent = readAssetFile("heading.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for heading.html ---


        Element h1 = doc.select("h1").first();
        assertNotNull("The <h1> tag was not found in heading.html.", h1);
        assertEquals("The text in the <h1> tag is not correct.", "Headings Structure", h1.text());

        Element h2 = doc.select("h2:contains(Output of TalkBack)").first();
        assertNotNull("h2 'Output of TalkBack' not found in heading.html.", h2);
        assertEquals("h2 text does not match.", "Output of TalkBack", h2.text());

        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Not enough h3 tags found in heading.html. Expected: 2, Found: " + h3s.size());
        }
        assertEquals("First h3 should be 'Native Apps'.", "Native Apps", h3s.get(0).text());
        assertEquals("Second h3 should be 'HTML content'.", "HTML content", h3s.get(1).text());
    }

    // --- Tests for the German versions of the HTML files ---

    @Test
    public void verifyHeadingsStructure_In_DarkModeHeadingDeFile() throws Exception {
        String htmlContent = readAssetFile("dark_mode_heading_de.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for dark_mode_heading_de.html ---

        Element h1 = doc.select("h1").first();
        assertNotNull("Das <h1>-Tag wurde in dark_mode_heading_de.html nicht gefunden.", h1);
        assertEquals("Der Text im <h1>-Tag ist nicht korrekt.", "Überschriften-Struktur", h1.text());

        Element h2 = doc.select("h2:contains(Ausgabe von TalkBack)").first();
        assertNotNull("h2 'Ausgabe von TalkBack' nicht in dark_mode_heading_de.html gefunden.", h2);
        assertEquals("h2 Text stimmt nicht überein.", "Ausgabe von TalkBack", h2.text());

        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Nicht genügend h3-Tags in dark_mode_heading_de.html gefunden. Erwartet: 2, Gefunden: " + h3s.size());
        }
        assertEquals("Erstes h3 sollte 'Native Apps' sein.", "Native Apps", h3s.get(0).text());
        assertEquals("Zweites h3 sollte 'HTML Inhalt' sein.", "HTML Inhalt", h3s.get(1).text());
    }

    @Test
    public void verifyHeadingsStructure_In_HeadingDeFile() throws Exception {
        String htmlContent = readAssetFile("heading_de.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for heading_de.html ---

        Element h1 = doc.select("h1").first();
        assertNotNull("Das <h1>-Tag wurde in heading_de.html nicht gefunden.", h1);
        assertEquals("Der Text im <h1>-Tag ist nicht korrekt.", "Überschriften-Struktur", h1.text());

        Element h2 = doc.select("h2:contains(Ausgabe von TalkBack)").first();
        assertNotNull("h2 'Ausgabe von TalkBack' nicht in heading_de.html gefunden.", h2);
        assertEquals("h2 Text stimmt nicht überein.", "Ausgabe von TalkBack", h2.text());

        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Nicht genügend h3-Tags in heading_de.html gefunden. Erwartet: 2, Gefunden: " + h3s.size());
        }
        assertEquals("Erstes h3 sollte 'Native Apps' sein.", "Native Apps", h3s.get(0).text());
        assertEquals("Zweites h3 sollte 'HTML Inhalt' sein.", "HTML Inhalt", h3s.get(1).text());
    }

    // Tests for the usage.html and usage_de.html files

}
