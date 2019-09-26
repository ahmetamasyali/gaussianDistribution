import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static final double PI = 3.14159;

    public static final double EPSILON = 0.008;

    public static void main(String[] args) throws IOException
    {
        List<Integer> dataset = new ArrayList<>();
        dataset.addAll(Arrays.asList(3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1,
                3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1,
                3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1,
                3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1,
                3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1,
                3, 2, 11, 1, 4, 0, 12, 3, 14, 0, 5, 17, 1, 20, 4, 3, 2, 1));


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            Double newValue = Double.valueOf(in.readLine());

            System.out.println(newValue + " is anomally : " + Boolean.toString(EPSILON > calculateDistribution(dataset, newValue))) ;
        }
    }

    public static Double calculateDistribution( List<Integer> dataset, Double newValue){

        Double mean = calculateMean(dataset);

        Double standartDeviation = calculateStandartDeviation(dataset, mean);

        Double variance = standartDeviation * standartDeviation;

        double distribution = ( 1.0 / (Math.sqrt( 2 * PI * variance))) * Math.exp((-1 * (Math.pow(newValue - mean, 2))) / (2 * variance));

        return distribution;
    }

    public static Double calculateMean( List<Integer> dataset){
        return dataset.stream().mapToDouble(data -> data.doubleValue()).average().orElse(Double.NaN);
    }


    public static Double calculateStandartDeviation( List<Integer> dataset, Double mean){
        double sum = 0;
        for(Integer data : dataset){
            sum += (data - mean) * (data - mean);
        }

        return sum / (dataset.size()-1);
    }
}
