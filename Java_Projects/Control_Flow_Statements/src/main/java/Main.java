public class Main {
    public static void main(String[] args) {
        int age = 25;
        int ticketPrice;

        if (age < 5) {
            ticketPrice = 0;
        } else if (age < 12) {
            ticketPrice = 5;
        } else if (age < 18) {
            ticketPrice = 10;
        } else {
            ticketPrice = 15;
        }
        System.out.println("Ticket Price: $ " + ticketPrice);


        char grade = 'A';
        String comment;
        switch (grade) {
            case 'A':
                comment = "Excellent!";
                break;
            case 'B':
                comment = "Good Job!";
                break;
            case 'C':
                comment = "Meh!";
                break;
            case 'D':
                comment = "Do Better!";
                break;
            case 'E':
                comment = "Come On Now!";
                break;
            case 'F':
                comment = "Failure!";
                break;
            default:
                comment = "Invalid Grade!";
        }
        System.out.println("Comment: " + comment);


        int[] numbers = {3, 76, 36, 49, 53};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Value at index " + i + ": " + numbers[i]);
        }

        int n = 3;
        int counter = 0;
        int i = 0;

        while (counter < n) {
            if (i % 2 == 0) {
                System.out.println(i);
                counter++;
            }
            i++;
        }

        int m = 6;
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while(j<=m);
        
        int[] nums = { 2, 6, 8, 19, 45, 57};
        int sum = 0;
        for ( int num : nums  ) {
            sum += num;
        }
        System.out.println(sum);


        int[] grades = {0, 14, 45, 75};
        int highest = grades[0];
        int lowest = grades[0];

        for(int k=0; i<grades.length; k++) {
            if (grades[k] > highest) {
                highest = grades[k];
            }
            if (grades[k] < lowest) {
                lowest = grades[k];
            }
        }

        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);


        int[] numbs = {4, 64, 743, 346};

        int sun = 0;
        int coumt = 0;

        for (int numb: numbs) {
            if (numb % 2 != 0 ) {
                sun += numb;
                coumt++;
            }
        }
        double average = (double) sun/coumt;
        System.out.println("Average of odd numbers: " + average);


    }
}
