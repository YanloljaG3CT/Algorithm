class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); // 대문자 -> 소문자 변경
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]",""); // 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
        new_id = new_id.replaceAll("\\.+","."); // 마침표 2번 이상 연속된 부분 하나로 치환
        new_id = new_id.replaceAll("^\\.|\\.$", ""); // 마침표가 처음이나 끝에는 올 수 없음
        if (new_id.isEmpty()) new_id = "a"; // 빈 문자열이라면 a 추가
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.+$", ""); // 15개로 줄인 후 마침표가 마지막에 위치한다면 마침표 제거
        }
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }
}