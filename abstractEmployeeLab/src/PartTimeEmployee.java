public class PartTimeEmployee extends Employee {

   public PartTimeEmployee() {
      super();
   }

   public PartTimeEmployee(String n, double r, int h,int i){
      super(n, r, h, i);
   }
   public double getPay() {
      double pay;
      pay = rate * hours;
      totalPay += pay;
      return pay;
   }
}

