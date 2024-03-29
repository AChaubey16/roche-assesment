package com.roche.doselect2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;import io.micrometer.common.util.StringUtils;

@Service
public class RocheService {
	
	public List<String> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2) {
		List<String> result = new ArrayList<>();

		if (!StringUtils.isBlank(str2) && !StringUtils.isBlank(str1) && int1 > 0 && int2 > 0 && limit > 0) {

			for (int i = 1; i <= limit; i++) {
				if (i % (int1 * int2) == 0) {
					result.add(str1 + str2);
				} else if (i % int1 == 0) {
					result.add(str1);
				} else if (i % int2 == 0) {
					result.add(str2);
				} else {
					result.add(String.valueOf(i));
				}
			}
		}
		return result;
	}
}
