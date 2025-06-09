// ArrayNumbers.java
class ArrayNumbers {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 70};

        int sum = 0;
        int max = scores[0];
        int min = scores[0];

        for (int score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        double average = (double) sum / scores.length;

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
    }
}
