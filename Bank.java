 class SBI extends Bank{
    public int rate_of_interest=5;
    public int no_of_cust=100;
    String ifsc_code="sbidabarpur";

    public void getDetails(int a,int b,String c)
    {
        rate_of_interest=a;no_of_cust=b;ifsc_code=c;
        System.out.println("rate:"+rate_of_interest+"\tno_of_costumer"+no_of_cust+"\tifsc_code"+ifsc_code+"\n");
    }
     public SBI()
     {
         System.out.println("rate:"+this.rate_of_interest+"\tno_of_cust"+this.no_of_cust+"\tifsc_code"+this.ifsc_code+"\n");
     }
 }
class ICICI extends Bank
{

    public int rate_of_interest=10;
    public int no_of_cust=200;
    String ifsc_code="icicidabarpur";


    public void getDetails(int a,int b,String c)
    {
        rate_of_interest=a;no_of_cust=b;ifsc_code=c;
        System.out.println("rate:"+rate_of_interest+"\tno_of_costumer"+no_of_cust+"\tifsc_code"+ifsc_code+"\n");
    }
    public ICICI()
    {
        System.out.println("rate:"+this.rate_of_interest+"\tno_of_cust"+this.no_of_cust+"\tifsc_code"+this.ifsc_code+"\n");
    }
}
class BOI extends Bank{

    public int rate_of_interest=15;
    public int no_of_cust=300;
    String ifsc_code="boidabarpur";

    public void getDetails(int a,int b,String c)
    {
        rate_of_interest=a;no_of_cust=b;ifsc_code=c;
        System.out.println("rate:"+rate_of_interest+"\tno_of_costumer"+no_of_cust+"\tifsc_code"+ifsc_code+"\n");
    }
    public BOI()
    {
        System.out.println("rate:"+this.rate_of_interest+"\tno_of_cust"+this.no_of_cust+"\tifsc_code"+this.ifsc_code+"\n");
    }
}


    public class Bank{

    int rate_of_interest=20;
    int no_of_cust=900;
    String ifsc_code="bank";

        public void getDetails(int a,int b,String c)
        {
            rate_of_interest=a;no_of_cust=b;ifsc_code=c;
            System.out.println("rate:"+rate_of_interest+"\tno_of_costumer"+no_of_cust+"\tifsc_code"+ifsc_code+"\n");
        }
        public Bank()
        {
            System.out.println("rate:"+this.rate_of_interest+"\tno_of_cust"+this.no_of_cust+"\tifsc_code"+this.ifsc_code+"\n");
        }

    public static void main(String[] args) {

        SBI sbi1=new SBI();
        sbi1.getDetails(2,10,"customsbi");
//        SBI sbi2=new Bank();
        Bank sbi3=new SBI();
        sbi3.getDetails(3,15,"bank_sbi");
        Bank sbi4=new Bank();
        sbi4.getDetails(4,20,"Bank");

    }
}