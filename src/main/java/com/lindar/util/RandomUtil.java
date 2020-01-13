package com.lindar.util;

import java.util.Random;

public class RandomUtil {

	// generate number inclusive of min and max
	static public int getRandomNmber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

}
