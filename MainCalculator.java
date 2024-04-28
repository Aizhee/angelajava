package midterm;
//This is the main calculator class for the Spherical Triangle Calculator
//This class is used to calculate the area of a spherical triangle
//This uses inheritance to allow the SphericalTriangleCalculator to inherit the methods from the UIMaker class
public class MainCalculator extends UIMaker{

	protected static double computeMissingVariables(double[] angles, double[] sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        double A = Math.toRadians(angles[0]);
        double B = Math.toRadians(angles[1]);
        double C = Math.toRadians(angles[2]);
        
        boolean missingVariableFound = (A == 0 || B == 0 || C == 0 || a == 0 || b == 0 || c == 0);
 
        // If all three sides are provided, use the Spherical Excess formula to calculate the area
        
        while (missingVariableFound) {
            // If all three sides are provided, use the Spherical Excess formula to calculate the area
        	missingVariableFound = false;
        	if (A == 0) {
                if (B != 0 && a != 0 && b != 0) {
                    A = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(B)) * Math.sin(Math.toRadians(a)) / Math.sin(Math.toRadians(b))));
                    missingVariableFound = true;
                } else if (C != 0 && a != 0 && c != 0) {
                    A = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(a)) * Math.cos(Math.toRadians(c)) + Math.sin(Math.toRadians(a)) * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(C))));
                    missingVariableFound = true;
                } 
            }

            if (B == 0) {
                if (A != 0 && a != 0 && b != 0) {
                    B = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(A)) * Math.sin(Math.toRadians(b)) / Math.sin(Math.toRadians(a))));
                    missingVariableFound = true;
                } else if (C != 0 && b != 0 && c != 0) {
                    B = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(c)) + Math.sin(Math.toRadians(b)) * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(C))));
                    missingVariableFound = true;
                } 
            }

            if (C == 0) {
                if (A != 0 && a != 0 && c != 0) {
                    C = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(A)) * Math.sin(Math.toRadians(c)) / Math.sin(Math.toRadians(a))));
                    missingVariableFound = true;
                } else if (B != 0 && b != 0 && c != 0) {
                    C = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) + Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(b)) * Math.cos(Math.toRadians(B))));
                    missingVariableFound = true;
                } else if (A != 0 && B != 0 && c != 0) {
                	C = Math.toDegrees(Math.acos((Math.cos(Math.toRadians(c)) - Math.cos(Math.toRadians(A)) * Math.cos(Math.toRadians(B))) / 1+(Math.sin(Math.toRadians(A)) * Math.sin(Math.toRadians(B)))));
                	missingVariableFound = true;
                }
            }


            if (a == 0) {
                if (A != 0 && B != 0 && b != 0) {
                    a = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(A)) * Math.sin(Math.toRadians(b)) / Math.sin(Math.toRadians(B))));
                    missingVariableFound = true;
                } else if (c != 0 && A != 0 && C != 0) {
                    a = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(a)) * Math.cos(Math.toRadians(c)) + Math.sin(Math.toRadians(a)) * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(C))));
                    missingVariableFound = true;
                }
            }

            if (b == 0) {
                if (a != 0 && A != 0 && B != 0) {
                    b = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(a)) * Math.sin(Math.toRadians(B)) / Math.sin(Math.toRadians(A))));
                    missingVariableFound = true;
                } else if (c != 0 && B != 0 && C != 0) {
                    b = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(c)) + Math.sin(Math.toRadians(b)) * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(C))));
                    missingVariableFound = true;
                } 
            }

            if (c == 0) {
                if (a != 0 && A != 0 && C != 0) {
                    c = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(a)) * Math.sin(Math.toRadians(C)) / Math.sin(Math.toRadians(A))));
                    missingVariableFound = true;
                } else if (b != 0 && B != 0 && C != 0) {
                    c = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) + Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(b)) * Math.cos(Math.toRadians(B))));
                    missingVariableFound = true;
                } 
            }
            angles[0] = Math.toDegrees(A);
            angles[1] = Math.toDegrees(B);
            angles[2] = Math.toDegrees(C);
            sides[0] = a;
            sides[1] = b;
            sides[2] = c;
        }   return -1;

    }
    
    public static double calculateSphericalExcess(double[] angles) {
        return (angles[0] + angles[1] + angles[2]) - 180.0;
    }

    public static double calculateSphericalArea(double sphericalExcess, double radius) {
        return Math.PI * Math.pow(radius, 2) * sphericalExcess / 180;
    }

}
