import java.util.Scanner;

public class HRS 
{
    static class Room 
	{
        int rno;
        int p;
        boolean res;
        String gname;

        Room(int rno, int p, boolean res, String gname)
		{
            this.rno = rno;
            this.p = p;
            this.res = res;
            this.gname = gname;
        }
    }

    static Room[] rooms = 
	{
        new Room(101, 1000, false, ""),
        new Room(201, 2000, false, ""),
        new Room(301, 3000, false, ""),
        new Room(401, 4000, false, ""),
        new Room(501, 5000, false, "")
    };

    static Scanner s1 = new Scanner(System.in);

    public static void main(String[] args) 
	{
        boolean exit = false;

        while (!exit) 
		{
            System.out.println("\nEnter the choice (1:Search Rooms, 2:Make Reservation, 3:Check Booking Details, 4:Exit): ");

            System.out.print("Enter your choice: ");
            int ch = s1.nextInt();
            s1.nextLine(); 

            switch (ch) 
			{
                case 1:
                    searchRooms();
                    break;

                case 2:
                    makeReservation();
                    break;

                case 3:
                    viewBookingDetails();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void searchRooms() 
	{
        boolean b = false;
        for (Room room : rooms) 
		{
            if (!room.res) 
			{
                b = true;
                System.out.println("Room-" + room.rno + ", Price-" + room.p);
            }
        }
        if (!b) 
		{
            System.out.println("No available rooms.");
        }
    }

    public static void makeReservation() 
	{
        System.out.print("Enter your name: ");
        String gname = s1.nextLine(); 

        System.out.print("\nEnter number of rooms to book: ");
        int n = s1.nextInt();
        s1.nextLine(); 

        int bookedRoomsCount = 0;

        for (int i = 0; i < n; i++) 
		{
            System.out.print("\nEnter room number for room " + (i + 1) + ": ");
            int rno = s1.nextInt();
            s1.nextLine(); 

            boolean roomFound = false;
            for (Room room : rooms) 
			{
                if (room.rno == rno && !room.res) 
				{
                    room.res = true;
                    room.gname = gname;
                    System.out.println("Room " + room.rno + " reserved successfully!");
                    bookedRoomsCount++;
                    roomFound = true;
                    break;
                }
            }

            if (!roomFound) 
			{
                System.out.println("Room " + rno + " is either already reserved or does not exist.");
            }
        }

        if (bookedRoomsCount == n) 
		{
            System.out.println("All rooms booked successfully!");
            System.out.println("Reservation Details:");
            System.out.println("Guest Name: " + gname);
            System.out.println("Number of Rooms Booked: " + n);
        } else 
		{
            System.out.println("One or more rooms are not available for reservation.");
        }
    }

    public static void viewBookingDetails() 
	{
        System.out.print("Enter your name: ");
        String gname = s1.nextLine();
        boolean bookingFound = false;
        int totalAmount = 0;

        for (Room room : rooms) 
		{
            if (room.res && room.gname.equals(gname)) 
			{
                bookingFound = true;
                System.out.println("Booking Details:");
                System.out.println("Guest Name: " + room.gname);
                System.out.println("Room Number: " + room.rno);
                System.out.println("Price: Rs." + room.p);
                totalAmount += room.p;
            }
        }

        if (!bookingFound)
		{
            System.out.println("No booking found for the guest: " + gname);
        } 
		else
		{
            System.out.println("Total Price for all rooms booked: Rs." + totalAmount);
        }
    }
}
