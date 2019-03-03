//Q1 Implement Singleton Design Pattern on a dummy class.
public class Q1SingletonClass {
    private static Q1SingletonClass instance;
    private Q1SingletonClass(){}
    //not thread safe and lazy initialisation
    public static Q1SingletonClass getInstance()
    {
        if(instance==null)
            instance= new Q1SingletonClass();
         return instance;
    }
}
class Singleton{
    private static Singleton single;
    private Singleton(){}
    //thread safe but not efficient and lazy initialisation
    public synchronized Singleton getSingle()
    {
        if(single==null)
            return single=new Singleton();
        return single;
    }
}

class Singleton2{
    private static Singleton2 single;
    private Singleton2(){}
    //efficient thread safe and lazy initialisation , called double locking
    public Singleton2 getInstance() {
        if(single == null) {
            synchronized(this) {
                if(single == null)
                    single = new Singleton2();
            }
        }
        return single;
    }
}

class Singleton3
{   //not lazy initialisation , variable will be created when the class is loaded
 private static final Singleton3 instance = new Singleton3();
        private Singleton3(){}
        public static Singleton3 getInstance(){
            return instance;
        }

}
//other 2 ways are @ThreadSafe annotation and lastly enum