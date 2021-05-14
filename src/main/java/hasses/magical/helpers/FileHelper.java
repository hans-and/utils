package hasses.magical.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.IOUtils;

public class FileHelper
{

   private FileHelper()
   {

   }

   private final static DateTimeFormatter FILE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

   public static String getResourceAsString(String resource) throws IOException
   {
      try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource))
      {
         return IOUtils.toString(is, StandardCharsets.UTF_8.name());
      }
   }

   public static String getDateAsFileStr() 
   {
      return FILE_DATE_FORMATTER.format(ZonedDateTime.now());
   }
}
