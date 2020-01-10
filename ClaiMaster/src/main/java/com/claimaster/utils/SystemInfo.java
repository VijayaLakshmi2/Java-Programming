package com.claimaster.utils;

import java.lang.management.ManagementFactory;
import java.util.Random;

public class SystemInfo {

	static boolean isPrime(int n) {
		// 2 is the smallest prime
		if (n <= 2) {
			return n == 2;
		}
		// even numbers other than 2 are not prime
		if (n % 2 == 0) {
			return false;
		}
		// check odd divisors from 3
		// to the square root of n
		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void getMemoryInfo() {
		Double totalMemory = Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0);
		Double freeMemory = Runtime.getRuntime().freeMemory() / (1024.0 * 1024.0 * 1024.0);
		double usedMemory = Math.floor(((totalMemory - freeMemory) / totalMemory) * 100);
		System.out.print("Total Memory Available :");
		System.out.printf("%.3fGiB", totalMemory);
		System.out.println();
		System.out.println("Total Memory Used :" + usedMemory + "%");
		long elapsedStartTime = System.nanoTime();
		int cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
		System.out.println("No.of avaiable processors: " + cpuCount);
		Random random = new Random(elapsedStartTime);
		int seed = Math.abs(random.nextInt());
		System.out.println("CPU USAGE DETAILS:");
		int primes = 10000;
		long cpuStartTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		elapsedStartTime = System.nanoTime();
		while (primes != 0) {
			if (isPrime(seed)) {
				primes--;
			}
			seed++;
		}
		long end = System.nanoTime();
		long totalAvailCPUTime = cpuCount * (end - elapsedStartTime);
		long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - cpuStartTime;
		float per = ((float) totalUsedCPUTime * 100) / (float) totalAvailCPUTime;
		System.out.println("CPU USAGE : " + per + " % ");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

}
