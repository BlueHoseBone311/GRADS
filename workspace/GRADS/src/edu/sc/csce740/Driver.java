/**
 * 
 */
package edu.sc.csce740;


/**
 * @author brandemr
 * test
 */
public class Driver {

	/**
	 * @param args
	 * @throws Exception 
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GRADS grads = null;
		grads = new GRADS();
		
		try {
			grads.loadUsers("resources/users.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			grads.loadRecords("resources/students.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			grads.loadCourses("resources/courses.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grads.setUser("mmatthews");
		//grads.generateProgressSummary("mhunt");
		//grads.generateProgressSummary("mhunt");
		
		//System.out.println(grads.getTranscript("mhunt").getCoursesTaken().get(0).getCourse().getName());
		//System.out.println(grads.getStudentIDs());
		//System.out.println(grads.getGPCIDs());
		//System.out.println(grads.getTranscript("mhunt").getNotes().get(1));
		
		//Testing if degree reqs are being loaded
		//grads.addNote("mbr", "Im a note stillllllll!!!", true);

		grads.getTranscript("mhunt").setLastName("Hunter");
		
		grads.updateTranscript("mhunt", grads.getTranscript("mhunt"), true);
		System.out.println(grads.getTranscript("mhunt").getLastName());
		//grads.validateAccess("mhunt");
		
//		List<CourseTaken> courses = new ArrayList<CourseTaken>();
//		Course firstCourse = new Course();
//		firstCourse.setCourse("csce515", "Computer Network Programming", "3");
//		CourseTaken c= new CourseTaken();
//		c.setCourse(firstCourse);
//		Term t = new Term();
//		t.setTerm("Spring", 2015);
//		c.setTerm(t);
//		c.setGrade("P");
//		courses.add(c);
//		grads.simulateCourses("mhunt",courses);
//		
		
		//For testing...don't delete!
//		String representation = new GsonBuilder().setPrettyPrinting().create().toJson(allRecords);
//		writeToFile("records.txt", representation );

	}

}