package os.FS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import sun.misc.IOUtils;

public class folder {
	

	private JSONObject json;
	public folder(){
        File f = new File("/home/julio/git/staller/Folder.json");
        if (f.exists()){

            String jsonTxt;
			try {
				jsonTxt = readFile("Folder.json");
	            System.out.println(jsonTxt);
	            this.json = new JSONObject(jsonTxt); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
            
 
        }

	}
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}


}
