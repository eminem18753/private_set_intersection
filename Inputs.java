import java.io.*;
import java.math.BigInteger;
/**
 * Created by naveed on 2/14/15.
 */
public class Inputs {

    int inputsize = 10;

    String[] inputs = new String[inputsize];
    BigInteger[] hashedInputs = new BigInteger[inputsize];

    public Inputs(String filename) { readInputs(filename); }

    public void readInputs(String filename){
        BufferedReader br = null;

        String line = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            int i = 0;
            while((line = br.readLine()) != null){
                inputs[i] = line;
                i++;
//                if(i > 25) {
//                    System.out.println("Error: Number of inputs are greater than 25.");
//                    System.exit(0);
//                }
            }
        } 
        catch (FileNotFoundException e) { e.printStackTrace(); } 
        catch (IOException e) { e.printStackTrace(); }
    }

    public BigInteger[] getInputs(){
        BigInteger[] in = new BigInteger[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            in[i] = BigInteger.valueOf(Integer.parseInt(inputs[i]));
        }
        return in;
    }

    public BigInteger[] hashInputs(){
        for(int i = 0; i < inputsize; i++){
            hashedInputs[i] = StaticUtils.truncatedHashBigInt(inputs[i]);
        }
        return hashedInputs;
    }
}
