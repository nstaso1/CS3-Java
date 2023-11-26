/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
import java.io.*;

public class ReadDataFile
{
    private ReadDataFile(){}

    public static void main (String[] args)
    {
        BufferedReader KB = new BufferedReader (new InputStreamReader (System.in));
	String Input = new String();
	boolean done = false;

	do
	{
            try
            {
		System.out.println ("Please type the name of data input file and then press enter key.");
		Input = KB.readLine(); //readLine can throw IOException
		File FL = new File(Input); //File class constructor can throw NullPointerException
		FileReader FR = new FileReader(FL); //Can throw FileNotFoundException check for length, hidden status, and read permission

		//check for length, hidden status, and read permission
                //Violation of any of them would cause SecurityException to be thrownwji
		if(FL.canRead())
		{
                    if(!FL.isHidden())
                    {
                        if(FL.length() != 0)
			{
                            System.err.println("Please specify the size of read buffer");
                            Input = KB.readLine();
                            int buf = Integer.parseInt(Input);
                            BufferedReader FReader = new BufferedReader(FR, buf);
                            readAndPrintFile(FReader);
                            done = true;
			}
			else
			{
                            System.err.println("The file has no data in it.");
                        }
                        done = false;
                    }
                    else
                    {
                        System.err.println("The file is hidden.");
                        done = false;
                    }
                }
                else
                {
                    System.err.println("The file does not have read permission");
                    done = false;
                }
            }//end of try block
            catch(NumberFormatException NFEx)//unchecked exception
            {
		NFEx.printStackTrace(System.err);
		System.err.println("Non-numeric buffer size has been entered.");
            }
            catch(IllegalArgumentException IllegalEx)//unchecked exception
            {
		IllegalEx.printStackTrace(System.err);
		System.err.println("Illegal buffer size has been entered.");
		done = false;
            }
            catch(NullPointerException NPex) //unchecked exception
            {
		NPex.printStackTrace(System.err);
		System.err.println("Null file name or null string has been entered.");
		done = false;
            }
            catch(SecurityException SC) //unchecked exception
            {
		SC.printStackTrace(System.err);
		done = false;
            }
            catch(FileNotFoundException FX) //checked exception - subclass of IOException
            {
		FX.printStackTrace(System.err);
		done = false;
            }
            catch(IOException IOex) //checked exception - subclass of Exception
            {
		IOex.printStackTrace(System.err);
		System.err.println("Input reading error.");
		done = false;
            }
            catch(Exception ex)
            {
		ex.printStackTrace(System.err);
		System.err.println("Unknown error/exception has occurred.");
		done = false;
            }
	} while(!done);
    }

    public static void readAndPrintFile(BufferedReader BR)
    {
	String Data = null;
	int count = 0;
	try
	{
            System.err.println("Printing your file to screen now.");
            while((Data = BR.readLine()) != null)
            {
                System.err.println(Data);
                if(++count %7 == 0)
                {
                    try
                    {
                        System.err.println("Press enter to continue printing.");
                        System.in.read();
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace(System.err);
                        System.err.println("Keyboard input error.");
                    }
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace(System.err);
            System.err.println("File reading error.");
        }
        System.err.println("Done printing.");
    }
}
