import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
        class Data {
            int code;
            int date;
            int maximum;
            int remain;

            public Data(int code, int date, int maximum, int remain){
                this.code = code;
                this.date = date;
                this.maximum = maximum;
                this.remain = remain;
            }

            @Override
            public String toString() {
                return "Data{" +
                        "code=" + code +
                        ", date=" + date +
                        ", maximum=" + maximum +
                        ", remain=" + remain +
                        '}';
            }
        }
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

            int N = data.length;
            ArrayList<Data> list = new ArrayList<>();
            for(int i= 0; i < N; i++){
                int idx = -1;
                switch (ext){
                    case "code" :
                        if(data[i][0] <= val_ext){
                            idx = 0;
                        }
                        break;
                    case "date" :
                        if(data[i][1] <= val_ext){
                            idx = 1;
                        }
                        break;
                    case "maximum":
                        if(data[i][2] <= val_ext){
                            idx = 2;
                        }
                        break;
                    case "remain":
                        if(data[i][3] <= val_ext){
                            idx = 3;
                        }
                        break;
                }
                if(idx != -1){
                    list.add(new Data(data[i][0], data[i][1],data[i][2],data[i][3]));
                }
            }
            // 정렬
            switch (sort_by){
                case "code" :
                    Collections.sort(list, new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.code - o2.code;
                        }
                    });
                    break;
                case "date" :
                    Collections.sort(list, new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.date - o2.date;
                        }
                    });
                    break;
                case "maximum":
                    Collections.sort(list, new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.maximum - o2.maximum;
                        }
                    });
                    break;
                case "remain":
                    Collections.sort(list, new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.remain - o2.remain;
                        }
                    });
                    break;
            }
            int[][] answer = new int[list.size()][4];
            for(int i=0; i< list.size(); i++){
                answer[i][0] = list.get(i).code;
                answer[i][1] = list.get(i).date;
                answer[i][2] = list.get(i).maximum;
                answer[i][3] = list.get(i).remain;
            }
            return answer;
        }
    }