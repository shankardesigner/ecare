package com.shankardesigner.ecare.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Laptop implements Comparable<Laptop>{
    private int price;
    private String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        if(this.getPrice() > o.getPrice()) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class CompareExample {
    public static void main(String[] args) {
        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(new Laptop(200,"Apple"));
        laptopList.add(new Laptop(250,"Samsung"));
        laptopList.add(new Laptop(220,"Toshiba"));
        laptopList.add(new Laptop(205,"Acer"));
        laptopList.add(new Laptop(150,"Hp"));

        Comparator<Laptop> compareLaptop = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop l1, Laptop l2) {
                if(l1.getName().compareTo(l2.getName()) < 0) {
                    return -1;
                } else  {
                    return 1;
                }
            };
        };

        Collections.sort(laptopList);

        for (Laptop laps: laptopList) {
            System.out.println(laps);
        }
    }
}
