class Food implements Comparable<Food> {
    public int rating;
    public String name;

    public Food(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    @Override
    public int compareTo(Food other) {
        if (this.rating == other.rating)
            return (this.name).compareTo(other.name);
        return other.rating - this.rating;
    }
}

class FoodRatings {
    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, TreeSet<Food>> cuisineTopFoodQMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineTopFoodQMap = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineTopFoodQMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisineOfFood = foodCuisineMap.get(food);
        cuisineTopFoodQMap.get(cuisineOfFood).remove(new Food(foodRatingMap.get(food), food));
        cuisineTopFoodQMap.get(cuisineOfFood).add(new Food(newRating, food));
        foodRatingMap.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineTopFoodQMap.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */