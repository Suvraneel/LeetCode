class ProductOfNumbers {
    List<Integer> stream;
    int cumulativePdt = 1, lastZeroIdx = -1;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            lastZeroIdx = stream.size();
            stream.add(cumulativePdt = 1);
        } else
            stream.add(cumulativePdt *= num);
    }

    public int getProduct(int k) {
        return lastZeroIdx > stream.size() - 1 - k ? 0
                : stream.get(stream.size() - 1) / stream.get(stream.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */