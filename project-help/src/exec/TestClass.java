package exec;

import static java.lang.System.out;

import java.io.IOException;
import java.util.stream.Stream;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class TestClass {

	public static void main(String[] args) {
		try {
			httpClient();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public static void httpClient() throws IOException, ParseException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://blog.sina.com.cn/s/blog_4b622a8e0100c1bo.html");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network
		// socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager.
		try {
			Stream.of(response1.getAllHeaders()).forEach(out::println);
			HttpEntity entity1 = response1.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			String entityString = EntityUtils.toString(entity1);
			System.out.println(entityString);
		} finally {
			response1.close();
		}
	}
}
