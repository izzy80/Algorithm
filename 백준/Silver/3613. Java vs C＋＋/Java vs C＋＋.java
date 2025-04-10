
/**
 * java 변수명
 * 첫 단어는 소문자
 * 다음 단어부터는 첫 문자만 대문자
 * 모든 단어는 붙여쓴다
 *
 * C++ 변수명
 * 소문자만 사용
 * 단어와 단어 구분은 _을 이용
 *
 * C++ -> java , java -> c++ 변환
 * 1. 어떤 언어 형식인지
 * 2. 변환
 * 2.1. c++ -> java
 * 2.2 java -> c++
 * 2.3 둘 다 아니라면 에러 발생
 */

import java.util.*;
import java.io.*;

public class Main {
    static boolean whatIsLanguage = false;     // false: c++, true: java
    static boolean allOfLower = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        //어떤 형식?
        // Java, C++ 형식에 맞지 않을 경우
        if(!(is_Cpp(sb) && is_Java(sb) && name_check(sb))){
            System.out.println("Error!");
            return;
        }

        // 모든 문자가 소문자일 경우 그대로 return
        if(allOfLower){
            System.out.println(sb.toString());
            return;
        }

        // true = java, false = Cpp
        if(whatIsLanguage) sb = toC(sb);
        else sb = toJava(sb);

        System.out.println(sb.toString());

    }

    public static boolean name_check(StringBuilder sb){
        int isUpperCase = 0;
        int isUnderBar = 0;

        for(int i=0; i < sb.length(); i++){
            char ch = sb.charAt(i);

            if(ch >= 'A' && ch <= 'Z') isUpperCase = 1;
            else if(ch == '_') isUnderBar = 1;
        }

        allOfLower = (isUnderBar == 1 || isUpperCase == 1) ? false : true;

        // Java와 Cpp 형식을 혼용 했을때 false return
        if((isUnderBar & isUpperCase) == 0 || allOfLower) {
            whatIsLanguage = (isUnderBar == 1) ? false : true;
            return true;
        }else return false;

    }

    public static boolean is_Cpp(StringBuilder sb){
        if(sb.charAt(sb.length()-1) == '_') return false;
        else if(sb.charAt(0) == '_') return false;
        else if(sb.indexOf("__") >= 0) return false;

        return true;
    }

    public static boolean is_Java(StringBuilder sb){
        return (sb.charAt(0) >= 'A'&& sb.charAt(0) <= 'Z') ? false : true;
    }

    public static StringBuilder toC(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.replace(i, i+1, String.valueOf(ch).toLowerCase());
                sb.insert(i, "_");
            }
        }
        return sb;
    }

    public static StringBuilder toJava(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '_'){
                sb.deleteCharAt(i);
                sb.replace(i+1, i+1, String.valueOf(sb.charAt(i)).toUpperCase());
                sb.deleteCharAt(i);
            }
        }
        return sb;
    }


}
