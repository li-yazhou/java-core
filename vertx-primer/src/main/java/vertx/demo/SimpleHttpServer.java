package vertx.demo;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class SimpleHttpServer {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		// 创建一个HttpServer
		HttpServer server = vertx.createHttpServer();

		server.requestHandler(request -> {
			// 获取到response对象
			HttpServerResponse response = request.response();

			// 设置响应头

			response.putHeader("Content-type", "text/html;charset=utf-8");
			// 响应数据
			response.end("Hello World");
		});

		System.err.println("Access Url is http://127.0.0.1:8888.");

		server.listen(8888); // 监听8888端口
	}
}
