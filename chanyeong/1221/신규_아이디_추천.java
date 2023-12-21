class Solution {
    public String solution(String new_id) {
        new_id = firstCondition(new_id);
        new_id = secondCondition(new_id);
        new_id = thirdCondition(new_id);
        new_id = fourthCondition(new_id);
        new_id = fifthCondition(new_id);
        new_id = sixthCondition(new_id);
        new_id = seventhCondition(new_id);
        return new_id;
    }

    private String firstCondition(String newId) {
        return newId.toLowerCase();
    }

    private String secondCondition(String newId) {
        return newId.replaceAll("[^-_.a-z\\d]", "");
    }

    private String thirdCondition(String newId) {
        return newId.replaceAll("[.]{2,}", ".");
    }

    private String fourthCondition(String newId) {
        return newId.replaceAll("^[.]|[.]$", "");
    }

    private String fifthCondition(String newId) {
        if (newId.isEmpty()) {
            newId = "a";
        }
        return newId;
    }

    private String sixthCondition(String newId) {
        if (newId.length() > 15) {
            newId = newId.substring(0, 15);
            newId = fourthCondition(newId);
        }
        return newId;
    }

    private String seventhCondition(String newId) {
        if (newId.length() < 3) {
            char last = newId.charAt(newId.length() - 1);
            StringBuilder sb = new StringBuilder(newId);
            while (sb.length() < 3) {
                sb.append(last);
            }
            newId = sb.toString();
        }
        return newId;
    }
}
