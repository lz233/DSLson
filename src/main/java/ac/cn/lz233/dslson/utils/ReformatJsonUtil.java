package ac.cn.lz233.dslson.utils;

public class ReformatJsonUtil {
    public static String stringToJson(String strJson) {
        // 计数tab的个数
        int tabNum = 0;
        StringBuilder jsonFormat = new StringBuilder();
        int length = strJson.length();

        char last = 0;
        boolean isInString = false;
        for (int i = 0; i < length; i++) {
            char c = strJson.charAt(i);
            if (c == '{') {
                tabNum++;
                jsonFormat.append(c).append("\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
            } else if (c == '}') {
                tabNum--;
                jsonFormat.append("\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
                jsonFormat.append(c);
            } else if (c == ',') {
                jsonFormat.append(c).append("\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
            } else if (c == ':') {
                if (isInString){
                    jsonFormat.append(c);
                }else {
                    jsonFormat.append(c).append(" ");
                }
            } else if (c == '[') {
                tabNum++;
                char next = strJson.charAt(i + 1);
                if ((next == ']')|isInString) {
                    jsonFormat.append(c);
                } else {
                    jsonFormat.append(c).append("\n");
                    jsonFormat.append(getSpaceOrTab(tabNum));
                }
            } else if (c == ']') {
                tabNum--;
                if ((last == '[')|isInString) {
                    jsonFormat.append(c);
                } else {
                    jsonFormat.append("\n").append(getSpaceOrTab(tabNum)).append(c);
                }
            }else if (c=='"') {
                isInString= !isInString;
                jsonFormat.append(c);
            } else {
                jsonFormat.append(c);
            }
            last = c;
        }
        return jsonFormat.toString();
    }

    private static String getSpaceOrTab(int tabNum) {
        return "  ".repeat(Math.max(0, tabNum));
    }
}
