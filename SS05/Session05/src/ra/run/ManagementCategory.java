package ra.run;

import ra.common.Common;
import ra.common.DataBase;
import ra.entity.Category;
import ra.entity.Product;

import java.util.Scanner;

public class ManagementCategory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       while (true){
           System.out.println("---------------------------CATEGORIES MENU---------------------------");
           System.out.println("|                    1. Nhập thông tin các danh mục                         |");
           System.out.println("|                    2. Hiển thị thông tin các danh mục                     |");
           System.out.println("|                    3. Cập nhật thông tin danh mục                          |");
           System.out.println("|                    4. Xóa danh mục                                                     |");
           System.out.println("|                    5. Cập nhật trạng thái danh mục                         |");
           System.out.println("|                    6. Quay lại                                                                 |");
           System.out.println("-------------------------------------------------------------------------------------");
           int choise = 0 ;
           System.out.println("Enter choise ");
           choise =Common.getInputInt(choise);


           switch (choise){
               case 1 : {
                   System.out.println("Enter number category want add :");
                   int choise1 = 0 ;
                  choise1 = Common.getInputInt(choise1);
                  for(int i = 1 ; i <= choise1 ; i++){
                      Category category = new Category();
                      category.inputData(scanner, DataBase.categories,DataBase.currentIndexCategory);
                      DataBase.currentIndexCategory++ ;
                      DataBase.categories[DataBase.currentIndexCategory] = category ;
                  }
                   System.out.println("Add " + choise1 + " category successfully !");
                  Common.displayCategory(DataBase.categories);
                  break;
               }
               case 2 : {
                   Common.displayCategory(DataBase.categories);
                   break;
               }
               case 3 : {
                   System.out.println("Enter category id to update :");
                   int categoryId =  0 ;
                   categoryId = Common.getInputInt(categoryId);
                   boolean isCkeck = false ;
                   for(Category category : DataBase.categories){
                       if(category.getCategoryId() == categoryId){
                           isCkeck = true ;
                           break;
                       }
                   }
                   if(isCkeck){
                       int indexCategory = -1 ;
                       for(int i = 0 ; i < DataBase.categories.length ; i++){
                           if(DataBase.categories[i].getCategoryId() == categoryId){
                               indexCategory = i ;
                               break;
                           }
                       }
                       DataBase.categories[indexCategory].updateData(scanner,DataBase.categories,DataBase.currentIndexCategory);

                       System.out.println("Update successfully !");
                       Common.displayCategory(DataBase.categories);
                   }else {
                       System.out.println("Not found category id !");
                   }
                   break;
               }
               case  4 : {
                   System.out.println("Enter id category to delete : ");
                   int categoryId = 0 ;
                  categoryId = Common.getInputInt(categoryId);
                   int indexCategory = -1 ;
                   for(int i = 0 ; i < DataBase.categories.length ; i++){
                     if(DataBase.categories[i] != null){
                         if(DataBase.categories[i].getCategoryId()  == categoryId){
                             indexCategory = i ;
                             break;
                         }
                     }else {
                         break;
                     }
                   }
                   if(indexCategory  < 0){
                       System.out.println("Not found category id ");
                   }else {
                       boolean isCheck = false ;
                       for(Product product : DataBase.products){
                          if(product !=null){
                              if(product.getCategoryId() == categoryId){
                                  isCheck = true ;
                                  break;
                              }
                          } else
                              break;
                       }
                      if(isCheck){
                          System.out.println("Cannot delete because the category already has products !");
                      }else {
                          for(int i = indexCategory ; i < DataBase.currentIndexCategory ; i++){
                              DataBase.categories[i] = DataBase.categories[i+1];
                          }
                          DataBase.categories[DataBase.currentIndexCategory] = null ;
                          DataBase.currentIndexCategory--;
                          System.out.println("Delete success !");
                          Common.displayCategory(DataBase.categories);
                      }
                   }
                   break;
               }

               case  5 : {
                   System.out.println("Enter id category to update status category :");
                   int categoryId = 0 ;
                   categoryId = Common.getInputInt(categoryId);
                   int indexCategory = -1 ;
                   for(int i = 0 ; i <= DataBase.currentIndexCategory ; i++){
                       if(DataBase.categories[i].getCategoryId() == categoryId){
                           indexCategory = i ;
                           break;
                       }
                   }
                   if(indexCategory == -1){
                       System.out.println("Not found id category");
                   }else {
                        if( DataBase.categories[indexCategory].getCategoryStatus() == true){
                            DataBase.categories[indexCategory].setCategoryStatus(false);
                        }else {
                            DataBase.categories[indexCategory].setCategoryStatus(true);
                        }
                       System.out.println("Update status category successfully !");
                        Common.displayCategory(DataBase.categories);
                   }
                   break;
               }
               case 6 : {
                   return;
               }
               default: {
                   System.out.println("Please enter choise valid !");
               }
           }
       }
    }
}
