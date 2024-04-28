package midterm;

import javax.swing.JOptionPane;
//This is the class for the User Interface Maker
//This class is used to create the UI for the Spherical Triangle Calculator
public class UIMaker {

	// Method to display a message dialog ui
	 public static void showMessage(String message) {
	     JOptionPane.showMessageDialog(null, message);
	 }


	 // Method to show input dialog and return the input double value
	 public static double showInputDialog(String message) {
	     String input = JOptionPane.showInputDialog(message);
	     if (input == null) {
	         return Double.NaN; // User clicked cancel
	     } else {
	         try {
	             return Double.parseDouble(input);
	         } catch (NumberFormatException e) {
	             showMessage("Invalid input! Please enter a numerical value.");
	             return showInputDialog(message);
	         }
	     }
	 }
	 
	 
	 // Method to show input dialog and return the input dropdown value
	 public static String showDropdown(String message, String title, String[] options, String defaultOption) {
	     String input = (String) JOptionPane.showInputDialog(null,
	         message, title,
	         JOptionPane.QUESTION_MESSAGE, null, options, defaultOption);
	     if (input == null) {
	         return null; // User clicked cancel
	     } else {
	         return input;
	     }
	 }
	 
	// Method to show a confirmation dialog
	public static boolean confirmDialog(String message, String title) {
        int dialogResult = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
