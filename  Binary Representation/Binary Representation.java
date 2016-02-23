public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n.indexOf('.') == -1) {
            return parseInteger(n);
        }
        String[] params = n.split("\\.");
        String floatValue = parseFloat(params[1]);
        if(floatValue == "ERROR") {
            return floatValue;
        }
        if( floatValue == "" || floatValue == "0") {
            return parseInteger(params[0]);
        } else {
            return parseInteger(params[0]) + "." + floatValue;
        }
    }

    private String parseInteger(String n) {
        int integer = Integer.parseInt(n);
        if(integer == 0) {
            return "0";
        }
        String output = "";
        while (integer != 0) {
            output = Integer.toString(integer % 2) + output;
            integer /= 2;
        }
        return output;
    }

    private String parseFloat(String n) {
        double doubleValue = Double.parseDouble ("0." + n);
        String output = "";
        if(doubleValue == 0) {
            return output;
        }
        HashSet<Double> set = new HashSet<Double> ();
        while(doubleValue != 0) {
            if (output.length() > 32 || set.contains(doubleValue)) {
                return "ERROR";
            }
            set.add(doubleValue);
            doubleValue *= 2;
            if(doubleValue >= 1) {
                output += "1";
                doubleValue -= 1;
            } else {
                output += "0";
            }
        }
        return output;
    }
}
