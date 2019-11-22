package section_20_networkprogramming._06_httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            // URL url = new URL("http://example.org");
            // URL url = new URL("http://example.org/somepage.html"); - Response code: 404
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // GET is the default.
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            // getResponseCode() method implicitly performs the connection.
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            // The getInputStream() method implicitly connects.
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line = "";
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}
