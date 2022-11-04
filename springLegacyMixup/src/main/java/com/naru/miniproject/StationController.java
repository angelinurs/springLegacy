package com.naru.miniproject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping( value="/location/estation", method = RequestMethod.GET )
	public String getLocation( String zcode, Model model ) throws Exception {
		// 공공데이터
		// - 한국환경공단_전기자동차 충전소 정보
		// https://apis.data.go.kr/B552584/EvCharger/getChargerInfo?
		// serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D
		// &pageNo=1
		// &numOfRows=10
		// &zcode=11
		
		// 서울 특별시 지역 code ( default value settup )
		if( zcode == null ) {
			zcode = "11";
		}
		
//		System.out.println( "zcode : " + zcode);
		
		model.addAttribute( "ar", getList(zcode).get( "ar" ) );
		model.addAttribute( "lat", getList(zcode).get( "lat" ) );
		model.addAttribute( "lng", getList(zcode).get( "lng" ) );
		model.addAttribute( "zcode", zcode );
		model.addAttribute( "mapKey", kakaoMapKey );
		
		return "location/map";
	}
	
	public Map<String, Object> getList( String zcode ) throws Exception {
		
		
		// 공공데이터
		// - 한국환경공단_전기자동차 충전소 정보
		// https://apis.data.go.kr/B552584/EvCharger/getChargerInfo?
		// serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D
		// &pageNo=1
		// &numOfRows=10
		// &zcode=11
		
		StringBuilder sb = new StringBuilder();
		
		sb.append( "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?" )
		  .append( "serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D" )
		  .append( "&pageNo=1" )
		  .append( "&numOfRows=20" )
		  .append( "&zcode=" )
		  .append( zcode );
		
		// URL 은 웹상의 경로 연결을 정의하는 Object 생성.
		URL url = new URL( sb.toString() );
		
		HttpURLConnection conn = ( HttpURLConnection )url.openConnection();
		
		conn.connect();
		
		// 서버쪽에서 보내는 자원이 xml 이면 
		// 자바환경에서 쉽궤 파싱하는 파서중 하나로 JDOM 사용한다.
		
		// XML 문서를 인지하기 위해 SAXBuilder 라는 객체가 필요함!
		SAXBuilder builder = new SAXBuilder();
				
		// SAXBuilder 를 통해 문서( Document )객체를 얻어낸다.
		Document doc = builder.build( conn.getInputStream() );
		
		Element root = doc.getRootElement();
		
		List<Element> items = root.getChild( "body" ).getChild( "items" ).getChildren( "item" );
		
		EStationVO[] ar = new EStationVO[ items.size() ];
		
		int nth = 0;
		
		double sumOfLat = 0, sumOfLng = 0;
		
		for( Element item : items )	{
			String statNm = item.getChildText( "statNm" );
			String chgerType = item.getChildText( "chgerType" );
			String addr = item.getChildText( "addr" );
			String lat = item.getChildText( "lat" );
			String lng = item.getChildText( "lng" );
			String useTime = item.getChildText( "useTime" );
			String busiCall = item.getChildText( "busiCall" );
			
			sumOfLat += Double.parseDouble( lat );
			sumOfLng += Double.parseDouble( lng );
			
			ar[ nth++ ] = new EStationVO(statNm, chgerType, addr, lat, lng, useTime, busiCall);
		}
		double aveOfLat, aveOfLng;
		aveOfLat = sumOfLat / ar.length;
		aveOfLng = sumOfLng / ar.length;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "lat", aveOfLat );
		map.put( "lng", aveOfLng );
		map.put( "ar", ar );
		
		
		return map;
	}
}
