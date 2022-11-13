package Service;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlBeolvas {

    public JSONArray Beolvas(int keres) {
        JSONArray Diakok = new JSONArray();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File("Diakok.xml");
            Document xml = builder.parse(f);
            xml.normalize();
            NodeList nodeList = xml.getElementsByTagName("diak");
            // for (int i = 0; i < nodeList.getLength(); i++) { // az összes elem kiiratásához
            Node node = nodeList.item(keres);
            Element diak = (Element) node;
            JSONObject diakObject = new JSONObject();
            String Nev = diak.getElementsByTagName("Nev").item(0).getTextContent();
            String kor = diak.getElementsByTagName("kor").item(0).getTextContent();
            String osztaly = diak.getElementsByTagName("osztaly").item(0).getTextContent();
            String tagozat = diak.getElementsByTagName("tagozat").item(0).getTextContent();
            diakObject.put("Nev", Nev);
            diakObject.put("kor", kor);
            diakObject.put("osztaly", osztaly);
            diakObject.put("tagozat", tagozat);
            Diakok.put(diakObject);

            //   }
        } catch (IOException | ParserConfigurationException | JSONException | DOMException | SAXException e) {
        }
        return Diakok;
    }
}
