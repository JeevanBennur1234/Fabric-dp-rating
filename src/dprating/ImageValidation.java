package dprating;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageValidation {
   public static boolean isImage(File file) 
	{
		System.out.println(String.valueOf(file));

    	boolean b = false;
		try 
		{
			b = (ImageIO.read(file) != null);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
	public static boolean checkExtension(File file)
	{
		String filepath = String.valueOf(file);
		
		String extension = "";

			int i = filepath.lastIndexOf('.');
			if (i > 0)
			{
				extension = filepath.substring(i+1);
				
			}	

			if(extension.trim().equals("jpg") || extension.trim().equals("jpeg"))
			{
				boolean b=isImage(file);
                                return b;
					
			}	
			else
			{
					return false;
			}

        } 
}