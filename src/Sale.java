public class Sale {


    private int itemsSold;
    private double totalSalesValue;


    public void Sale(){

    }

    public void incrementItemsSold(int sold){

        itemsSold = sold;

    }

    public void incrementTotalSalesValue(double pr){

        totalSalesValue = itemsSold *pr;

    }

    public int getItemsSold() {

        return itemsSold;
    }


    public double getTotalSalesValue() {

        return totalSalesValue;
    }

    @Override
    public String toString() {

        return "itemsSold = " + itemsSold + ", totalSalesValue = "+  totalSalesValue+"\n";
    }
}

