class FoodRatings {
    int n;
    String[] foods;
    String[] cuisines;
    int[] ratings;
    Map<String, Integer> foodIdx = new HashMap<>();
    Map<String, Integer> cuisineTopRated = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.n = foods.length;
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        for (int i = 0; i < n; i++) {
            foodIdx.put(foods[i], i);
            int prevTopRatedInCuisine = cuisineTopRated.getOrDefault(cuisines[i], -1);
            if (prevTopRatedInCuisine == -1 || ratings[prevTopRatedInCuisine] < ratings[i]
                    || (ratings[prevTopRatedInCuisine] == ratings[i]
                            && foods[prevTopRatedInCuisine].compareTo(foods[i]) > 0))
                cuisineTopRated.put(cuisines[i], i);
        }
        print();
    }

    public void changeRating(String food, int newRating) {
        int idx = foodIdx.get(food);
        int prevTopRatedInCuisine = cuisineTopRated.get(cuisines[idx]);
        if (ratings[prevTopRatedInCuisine] < newRating || (ratings[prevTopRatedInCuisine] == newRating
                && foods[prevTopRatedInCuisine].compareTo(foods[idx]) > 0))
            cuisineTopRated.put(cuisines[idx], idx);
        ratings[idx] = newRating;
        print();
    }

    public String highestRated(String cuisine) {
        return foods[cuisineTopRated.get(cuisine)];
    }

    private void print(){
        System.out.println(foodIdx);
        System.out.println(cuisineTopRated);
        System.out.println(Arrays.toString(ratings));
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */