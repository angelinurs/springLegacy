package spring.util;

import java.io.File;

public class FileRenameUtil {
	public static String checkSameFileName( String filename, String path ) {
		int period = filename.lastIndexOf( "." );
		
		String fname = filename.substring( 0, period );
		String suffix = filename.substring(period);
		
		String saveFilename = path + System.getProperty( "file.separator" ) + filename;
									 
		
		File f = new File( saveFilename );
		
		int idx = 1;
				
		while( f != null && f.exists() ) {
			//System.out.println( saveFilename );
			
			StringBuffer sb = new StringBuffer();
			sb.append( fname ).append( idx++ ).append( suffix );
			
			filename = sb.toString();
			saveFilename = path + System.getProperty( "file.separator" ) + filename;
			
			f = new File( saveFilename );
		}
		
		return filename;
	}
}
