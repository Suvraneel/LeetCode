class Solution {
    private class Person implements Comparable<Person> {
        String name;
        int height;

        public Person(String name, int height){
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person other){
            return Integer.compare(other.height, this.height);
        }

        @Override
        public String toString(){
            return "{"+name+"\t"+height+"}";
        }

    }
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] ppl = new Person[names.length];
        for(int i=0; i<heights.length; i++)
            ppl[i] = new Person(names[i], heights[i]);
        Arrays.sort(ppl);
        // System.out.println(Arrays.toString(ppl));
        return Arrays.stream(ppl).map(p->p.name).toArray(String[]::new);
    }
}