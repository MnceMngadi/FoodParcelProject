import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.logging.Handler;

public class Menu extends JFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton bu = new JButton("Mncedisi");
    private JButton deleteBtn = new JButton("DELETE");
    private JButton buyBtn = new JButton("Buy");
    private JTable table, table1;


    private JTextField itemField;
    private JTextField priceField;

    private JTextField theItemFied;
    private JTextField thePriceField;
    private JTextField numOfItemsField;

    private JLabel welcomeLabel = new JLabel("Joe’s Fast-Food Joint");
    private JLabel itemLabel;
    private JLabel cateLabel;
    private JLabel priceLabel;
    private JLabel theDeletingLbl = new JLabel("Select A Item From The Table To Delete");
    private JLabel thePriceLbl = new JLabel("Price:");
    private JLabel theItemLbl = new JLabel("Item:");
    private JLabel numOfItems = new JLabel("Number Of Items:");
    private JLabel dateLabel = new JLabel();
    private JLabel image;

    private JButton addBtn = new JButton("ADD");
    private JButton starterBtn = new JButton("Starter");
    private JButton mainBtn = new JButton("Main Meal");
    private JButton drinks = new JButton("Drinks");
    // private JButton deleteBtn = new JButton()
    private JButton clear = new JButton("CLEAR ITEMS");
    private JButton srtBtn = new JButton("SORT ITEMS"), salesBtn = new JButton("SALES TRANSACT"), salesRepBtn = new JButton("SALES REPORT"), extBtn = new JButton("EXIT");


    private JComboBox cateBox, transactTabel;
    private JComboBox itemToDelete;

    private JTextArea thisDisplay = new JTextArea();

    private JList list;

    private TitledBorder panel1Border = new TitledBorder("ADD");
    private TitledBorder panel2Border = new TitledBorder("DELETE");
    private TitledBorder panel3Border = new TitledBorder("SALES TRANSACTION");

    String hour, minutes, second, year, month, day;

    Image img;


    DefaultTableModel tableModel;
    // DefaultListModel listModel;

    private JTable table2;
    DefaultTableModel tableModel2;


    // ArrayList<FoodMenuItem> theAddingArray = new ArrayList<FoodMenuItem>();

    ArrayList<FoodMenuItem> theFoodItems = new ArrayList<FoodMenuItem>();

    Sale infor = new Sale();

    Object[][] data;

    String tableClicked, tableClicked2, tableClicked3;

    String display = "";


    public Menu() {

        super("Joe’s Fast-Food Joint");
        setSize(1320, 700);
        setLayout(null);
        //backGround();
        setBackground(Color.RED);




        String category[] = {"Select Category", "starter", "main meal", "drinks"};

        //Designing borders
        panel1Border.setTitleJustification(TitledBorder.LEFT);
        panel1Border.setTitlePosition(TitledBorder.TOP);
        panel1Border.setTitleFont(new Font("Tahoma", Font.BOLD, 16));

        panel2Border.setTitleJustification(TitledBorder.LEFT);
        panel2Border.setTitlePosition(TitledBorder.TOP);
        panel2Border.setTitleFont(new Font("Tahoma", Font.BOLD, 16));

        panel3Border.setTitleJustification(TitledBorder.LEFT);
        panel3Border.setTitlePosition(TitledBorder.TOP);
        panel3Border.setTitleFont(new Font("Tahoma", Font.BOLD, 16));

       /* image= new JLabel();
        image.setIcon(new ImageIcon("burger.jpg"));
        image.setBounds(430, 70, 600, 40);
        add(image);*/



        clock();

        itemLabel = new JLabel("Enter Item:");
        itemLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        itemField = new JTextField(20);
        itemField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        itemField.addActionListener(this);

        cateLabel = new JLabel("Choose Category:");
        cateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        cateBox = new JComboBox(category);
        cateBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cateBox.setPreferredSize(new Dimension(200, 25));
        cateBox.addActionListener(this);

        priceLabel = new JLabel("Enter Price:");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        priceField = new JTextField(22);
        priceField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        priceField.addActionListener(this);

        addBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        addBtn.setPreferredSize(new Dimension(130, 30));
        addBtn.addActionListener(this);

        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        welcomeLabel.setBounds(430, 60, 600, 40);

        srtBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        srtBtn.setBounds(455, 595, 120, 30);
        srtBtn.addActionListener(this);
        add(srtBtn);

        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        dateLabel.setBounds(40, 550, 270, 120);
        //dateLabel.addActionListener(this);
        add(dateLabel);

        /*salesBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        salesBtn.setBounds(460, 600, 128, 25);
        salesBtn.addActionListener(this);
        add(salesBtn);*/

        salesRepBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        salesRepBtn.setBounds(595, 595, 120, 30);
        salesRepBtn.addActionListener(this);
        add(salesRepBtn);

        extBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        extBtn.setBounds(730, 595, 120, 30);
        extBtn.addActionListener(this);
        add(extBtn);

        deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        deleteBtn.setBounds(200, 99, 120, 25);
        deleteBtn.addActionListener(this);

        clear.setFont(new Font("Tahoma", Font.BOLD, 10));
        clear.setBounds(80, 99, 120, 25);
        clear.addActionListener(this);

        theDeletingLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        theDeletingLbl.setBounds(58, 50, 300, 30);

        thisDisplay.setBounds(22, 160, 360, 210);
        thisDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        thisDisplay.setEditable(false);

        starterBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        starterBtn.setPreferredSize(new Dimension(110, 30));
        starterBtn.setToolTipText("Sorted Items For Starter");
        starterBtn.addActionListener(this);

        mainBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        mainBtn.setPreferredSize(new Dimension(110, 30));
        mainBtn.setToolTipText("Sorted Items For Main Meal");
        mainBtn.addActionListener(this);

        drinks.setFont(new Font("Tahoma", Font.BOLD, 12));
        drinks.setPreferredSize(new Dimension(110, 30));
        drinks.setToolTipText("Sorted Items For Drinks");
        drinks.addActionListener(this);


        theItemLbl.setFont(new Font("Tahoma", Font.BOLD, 14));

        thePriceLbl.setFont(new Font("Tahoma", Font.BOLD, 14));

        theItemFied = new JTextField(25);
        theItemFied.setEditable(false);
        theItemFied.setFont(new Font("Tahoma", Font.PLAIN, 14));
        theItemFied.addActionListener(this);


        thePriceField = new JTextField(25);
        thePriceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        thePriceField.setEditable(false);
        thePriceField.addActionListener(this);

        buyBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        buyBtn.setPreferredSize(new Dimension(130, 30));
        buyBtn.addActionListener(this);

        numOfItems.setFont(new Font("Tahoma", Font.BOLD, 14));

        numOfItemsField = new JTextField(18);
        numOfItemsField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        numOfItemsField.addActionListener(this);






       /* String n[] = new String[theFoodItems.size()];


      /*  for(int y = 0; y < theFoodItems.size(); y++) {


            n[y] = theFoodItems.get(y).getFoodItem();


            System.out.println(n[y].length());

        }



        itemToDelete = new JComboBox(n);
        //itemToDelete.setSelectedIndex(0);
        itemToDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        itemToDelete.setBounds(600, 80, 200, 30);
        itemToDelete.addActionListener(this);
        add(itemToDelete);*/

        //listModel =  new DefaultListModel();

        // String [] items = new String[theFoodItems.size()];






       /* ArrayList <String> p = new ArrayList<String>();
        p.add("Mnce");
        p.add("Jay");

        //list = new JList(p);

        /*list.setFont(new Font("Tahoma", Font.PLAIN, 18));
        list.setBounds(600, 80, 200, 30);
        list.setVisible(true);
        //list.addActionListener(this);*/

        String name[] = new String[theFoodItems.size()];//{"Mncedisi", "Mngadi"};

        for (int i = 0; i < theFoodItems.size(); i++) {

        }

        //listModel.addElement("Mncedi");



      /*  //list = new JList(listModel);
       list.setVisibleRowCount(4);
       list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      // list.setBounds(600, 80, 200, 30);
       add(new JScrollPane(list));*/


        panel1 = new JPanel();
        panel1.setBorder(panel1Border);
        panel1.setLayout(new FlowLayout());
        panel1.setBounds(450, 155, 402, 400);
        panel1.setBackground(Color.ORANGE);

        panel2 = new JPanel();
        panel2.setBorder(panel2Border);
        panel2.setLayout(null);
        panel2.setBounds(40, 155, 402, 400);
        panel2.setBackground(Color.ORANGE);

        panel3 = new JPanel();
        panel3.setBorder(panel3Border);
        panel3.setLayout(new FlowLayout());
        panel3.setBounds(862, 155, 402, 470);
        panel3.setBackground(Color.ORANGE);

        panel2.add(deleteBtn);
        panel2.add(clear);
        panel2.add(theDeletingLbl);
        panel2.add(thisDisplay);


        //Table
        String titles[] = {"Item", "Category", "Price"};


        tableModel = new DefaultTableModel(0, 3);
        //table = new JTable(tableModel);
        //table.setBounds(38, 215, 410, 142);


        // table.setPreferredScrollableViewportSize(table.getPreferredSize());


        //Hard cooding items to the Arraylist
        theFoodItems.add(new FoodMenuItem("Cheese burger", "main meal", 11.50, infor));
        theFoodItems.add(new FoodMenuItem("Gatsby", "main meal", 8.50, infor));
        theFoodItems.add(new FoodMenuItem("Fish and chips", "main meal", 9.50, infor));
        theFoodItems.add(new FoodMenuItem("Cappuccino", "drinks", 10.25, infor));
        theFoodItems.add(new FoodMenuItem("Coffee", "drinks", 5.00, infor));
        theFoodItems.add(new FoodMenuItem("Hot wings", "starter", 6.00, infor));
        theFoodItems.add(new FoodMenuItem("Calamari", "starter", 5.50, infor));
        theFoodItems.add(new FoodMenuItem("Calamari", "starter", 5.50, infor));

        infor = new Sale();


        Object[][] tableData = {
                {theFoodItems.get(0).getFoodItem(), theFoodItems.get(0).getCategory(), "R " + theFoodItems.get(0).getPrice()},
                {theFoodItems.get(1).getFoodItem(), theFoodItems.get(1).getCategory(), "R " + theFoodItems.get(1).getPrice()},
                {theFoodItems.get(2).getFoodItem(), theFoodItems.get(2).getCategory(), "R " + theFoodItems.get(2).getPrice()},
                {theFoodItems.get(3).getFoodItem(), theFoodItems.get(3).getCategory(), "R " + theFoodItems.get(3).getPrice()},
                {theFoodItems.get(4).getFoodItem(), theFoodItems.get(4).getCategory(), "R " + theFoodItems.get(4).getPrice()},
                {theFoodItems.get(5).getFoodItem(), theFoodItems.get(5).getCategory(), "R " + theFoodItems.get(5).getPrice()},
                {theFoodItems.get(6).getFoodItem(), theFoodItems.get(6).getCategory(), "R " + theFoodItems.get(6).getPrice()},};


        tableModel = new DefaultTableModel(tableData, titles);

        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        table.setRowHeight(20);
        table.setToolTipText("Click An Item If You Want To Delete!!");
        JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(350, 250));
        // table = (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)


        panel1.add(scroll);
        panel1.add(itemLabel);
        panel1.add(itemField);
        panel1.add(cateLabel);
        panel1.add(cateBox);
        panel1.add(priceLabel);
        panel1.add(priceField);
        panel1.add(addBtn);

        panel3.add(starterBtn);
        panel3.add(mainBtn);
        panel3.add(drinks);

        //panel3.add();

        add(panel1);
        add(panel2);
        add(panel3);
        //add(list);

        add(welcomeLabel);

        HandlerClass handler = new HandlerClass();
        table.addMouseListener(handler);


        String titles2[] = {"Item", "Category", "Price"};


        tableModel2 = new DefaultTableModel(0, 3);

        Object[][] tableData2 = {
        };


        tableModel2 = new DefaultTableModel(tableData2, titles2);

        table2 = new JTable(tableModel2);
        table2.setFillsViewportHeight(true);
        table2.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        table2.setRowHeight(20);
        table2.setToolTipText("Click An Item To Buy!!");
        JScrollPane scroll2 = new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setPreferredSize(new Dimension(350, 250));
        // table = (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)


        panel3.add(scroll2);
        panel3.add(theItemLbl);
        panel3.add(theItemFied);
        panel3.add(thePriceLbl);
        panel3.add(thePriceField);
        panel3.add(numOfItems);
        panel3.add(numOfItemsField);
        panel3.add(buyBtn);

        HandlerClass2 handler2 = new HandlerClass2();
        table2.addMouseListener(handler2);


    }

    public void actionPerformed(ActionEvent event) {


        String itemName = "", category = "", thePrice = "";
        double price = 0.00;


        int index = cateBox.getSelectedIndex();



        if (event.getSource() == addBtn) {

            itemName = itemField.getText();

            thePrice = priceField.getText();



            if (isNumber(thePrice) && isString(itemName)) {


                price = Double.parseDouble(thePrice);




                if (index == 1) {

                    category = "starter";

                } else if (index == 2) {

                    category = "main meal";

                } else if (index == 3) {

                    category = "drinks";

                } else {

                    JOptionPane.showMessageDialog(null, "You Have To Select A Valid Category");

                }


                     //Adding to the Arraylist
                     theFoodItems.add(new FoodMenuItem(itemName, category, price, infor));

                     //Adding to the Table
                     tableModel.addRow(new Object[]{itemName, category, "R " + price});

                     //Refresh
                     itemField.setText("");
                     priceField.setText("");
                     cateBox.setSelectedIndex(0);









            } else {

                JOptionPane.showMessageDialog(null, "A Name Should Be Entered For Item and A Number For Price!!");

            }





        } else if (event.getSource() == deleteBtn) {

            tableModel = (DefaultTableModel) table.getModel();

            int selectRowIndex = table.getSelectedRow();
            tableModel.removeRow(selectRowIndex);

            /*int row = table.getSelectedRow();
            String tableClicked = (table.getModel().getValueAt(row,0).toString());

            JOptionPane.showMessageDialog(null, tableClicked);*/

            thisDisplay.append(tableClicked + " Deleted...\n");

        }else if(event.getSource() == clear){

            thisDisplay.setText("");

        } else if (event.getSource() == srtBtn) {

            JOptionPane.showMessageDialog(null, "Items Sorted By Name");
            Collections.sort(theFoodItems, new SortItemNames());

        } else if (event.getSource() == starterBtn) {

            while (tableModel2.getRowCount() > 0) {

                tableModel2.removeRow(0);

            }

            for (int u = 0; u < theFoodItems.size(); u++) {

                if (theFoodItems.get(u).getCategory().equalsIgnoreCase("starter")) {

                    tableModel2.addRow(new Object[]{theFoodItems.get(u).getFoodItem(), theFoodItems.get(u).getCategory(), theFoodItems.get(u).getPrice()});

                }
            }

        } else if (event.getSource() == mainBtn) {

            while (tableModel2.getRowCount() > 0) {

                tableModel2.removeRow(0);

            }


            for (int o = 0; o < theFoodItems.size(); o++) {

                if (theFoodItems.get(o).getCategory().equalsIgnoreCase("main meal")) {

                    tableModel2.addRow(new Object[]{theFoodItems.get(o).getFoodItem(), theFoodItems.get(o).getCategory(), theFoodItems.get(o).getPrice()});

                }

            }

        } else if (event.getSource() == drinks) {

            while (tableModel2.getRowCount() > 0) {

                tableModel2.removeRow(0);

            }

            for (int o = 0; o < theFoodItems.size(); o++) {

                if (theFoodItems.get(o).getCategory().equalsIgnoreCase("drinks")) {

                    tableModel2.addRow(new Object[]{theFoodItems.get(o).getFoodItem(), theFoodItems.get(o).getCategory(), theFoodItems.get(o).getPrice()});

                }

            }

        } else if (event.getSource() == buyBtn) {

           // for (int u = 0; u < theFoodItems.size(); u++) {

                double tPrice = Double.parseDouble(tableClicked3);

                String numItems = numOfItemsField.getText();

                String name = theItemFied.getText();

                Integer num = Integer.parseInt(numItems);


                infor.incrementTotalSalesValue(tPrice);
                infor.incrementItemsSold(num);

                display += name +"        "+numItems+"            "+infor.getTotalSalesValue()+"\n";

               // if (theFoodItems.get(u).getFoodItem().equalsIgnoreCase(tableClicked2)) {


                    // theFoodItems.get(u).setSaleInfo(infor.incrementItemsSold());
                    // infor.incrementTotalSalesValue(tPrice);

                   // theFoodItems.get(u).setSaleInfo(infor);
                   // infor.Sale();



                    //JOptionPane.showMessageDialog(null, theFoodItems.get(u).toString());

               // }

           // }

           // infor.setSaleInfo(infor);

            numOfItemsField.setText("");
            theItemFied.setText("");
            thePriceField.setText("");

            JOptionPane.showMessageDialog(null, numItems+" "+ name+" Bought");


        } else if (event.getSource() == extBtn) {

            System.exit(0);

        }else if(event.getSource() == salesRepBtn){

            JOptionPane.showMessageDialog(null, "Item     "+"Sales Count     "+"Total\n"+display);

        }

    }


    private class HandlerClass implements MouseListener {

        public void mouseClicked(MouseEvent event) {

            int row = table.getSelectedRow();
            tableClicked = (table.getModel().getValueAt(row, 0).toString());

            for (int p = 0; p < theFoodItems.size(); p++) {

                if (theFoodItems.get(p).getFoodItem().equalsIgnoreCase(tableClicked)) {


                        theFoodItems.remove(theFoodItems.get(p));

                }


            }


        }

        public void mousePressed(MouseEvent event) {


        }

        public void mouseReleased(MouseEvent event) {


        }

        public void mouseEntered(MouseEvent event) {


        }

        public void mouseExited(MouseEvent event) {


        }


    }

    private class HandlerClass2 implements MouseListener {

        public void mouseClicked(MouseEvent event) {

            int row2 = table2.getSelectedRow();
            tableClicked2 = (table2.getModel().getValueAt(row2, 0).toString());

            int row3 = table2.getSelectedRow();
            tableClicked3 = (table2.getModel().getValueAt(row3, 2).toString());

            theItemFied.setText(tableClicked2);
            thePriceField.setText(tableClicked3);


        }

        public void mousePressed(MouseEvent event) {


        }

        public void mouseReleased(MouseEvent event) {


        }

        public void mouseEntered(MouseEvent event) {


        }

        public void mouseExited(MouseEvent event) {


        }


    }


    public void clock() {


        Thread clock = new Thread() {


            public void run() {


                try {


                    while (true) {


                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        int seconds = cal.get(Calendar.SECOND);
                        int minutes = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);

                        dateLabel.setText("Time  " + hour + " : " + minutes + " : " + seconds + "  Date " + year + "/" + month + "/" + day);

                        sleep(1000);


                    }


                } catch (InterruptedException e) {

                    e.printStackTrace();

                }
            }

        };


        clock.start();


    }

    public boolean isNumber(String in) {

        try {
            Double.parseDouble(in);

            return true;

        } catch (Exception E) {

            return false;

        }

    }

    public boolean isString(String in) {


        if(in.matches("[a-zA-Z]+")){

            return true;

        }else {

            return false;
        }

    }



}
