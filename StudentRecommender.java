import java.util.*;
class Student
{
private String name="";
private String email_id="";
private int marks[];
private int percentage;
private int backlogs; 
Student(String name,String email_id,int marks[])
{
this.name=name;
this.email_id=email_id;
this.marks=marks;
}
public String getName()
{
return this.name;
}
public void Calculate()
{
int i;
int sum = 0;
int count = 0;
for(i = 0 ; i< 6 ; i++)
{
if(marks[i]<40)
{
++count;
}

sum = sum + marks[i];
}
int percentage = sum / 6;
this.percentage = percentage;
this.backlogs = count;
}
public int getPercent()
{
return this.percentage;
}
public int getBacklogs()
{
return this.backlogs;
}
}
class StudentDB
{
ArrayList<Student> studentarr;
StudentDB()
{
studentarr=new ArrayList<>();
}
public void addStudent(Student std)
{
studentarr.add(std);
}
public ArrayList<Student> getList()
{
return studentarr;
}
}
public class StudentRecommender
{
public static void main(String args[])
{
int num=1;
int i;
int n;
int j;
String ew[] = {"1st" ,"2nd" , "3rd" , "4th" , "5th" , "6th" };
StudentDB lol=new StudentDB();
System.out.println("Enter no. of Students");
Scanner obj=new Scanner(System.in);
n = obj.nextInt();
for(j=0; j<n ; j++)
{
String mname="";
String memail_id="";
int marks[] = new int[6];
System.out.println("Enter name,email id of student");
Scanner obj2=new Scanner(System.in);
mname=obj2.nextLine();
memail_id=obj2.nextLine();
for(i = 0 ; i<6 ; i++ )
{
System.out.println("Enter marks of " + ew[i] + " Subject");
marks[i] = obj2.nextInt();
while(marks[i]>100)
{
System.out.println("Marks cannot be more than 100. Enter valid data");
marks[i] = obj2.nextInt();
}
}

Student std=new Student(mname,memail_id,marks);
std.Calculate();
int percent = std.getPercent();
int backlog = std.getBacklogs();
if(backlog==0 && percent>60)
{
lol.addStudent(std);
}
}

ArrayList<Student> hmm=new ArrayList<>();
hmm=lol.getList();
for(Student display : hmm)
{
System.out.println("Recommended Students:"); 
System.out.println(display.getName());
}
}
}
