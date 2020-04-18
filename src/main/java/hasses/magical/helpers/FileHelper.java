package hasses.magical.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class FileHelper {
	public static String getResourceAsString(String resource) throws IOException {
		try(InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource)){
			return IOUtils.toString(is ,StandardCharsets.UTF_8.name()); 
		}
	}
}
