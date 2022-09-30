/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controller.ProductManager;
import Entity.Product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class utils {

    ProductManager pm = new ProductManager();

    public static void askToback() {
        String quit = utils.inputValue("Do you want to back(y/n):");
        if (quit.equalsIgnoreCase("n") || quit.equalsIgnoreCase("no")) {
            System.exit(0);
        }
    }
//quantity

    public static int inputValueQuantity(String welcome, int min, int max) {
        int number = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome + "[" + min + ", " + max + "]: ");
                number = Integer.parseInt(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.print(welcome + "[" + min + ", " + max + "]: ");
            }
        } while (cont || number > max || number < min);
        return number;
    }

    public static int updateValueQuantity(String welcome, int min, int max, int oldValue) {
        int number = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome + "[" + min + ", " + max + "]");
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    number = oldValue;
                    cont = false;
                } else {
                    number = Integer.parseInt(str);
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome + "[" + min + ", " + max + "]");
            }
        } while (cont || number > max || number < min);
        return number;
    }
//price

    public static float inputValuePrice(String welcome, int min, int max) {
        float number = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome + "[" + min + ", " + max + "]: ");
                number = Integer.parseInt(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.print(welcome + "[" + min + ", " + max + "]: ");
            }
        } while (cont || number > max || number < min);
        return number;
    }

    public static float updateValuePrice(String welcome, int min, int max, float oldValue) {
        float number = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome + "[" + min + ", " + max + "]");
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    number = oldValue;
                    cont = false;
                } else {
                    number = Integer.parseInt(str);
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome + "[" + min + ", " + max + "]");
            }
        } while (cont || number > max || number < min);
        return number;
    }
//name

    public static String inputValueName(String welcome, List<Product> listOfProduct) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (!str.isEmpty() && str.length() >= 5 && !str.contains(" ")) {
                    cont = false;
                }

                for (Product item : listOfProduct) {
                    if (item.getProductName().contains(str)) {
                        cont = true;
                    }
                }

            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }
    
     public static String inputValueName(String welcome) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (!str.isEmpty()) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

    public static String updateValueName(String welcome, String oldValue, List<Product> listOfProduct) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (str.isEmpty()) {
                    str = oldValue;
                    cont = false;
                    break;
                } else if (str.length() < 5) {
                    cont = true;
                } else {
                    cont = false;
                }

                for (Product item : listOfProduct) {
                    if (item.getProductName().contains(str)) {
                        cont = true;
                    }
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

//status
    public static String inputValueStatus(String welcome) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        String avai = "Available";
        String notAvai = "Not Available";
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (!str.isEmpty()) {
                    if (str.equalsIgnoreCase(avai) || str.equalsIgnoreCase(notAvai)) {
                        cont = false;
                    } else {
                        cont = true;
                    }
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

    public static String updateValueStatus(String welcome, String oldValue) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (str.isEmpty()) {
                    str = oldValue;
                    cont = false;
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

//value
    public static String inputValue(String welcome) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (!str.isEmpty()) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

    public static String updateValue(String welcome, String oldValue) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                str = sc.nextLine();
                if (str.isEmpty()) {
                    str = oldValue;
                    cont = false;
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.print(welcome);
            }
        } while (cont);
        return str;
    }

}
