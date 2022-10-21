package com.springLegacy.pubData;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pubData.vo.EStationVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		// ����������
		// - �ѱ�ȯ�����_�����ڵ��� ������ ����
		// https://apis.data.go.kr/B552584/EvCharger/getChargerInfo?
		// serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D
		// &pageNo=1
		// &numOfRows=10
		// &zcode=11
		
		StringBuffer sb = new StringBuffer();
		
		sb.append( "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?" )
		  .append( "serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D" )
		  .append( "&pageNo=1" )
		  .append( "&numOfRows=10" )
		  .append( "&zcode=11" );
		
		// URL �� ������ ��� ������ �����ϴ� Object ����.
		URL url = new URL( sb.toString() );
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.connect();
		
		// �����ʿ��� ������ �ڿ��� xml �̸� 
		// �ڹ�ȯ�濡�� ���� �Ľ��ϴ� �ļ��� �ϳ��� JDOM ����Ѵ�.
		
		// XML ������ �����ϱ� ���� SAXBuilder ��� ��ü�� �ʿ���!
		SAXBuilder builder = new SAXBuilder();
		
		// SAXBuilder �� ���� ����( Document )��ü�� ����.
		Document doc = builder.build( conn.getInputStream() );
		
		// ������ ���� ������ü���� ��Ʈ������Ʈ�� ���Ѵ�.
		Element root = doc.getRootElement();
		System.out.println( root.getName() );
		
		Element body = root.getChild( "body" );
		
		Element items = body.getChild( "items" );
		
		List<Element> item_list = items.getChildren( "item" );
		
		EStationVO[] ar = new EStationVO[ item_list.size() ];
		
		int nth = 0;
		
		for( Element item : item_list ) {
			// �� item element ���� statNm element �� text �� �����´�.
			
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
		
		
		return "home";
	}
	
}
