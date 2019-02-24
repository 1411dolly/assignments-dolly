public class Student {
    String Name; Double Score; Double Age;

    public Student(String j, double i, double k) {
        Name=j;
        Score=i;
        Age=k;
    }

    public String toString()
    {
        return "Name:"+getName()+"\tScore:"+getScore()+"\tAge:"+getAge();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }

    public Double getAge() {
        return Age;
    }

    public void setAge(Double age) {
        Age = age;
    }
}
