public class FoodMenuItem {

    private String foodItem;
    private String category;
    private double price;
    private Sale saleInfo;



    public FoodMenuItem(){

    }

    public FoodMenuItem(String item, String cat,double pri, Sale s){

        foodItem = item;
        category = cat;
        price = pri;
        saleInfo = s;



    }


    public String getCategory() {
        return category;
    }

    public String getFoodItem() {

        return foodItem;
    }

    public double getPrice() {
        return price;
    }

    public Sale getSaleInfo() {

        return saleInfo;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public void setFoodItem(String foodItem) {

        this.foodItem = foodItem;
    }

    public void setPrice(double price) {

        this.price = price;
    }


    public void setSaleInfo(Sale saleInfo) {

        this.saleInfo = saleInfo;
    }

    @Override
    public String toString() {
        return "foodItem= " + foodItem  + ", category= " + category + ", price= " + price + ", saleInfo= " + saleInfo+"\n";
    }
}
