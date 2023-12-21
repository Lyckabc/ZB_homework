package test;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        // 예제 데이터
        String data = "abcde";
        int A = 3;
        int M = 11;

        // 초기 해시 값 계산
        int initialHash = rollingHash(data, A, M);
        System.out.println("Initial Hash Value: " + initialHash);

        // 데이터의 첫 문자를 제거하고 새로운 문자 'f'를 추가하여 롤링 해시 업데이트
        String updatedData = "bcdef";
        int updatedHash = rollingHashUpdate(initialHash, data.charAt(0), updatedData.charAt(updatedData.length() - 1), A, M, data.length());
        updatedHash = (updatedHash + M) % M; // 음수를 방지하기 위해 추가
        System.out.println("Updated Hash Value: " + updatedHash);
    }

    public static int rollingHash(String data, int A, int M) {
        int hashValue = 0;

        for (int i = 0; i < data.length(); i++) {
            hashValue = (hashValue * A + data.charAt(i)) % M;
        }

        return hashValue;
    }

    public static int rollingHashUpdate(int prevHash, char removedChar, char addedChar, int A, int M, int length) {
        int updatedHash = (prevHash * A + addedChar - removedChar * pow(A, length - 1, M)) % M;
        return updatedHash;
    }

    public static int pow(int base, int exponent, int mod) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (int) (((long) base * base) % mod);
            exponent /= 2;
        }
        return result;
    }
}
