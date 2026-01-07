class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length()>=part.length()) {
                if (sb.substring(sb.length()-part.length()).equals(part)) {
                    sb.delete(sb.length()-part.length(), sb.length());
                }
            }
        }
        return sb.toString();
    }
}
