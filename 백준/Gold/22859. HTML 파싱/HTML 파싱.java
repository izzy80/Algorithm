import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // ✅ 1. 빠른 입력 (BufferedReader, 64KB 버퍼 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
        String html = br.readLine();

        // ✅ 2. <main>...</main> 태그 제거 (안전성 확보)
        if (html.startsWith("<main>") && html.endsWith("</main>")) {
            html = html.substring(6, html.length() - 7);
        }

        // ✅ 3. 빠른 처리 (StringBuilder 사용)
        StringBuilder result = new StringBuilder();
        boolean inTag = false, inDiv = false, inP = false, spaceFlag = false;
        StringBuilder title = new StringBuilder();
        int i = 0;

        while (i < html.length()) {
            char c = html.charAt(i);

            // 🔹 1. <div title="..."> 처리
            if (html.startsWith("<div title=\"", i)) {
                inDiv = true;
                i += 12; // "<div title=" (12글자)
                while (i < html.length() && html.charAt(i) != '"') {
                    title.append(html.charAt(i++));
                }
                result.append("title : ").append(title).append("\n");
                title.setLength(0); // title 초기화
                i++; // '"' 넘기기
                continue;
            }

            // 🔹 2. </div> 태그 처리
            if (html.startsWith("</div>", i)) {
                inDiv = false;
                i += 6;
                continue;
            }

            // 🔹 3. <p> 태그 처리 (문장 시작)
            if (html.startsWith("<p>", i)) {
                inP = true;
                i += 3;
                continue;
            }

            // 🔹 4. </p> 태그 처리 (문장 끝)
            if (html.startsWith("</p>", i)) {
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

        // ✅ 4. 빠른 출력 (BufferedWriter 사용)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 65536);
        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
    }
}