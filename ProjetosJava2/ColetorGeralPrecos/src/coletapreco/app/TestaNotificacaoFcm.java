package coletapreco.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;

public class TestaNotificacaoFcm {

	public static void main(String[] args) {
		String token = "esoKlL3Jwcg:APA91bGO5D8ATLT5cSC_drNqwegWiOlr49rYsbciujPg62c6CDNKNxG27HlGgUdguqYKpQ_ZGhjgCudE2FFjeu35_wgnNG7NKaoR42ZnNiDna7G797tt_Jn6B4WAsfvpXik6ZPqs0Gl3";
		String apiKey = "AIzaSyAtjaGGiAnp-HMs15nfXz7DfVwdK0iKS4w";
		token = "c1Ynk1Wu2Lk:APA91bEgnBwFxASjhVuoUVYkFZh-WBRD3w1i-mIAAPJEzdDB2hWVvag3Ij1hVOpumvfUCooOgdFfh5HGMh_tBH9pu1woxN3CHef4hZCIrwvHQOI_DAakEN48QP4pIiJcBNxG7LKWN9tv";
		JSONObject result = chamaMobileNovo(apiKey,token,"teste");
		try {
			int sucesso = result.getInt("success");
			if (sucesso==0) {
				System.out.println(result.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	
	private static JSONObject chamaMobileNovo(String apiKey, String mobileKey, String tipoSinc) {
		//final String API_KEY = "AIzaSyAak1l-hsYbZ2ZrOLe94xoQzuhEmZJ1Jyo";
		
		try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jGcmData.put("to", mobileKey);
            // What to send in GCM message.
            jData.put("tipoSinc", tipoSinc);
            jGcmData.put("data", jData);

            // Create connection to send GCM Message request.
            //URL url = new URL("https://android.googleapis.com/gcm/send");
            
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response.
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.out.println(resp);
            JSONObject saida = new JSONObject(resp);
            System.out.println("Check your device/emulator for notification or logcat for " +
                    "confirmation of the receipt of the FCM message.");
            return saida;
		} catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " +
                    "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
        	e.printStackTrace();
			return null;
		}
	}

}
