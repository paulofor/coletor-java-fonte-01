package br.com.digicom.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

public class ConectorJson extends ConectorApache {

	// Returns a json object from an input stream
	public JSONObject getJsonObject() {

		/*JSONObject jsonObject = null;
		try {
			JSONParser jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;*/

		JSONObject jsonObject = null;
		try {
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);

			jsonObject = new JSONObject(responseStrBuilder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
