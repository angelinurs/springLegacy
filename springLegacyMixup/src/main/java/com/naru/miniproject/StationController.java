package com.naru.miniproject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pubData.EStationVO;

@Controller
public class StationController {
	private String kakaoMapKey = "45370cb3ddc7ad495a13fcfd6952c6e3";

	@RequestMapping( value="/location", method = RequestMethod.GET )
	public String getLocation( Model model ) throws Exception {
		// ����������
		// - �ѱ�ȯ�����_�����ڵ��� ������ ����
		// https://apis.data.go.kr/B552584/EvCharger/getChargerInfo?
		// serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D
		// &pageNo=1
		// &numOfRows=10
		// &zcode=11
		
		StringBuilder sb = new StringBuilder();
		
		sb.append( "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?" )
		  .append( "serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D" )
		  .append( "&pageNo=1" )
		  .append( "&numOfRows=10" )
		  .append( "&zcode=11" );
		
		// URL �� ������ ��� ������ �����ϴ� Object ����.
		URL url = new URL( sb.toString() );
		
		HttpURLConnection conn = ( HttpURLConnection )url.openConnection();
		
		conn.connect();
		
		// �����ʿ��� ������ �ڿ��� xml �̸� 
		// �ڹ�ȯ�濡�� ���� �Ľ��ϴ� �ļ��� �ϳ��� JDOM ����Ѵ�.
		
		// XML ������ �����ϱ� ���� SAXBuilder ��� ��ü�� �ʿ���!
		SAXBuilder builder = new SAXBuilder();
				
		// SAXBuilder �� ���� ����( Document )��ü�� ����.
		Document doc = builder.build( conn.getInputStream() );
		
		Element root = doc.getRootElement();
		
		List<Element> items = root.getChild( "body" ).getChild( "items" ).getChildren( "item" );
		
		EStationVO[] ar = new EStationVO[ items.size() ];
		
		int nth = 0;
		
		for( Element item : items )	{
			String statNm = item.getChildText( "statNm" );
			String chgerType = item.getChildText( "chgerType" );
			String addr = item.getChildText( "addr" );
			String lat = item.getChildText( "lat" );
			String lng = item.getChildText( "lng" );
			String useTime = item.getChildText( "useTime" );
			String busiCall = item.getChildText( "busiCall" );
			
			ar[ nth++ ] = new EStationVO(statNm, chgerType, addr, lat, lng, useTime, busiCall);
		}
		
		model.addAttribute( "ar", ar );
		model.addAttribute( "mapKey", kakaoMapKey );
		
		return "estation/map";
	}
}
