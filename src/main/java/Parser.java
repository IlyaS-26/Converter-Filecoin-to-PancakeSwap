import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class Parser {
    public String getRate(String address) {
        JSONParser parser = new JSONParser();
        String urlString = "";
        String price = "";
        try {
            URL url = new URL(address);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) urlConnection;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    urlString += line;
                }
                JSONObject object = (JSONObject) parser.parse(urlString);
                JSONObject data = (JSONObject) object.get("data");
                price = data.get("priceUsd").toString();
                connection.disconnect();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return price;
    }
}
