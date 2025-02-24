import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

            for (long number : numbers) {
                if (isBinaryTree(number)) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public static boolean isBinaryTree(long number) {
        //1. 10진법 숫자 -> 2진법 변환
        String binary = Long.toBinaryString(number);
        //2. 포화이진트리를 위해서 단순하게 숫자 앞에 0을 붙이는게 아니라
        //포화이진트리의 숫자 중 가장 가까운 수로 만들어준다. (2^n-1 : 1,3,7,15,31...)
        //기존에 나는 짝수, 홀수로 구분해서 짝수면 그냥 앞에다 붙였는데 이건 그냥 말이 안 되는거임....
        //그리고 앞쪽에 0을 붙이는 이유는 트리의 균형과 부모-자식 관계를 유지하기 위해서
        String fullBinary = getFullBinary(binary);
        int len = fullBinary.length();

        //3. root의 위치를 기준으로 왼쪽, 오른족 쪼갬
        int root = len / 2;
        String leftSubTree = fullBinary.substring(0, root);
        String rightSubTree = fullBinary.substring(root + 1);

        //4. 그런데 만약 root가 0이면 이건 안 되는 트리
        if (fullBinary.charAt(root) == '0') {
            return false;
        }
        //5. 아래 함수 역시 충족되어야 함.
        return isBinarySubTree(leftSubTree) && isBinarySubTree(rightSubTree);
    }

    public static  boolean isBinarySubTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '0') {
            return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
        }

        return isBinarySubTree(leftSubTree) && isBinarySubTree(rightSubTree);
    }

    public static  boolean isZeroTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '1') {
            return false;
        }

        return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
    }

    public static String getFullBinary(String binary){
        int length = binary.length();
        int nodeCount = 1;
        int level = 1;
        while (length > nodeCount) {
            level *= 2;
            nodeCount += level;
        }

        int offset = nodeCount - length;
        return "0".repeat(offset) + binary;
    }
}