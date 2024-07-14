class Solution {
    private class Element {
        public String atom;
        public int valency;

        public Element(String atom, int valency) {
            this.atom = atom;
            this.valency = valency;
        }

        public String toString() {
            return "{" + atom + valency + "}";
        }
    }

    public String countOfAtoms(String formula) {
        Stack<Element> stk = new Stack<>();
        formula = formula + "_";    // Mark end of formula
        char[] F = formula.toCharArray();
        String elem = "";
        int num = 0;
        for (char c : F) {
            if (c >= '0' && c <= '9') {
                stk.peek().valency = stk.peek().valency * 10 + c - '0';
                continue;
            } else if (c >= 'A' && c <= 'Z') {
                elem = String.valueOf(c);
                num = 0;
            } else if (c >= 'a' && c <= 'z') {
                stk.peek().atom += c;
                continue;
            } else if (c == '('){
                elem = "(";
            } else if (c == ')') {
                elem = ")";
            }
            if (!stk.empty() && stk.peek().atom == ")"){
                int multiplier = stk.pop().valency;
                Stack<Element> interim = new Stack<>();
                while (stk.peek().atom != "(") {
                    Element top = stk.pop();
                    if (top.valency == 0)
                        top.valency = 1;
                    top.valency *= multiplier;
                    interim.push(top);
                }
                stk.pop();
                while (!interim.isEmpty())
                    stk.push(interim.pop());
            }
            stk.push(new Element(elem, num));
            elem = "";
            num = 0;
            // System.out.println(stk.toString());
        }
        Map<String, Integer> freq = new TreeMap<>();
        while(!stk.isEmpty()){
            Element top = stk.pop();
            if (top.valency == 0)
                top.valency = 1;
            freq.put(top.atom, freq.getOrDefault(top.atom, 0)+top.valency);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> e: freq.entrySet()){
            sb.append(e.getKey()); 
            if(e.getValue()!=1)
                sb.append(e.getValue());
        }
        return sb.toString();
    }
}