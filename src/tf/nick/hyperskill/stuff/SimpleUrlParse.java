package tf.nick.hyperskill.stuff;

import java.util.Scanner;

// Sample input:
// https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost

public class SimpleUrlParse {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String url = sc.nextLine();
    String urlParams = url.split("\\?")[1];
    String[] urlParamsGrouped = urlParams.split("&");
    String password = null;
    for (String keyValue : urlParamsGrouped) {
      String[] kvp = keyValue.split("=");
      String paramName = kvp[0];
      String paramVal = kvp.length > 1 ? kvp[1] : "";
      if ("pass".equals(paramName)) {
        password = paramVal;
      }
      String line = paramVal.isEmpty() ? paramName + " : not found" : paramName + " : " + paramVal;
      System.out.println(line);
    }

    if (password != null) {
      System.out.println("password : " + password);
    }
  }
}
