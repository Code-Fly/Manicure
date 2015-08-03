/**
 * 
 */
package com.manicure.commmon;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

/**
 * Test 类 工程接受 请删除
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		System.out.println(JSONArray.fromObject(list).toString());

	}

}
