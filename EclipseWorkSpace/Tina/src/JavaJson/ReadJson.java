package JavaJson;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJson {
	public static void main(String[] args) {
		JsonParser  parser= new JsonParser();	 	  
		try {
			JsonObject object= (JsonObject) parser.parse(new FileReader("readjson.json"));
			System.out.println("cat="+object.get("cat").getAsString());
			System.out.println("pop="+object.get("pop").getAsString());
			JsonArray array=object.get("languages").getAsJsonArray();
			for(int i=0;i<array.size();i++) {
				System.out.println("---------------------");
				JsonObject subobject=array.get(i).getAsJsonObject();
				System.out.println("id="+subobject.get("id").getAsInt());
				System.out.println("name="+subobject.get("name").getAsString());
				System.out.println("ide="+subobject.get("ide").getAsString());
			}
			 
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
