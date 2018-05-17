public class Contact {

    private static String name;
    private static String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String toString (){

        return name +" "+phoneNumber;
    }
}
//String.format("(%s) %s-%s", phoneNumber.substring(0, 3),
//        phoneNumber.substring(3, 6),phoneNumber.substring(6, 10))