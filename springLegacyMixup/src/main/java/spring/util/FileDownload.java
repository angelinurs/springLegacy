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
		// �Ķ���� �� �ޱ�
		String dir = request.getParameter( "dir" ); // bbs_upload : ���ϵ��� ����� ������
		String filename = request.getParameter( "fname" ); // �ٿ�ε� �� ���ϸ�
		
		// ���ϵ��� ����� ��ġ ������ ������ȭ ��Ų��.
		String realPath = getServletContext().getRealPath( "/resources/" + dir + "/filename" );
		
		// �����θ� ������ ���ϰ�ü ����
		File f = new File( realPath );
		
		if( f != null && f.exists() && f.isFile() ) {
			byte[] buf = new byte[2048];
			
			// ������ �����Ͱ� ��Ʈ�� ó���� �� ���ڼ� ����
			response.setContentType( "application/octet-stream; charset=8859_1" );
			
			// �ٿ�ε� ��ȭ���� ó��
			response.setHeader( "Content-disposition", 
								"attachment;filename=" + new String( filename.getBytes(), "8859_1") 
							  );
			
			// ����Ÿ�� ����������( binary )
			response.setHeader( "Content-Tranfer-Encoding", "binary" );
			
			// �ٿ�ε带 ���� ��Ʈ�� �غ�
			BufferedInputStream bis = new BufferedInputStream( new FileInputStream(f) );
			
			// ��û�� ������ ������ ���� ��Ʈ���� ���䰴ü�κ��� ����.
			BufferedOutputStream bos = new BufferedOutputStream( response.getOutputStream() );
			
			int size = -1;
			
			try {
				// bis �� ���� �б⸦ ���ڸ��� bos �� ������.
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
