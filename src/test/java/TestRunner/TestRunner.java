package TestRunner;
	
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
	
	@KarateOptions(features = "com.bestbuy.features", tags = {"@test"})
	public class TestRunner {

	       @Test

	       public void testParallel() {
	              Results results = Runner.parallel(getClass(), 0, "target/surefire.reports");
	              String karateOutputPath = "target/surefire.reports";
	              generateReport(karateOutputPath);
	       }

	       public static void generateReport(String karateOutputPath) {
	              try {
	                     Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
	                     List<String> jsonPaths = new ArrayList(jsonFiles.size());
	                     jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
	                     Configuration config = new Configuration(new File("target"), "Karate Framework");
	                     ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
	                     reportBuilder.generateReports();
	                     File sourceFolder = new File("target/cucumber-html-reports");
	                     long yourmilliseconds = System.currentTimeMillis();
	                     SimpleDateFormat sdf = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss");    
	                     Date resultdate = new Date(yourmilliseconds);
	                     File destinationFolder = new File("target/ReportRepo/KarateReports_"+sdf.format(resultdate));
	                     copyFolder(sourceFolder, destinationFolder);
	              } catch (Exception e) {
	                     e.printStackTrace();
	              }
	       }
	       
	       private static void copyFolder(File sourceFolder, File destinationFolder) throws IOException
	    {
	        //Check if sourceFolder is a directory or file
	        //If sourceFolder is file; then copy the file directly to new location
	        if (sourceFolder.isDirectory()) 
	        {
	            //Verify if destinationFolder is already present; If not then create it
	            if (!destinationFolder.exists()) 
	            {
	                destinationFolder.mkdir();
	                System.out.println("Directory created :: " + destinationFolder);
	            }
	             
	            //Get all files from source directory
	            String files[] = sourceFolder.list();
	             
	            //Iterate over all files and copy them to destinationFolder one by one
	            for (String file : files) 
	            {
	                File srcFile = new File(sourceFolder, file);
	                File destFile = new File(destinationFolder, file);
	                 
	                //Recursive function call
	                copyFolder(srcFile, destFile);
	            }
	        }
	        else
	        {
	            //Copy the file content from one place to another 
	            Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File copied :: " + destinationFolder);
	        }
	    }

	}




