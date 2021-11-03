package com.rsaStudy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DocumentBuilderTEST {

    public static void main(String argv[]) throws ParserConfigurationException, IOException, SAXException {

//        1.문서를 읽기위한 공장을 만들어야 한다.
        File xmlFile = new File("polymorphList.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        //2.빌더 생성
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        //3.생성된 빌더를 통해서 xml문서를 Document객체로 파싱해서 가져온다
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();//문서 구조 안정화

        Element root = doc.getDocumentElement();

        NodeList normal_list = root.getElementsByTagName("normallist");
        Element normalList = (Element) normal_list.item(0);

        NodeList monster_List = null;

        NodeList poly_morph = normalList.getElementsByTagName("polymorph");

        for (int i=0; i<poly_morph.getLength(); i++) {
            Element polymophList = (Element) poly_morph.item(i);
            monster_List = polymophList.getElementsByTagName("monster");

            for (int j = 0; j < monster_List.getLength(); j++) {
                Element monster= (Element) monster_List.item(j);
                System.out.println(monster.getAttributes().getNamedItem("id"));
                System.out.println(monster.getAttributes().getNamedItem("id").getNodeValue());
                monster.getAttributes().getNamedItem("id").getNodeValue();
            }
        }

//        Element el = null;
//        NodeList sub_n_list = null; //sub_n_list
//        Element sub_el = null; //sub_el
//
//        NodeList poly_n_list = null;
//
//        Node v_txt = null;
//        String value="";
//
//        String[] tagList = {"polymorph", "age", "job"};
//
//        for(int i=0; i<normal_list.getLength(); i++) {
//            el = (Element) normal_list.item(i);
//            for(int k=0; k< tagList.length; k++) {
//                sub_n_list = el.getElementsByTagName("polymorph");
//                for(int j=0; j<sub_n_list.getLength(); j++) {
//
//                    poly_n_list = el.getElementsByTagName("monster");
//
//                    for(int z=0; z<poly_n_list.getLength(); z++) {
//                        sub_el = (Element) poly_n_list.item(z);
//                        v_txt = sub_el.getFirstChild();
//                        value = v_txt.getNodeValue();
//
//                        System.out.println(sub_el.getNodeName() + "::::value="+value);
//                        if(sub_el.getAttributes().getNamedItem("id")!=null)
//                            System.out.println("id="+ sub_el.getAttributes().getNamedItem("id").getNodeValue() );
//                    }
//
//                }
//            }
//
//        }
    }

}