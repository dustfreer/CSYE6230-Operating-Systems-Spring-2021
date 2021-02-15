public class ProcessTest {
    public static void main(String[] args)
    {
        try
        {

            // create a new process
            System.out.println("Creating Process");
            ProcessBuilder builder = new ProcessBuilder("open", "https://www.google.com/");
            Process pro = builder.start();

            // wait 10 seconds
            System.out.println("Waiting for 30s");
            Thread.sleep(30000);

            // kill the process
            pro.destroy();
            System.out.println("Process destroyed");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
