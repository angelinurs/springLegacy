package com.springLegacy.pps;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ppa.util.ConvertMapToVO;
import ppa.vo.BidPblancListInfoThngVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	// openAPI 의 URL
	private String base_path = "http://apis.data.go.kr/1230000/BidPublicInfoService03";
	private String category= "getBidPblancListInfoThng";
	private String serviceKey= "RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D";
	private String numOfRows;
	private String pageNo;
	private String inqryDiv;
	private String inqryBgnDt;
	private String inqryEndDt;
	private String bidNtceNo;
	private String type;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() throws Exception {
		
		String path="http://apis.data.go.kr/1230000/BidPublicInfoService03/getBidPblancListInfoThng?serviceKey=RqS0Hjv%2B%2F1p4pVpY6HBC%2Fyblgg3WzSz%2B%2Ba2G3m25XrDO3%2Br6ElDZ%2BtkL4GlGf59z3m6%2FYRzGF%2BJBDD0eQvI%2Fgw%3D%3D&numOfRows=10&pageNo=1&inqryDiv=1&inqryBgnDt=201605010000&inqryEndDt=201605102359&bidNtceNo=20160344731&type=xml";
		
		ModelAndView mv = new ModelAndView();
		
		// URL 정보를 가지고 연결할 객체를 만들다.
		URL url = new URL( path );
		
		// 연결객체를 가지고 연결한다.
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.connect();
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build( con.getInputStream() );
		
		Element root = doc.getRootElement();
		
		Element items =  root.getChild( "body" ).getChild( "items" );
		
		List<Element> list = items.getChildren( "item" );
		
		if( list != null && list.size() > 0 ) {
			
			Iterator<Element> it = list.iterator();
			
			BidPblancListInfoThngVO[] p_list = new BidPblancListInfoThngVO[ list.size() ];
			Map<String, Object> map = null;
			int idx=0;
			while( it.hasNext() ) {
				Element item = it.next();
				
				Iterator<Element> item_it = item.getChildren().iterator();
				
				map = new HashMap<String, Object>();
				while( item_it.hasNext() ) {
					Element elem = item_it.next();
					map.put(elem.getName(), elem.getText());
				}
				
				BidPblancListInfoThngVO vo = ConvertMapToVO.convertToValueObject(map, BidPblancListInfoThngVO.class );
				
				p_list[ idx++ ] = vo;
				map = null;
			}
			
			mv.addObject( "p_list", p_list );
		}
		
		mv.setViewName( "home" );
		
		return mv;
	}
	
}
