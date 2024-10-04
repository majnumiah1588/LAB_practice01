import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args[0].equals("a")) {
		    System.out.println("Loading data ...");			
		    try {
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String fileContent = fileReader.readLine();
                String studentNames[] = fileContent.split(", ");			
                for(String student : studentNames) { 
                System.out.println(student); 
                }
			} 
            catch (Exception e){

            } 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
		    System.out.println("Loading data ...");			
		    try {
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			String fileContent = fileReader.readLine();
			System.out.println(fileContent);
			String studentNames[] = fileContent.split(", ");	
			Random randomGenerator = new Random();
            int totalStudents = studentNames.length;
			int randomIndex = randomGenerator.nextInt(totalStudents);
			System.out.println(studentNames[randomIndex]);
			} 
            catch (Exception e){

            } 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("students.txt", true));
			String newStudentName = args[0].substring(1);
	        Date currentDate = new Date();
	        String dateFormatPattern = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormatter = new SimpleDateFormat(dateFormatPattern);
	        String formattedDate = dateFormatter.format(currentDate);
			fileWriter.write(", "+newStudentName+"\nList last updated on "+formattedDate);
			fileWriter.close();
			} 
            catch (Exception e){

            }				
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String fileContent = fileReader.readLine();
                String studentNames[] = fileContent.split(", ");	
                boolean studentFound = false;
                String studentToSearch = args[0].substring(1);
                for(int index = 0; index<studentNames.length && !studentFound; index++) {
                    if(studentNames[index].equals(studentToSearch)) {
                    System.out.println("We found it!");
                    studentFound=true;
                    }
                }
			} 
            catch (Exception e){

            } 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String fileContent = filReader.readLine();
                char characters[] = fileContent.toCharArray();			
                boolean inWord = false;
                int wordCount=0;
                for(char character:characters) {
                    if(character ==' ') 
                    {
                        if (!inWord) {	
                            wordCount++; 
                            inWord =true;	
                        }
                        else { 
                            inWord=false;
                        }			
                    }
                }
                System.out.println(wordCount +" word(s) found " + characters.length);
			} 
            catch (Exception e){

            } 
			System.out.println("Data Loaded.");				
		}
	}
}