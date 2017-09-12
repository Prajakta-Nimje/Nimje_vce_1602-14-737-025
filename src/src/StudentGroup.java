import java.util.Date;
import java.util.ArrayList;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return this.students;
		// Add your implementation here
		
	}

	@Override
	public void setStudents(Student[] students) {
		
		if(students == null) {
		throw new IllegalArgumentException();
		}
		else
		this.students = students;
		
		// Add your implementation here
	}

	@Override
	public Student getStudent(int index) {
		
		if(index<0 || index>=this.students.length) {
		throw new IllegalArgumentException();
		}
		else {
		return this.students[index];
		}
		}
		

	@Override
	public void setStudent(Student student, int index) {
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
		this.students[index]=student;
		}
	}
		// Add your implementation here

	@Override
	public void addFirst(Student student) {
		if(student == null) {
		throw new IllegalArgumentException();
		}
		else {
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(0,student);
		}
		// Add your implementation here
	}

	@Override
	public void addLast(Student student) {
		if(student == null) {
		throw new IllegalArgumentException();
		}
		else {
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(student);
		}
		
		// Add your implementation here
	}

	@Override
	public void add(Student student, int index) {
		if(student == null) {
		throw new IllegalArgumentException();
		}
		else {
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(index,student);
		}
		// Add your implementation here
	}

	@Override
	public void remove(int index) {
		
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			//this.students.remove(new Student(index));
			list.remove(index);
		}
		// Add your implementation here
	}

	@Override
	public void remove(Student student) {
		int index=0;
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			list.remove(student);
		}
		// Add your implementation here
	}

	@Override
	public void removeFromIndex(int index) {
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			list.subList(index+1, list.size()).clear();
		// Add your implementation here
		}
	}

	@Override
	public void removeFromElement(Student student) {
		int index=0;
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			int in=list.indexOf(student);
			list.subList(in+1, list.size()).clear();
		}
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			list.subList(0,index-1).clear();
		}
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		int index=0;
		if(index<0 || index>=this.students.length || students == null) {
		throw new IllegalArgumentException();
		}
		else {
			ArrayList<Student> list=new ArrayList<Student>();
			int in=list.indexOf(student);
			list.subList(0,in-1).clear();
		}
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		Student s1;
		Student[] s = new Student[this.students.length];
		for(int i=0; i < this.students.length-1; i++){
             for(int j=1; j < this.students.length; j++){
                      if(this.students[i].getId() > this.students[j].getId()){
                             //swap elements
                             s1 = this.students[j-1];
                             this.students[j-1] = this.students[j];
                             this.students[j] = s1;
                     }
                      
             }
		// Add your implementation here
	}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date==null) {
		throw new IllegalArgumentException();
		}
		else {
		Student[] s=students;
		int j=0;
		for(int i=0;i<this.students.length;i++) {
		if(this.students[i].getBirthDate().equals(date)) {
		s[j]=this.students[i];
		j++;
		}
	}
		Student[] s1 = new Student[j+1];
		s1=s;
		return s1;
	}
		// Add your implementation here
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null || lastDate==null) {
		throw new IllegalArgumentException();
		}
		else {
		Student[] s = students;
		int j=0;
		for(int i=0;i<this.students.length;i++) {
		if((this.students[i].getBirthDate().after(firstDate) && this.students[i].getBirthDate().before(lastDate))||(this.students[i].getBirthDate().equals(firstDate))||(this.students[i].equals(lastDate)) ) {

		s[j]=this.students[i];
		j++;
		}
		}
		Student[] s1 = new Student[j+1];
		s1=s;
		return s1;
		}
		// Add your implementation here
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date==null) {
		throw new IllegalArgumentException();
		}
		else {
		Student[] s = students;
		int j=0;
		for(int i=0;i<this.students.length;i++) {
		if(date.equals(this.students[i].getBirthDate())|| (Math.abs(date.getDate()-this.students[i].getBirthDate().getDate())<=days)) {
		s[j]=this.students[i];
		j++;

		}
		}
		Student[] s1=new Student[j+1];
		s1=s;
		return s1;
		}

		// Add your implementation here
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if(indexOfStudent == 0) {
		throw new IllegalArgumentException();
		}
		else {
		int y = this.students[indexOfStudent].getBirthDate().getYear();
		return 2017-y;

		}
		// Add your implementation here

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		Student[] s =this.students;
		int j=0;
		for(int i=0;i<this.students.length;i++) {
		if(age==this.getCurrentAgeByDate(i)) {
		s[j]=this.students[i];
		j++;
		}
		}
		Student[] s1 = new Student[j+1];
		s1=s;
		return s1;
		// Add your implementation here
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		Student[] s =this.students;
		int count = Integer.MIN_VALUE;
		int j=0;
		for(int i=0;i<this.students.length;i++) {
		if(count<this.students[i].getAvgMark()) {
		s[j]=students[i];
		j++;
		}
		}
		Student[] s1 = new Student[j+1];
		s1=s;
		return s1;
		// Add your implementation here
		
	}

	@Override
	public Student getNextStudent(Student student) {
		if(student == null) {
		throw new IllegalArgumentException();
		}
		else {
		for(int i=0;i<this.students.length;i++) {
		if(this.students[i]==student) {
		return this.students[i+1];
			}
		}
	}
}

}

