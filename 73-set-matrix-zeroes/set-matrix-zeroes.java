class Solution {
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean firstrowhaszero=false;
        boolean firstcolhaszero=false;
        //checking if the first row contains zero
        for(int c=0;c<cols;c++){
            if(matrix[0][c]==0){
                firstrowhaszero=true;
                break;
            }
        }
        //checking if the first col contains zero
        for(int r=0;r<rows;r++){
            if(matrix[r][0]==0){
                firstcolhaszero=true;
                break;
            }
        }
        //using first row and col as markers
        for(int r=1;r<rows;r++){
            for(int c=1;c<cols;c++){
                if(matrix[r][c]==0){
                    matrix[r][0]=0;
                    matrix[0][c]=0;
                }
            }
        }
        //set marked rows to zero
        for(int r=1;r<rows;r++){
            if(matrix[r][0]==0){
                for(int c=1;c<cols;c++){
                    matrix[r][c]=0;
                }
            }
        }
        // set marked cols to zero
        for(int c=1;c<cols;c++){
            if(matrix[0][c]==0){
                for(int r=1;r<rows;r++){
                    matrix[r][c]=0;
                }
            }
        }
        //set the first row to zero if required
        if(firstrowhaszero){
            for(int c=0;c<cols;c++){
                matrix[0][c]=0;
            }
        }
        //setting first col to zero if required
        if (firstcolhaszero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }      

        
    
        
        
    }
}