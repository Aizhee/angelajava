package midterm;

//This is the main class file for the Spherical Triangle Calculator
//This class is used to calculate the area of a spherical triangle
//This uses inheritance to allow the SphericalTriangleCalculator to inherit the methods from the MainCalculator class
//Also uses encapsulation to protect the data
public class SphericalTriangleCalculator extends MainCalculator{

	public static double[] angles;
	public static  double[] sides;

    public static void main(String[] args) {
    	run();
    }
    // Run method to handle the main logic
    public static void run() {
    	int choice = showOptions();

        angles = new double[3];
        sides = new double[3];
        double radius;

        switch (choice) {
            case 1:
                angles = getSphericalAngles();
                radius = getRadius();
                break;
            case 2:
            	angles[0] = getAngle0();
            	angles[1] = getAngle1();
                sides[2] = getSide2();
                radius = getRadius();
                computeMissingVariables(angles, sides);
            	break;
            case 3:
            	angles[0] = getAngle0();
            	angles[1] = getAngle1();
                sides[0] = getSide0();
                radius = getRadius();
                computeMissingVariables(angles, sides);
                break;
            case 4:
                sides = getSides();
                radius = getRadius();
                break;
            case 5:
                sides [0] = getSide0();
                sides [1] = getSide1();
                angles[2] = getAngle2();
                radius = getRadius();
                computeMissingVariables(angles, sides);
                break;
            case 6:
            	sides [0] = getSide0();
                sides [1] = getSide1();
                angles[0] = getAngle0();
                radius = getRadius();
                computeMissingVariables(angles, sides);

                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        
        if ((angles[0] != 0 && angles[1] != 0 && angles[2] != 0) || (sides[0] != 0 && sides[1] != 0 && sides[2] != 0)) {
            showMessage( "Angles: A = " + angles[0] + "\nB = " + angles[1] + "\nC = " + angles[2] +
                    "\nSides: a = " + sides[0] + "\n b = " + sides[1] + "\n c = " + sides[2]);
        } else {
        	 boolean reRun = confirmDialog("Area cannot be computed.", "Error");
        	 if (reRun) 
      			run();
        }


        double sphericalExcess = calculateSphericalExcess(angles);
        if (sphericalExcess < 0) {
        	 boolean reRun = confirmDialog( "Invalid input! The sum of interior angles should be greater than 180 degrees and less than 540 degrees. \nDo you want to calculate again?", "Error");
        	 if (reRun) 
     			run();
        	 return;
        }

        // Calculate the area of the spherical triangle
        double area = calculateSphericalArea(sphericalExcess, radius);

        // Display the result
        boolean reRun = confirmDialog( "Area of the spherical triangle: " + area + "\nSpherical Excess: "+ sphericalExcess + "\nDo you want to calculate again?", "Result");
		if (reRun) 
			run();
    }
    
    
    private static int showOptions() {
        String[] options = {
                "3 spherical angles (A,B,C)",
                "2 spherical angles and subtending angle between (A,B,c)",
                "2 spherical angles and adjacent subtending angle (A,B,a)",
                "3 subtending angles (a,b,c)",
                "2 subtending angles and spherical angle between (a,b,C)",
                "2 subtending angles and adjacent subtending angle (a,b,A)"
        };
        String choice = (String) showDropdown( "Choose an option:", "Spherical Triangle Calculator", options, options[0]);

        int choiceIndex = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(choice)) {
                choiceIndex = i;
                break;
            }
        }
        return choiceIndex + 1;
    }
    
    //Method to get input from the user for the angles of the spherical triangle
    private static double[] getSphericalAngles() {
        double[] angles = new double[3];
        angles[0] = showInputDialog("Enter angle A:");
        angles[1] = showInputDialog("Enter angle B:");
        angles[2] = showInputDialog("Enter angle C:");
        return angles;
    }

    private static double[] getSides() {
        double[] sides = new double[3];
        sides[0] = showInputDialog("Enter side a:");
        sides[1] = showInputDialog("Enter side b:");
        sides[2] = showInputDialog("Enter side c:");
        return sides;
    }
    private static double getSide0() {
        return showInputDialog("Enter side a:");
    }
    private static double getSide1() {
        return showInputDialog("Enter side b:");
    }
    private static double getSide2() {
        return showInputDialog("Enter side c:");
    }

    private static double getAngle0() {
        return showInputDialog("Enter angle A:");
    }
    private static double getAngle1() {
        return showInputDialog("Enter angle B:");
    }
    private static double getAngle2() {
        return showInputDialog("Enter angle C:");
    }

    private static double getRadius() {
        return showInputDialog("Enter the radius:");
    }


}
