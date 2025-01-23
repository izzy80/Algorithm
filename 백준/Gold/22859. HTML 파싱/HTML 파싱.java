import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536); // 입력 버퍼 크기 증가
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 65536); // 출력 버퍼 크기 증가

        String input = br.readLine();
        if (!input.startsWith("<main>") || !input.endsWith("</main>")) return;

        char[] html = input.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder title = new StringBuilder();
        boolean inTag = false, inDiv = false, inP = false, spaceFlag = false;

        int i = 6; // "<main>" 이후부터 시작
        while (i < html.length - 7) { // "</main>" 전까지 처리
            char c = html[i];

            // 🔹 1. <div title="..."> 처리
            if (input.startsWith("<div title=\"", i)) {
                inDiv = true;
                i += 12; // "<div title=" (12글자)
                while (i < html.length && html[i] != '"') {
                    title.append(html[i++]);
                }
                result.append("title : ").append(title).append("\n");
                title.setLength(0); // title 초기화
                i++; // '"' 넘기기
                continue;
            }

            // 🔹 2. </div> 태그 처리
            if (input.startsWith("</div>", i)) {
                inDiv = false;
                i += 6;
                continue;
            }

            // 🔹 3. <p> 태그 처리 (문장 시작)
            if (input.startsWith("<p>", i)) {
                inP = true;
                i += 3;
                continue;
            }

            // 🔹 4. </p> 태그 처리 (문장 끝)
            if (input.startsWith("</p>", i)) {
                inP = false;
                result.append("\n");
                i += 4;
                continue;
            }

            // 🔹 5. HTML 태그 제거 (<b>, <i>, <br> 등)
            if (c == '<') {
                inTag = true;
            } else if (c == '>') {
                inTag = false;
                i++;
                continue;
            }

            // 🔹 6. 본문 내용 저장 (태그가 아닐 때)
            if (!inTag && inDiv && inP) {
                if (c == ' ') {
                    if (!spaceFlag) {
                        result.append(' ');
                        spaceFlag = true;
                    }
                } else {
                    result.append(c);
                    spaceFlag = false;
                }
            }
            i++;
        }

        // ✅ 3. 최종 출력 (BufferedWriter 사용)
        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
    }
}