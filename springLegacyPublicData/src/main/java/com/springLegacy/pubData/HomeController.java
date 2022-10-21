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
		// 공공데이터
		// - 한국환경공단_전기자동차 충전소 정보
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
		
		// URL 은 웹상의 경로 연결을 정의하는 Object 생성.
		URL url = new URL( sb.toString() );
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.connect();
		
		// 서버쪽에서 보내는 자원이 xml 이면 
		// 자바환경에서 쉽궤 파싱하는 파서중 하나로 JDOM 사용한다.
		
		// XML 문서를 인지하기 위해 SAXBuilder 라는 객체가 필요함!
		SAXBuilder builder = new SAXBuilder();
		
		// SAXBuilder 를 통해 문서( Document )객체를 얻어낸다.
		Document doc = builder.build( conn.getInputStream() );
		
		// 위에서 구한 문서객체에서 루트엘리먼트를 구한다.
		Element root = doc.getRootElement();
		System.out.println( root.getName() );
		
		Element body = root.getChild( "body" );
		
		Element items = body.getChild( "items" );
		
		List<Element> item_list = items.getChildren( "item" );
		
		EStationVO[] ar = new EStationVO[ item_list.size() ];
		
		int nth = 0;
		
		for( Element item : item_list ) {
			// 각 item element 에서 statNm element 의 text 를 가져온다.
			
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
