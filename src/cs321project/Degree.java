package cs321project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Degree {

	private ArrayList<Requirement> requirements;
	private HashMap<String, ArrayList<Requirement>> allRequirements;
	FileHandler handler;
	
	public Degree() {
		this.requirements = new ArrayList<>();
	}
	//be careful with this!
	public void setHashTable(HashMap<String, ArrayList<Requirement>> table) {
		//note that i'm still not doing a hard copy.
		allRequirements = table;
	}
	public ArrayList<Requirement> getUniversityCore() {
		return allRequirements.get("University Core");
	}
	public ArrayList<Requirement> getComputerScienceDepartment() {
		return allRequirements.get("Computer Science Department");
	}
	public ArrayList<Requirement> getMajorInComputerScience() {
		return allRequirements.get("Major in Computer Science");
	}
	public ArrayList<Requirement> getSeniorCSOneElective() {
		return allRequirements.get("Senior CS, Elective One of:");
	}
	public ArrayList<Requirement> getAdditionalSeniorCS() {
		return allRequirements.get("Senior CS, Additional");
	}
	public ArrayList<Requirement> getCSRelatedCourses() {
		return allRequirements.get("CS-Related Courses");
	}
	public void fulfillRequirement(int index) {
		this.requirements.get(index).setFulfilled(true);
	}
	
	
	/**
	 * Method:TestCategory
	 * Description: Prints out the complete information of the Parameter Category
	 * @param category
	 */
	private void testCategory(ArrayList<Requirement> category)
	{
		/**
		 * goes over all requirements of the requirements
		 */
		for(int i = 0; i < category.size(); i++)
		{
			/**
			 * Checking Abstraction/Concretion(that's a word right?..) 
			 */
			System.out.print("(ReqType ->)");
			if(category.get(i).getSubject()!= null)
			{
				System.out.print("Concrete");
			}
			else
			{
				System.out.print("Abstract");
			}
			
			/**
			 * Retrieving basic info on the given Requirement
			 */
			System.out.print("(LabelInfo ->)");
			System.out.print(category.get(i).getLabel());
			//System.out.print("(NumberInfo ->)");
			//System.out.print(category.get(i).getNumber());
			//System.out.print("(SubjectInfo ->)");
			//System.out.print(category.get(i).getSubject());
			System.out.print("(FulfilledStatus ->)");
			/**
			 *prints yes if fulfilled, no if not 
			 */
			if(category.get(i).isFulfilled())
			{
				System.out.print("Yes");
			}
			else
			{
				System.out.print("no");
			}
			
			
			/**
			 * checking each prerequisite for the course if they exist
			 */
			
			if(category.get(i).getPrerequisiteFor() != null)
			{
				System.out.print("(PrerequisitesInfo ->)");
				System.out.print(category.get(i).getPrerequisiteFor().size());
				for(int j = 0; j<category.get(i).getPrerequisiteFor().size();j++)
				{
					System.out.print(category.get(i).getPrerequisiteFor().get(j).getLabel());
					System.out.print(",");
				}
			}
			System.out.println();
			
		}
		System.out.println();
	}
	
	
	/**
	 * Testing Degree Class:
	 * 
	 * It's relation to FileHandler and it's Methods
	 * @param args
	 */
	public static void main(String[]args)
	{
		Degree d = new Degree(); //testing degree
				/**
				 * Obtaining file information for input (output pending).
				 */
		
				//filepath will vary for this test,changing accordingly and all that
				d.handler = new FileHandler("C:\\Users\\Owner\\Desktop\\Eclipse_2019\\Java 2017_2018 projects\\cs321project-master\\src\\cs321project\\DegreeRequirements2.txt", "somecrap");
				try {
					d = d.handler.getDegree();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("wat");
					e.printStackTrace();
				}
				
				d.testCategory(d.getComputerScienceDepartment());
				d.testCategory(d.getAdditionalSeniorCS());
				d.testCategory(d.getCSRelatedCourses());
				d.testCategory(d.getMajorInComputerScience());
				d.testCategory(d.getSeniorCSOneElective());
				d.testCategory(d.getUniversityCore());
				
	}
}