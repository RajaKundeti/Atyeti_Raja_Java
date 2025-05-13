package Problem2;

import static Problem2.RoomType.AC;
import static Problem2.RoomType.NON_AC;

public class HotelBookingSystem {

    public static void bookRoom(int noOfPeople, RoomType roomType, int noOfDays){
        if(noOfPeople <= 3){
            System.out.print("No Of People: "+noOfPeople+", Room Type: "+roomType+", No Of Days: "+noOfDays+", ");
            calculateCost(2000, 1000, roomType, noOfDays);
        }else if (noOfPeople <= 5){
            System.out.print("No Of People: "+noOfPeople+", Room Type: "+roomType+", No Of Days: "+noOfDays+", ");
            calculateCost(3000, 2000, roomType, noOfDays);
        } else {
            System.out.print("No Of People: "+noOfPeople+", Room Type: "+roomType+", No Of Days: "+noOfDays+", ");
            calculateCost(5000, 4000, roomType, noOfDays);
        }
    }

    private static void calculateCost(double acCost, double nonAcCost, RoomType roomType, int noOfDays) {
        switch (roomType){
            case AC :
                showTotalCost(acCost, noOfDays);
                break;
            case NON_AC:
                showTotalCost(nonAcCost,noOfDays);
                break;
            default:
                System.out.println("Invalid Room Type!");
        }
    }

    private static void showTotalCost(double amount, int noOfDays) {
        double totalCost=0;
        if(noOfDays <= 5){
            totalCost = noOfDays*amount;
            System.out.println("Total Cost: "+totalCost);
        }
        else {
            totalCost = noOfDays*amount;
            totalCost = totalCost - totalCost*0.1;
            System.out.println("Total Cost: "+totalCost+", Discount: "+totalCost*0.1);
        }
    }
}
