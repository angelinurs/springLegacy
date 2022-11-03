package spring.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 값 받기
		String dir = request.getParameter( "dir" ); // bbs_upload : 파일들이 저장될 폴더명
		String filename = request.getParameter( "fname" ); // 다운로드 할 파일명
		
		// 파일들이 저장된 위치 폴더를 절대경로화 시킨다.
		String realPath = getServletContext().getRealPath( "/resources/" + dir + "/filename" );
		
		// 절대경로를 가지고 파일객체 생성
		File f = new File( realPath );
		
		if( f != null && f.exists() && f.isFile() ) {
			byte[] buf = new byte[2048];
			
			// 전송할 데이터가 스트림 처리될 때 문자셋 지정
			response.setContentType( "application/octet-stream; charset=8859_1" );
			
			// 다운로드 대화상자 처리
			response.setHeader( "Content-disposition", 
								"attachment;filename=" + new String( filename.getBytes(), "8859_1") 
							  );
			
			// 전송타입 이진데이터( binary )
			response.setHeader( "Content-Tranfer-Encoding", "binary" );
			
			// 다운로드를 위한 스트림 준비
			BufferedInputStream bis = new BufferedInputStream( new FileInputStream(f) );
			
			// 요청한 곳으로 보내기 위해 스트림을 응답객체로부터 얻어낸다.
			BufferedOutputStream bos = new BufferedOutputStream( response.getOutputStream() );
			
			int size = -1;
			
			try {
				// bis 로 부터 읽기를 하자마자 bos 로 보낸다.
				while( (size = bis.read( buf ) ) != -1 ) {
					bos.write( buf, 0, size );
					bos.flush();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if( bos != null ) bos.close();
				if( bis != null ) bis.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
