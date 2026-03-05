class Solution {
    public String interpret(String command) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<command.length();i++) {
            char curr=command.charAt(i);

            if(curr=='G') {sb.append("G");}
            else if(curr=='(') {
                if(command.charAt(i+1)==')') { sb.append("o"); i++; }
                else { sb.append("al"); i+=3; }
            }
        }
        return sb.toString();
    }
}
