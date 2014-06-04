package org.thinker.common;

import java.net.URL;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.thinker.vo.BookVO;

public class BookJsonParser {
	public BookVO getBookInfo(Long isbn) throws Exception {
		StringBuilder builder = new StringBuilder();

		String urlPath = "http://apis.daum.net/search/book?q="
				+ isbn
				+ "&searchType=isbn&apikey=98de4baf333b4819379ebdec8c8505974d444d0e&output=json";

		URL url = new URL(urlPath);
		Scanner scanner = new Scanner(url.openStream(), "UTF-8");
		while (true) {
			try {
				String str = scanner.nextLine();
				builder.append(str);
			} catch (Exception e) {
				break;
			}
		}

		String jString = builder.toString();

		JSONObject jsonObject = JSONObject.fromObject(jString);
		JSONObject channel = (JSONObject) jsonObject.get("channel");
		JSONArray itemArr = (JSONArray) channel.get("item");
		JSONObject item = (JSONObject) itemArr.get(0);

		BookVO vo = new BookVO();
		vo.setTitle((String) item.get("title"));
		vo.setAuthor((String) item.get("author"));
		vo.setpYear((Integer.parseInt((String) item.get("pub_date"))));
		vo.setPublisher((String) item.get("pub_nm"));
		vo.setIsbn(isbn);
		vo.setCategory((String) item.get("category"));
		vo.setDescription((String) item.get("description"));
		vo.setImage((String) item.get("cover_l_url"));

		return vo;
	}

}
