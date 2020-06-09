import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by naveed on 2/15/15.
 */
public class ClientPhase2 {

    public static void main(String[] args) 
    {
    	if(args.length != 2) { System.out.println("Invalid arguments, exiting..."); return; }
    	
        String filename = args[0];
        String fileFromServer = args[1];

        ArrayList<BigInteger> sk = (ArrayList<BigInteger>)StaticUtils.read("ClientSK.out");
        Paillier paillier = new Paillier();
        paillier.setSecretKey(sk);

        BigInteger[] encryptedPolyEval = (BigInteger[])StaticUtils.read(fileFromServer);
        Inputs inputs = new Inputs(filename);
        BigInteger[] roots = inputs.getInputs();
        List<BigInteger> rootsList = Arrays.asList(roots);

        for(int i = 0; i < encryptedPolyEval.length; i++){
            BigInteger match = paillier.Decryption(encryptedPolyEval[i]);
            if(rootsList.contains(match)){
                System.out.println(match + " is common.");
            }
        }
    }

}
