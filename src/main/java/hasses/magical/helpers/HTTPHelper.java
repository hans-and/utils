package hasses.magical.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;


public class HTTPHelper {
	private static final Logger LOGGER = Logger.getLogger(HTTPHelper.class);

	public static Optional<String> getSimpleRequestAsString(String url) throws IOException {
		URL urlForGetRequest = new URL(url);

		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		
		if (responseCode == HttpURLConnection.HTTP_OK)
			return Optional.of(getResultAsString(conection));
		else
			return Optional.empty();
		
	}

	public static Optional<Document> getSimpleRequestAsDocument(String url) throws IOException, DocumentException {
		Optional<String> tmp = getSimpleRequestAsString(url);

		if(tmp.isPresent()) {
			try {
				return Optional.of(DocumentHelper.parseText(tmp.get()));	
			} catch (Exception e) {
				LOGGER.error("error parsin"+tmp.get(),e);
				return Optional.empty();
			}
			
		}else {
			return Optional.empty();
		}
		
	}

	
	private static String getResultAsString(HttpURLConnection conection) throws IOException {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()))) {
			StringBuffer response = new StringBuffer();

			String readLine;

			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			return response.toString();
		}

	}
	
		
	
}
