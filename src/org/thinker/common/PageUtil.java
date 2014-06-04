package org.thinker.common;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	
	public static List<String> makePageList(int pageNumber, int cnt) {
		List<String> pageNumberList = new ArrayList<String>();

		int startPageNum = ((pageNumber - 1) / 10) * 10 + 1;
		int endPageNum = (cnt / 10) + 1;

		double page = Math.ceil((double) cnt / 10);

		for (int i = startPageNum; i <= endPageNum; i++) {
			if (startPageNum > 10 && i == startPageNum) {
				pageNumberList.add("<");
			}

			if (i == startPageNum + 10) {
				pageNumberList.add(">");
				break;
			}
			pageNumberList.add("" + i);
		}
		return pageNumberList;
	}
}
