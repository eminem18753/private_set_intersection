import flanagan.math.Polynomial;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClientPhase1 {

    public static void main(String[] args) 
    {
    	if(args.length != 2) { System.out.println("Invalid arguments, exiting..."); return; }
    	
        String filename = args[0];
        String netids = args[1];

        Paillier paillier = new Paillier();

        Inputs inputs = new Inputs(filename);
        BigInteger[] roots = inputs.getInputs();

        double[] rootsDouble = new double[roots.length];
        for(int i = 0; i < roots.length; i++) rootsDouble[i] = roots[i].doubleValue();

        Polynomial poly = Polynomial.rootsToPoly(rootsDouble);

        double[] coefficients = poly.coefficientsCopy();
        BigInteger[] coefficientsBigInteger = new BigInteger[coefficients.length];
		
        int j = 0;
        for(double coefficient : coefficients){
            coefficientsBigInteger[j++] = new BigDecimal(coefficient).toBigInteger().mod(paillier.getPublicKey());
        }
		
        BigInteger[] encryptedCoefficients = new BigInteger[coefficients.length];

        for(int k = 0; k < coefficients.length; k++){
            encryptedCoefficients[k] = paillier.Encryption(coefficientsBigInteger[k]);
        }

        StaticUtils.write(encryptedCoefficients, netids);
        StaticUtils.write(paillier.getPublicKey(), "ClientPK.out");
        StaticUtils.write(paillier.getSecretKey(), "ClientSK.out");
    }

}
