/**
 * Original is here: https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
*/

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlDomParser {

    public static void main(String[] args) {
        String filename = "resources/wf.xml";
        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        if (args.length > 0) {
            filename = args[0];
        }

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root XML element: " + doc.getDocumentElement().getNodeName());
            System.out.println();

            // get <global>
            NodeList list = doc.getElementsByTagName("property");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get attribute
                    String id = element.getAttribute("id");

                    // get text
                    String propertyName = element.getElementsByTagName("name").item(0).getTextContent();
                    String propertyValue = element.getElementsByTagName("value").item(0).getTextContent();

                    System.out.println("Current element:   " + node.getNodeName());
                    System.out.println("Element ID:        " + id);
                    System.out.println("Property name:     " + propertyName);
                    System.out.println("Property value:    " + propertyValue);
                    System.out.println();
              }
          }
        } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
    }
}
