package fc1221;

//신규 아이디 추천
public class pg72410 {
    public static void main(String[] args) {
        String new_id = "";

        //1
        String id1 = new_id.toLowerCase();

        //2
        char[] charArray = id1.toCharArray();
        StringBuilder id2 = new StringBuilder();
        for (char c : charArray) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                id2.append(c);
            }
        }

        //3
        String id3 = id2.toString();
        while (id3.contains("..")) {
            id3 = id3.replace("..", ".");
        }

        //4
        String id4 = id3;
        if (!id4.isEmpty()) {
            if (id4.charAt(0) == '.') {
                id4 = id4.substring(1, id4.length());
            }
        }
        if (!id4.isEmpty()) {
            if (id4.charAt(id4.length() - 1) == '.') {
                id4 = id4.substring(0, id4.length() - 1);
            }
        }

        //5
        String id5 = id4;
        if (id5.equals("")) {
            id5 = "a";
        }

        //6
        String id6 = id5;
        if (id6.length() >= 16) {
            id6 = id6.substring(0, 15);

            if (id6.charAt(id6.length() - 1) == '.') {
                id6 = id6.substring(0, id6.length() - 1);
            }
        }

        //7
        StringBuilder id7 = new StringBuilder(id6);
        if (id6.length() <= 2) {
                char c = id6.charAt(id6.length() - 1);
            while (id7.length()<3){
                id7.append(c);
            }
        }

        /**
         * 정규표현식
         */
        String answer = new_id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

        if (answer.equals("")) {    // 5단계
            answer += "a";
        }

        if (answer.length() >= 16) {     // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }

        if (answer.length() <= 2) {  // 7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
    }
}
