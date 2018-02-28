/**
 * Class that pumps out objects in a method called 'Matrix', then allows for various matrix functions to be used on each matrix
 * 
 * @author Sunil Narayan
 * @version 1.0.0
 * 
 * Requires an input of a matrix as a paramater to set and get
 */
public class Matrix
{

    // variables
    int length;
    int height;
    int column;
    int row;
    double arr [] [] = new double [0] [0] ;
    /**
     * Constructor for objects of class Matrix
     * Stores doubles in the matrix array labeld 'arr'
     */
    public Matrix (int rows, int columns)
    {
        // Makes the matrix objects
        height = rows;
        length = columns;
        arr = new double [columns] [rows];         
    }

    public int getHeight(Matrix x) {
        //used to get the height of each matrix in rows for later use in operations
        return x.height;
    }

    public int getLength(Matrix x) {
        //used to get the length of each matrix in rows for later use in operations
        return x.length;
    }

    /**
     *Adds a double to a specified double to a specified place in the matrix
     */
    public void set (Matrix mat,int y, int x, double numadd) throws MatrixException {
        if (y < mat.getHeight(mat) && x >= 0 && x < mat.getLength(mat) && y >= 0)
        {            
            mat.arr [x] [y] = numadd;   
        } else {          
            throw new MatrixException("Exeption: x or y input value exeeds the boundries of the matrix or matrix is null");          
        }
    }

    /**
     *Returns the double at the specific point in the given matrix specified by the user
     */
    public double get (Matrix mat, int y, int x) throws MatrixException {
        //stuff
        if (y < mat.getHeight(mat) && x>= 0 && x < mat.getLength(mat) && y >= 0 && mat != null){
            return mat.arr [x] [y];
        } else {
            throw new MatrixException("Exeption: x or y input value exeeds the boundries of the matrix or matrix is null");    
        }
    }

    /**
     *Adds two full matricies together and returns the sum
     *Both matricies must be the same length and height
     *Returns the sum matrix
     */
    public Matrix add (Matrix x, Matrix y)throws MatrixException {
        //stuff
        if (x.getHeight(x) == y.getHeight(y) && x.getLength(x) == y.getLength(y) && x != null && y != null){
            Matrix c = new Matrix (x.getHeight(x), x.getLength(x));
            for (int i = 0; i < x.getLength(x); i++){
                for (int j = 0; j < x.getHeight(x); j++){
                    c.set(c, j, i, (x.get(x, j, i) + y.get(y, j, i)));
                }
            }
            return c;
        } else {
            throw new MatrixException("Exeption: Matrix input heights or lengths do not match or one or more matrix is null");    
        }
    }

    /**
     *Subtracts two full matricies
     *Both matricies must be the same length and height
     *Returns the difference matrix
     */
    public Matrix sub (Matrix x, Matrix y) throws MatrixException  {
        //stuff
        if (x.getHeight(x) == y.getHeight(y) && x.getLength(x) == y.getLength(y) && x != null && y != null){
            Matrix c = new Matrix (x.getHeight(x), x.getLength(x));
            for (int i = 0; i < x.getLength(x); i++){
                for (int j = 0; j < x.getHeight(x); j++){
                    c.set(c, j, i, (x.get(x, j, i) - y.get(y, j, i)));
                }
            }
            return c;
        } else {
            throw new MatrixException("Exeption: Matrix input heights or lengths do not match or one or more  matrix is null");  
        }
    }

    /**
     *Multiplies two full matricies together and returns the product
     *Both matricies must be the same length and height
     *Returns the product as a matrix
     */
    public Matrix mult (Matrix x, Matrix y) throws MatrixException  {
        //stuff
        double bigNumber = 0.0;
        int j2 = 0;
        if (x.getHeight(x) == y.getLength(y) && x.getLength(x) == y.getHeight(y) && x != null && y != null) {
            Matrix c = new Matrix (x.getHeight(x), x.getHeight(x));
            for (int i = 0; i < x.getHeight(x); i++){
                for (int j = 0; j < x.getHeight(x); j++){
                    bigNumber += (x.get(x, j, i) * y.get(y, j, i));
                }
                c.set(c, j2, i, bigNumber);
                j2++;
                bigNumber = 0.0;
            } 
            return c;
        } else {
            throw new MatrixException("Exeption: Input matricies heights or lengths are not the inverse of one another or one or more matrix is null");  
        }
    }

    /**
     *Multiplies each value in one full matrix by a double
     *Returns the product as a matrix
     */
    public Matrix mult (Matrix x, double y) throws MatrixException  {
        //stuff
        if (x != null) {
            Matrix c = new Matrix (x.getHeight(x), x.getLength(x));
            for (int i = 0; i < x.getHeight(x); i++){
                for (int j = 0; j < x.getLength(x); j++){
                    c.set(c, j, i, (x.get(x, j, i) * y));
                }
            } 
            return c;
        }else {
            throw new MatrixException("Exeption: matrix is null"); 
        }
    }

    /**
     *Transposes a matrix by switching each value's x and y coordinate in the 2d array
     *Returns a transposed matrix
     */
    public Matrix transpose (Matrix x) throws MatrixException {
        //stuff
        if (x != null) {
            Matrix c = new Matrix(x.getLength(x) , (x.getHeight(x)));
            for (int i = 0; i < x.getHeight(x); i++){
                for (int j = 0; j < x.getLength(x); j++){
                    c.set(c, j, i, (x.get(x, i, j)));
                }
            } 
            return c;
        } else {
            throw new MatrixException("Exeption: matrix is null"); 
        }
    }
}