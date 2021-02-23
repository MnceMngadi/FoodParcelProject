import java.util.Comparator;

public class SortItemNames implements Comparator<FoodMenuItem> {


    public int compare(FoodMenuItem item1, FoodMenuItem item2){

        return  item1.getFoodItem().compareToIgnoreCase(item2.getFoodItem());
    }


}
