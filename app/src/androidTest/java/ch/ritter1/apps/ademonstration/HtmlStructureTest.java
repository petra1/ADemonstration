package ch.ritter1.apps.ademonstration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        assertNotNull("The <h1> tag was not found in dark_mode_heading_de.html.", h1);
        assertEquals("The text in the <h1> tag is not correct.", "Überschriften-Struktur", h1.text());

        Element h2 = doc.select("h2:contains(Ausgabe von TalkBack)").first();
        assertNotNull("h2 'Ausgabe von TalkBack' not found in dark_mode_heading_de.html.", h2);
        assertEquals("h2 text does not match.", "Ausgabe von TalkBack", h2.text());

        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Not enough h3 tags found in dark_mode_heading_de.html. Expected: 2, Found: " + h3s.size());
        }
        assertEquals("First h3 should be 'Native Apps'.", "Native Apps", h3s.get(0).text());
        assertEquals("Second h3 should be 'HTML content'.", "HTML-Inhalt", h3s.get(1).text());
    }

    @Test
    public void verifyHeadingsStructure_In_HeadingDeFile() throws Exception {
        String htmlContent = readAssetFile("heading_de.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for heading_de.html ---

        Element h1 = doc.select("h1").first();
        assertNotNull("The <h1> tag was not found in heading_de.html.", h1);
        assertEquals("The text in the <h1> tag is not correct.", "Überschriften-Struktur", h1.text());

        Element h2 = doc.select("h2:contains(Ausgabe von TalkBack)").first();
        assertNotNull("h2 'Ausgabe von TalkBack' not found in heading_de.html.", h2);
        assertEquals("h2 text does not match.", "Ausgabe von TalkBack", h2.text());

        Elements h3s = doc.select("h3");
        if (h3s.size() < 2) {
            fail("Not enough h3 tags found in heading_de.html. Expected: 2, Found: " + h3s.size());
        }
        assertEquals("First h3 should be 'Native Apps'.", "Native Apps", h3s.get(0).text());
        assertEquals("Second h3 should be 'HTML-Inhalt'.", "HTML-Inhalt", h3s.get(1).text());
    }

    @Test
    public void verifyOrderedLists_In_UsageFiles() throws Exception {
        // Test usage.html (English)
        String htmlContent = readAssetFile("usage.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for ol in usage.html ---
        Elements listItems = doc.select("ol > li");
        assertNotNull("The ordered list was not found in usage.html.", listItems);
        assertEquals("The ordered list should contain 5 items.", 5, listItems.size());

        assertEquals("Item 1 text is incorrect.", "Open Settings.", listItems.get(0).text());
        assertEquals("Item 2 text is incorrect.", "Scroll down to Accessibility and open it.", listItems.get(1).text());
        assertEquals("Item 3 text is incorrect.", "Scroll to TalkBack and open it.", listItems.get(2).text());
        assertEquals("Item 4 text is incorrect.", "Activate TalkBack with the button next to \"Use TalkBack\".", listItems.get(3).text());
        assertEquals("Item 5 text is incorrect.", "You may need to give TalkBack some permissions.", listItems.get(4).text());

        // Test dark_mode_usage.html (English)
        String dmHtmlContent = readAssetFile("dark_mode_usage.html");
        Document dmDoc = Jsoup.parse(dmHtmlContent);

        // --- Assertions for ol in dark_mode_usage.html ---
        Elements dmListItems = dmDoc.select("ol > li");
        assertNotNull("The ordered list was not found in dark_mode_usage.html.", dmListItems);
        assertEquals("The ordered list should contain 5 items.", 5, dmListItems.size());

        assertEquals("Item 1 text is incorrect.", "Open Settings.", dmListItems.get(0).text());
        assertEquals("Item 2 text is incorrect.", "Scroll down to Accessibility and open it.", dmListItems.get(1).text());
        assertEquals("Item 3 text is incorrect.", "Scroll to TalkBack and open it.", dmListItems.get(2).text());
        assertEquals("Item 4 text is incorrect.", "Activate TalkBack with the button next to \"Use TalkBack\".", dmListItems.get(3).text());
        assertEquals("Item 5 text is incorrect.", "You may need to give TalkBack some permissions.", dmListItems.get(4).text());
    }

     @Test
    public void verifyOrderedLists_In_UsageDeFiles() throws Exception {
        // Test usage_de.html (German)
        String htmlContent = readAssetFile("usage_de.html");
        Document doc = Jsoup.parse(htmlContent);

        // --- Assertions for ol in usage_de.html ---
        Elements listItems = doc.select("ol > li");
        assertNotNull("The ordered list was not found in usage_de.html.", listItems);
        assertEquals("The ordered list should contain 5 items.", 5, listItems.size());

        assertEquals("Item 1 text is incorrect.", "Öffnen Sie die Einstellungen", listItems.get(0).text());
        assertEquals("Item 2 text is incorrect.", "Scrollen Sie nach unten zu \"Eingabehilfen\" und öffnen Sie den Menüpunkt.", listItems.get(1).text());
        assertEquals("Item 3 text is incorrect.", "Scrollen Sie zu \"TalkBack\" und öffnen Sie es.", listItems.get(2).text());
        assertEquals("Item 4 text is incorrect.", "Aktivieren Sie TalkBack mit der Schaltfläche neben \"TalkBack verwenden\".", listItems.get(3).text());
        assertEquals("Item 5 text is incorrect.", "Geben Sie TalkBack die erforderlichen Berechtigungen.", listItems.get(4).text());

        // Test dark_mode_usage_de.html (German)
        String dmHtmlContent = readAssetFile("dark_mode_usage_de.html");
        Document dmDoc = Jsoup.parse(dmHtmlContent);

        // --- Assertions for ol in dark_mode_usage_de.html ---
        Elements dmListItems = dmDoc.select("ol > li");
        assertNotNull("The ordered list was not found in dark_mode_usage_de.html.", dmListItems);
        assertEquals("The ordered list should contain 5 items.", 5, dmListItems.size());

        assertEquals("Item 1 text is incorrect.", "Öffnen Sie die Einstellungen", dmListItems.get(0).text());
        assertEquals("Item 2 text is incorrect.", "Scrollen Sie nach unten zu \"Eingabehilfen\" und öffnen Sie den Menüpunkt.", dmListItems.get(1).text());
        assertEquals("Item 3 text is incorrect.", "Scrollen Sie zu \"TalkBack\" und öffnen Sie es.", dmListItems.get(2).text());
        assertEquals("Item 4 text is incorrect.", "Aktivieren Sie TalkBack mit der Schaltfläche neben \"TalkBack verwenden\".", dmListItems.get(3).text());
        assertEquals("Item 5 text is incorrect.", "Geben Sie TalkBack die erforderlichen Berechtigungen.", dmListItems.get(4).text());
     }


}
