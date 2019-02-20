import java.util.ArrayList;
import java.util.List;

public class Main {


    static String firstname="Dolly",lastname="Singh";
    static int age =23;

    static {
        String firstname="dolly";
        String lastname="singh";
        int age=23;
        System.out.println("firstname:"+firstname+"lastname:"+lastname+"age:"+age);
    }



    public static void main(String[] args)
    {  // Q1 Write a program to replace a substring inside a string with other string ?
        String a=substringreplace("hello welcome to ttn",6,20," ","dolly");
        System.out.println(a);


        //Q2Write a program to find the number of occurrences of the duplicate words in a string and print them ?
        duplicate("today is to the new today hello world is today");

        //  Q3. Write a program to find the number of occurrences of a character in a string without using loop?
        int b=countcharacter("raishab",'a');
        System.out.println(b);

        //Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
        countAll("Dolly@1411");

        //Q5. Find common elements between two arrays.
        ArrayList<Integer> arr;
        int arr1[]={2,34,5,5,6,}; int arr2[]={64,7,12,6,5};
        arr=commonarray(arr1,arr2);
        for(int i : arr)
            System.out.println(i);

        //Q6. There is an array with every element repeated twice except one. Find that element
        int str[]={7,8,3,2,9,3,8,7,0,9,2};
        twiceExceptone(str);

        // Q7. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
        staticvar();
        description("Rishab","Jain",23);

        //Q8. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer
        String c=reverseString("qwertylkjhmnbv");
        System.out.println(c);

        //Q9 enum --- attached

//      overloading Q10.Write a single program for following operation using overloading
//  A) Adding 2 integer number
//  B) Adding 2 double
//  C) multiplying 2 float
//  D) multiplying 2 int
//  E) concate 2 string
//  F) Concate 3 String
        OverloadingEx ov=new OverloadingEx();
        int z=ov.add(2,5);
        double y=ov.add(2,8.9f);
        double x=ov.add(2,2.5d);
        int w=ov.add(2,6,0);
        double v=ov.add(12.45d,45.7d);
        float u=ov.multiply(3.4f,8.4f);
        int t=ov.multiply(2,4);
        String s=ov.concatString("dolly",new String("hey"));
        System.out.println(z);
        String r=ov.concat3string("hello","how","you?");
        System.out.println(r+"\t"+s+"\t"+t+"\t"+u+"\t"+v+"\t"+w+"\t"+x+"\t"+y+"\t"+z);
//        ov.concatString(null,null);//compile time
//        ov.add(null,2);//error


    }
  // Q1 Write a program to replace a substring inside a string with other string ?
    static public String substringreplace(String a,int first,int last,String replace ,String replacewith)
    {
        return a.substring(first,last).replace(replace,replacewith);
    }


    //Q2Write a program to find the number of occurrences of the duplicate words in a string and print them ?
    public static  void duplicate(String a)
    {

        String arr[];int count=1;int flag=0;
        arr=a.split(" ");
        for (String z:arr)
            System.out.print(z+" ");
        System.out.println("");
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (arr[j].equals(arr[i]))
                {
                    count++;
                    for(int z=j;z<len-1;z++)
                    {
                        arr[z]=arr[z+1];
                    }
                    len=len-1;
                }
            }
            flag=0;
            if(count>1)
                flag=1;
            if(flag==1)
            {
                System.out.println(arr[i]+count);
            }
            count=1;
        }

    }
    //  Q3. Write a program to find the number of occurrences of a character in a string without using loop?
    static public int countcharacter(String a,char b)
    {
        int len=a.length();
        String c=a.replace(String.valueOf(b),"");
        int leng=c.length();
        return len-leng;
    }

    //Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
    static public void countAll(String str)
    {
        int len=str.length();
        int uc=0;int lc=0;int digit=0;int sc=0;
        for(int i=0;i<str.length();i++)
        {
            char a=str.charAt(i);
            if(Character.isUpperCase(a)) uc++;
            else if(Character.isLowerCase(a)) lc++;
            else if(Character.isDigit(a)) digit++;
            else sc++;
        }
        System.out.println("UPPERCASE:"+uc+"and "+(uc*100.0/len)+"%");
        System.out.println("LOWERCASE:"+lc+"and "+(lc*100.0/len)+"%");
        System.out.println("DIGIT:"+digit+"and "+(digit*100.0/len)+"%");
        System.out.println("SPECIAL CHARACTER:"+sc+"and "+(sc*100.0/len)+"%");
    }
//Q5. Find common elements between two arrays.
    static public ArrayList<Integer> commonarray(int str1[],int str2[])
    {
        ArrayList<Integer> common=new ArrayList<Integer>();
        for(int i=0;i<str1.length;i++)
        {
            for(int j=0;j<str2.length;j++)
            {
                if(str1[i]==str2[j])
                {
                    if(!common.contains(str1[i]))
                        common.add(str1[i]);
                }
            }
        }
        return common;
    }


    //Q6. There is an array with every element repeated twice except one. Find that element
    public static void twiceExceptone(int str[])
    {
        int count=0;
        for(int i=0;i<str.length;i++) {
            for (int j = 0; j < str.length; j++) {
                if (str[i] == str[j])
                    count++;
            }
            if(count<2) {
                System.out.println(str[i] + " with occurence " + count);
            }
            count=0;

        }
    }

    // Q7. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
    public static void description(String firstname,String lastname,int age)
    {
        System.out.println("inside static method");
        System.out.println("firstname:"+firstname+"\tlastname:"+lastname+"\tage:"+age);
    }

    public static void staticvar()
    {
        System.out.println("firstname:"+firstname+"\tlastname:"+lastname+"\tage:"+age);
    }

    //Q8. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer
    public static String reverseString(String str)
    {
        StringBuffer sb=new StringBuffer(str);
        sb=sb.reverse();
        String s=String.valueOf(sb.subSequence(4,9));
        return s;
    }

}
