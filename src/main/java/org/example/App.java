package org.example;

import org.example.Dao.MenuDao;
import org.example.Dao.SellerDao;
import org.example.Dao.StoreDao;
import org.example.Dao.UserDao;
import org.example.Model.Menu;
import org.example.Model.Seller;
import org.example.Model.Store;
import org.example.Model.User;
import org.example.Util.Connect;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDao userDao=new UserDao();
        User newUser = new User(1L, "Admin", "Gul", "Nur", "gul.nur@example.com", "password123", "1234567890");
        User newUser1=new User(2L,"Seller","Manasbek","Iman","iman@gmail.com","12345678","0708362921");
        User newUser2=new User(3L,"Customer","Argen","Emil","Argen01@gmail.com","83034274","0508606040");

       // userDao.createUser(newUser2);
      //  User retrievedUser = userDao.getUserById(1L);
        //if (retrievedUser != null) {
          //  System.out.println("Retrieved User: " + retrievedUser);
        //} else {
         //   System.out.println("User not found.");
        //}
        //userDao.getUserById(1L);
        // Updating the user's information
      //  if (retrievedUser != null) {
        //    retrievedUser.setFirstName("UpdatedJohn");
          //  userDao.updateUser(retrievedUser);
            //System.out.println("User updated successfully.");
        //}

        // Deleting the user by ID
       // userDao.deleteUser(1L);
      //  System.out.println("User deleted successfully.");

//_____________________________________________________________________________________________________

        //StoreDao storeDao = new StoreDao();
        //Store newStore = new Store(1L, " St.Temirova 80", "555-1234", "donutstore@example.com");
        //storeDao.createStore(newStore);

        // Retrieving the store by ID
     //   Store retrievedStore = storeDao.getStoreById(1L);
       // if (retrievedStore != null) {
         //   System.out.println("Retrieved Store: " + retrievedStore);
        //} else {
          //  System.out.println("Store not found.");
        //}

        // Updating the store's information
      //  if (retrievedStore != null) {
        //    retrievedStore.setAddress("456 Oak St");
          //  storeDao.updateStore(retrievedStore);
            //System.out.println("Store updated successfully.");
        //}

        // Deleting the store by ID
      //  storeDao.deleteStore(1L);
        //System.out.println("Store deleted successfully.");



      //________________________________________________________________
     //   SellerDao sellerDao = new SellerDao();

        // Creating a new seller
       // Seller newSeller = new Seller(1L, "Seller", "Jalil", "Ainura", "ainurajj@example.com", "jddjshkj", "1234567890", "Sales Associate", 15.50);

        // Adding the seller to the database
        //sellerDao.createSeller(newSeller);

        // Retrieving the seller by ID
    //  Seller retrievedSeller = sellerDao.getSellerById(1L);
      //  if (retrievedSeller != null) {
         //   System.out.println("Retrieved Seller: " + retrievedSeller);
        //} else {
          //  System.out.println("Seller not found.");
        //}

        // Updating the seller's information
        //if (retrievedSeller != null) {
          //  retrievedSeller.setFirstName("UpdatedJohn");
            //retrievedSeller.setHourlyRate(18.75);
            //sellerDao.updateSeller(retrievedSeller);
            //System.out.println("Seller updated successfully.");
        //}

        // Deleting the seller by ID
        //sellerDao.deleteSeller(1L);
        //System.out.println("Seller deleted successfully.");



        //__________________________________________________________________________
        // MenuDao menuDao = new MenuDao();

        // Creating a new menu
        //Menu newMenu = new Menu("Burger", 9.99, "Main Course");

        // Adding the menu to the database
        //menuDao.createMenu(newMenu, 1L); // Assuming 1L is the storeId

        // Retrieving the menu by ID
       // Menu retrievedMenu = menuDao.getMenuById(1L); // Assuming 1L is the menuId
       // if (retrievedMenu != null) {
         //   System.out.println("Retrieved Menu: " + retrievedMenu);
        //} else {
          //  System.out.println("Menu not found.");
      //  }

        // Updating the menu's information
       // if (retrievedMenu != null) {
         //   retrievedMenu.setPrice(12.99);
           // menuDao.updateMenu(retrievedMenu);
            //System.out.println("Menu updated successfully.");
        //}

        // Deleting the menu by ID
        //menuDao.deleteMenu(1L); // Assuming 1L is the menuId
       // System.out.println("Menu deleted successfully.");


    }
}

