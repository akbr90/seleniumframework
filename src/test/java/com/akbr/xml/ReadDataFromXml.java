package com.akbr.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * TODO Put here a description of what this class does.
 *
 * @author AKBAR.
 *         Created Dec 13, 2020.
 */
public class ReadDataFromXml {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {


		String path=System.getProperty("user.dir")+"/src/main/TestDataXml/TestData.xml";

		File file = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbf.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList nodeList = doc.getElementsByTagName("Credential");
		int tLength = nodeList.getLength();


		for(int i=0; i<tLength; i++){
			Node node = nodeList.item(i);

			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element element = (Element)node;
				System.out.println("User: "+element.getElementsByTagName("User").item(0).getTextContent());
				System.out.println("Password: "+element.getElementsByTagName("Password").item(0).getTextContent());
				System.out.println("Card: "+element.getElementsByTagName("Card").item(0).getTextContent());
				System.out.println("Pin: "+element.getElementsByTagName("pin2").item(0).getTextContent());
				
			}

		}

	}

}
