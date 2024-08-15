package ra.run;

import ra.common.Common;

public class ShopManagement {
    public static void main(String[] args) {
       while (true){
           System.out.println("---------------------------SHOP MENU---------------------------");
           System.out.println("|             1. Quản lý danh mục sản phẩm                    |");
           System.out.println("|             2. Quản lý sản phẩm                             |");
           System.out.println("|             3. Thoát                                        |");
           System.out.println("|-------------------------------------------------------------|");
           System.out.println("Enter your choise :");
           int choise  = 0 ;
           while (true){
               choise = Common.getInputInt(choise);
               if(choise > 0 && choise < 4){
                   break;
               }else {
                   System.out.println("Please enter number from 1 to 3 !");
               }
           }

           switch (choise){
               case 1 : {
                   ManagementCategory managementCategory = new ManagementCategory();
                   managementCategory.main(args);
                   break;
               }
               case 2 : {
                   ManagementProduct managementProduct = new ManagementProduct();
                   managementProduct.main(args);
                   break;
               }
               case 3 : {
                   System.out.println("Goodbye !!!");
                   return;
               }
           }
       }
    }
}
