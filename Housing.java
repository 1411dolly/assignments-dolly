enum HousegetPrice {
    house_1BHK(1000,"faridabad"),house_2BHK(2000,"delhi"),house_3BHK(3000,"new delhi"),bunglow(4000,"haryana");
    private int price;
    private String location;
    HousegetPrice(int p,String loc) {
        price = p;
        location=loc;
    }
    int getPrice() {
        return price;
    }
    String getLocation(){
        return location;
    }
}
public class Housing {
    public static void main(String args[]){
        for (HousegetPrice house : HousegetPrice.values()) System.out.println(
                house + " costs " + house.getPrice() + " location "+house.getLocation());
    }
}