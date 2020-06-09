import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StaticUtils 
{
    public static BigInteger truncatedHashBigInt(String str)
    {
        MessageDigest md = null;
        try 
        {
            md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes("UTF-8"));
        } 
        catch (NoSuchAlgorithmException e) { e.printStackTrace(); return null; } 
        catch (UnsupportedEncodingException e) { e.printStackTrace(); return null; }

        byte[] hash = md.digest();
        byte[] truncatedHash = new byte[4];
        System.arraycopy(hash, 0, truncatedHash, 0, 4);
        return new BigInteger(truncatedHash).abs();
    }
    
    public static void write(Object object, String filename)
    {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(object);
        } 
        catch (IOException e) { e.printStackTrace(); }
        finally { try { if(oos != null) { oos.close(); } } catch (IOException e) { e.printStackTrace(); } }
    }
    
    public static Object read(String filename)
    {
        ObjectInputStream ois = null;
        Object object = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
            object = ois.readObject();
        } 
        catch (IOException e) { e.printStackTrace();} 
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        finally { try { if(ois != null) { ois.close(); } } catch (IOException e) { e.printStackTrace(); } }
        return  object;
    }
}
